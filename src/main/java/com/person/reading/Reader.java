package com.person.reading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.person.impl.entity.PersonEntity;
import com.person.impl.repository.PersonRepository;


public class Reader {
	@Autowired
	private PersonRepository personRepository;
	
	public Reader(String inputfile,String outputfile, String logfile,PersonRepository personRepository ){
		this.personRepository = personRepository;
		read(inputfile,outputfile,logfile);
	}
	
	public static void show(String[] values) {
		for(String v:values) {
			System.out.print(v + " ! ");
		}
		System.out.println();
	}
	
	public void read(String inputfile,String outputfile, String logfile) {
		
		try {
			Logger logger = Logger.getLogger(Reader.class.getName());

	        // Create an instance of FileHandler that write log to a file called
	        // ms3Interview.log. Each new message will be appended at the end of the log file.
			FileHandler log = new FileHandler(logfile, true);        
	        logger.addHandler(log);

	        //for reading in csv file of records
	        BufferedReader br = new BufferedReader(new FileReader(inputfile));
	        
	        //for writing to csv file of failed records. Unlike the logfile, this file will replace
	        //old data with new data everytime the application is run
	        BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile, false));
	        
	        //for each line to be read in
		    String line;
		    
		    //To store records with all records that are verified to be complete
		    List<PersonEntity> personEntities = new ArrayList<PersonEntity>();
		    
		    //for logging number, successful and failed entries
		    int entry = 0;
		    int successEntry = 0;
		    int failEntry = 0;
		    
		    while ((line = br.readLine()) != null) {
		    	
		    	//check for empty records
		    	if(line.equals("")) {
		    		continue;
		    	}
		    	
		    	//split string where there is a comma, except when comma is within string entry in column of db table
		        String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		    
		        //check if all columns in a row are filled and whether there are 10 columns in a row
		        if(checkLineValidity(values)) {
		        	successEntry++;
		        	
		        	//skip first record as it is header
		        	if(entry>0) {
		        	PersonEntity p = new PersonEntity(values);
		        	personEntities.add(p);
		        	}
		        	else {
		        		
		        		//store header at top of failed records csv file
		        		bw.write(line + "\n");
		        	}
		        }else {
		        	failEntry++;
		        	//System.out.println(entry + " " + line);
		        	//show(values);
		        	//System.out.println("bad");
		        
		        	//write out failed records to file
		        	bw.write(line + "\n");
		        }
		        
		       entry++;
		       
		      /* if(entry==20) {
		        	break;
		        }*/
		    }
		  //Don't count header record in the statistics
    		entry--;
    		successEntry--;
		    
		    //send successful records to database table
		    personRepository.saveAll(personEntities);
		    
		    //log information about records
		    if (logger.isLoggable(Level.INFO)) {
		    	
	            logger.info("Number of Records received: " + entry);
	            logger.info("Number of Records successful: " + successEntry);
	            logger.info("Number of Records failed: " + failEntry);
	        }
		    br.close();
			bw.close();
			log.close();
		}
		catch(Exception e) {
			System.out.println("here lies an exception");
			e.printStackTrace();
		}
		
	}
	
	public static boolean checkLineValidity(String[] values) {
		//check if a record has 10 columns
		 if(values.length!=10) {
			 return false;
		 }
		 
		 //check if all columns in a record are filled
		for(String val:values) {
			if(val.isEmpty()) {
				return false;
			}
		}
		return true;
	}

}
