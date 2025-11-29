# 1. Образ(Java 17)
FROM eclipse-temurin:17-jdk

# 2. Рабочая директория
WORKDIR /app

# 3. Инструкция копирования собранного JAR в контейнер
COPY build/libs/calculator-demo-0.0.1-SNAPSHOT.jar app.jar

# 4. Проброс порта 8090
EXPOSE 8090

# 5. Директива запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]