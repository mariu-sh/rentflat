FROM gradle:jdk11 AS gradle_build

COPY --chown=gradle:gradle . /src

WORKDIR /src
RUN gradle build --no-daemon

FROM openjdk:11

COPY --from=gradle_build /src/build/libs/*.jar rent-flat-backend.jar

ENTRYPOINT ["java", "-jar", "rent-flat-backend.jar"]