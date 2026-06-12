FROM eclipse-temurin:17-jre

WORKDIR /keellssmartgrocery

COPY target/*.jar keellssmartgrocery.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "keellssmartgrocery.jar" ]