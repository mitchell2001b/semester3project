FROM openjdk:11-jre-slim

WORKDIR application

COPY ./target/demoo-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "demoo-0.0.1-SNAPSHOT.jar"]



