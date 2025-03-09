# build stage
FROM bellsoft/liberica-openjdk-alpine:21 AS build

WORKDIR /app
COPY gradlew gradlew.bat build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
COPY src ./src

RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon --parallel


# runtime stage
FROM bellsoft/liberica-openjre-alpine:21 AS runtime

WORKDIR /app
COPY --from=build /app/build/libs/example-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "example-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
