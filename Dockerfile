FROM maven:3.6.3-jdk-11-slim AS build
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
