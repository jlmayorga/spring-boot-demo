FROM maven:3.8.5-openjdk-11 AS BUILDER
COPY pom.xml /tmp/
RUN mvn -B dependency:go-offline -f /tmp/pom.xml
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn -B -f /tmp/pom.xml package

FROM openjdk:11-jre
EXPOSE 8080
COPY --from=BUILDER /tmp/target/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]