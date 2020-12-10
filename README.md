
EDUCATIONAL-SERVLET

Web Application to "Sign In" in a Data Base, and "Log In" by Data Base checking, usefull to access in any web site private section. (Eclipse IDE Version: 2019-09, jre 8)

Sign In is an html form to insert name, surname, user, password and mail; record is ok only if user or mail aren't already present in the database table, other field can be present. If Sign In operation is ok, browser show a web page where all inserted field are listed, if not, show a page to communicate that user or mail is already recorded.

Log In is an html form where user and password are request. Log in ok only if user are alredy recorded, and mach with his recorded password. Next html pages show log in result in each case (Log In Ok, or Error).

If Log In is ok, we have the possibility of change password; in this case, another servlet is recall to update database table and show an html page with result of operation.

Forgotten password are resettable, back end logic use mail with html link to a "special" web page not recallable otherwise. A pseudo-random token, generated in business logic and sotred in database, is sent with mail: only if the user type the right token correlated with correct mail, he can change and reset password.

DAO - DTO pattern are implemented and passwords are recorded in databese as a digested string of SHA-256 hash-function to preserve user privacy. 
At every database table check, business logic execute this hash algorithm on password field. 

The Java application run on (local in this example) server and implement all controll logic and db management.

ATTENTION: before try this scripts, an Application Server like Apache Tomcat (in this days version 9.0) must be installed and imported in your development enviroment. A MySQL DB Server must be started, new user "admin" pass "admin" with a database, called here "testdbservlet" with a single table "customer", must be created, the Mysql Java Connector and Java Mailil frameworks included in Web-App-Libraries section of the "Package Explorer".

Here a basic SQL script for create the "testdbservlet" database with "customer" table:

(change position in mysql default installation path...

C:>cd Program Files\MySQL\MySQL Server 8.0\bin

C:\Program Files\MySQL\MySQL Server 8.0\bin>mysql -h localhost -u root -p

insert root password...)

mysql> SHOW DATABASES;

mysql> CREATE DATABASE testdbservlet;

mysql> SHOW DATABASES;

mysql> USE testdbservlet;

mysql>SELECT user,host from MySQL.user;

mysql>CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

mysql>SELECT user,host from MySQL.user;

mysql>SHOW GRANTS FOR 'admin'@'localhost';

mysql>GRANT ALL PRIVILEGES ON testdbservlet.customer TO 'admin'@'localhost';

mysql>SHOW GRANTS FOR 'admin'@'localhost';

mysql>SHOW TABLES;

mysql> CREATE TABLE customer (name VARCHAR(20), surname VARCHAR(20), user VARCHAR(20), password VARCHAR (512) NOT NULL, customer_id INT(10) PRIMARY KEY AUTO_INCREMENT NOT NULL, mail VARCHAR(40), token SMALLINT(2));

mysql> SHOW TABLES;

mysql> DESCRIBE TABLE customer;

mysql> SELECT * FROM testdbservlet.customer;
