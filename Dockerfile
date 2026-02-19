# ========================================
# ETAPA 1 - BUILD
# ========================================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copia apenas os arquivos de build primeiro (cache)
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

RUN mvn -B dependency:resolve dependency:resolve-plugins

# Agora copia o restante do código
COPY src src

# Build do jar
RUN mvn clean package -DskipTests


# ========================================
# ETAPA 2 - RUNTIME
# ========================================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/oficina-*.jar oficina.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "oficina.jar"]
