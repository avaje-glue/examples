FROM openjdk:8-jre-alpine
RUN mkdir -p /app
RUN mkdir -p /app/lib
WORKDIR /app
COPY target/lib /app/lib
COPY target/app.jar /app/app.jar
EXPOSE 8080
CMD ["java","-Djava.security.egd=file:/dev/urandom","-jar","/app/app.jar"]