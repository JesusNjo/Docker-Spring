FROM openjdk:17 AS build
ADD target/CotizacionProject-0.0.1-SNAPSHOT.jar Cotizacion.jar
ARG JAR_FILE=target/*.jar
COPY ./target/CotizacionProject-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]