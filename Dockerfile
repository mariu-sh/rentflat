FROM openjdk:11
ARG jar_path
COPY ${jar_path} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]