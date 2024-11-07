FROM openjdk:17-jdk-alpine
EXPOSE 8082
COPY target/skistation-5.0.0.jar skistation-5.0.0.jar
ENTRYPOINT ["java","-jar","/skistation-5.0.0.jar"]