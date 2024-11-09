# Utilisez une image de base avec JDK 11 installé
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Installer curl pour télécharger les artefacts depuis Nexus
RUN apt-get update && apt-get install -y curl && apt-get clean

# Télécharger le fichier JAR de l'application Spring Boot depuis Nexus
RUN curl -u admin:nexus "http://192.168.152.128:8081/repository/5SIM1-G2-SKISTATION/tn/esprit/spring/gestion-station-ski/1.0/gestion-station-ski-1.0.jar" -o /app/gestion-station-ski.jar

# Exposer le port que l'application Spring Boot utilise
EXPOSE 8080

# Spécifiez la commande pour exécuter l'application Spring Boot quand le conteneur démarre
ENTRYPOINT ["java", "-jar", "gestion-station-ski.jar"]


