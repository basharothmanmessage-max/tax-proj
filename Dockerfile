# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jre-alpine AS runtime

WORKDIR /app

COPY --from=build /app/target/sales-tax-system-1.0-SNAPSHOT.jar ./sales-tax-system.jar

ENTRYPOINT ["java", "-jar", "sales-tax-system.jar"]
