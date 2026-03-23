FROM maven:3.9-eclipse-temurin-21 AS build
LABEL authors="blend"

WORKDIR /app

COPY pom.xml .
COPY . /app

RUN mvn package -DskipTests

CMD ["java", "-jar", "target/otp-2-inclass-assignments-1.0-SNAPSHOT.jar"]
