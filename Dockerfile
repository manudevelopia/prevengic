FROM openjdk:8-jdk-alpine
VOLUME /tmp

COPY "build/libs/*.jar" app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]