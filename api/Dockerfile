# Building
FROM maven:3.9.6 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Executing
FROM openjdk:21
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Instala wait-for-it
RUN apt-get update && apt-get install -y curl
RUN curl -sSLo /wait-for-it.sh https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh && chmod +x /wait-for-it.sh

EXPOSE 8080

# Using 5005 for Remote JVM Debugger on IntelliJ
EXPOSE 5005

CMD ["sh", "-c", "/wait-for-it.sh db:5432 --timeout=60 -- java ${JAVA_DEBUG_OPTS} -jar app.jar"]