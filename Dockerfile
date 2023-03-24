FROM eclipse-temurin:17-jdk-alpine

COPY . .

CMD ["gradle clean build"]

ENV ARTIFACT_NAME=/build/libs/audsat-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT exec java -jar ${ARTIFACT_NAME}