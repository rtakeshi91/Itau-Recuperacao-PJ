# Usa a imagem base do OpenJDK 21
FROM eclipse-temurin:21-jdk as builder
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Constrói a aplicação usando Gradle
RUN ./gradlew build -x test

# Cria uma nova imagem sem os arquivos do build
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia o JAR gerado na fase anterior
COPY --from=builder /app/build/libs/*.jar app.jar

# Define variáveis de ambiente para o banco de dados H2
ENV SPRING_DATASOURCE_URL=jdbc:h2:file:/app/db-recuperacao-pj;AUTO_SERVER=TRUE;CACHE_SIZE=1024
ENV SPRING_DATASOURCE_USERNAME=sa
ENV SPRING_DATASOURCE_PASSWORD=
ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
