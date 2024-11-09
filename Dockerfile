FROM openjdk:11-jre-slim


WORKDIR /app


RUN apt-get update && apt-get install -y curl && apt-get clean


RUN curl -u admin:Raniahachem1234\! "http://192.168.33.10:8081/repository/5SIM1-G2-SKISTATION/tn/esprit/spring/gestion-station-ski/1.0/gestion-station-ski-1.0.jar" -o /app/gestion-station-ski-1.0.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "gestion-station-ski.jar"]

