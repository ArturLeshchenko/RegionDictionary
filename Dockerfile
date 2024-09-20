FROM openjdk:17
COPY target/RegionDictionary-1.0-SNAPSHOT.jar opt/app.jar
ENTRYPOINT ["java", "-jar", "opt/app.jar"]

