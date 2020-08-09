# ms3Interview
1)
The purpose of this repo is to show an application that takes a csv file (ms3Interview) of records and filters it,
taking the records with:

-the right number of columns 
-having all columns filled with values 

and inserting them into a SQLite database. Records which fail the above criteria are sent to another csv file (ms3Interview-bad).
The number of records, successful records and failed records are stored in a log file.

2) 
For getting this application running, there are 2 ways to do it

-You can open the project with Eclipse IDE, go to the file labeled "Main.java" in package com.person, right click and select
run as java application.

-The second way to run this project is to go inside the ms3Interview folder using the Command Prompt, and run the
ms3Interview-0.0.1-SNAPSHOT.jar file located in the target folder. This can be done from the interview folder using
the command:
 
java -jar target/ms3Interview-0.0.1-SNAPSHOT.jar

use CTRL + C to stop running the application

3)
-I am assuming that the database (labelled ms3Interview), ms3Interview.csv file, ms3Interview-bad.csv file and ms3Interview.log file are all located
within the ms3Interview folder. 

-I am not counting the header record in the logfile statistics

-I decided to use a SpringBoot application to tackle the given problem. I start the process simply by instantiating
a class I created called Reader which in turn calls a method through its constructor called read which handles the file processing work and the 
work related to writing to other files and the database. 

-The ms3Interview-bad.csv replaces old data with new data everytime the application is run while the ms3Interview.log file simply adds on new data.

-I use Spring Data Jpa for writing to the database. The table within the database I write to is called person. 
I had to make a primary key or I couldn't write to the table using Spring Data so I made the column
labelled "c" as the primary key as values stored appear to be unique.
