package com.person;

import com.person.impl.repository.PersonRepository;
import com.person.reading.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Main{
	

	public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		System.out.println( "ms3Interview" );
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		
		//Start the process of reading in values from the csv file
		Reader read = new Reader("ms3Interview.csv","ms3Interview-bad.csv","ms3Interview.log", personRepository);
		
		
		
	}

}
