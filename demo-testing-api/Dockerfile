FROM openjdk:8-jdk-alpine

EXPOSE 8091

ADD /target/demo-testing-api-0.0.1-SNAPSHOT.jar demo-testing-api-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","demo-testing-api-0.0.1-SNAPSHOT.jar"]