# Boxinator
Code test for Fortnox. 
The application follows the pdf instructions.
The rest-api folder has all the files for the server, (has a rest-api folder with the java files)
The boxinator has all the frontend files
# Setup
1. First setup database by creating schema called "boxinator" in mysql workbench or simular. 
Run the "boxData.sql" to replicate my database. (password: root, username:root, if using other username and password you need to chang ethe password in the java controller class(line 38)) 
It should have a table called tblbox and columns: name, weight, color, country

make sure the sql server runs on localhost:3306

2. open up the Fortnox-Boxinator folder in Visual studio code or simualre.
start run the RestApiApplication.java file in the rest-api folder. Or cd to rest-api and then cd to rest-api again and next write ".\mvnw spring-boot:run to start java server

Make sure it runs on localhost:8080

3.  open  Fortnox-Boxinator, cd to boxinator, write "npm start" in teminal, make sure it runs on localhost:3000
