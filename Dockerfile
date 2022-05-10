# BASE DOCKER IMAGE
FROM openjdk:17-jdk-alpine
ADD target/reports-0.0.1-SNAPSHOT.jar reports.jar
ENTRYPOINT ["java", "-jar", "reports.jar"]