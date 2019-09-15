FROM alpine:latest
RUN apk --update add openjdk8-jre
COPY /target/orderservice-0.0.1-SNAPSHOT.jar orderservice.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "orderservice.jar"]