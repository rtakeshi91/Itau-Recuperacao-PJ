# Usar imagem base do OpenJDK
FROM openjdk:21-jdk-alpine

# Diretório para armazenar a aplicação
WORKDIR /app

# Copiar o arquivo JAR do Spring Boot para dentro do container
COPY build/libs/*.jar app.jar

# Expõe a porta onde o servidor estará ouvindo
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
