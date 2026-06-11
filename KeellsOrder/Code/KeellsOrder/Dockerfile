FROM eclipse-temurin:17-jre

WORKDIR /keellsorder

COPY target/*.jar keellsorder.jar

EXPOSE 8081

ENTRYPOINT [ "java", "-jar", "keellsorder.jar" ]