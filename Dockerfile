FROM amazoncorretto:21-alpine-jdk
COPY ./build/libs/kafka-concumer-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","kafka-concumer-0.0.1-SNAPSHOT.jar"]