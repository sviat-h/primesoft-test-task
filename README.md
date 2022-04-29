# primesoft-test-task | TCP/IP server
## Description:
```
A simple TCP/IP server that opens a socket and listens to requests from the users.
```
## Used technologies and libraries:
- Java 11
- MySQL
- JDBC
- Checkstyle plugin
- Project Lombok
## Steps to run the program on your computer:
- Clone the repo: [https://github.com/sviat-h/primesoft-test-task.git](https://github.com/sviat-h/primesoft-test-task.git);
- Copy and run the SQL script [src/main/resources/init_db.sql](src/main/resources/init_db.sql) to create the schema with the required tables and insert the data;
- Configure [src/main/java/com/primesoft/util/ConnectionUtil.java](src/main/java/com/primesoft/util/ConnectionUtil.java) with your URL, USERNAME, PASSWORD, JDBC_DRIVER;
- You already have two registered users: ``login: userLogin, password: user1234`` and ``login: adminLogin, password: admin1234`` and can change login/password here - [src/main/java/com/primesoft/socket/ClientSocket.java](src/main/java/com/primesoft/socket/ClientSocket.java) at 16-17 lines;
- Run the server - [src/main/java/com/primesoft/socket/ServerSocket.java](src/main/java/com/primesoft/socket/ServerSocket.java);
- Run the client - [src/main/java/com/primesoft/socket/ClientSocket.java](src/main/java/com/primesoft/socket/ClientSocket.java).
