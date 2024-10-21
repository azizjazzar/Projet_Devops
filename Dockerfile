# Étape 1 : Construction de l'application
FROM maven:3.8.5-openjdk-17 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier pom.xml et le code source
COPY pom.xml .
COPY src ./src

# Construire le JAR
RUN mvn clean package -DskipTests

# Étape 2 : Création de l'image finale
FROM openjdk:17-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR construit depuis l'étape précédente
COPY --from=build /app/target/mon-application-0.0.1-SNAPSHOT.jar app.jar

# Copier le fichier application.properties
COPY src/main/resources/application.properties application.properties

# Exposer le port sur lequel l'application va écouter
EXPOSE 9090

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
