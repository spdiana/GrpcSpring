# Grpc with Spring Boot

•	gRPC <br />
•	Spring Boot
•	Spring Data JPA
•	MySQL 
•	Gradle
•	JUnit
•	SLF4J
•	Commons CLI 


Server:
java -jar server-1.0-SNAPSHOT.jar 

Client:

-c,--requestNumber <arg>   Number of concurrent requests a user will make
-r,--roundsNumber <arg>    Number of rounds each thread is executing
-u,--usersNumber <arg>     Number of concurrent users emulated
  
java -jar client-1.0-SNAPSHOT.jar   -u  4   -c  3  -r   2
