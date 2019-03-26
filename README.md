# Grpc with Spring Boot

•	gRPC <br />
•	Spring Boot <br />
•	Spring Data JPA <br />
•	MySQL  <br />
•	Gradle <br />
•	JUnit  <br />
•	SLF4J  <br />
•	Commons CLI <br />


Server: <br />

java -jar server-1.0-SNAPSHOT.jar 

Client: <br />

-c,--requestNumber <arg>   Number of concurrent requests a user will make <br />
-r,--roundsNumber <arg>    Number of rounds each thread is executing <br />
-u,--usersNumber <arg>     Number of concurrent users emulated <br />
  
java -jar client-1.0-SNAPSHOT.jar   -u  4   -c  3  -r   2
