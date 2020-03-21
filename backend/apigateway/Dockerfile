FROM gradle:jdk11 AS gradle_builder

COPY --chown=gradle:gradle . /src

WORKDIR /src
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

COPY --from=gradle_builder /src/build/libs/*.jar api-gateway.jar

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]