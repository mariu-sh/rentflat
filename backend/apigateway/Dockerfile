FROM openjdk:11-jre-slim

COPY build/libs/*.jar api-gateway.jar

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]