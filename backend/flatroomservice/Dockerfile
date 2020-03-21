FROM gradle:jdk11 AS gradle_build

COPY --chown=gradle:gradle . /src

WORKDIR /src
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

COPY --from=gradle_build /src/build/libs/*.jar flat-room-service.jar

ENTRYPOINT ["java", "-jar", "flat-room-service.jar"]