FROM openjdk:13-jdk-alpine

RUN mkdir -p /java/run

COPY ./build/libs/synchronous-0.0.1-SNAPSHOT.jar /java/run/synchronous.jar

WORKDIR /java/run

ENTRYPOINT ["java", "-jar", "synchronous.jar"]