FROM openjdk:17-jdk-alpine3.14
WORKDIR /app
COPY target/excity-0.0.1-SNAPSHOT.jar excity.jar
COPY wait-for wait-for
COPY start.sh start.sh
#EXPOSE 8080
#ENV MYSQL_DB_HOST=jdbc:mysql://localhost
#ENV MYSQL_DB_PORT=3306
#ENTRYPOINT ["java","-jar","/app/excity.jar"]