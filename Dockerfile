# Use Maven directly in the build stage
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

# Copy the Maven project files and dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Use a lightweight JRE for the final image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the packaged jar from the build stage
COPY --from=build /app/target/hello-world-micronaut-*.jar app.jar

# Set the entry point to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]