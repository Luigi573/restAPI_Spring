FROM openjdk:17
COPY /build/libs/restAPI-0.0.1-SNAPSHOT.jar /opt/app/restAPI-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/restAPI-0.0.1-SNAPSHOT.jar"]