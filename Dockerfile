FROM openjdk:17-jdk
COPY "target/demoLosAmos-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]