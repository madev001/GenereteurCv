FROM openjdk:latest
#ARG JAR_FILE=./target/cv-0.0.1-GenerateurCv.jar
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
