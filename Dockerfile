FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY target/whatsappClient-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "app.jar"]
