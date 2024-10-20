# Étape 1 : Utiliser une image de base contenant OpenJDK
FROM openjdk:11-jre-slim

# Étape 2 : Définir le répertoire de travail
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré par Maven
COPY target/gestion-station-ski-1.0.jar app.jar

# Étape 4 : Exposer le port sur lequel l'application sera accessible
EXPOSE 8080

# Étape 5 : Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
