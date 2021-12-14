FROM openjdk:latest
EXPOSE 8080
ADD target/hello-world.jar api.jar
ENTRYPOINT ["sh", "-c", "java -jar /api.jar"]