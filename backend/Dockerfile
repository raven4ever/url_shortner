# build the source code of the app
FROM maven:3-alpine AS BUILDER

WORKDIR /app

COPY . .

RUN mvn clean install -Pprod

# copy JAR to runtime container
FROM openjdk:8-jdk-alpine

COPY --from=BUILDER /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
