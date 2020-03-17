FROM gradle:jdk11 AS gradle_build

COPY --chown=gradle:gradle . /src

WORKDIR /src
RUN gradle build --no-daemon

RUN ls -la /src/build/libs/

FROM openjdk:11

COPY --from=gradle_build /src/build/libs/*.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]