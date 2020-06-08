FROM openjdk:11-jre-slim

COPY build/libs/*.jar cost-service.jar

ENTRYPOINT ["java", "-jar", "cost-service.jar"]