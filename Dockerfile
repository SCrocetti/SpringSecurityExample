FROM eclipse-temurin:17
VOLUME /tmp
COPY ./build/libs/spring_security_demo-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]