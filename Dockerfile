FROM maven:3.6.0-jdk-11-slim
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:latest
COPY target/demoo-0.0.1-SNAPSHOT.jar demo-0.01-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo-0.01-SNAPSHOT.jar"]



