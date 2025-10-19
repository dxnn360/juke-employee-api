# Gunakan base image Maven dengan JDK 22 untuk build
FROM maven:3.9.9-eclipse-temurin-22 AS build

# Set working directory
WORKDIR /app

# Copy semua file ke container
COPY . .

# Build aplikasi (tanpa menjalankan test biar lebih cepat)
RUN mvn clean package -DskipTests

# Tahap runtime: hanya ambil hasil build (jar)
FROM eclipse-temurin:22-jre

# Set working directory
WORKDIR /app

# Copy file JAR hasil build dari tahap sebelumnya
COPY --from=build /app/target/*.jar app.jar

# Expose port aplikasi (default Spring Boot 8080)
EXPOSE 8080

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]
