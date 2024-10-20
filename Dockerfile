# Utiliser une image de base de Java
FROM openjdk:11-jre-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR du projet (généré par Maven ou Gradle)
COPY target/mon-projet.jar app.jar

# Exposer le port sur lequel l'application sera accessible
EXPOSE 9090

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
