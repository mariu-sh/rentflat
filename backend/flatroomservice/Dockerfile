FROM openjdk:11-jre-slim

COPY build/libs/*.jar flat-room-service.jar

ENTRYPOINT ["java", "-jar", "flat-room-service.jar"]