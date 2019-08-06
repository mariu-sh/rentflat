FROM openjdk:11
ARG jar_path
COPY ${jar_path} rent-flat-backend.jar
ENTRYPOINT ["java", "-jar", "rent-flat-backend.jar"]