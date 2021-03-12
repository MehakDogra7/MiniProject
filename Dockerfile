FROM openjdk:8
COPY ./target/MiniProject-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-cp", "MiniProject-1.0-SNAPSHOT-jar-with-dependencies.jar", "Calculator"]