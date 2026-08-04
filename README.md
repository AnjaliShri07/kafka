Kafka sample project with spring boot

**Docker Run:**
1. Build Your Docker Image in Docker Desktop
   Docker Desktop doesn’t have a button for building from source yet, so you use the terminal integrated in Docker Desktop or your system terminal:
docker build -t hello-kafka-java .

•	This tells Docker: “Use the Dockerfile in this folder to build an image named hello-kafka-java.”
🧭 Make sure you run this from the folder that contains both your Dockerfile and your target/hello-kafka-java-0.0.1-SNAPSHOT.jar.
docker run --name hello-kafka-container -p 8080:8080 hello-kafka-java

2. Docker image run:
   docker run --name hello-kafka-container -p 8080:8080 hello-kafka-java

🔹 docker run
- Tells Docker to start (or “run”) a new container based on a given image.
  🔹 -p 8080:8080
- This publishes the container’s internal port 8080 to your host machine’s port 8080.
- In other words:
- Port 8080 is where your Spring Boot app inside the container is listening.
- Port 8080 is where you on your machine can access the app—like visiting http://localhost:8080.
  🔹 hello-kafka-java
- This is the name (or ID) of the Docker image you’re running.

3. Push Image to docker Hub-
-   docker tag hello-kafka-java anjali0715/hello-kafka-java:latest
-   docker push anjali0715/hello-kafka-java:latest

***********************************************************************************************************************
Kafka set up: 

Required Commands:
Go to c:/kafka, run below cmd
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

In new cmd window-
.\bin\windows\kafka-server-start.bat .\config\server.properties

List of all topics-
.\bin\kafka-topics.sh --list --bootstrap-server localhost:9092

go to C:\kafka\bin\windows-

kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic my-first-topic

From <https://anishmahapatra.medium.com/apache-kafka-102-how-to-set-up-kafka-on-your-local-68f432dfb1ab>


Below launches a Kafka producer that lets you send messages to a topic from the command line.

🧱 **Command Breakdown**

**Part**	                      **Meaning**
kafka-console-producer.bat	    Starts Kafka’s built-in CLI tool for sending messages
--broker-list localhost:9092	Connects to the Kafka broker running on your machine at port 9092
--topic my-first-topic	        Specifies which topic the producer should send messages to

kafka-console-producer.bat --broker-list localhost:9092 --topic my-first-topic
-------------------------------------------------------------------------------------------------------
Sample Data:

{"Name: "John", "Age":"31", "Gender":"Male"}
{"Name: "Emma", "Age":"27", "Gender":"Female"}
{"Name: "Ronald", "Age":"17", "Gender":"Male"}
---------------------------------------------------------------------------------------------------------
**Display msg from producer:**
I have created two topics - **my-topic** from program and **my-first-topic** from kafka cmd
kafka-console-consumer.bat --topic my-first-topic --bootstrap-server localhost:9092 --from-beginning
kafka-console-consumer.bat --topic my-topic --bootstrap-server localhost:9092 --from-beginning
🔍 **Command Breakdown**
kafka-console-consumer.bat --topic my-first-topic --bootstrap-server localhost:9092 --from-beginning

| 🔧 **Part**                       | 💬 **Meaning** |
| kafka-console-consumer.bat        | Starts Kafka’s built-in consumer CLI on Windows |
| --topic my-first-topic            | Specifies which topic you want to consume messages from |
| --bootstrap-server localhost:9092 | Connects to your local Kafka broker |
| --from-beginning                  | Reads all messages from the beginning of the topic, not just new ones |

📥 What It Does
When you run this:
- The terminal will display all messages that have been published to my-first-topic, starting from the very first one.
- It stays open and keeps listening for new messages too—so you can watch real-time delivery as producers send data.
  Perfect for testing your Spring Boot Kafka producer or even validating that Kafka is functioning properly.

