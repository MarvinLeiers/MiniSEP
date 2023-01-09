#FROM openjdk:17 as build
#ARG JAR_FILE=jar/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#
#FROM openjdk:alpine
#WORKDIR /Backend
#COPY --from=build /Backend/jar/Backend-0.0.1-SNAPSHOT.jar app.jar
#CMD ["java", "-jar", "app.jar"]
#
#FROM nginx:alpine
#COPY --from=build /Backend/jar/Backend-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080

FROM gradle:7.6.0-jdk17-alpine AS build
WORKDIR /Backend
COPY --chown=gradle:gradle . .
RUN gradle assemble --no-daemon

FROM openjdk:17-alpine as build2
WORKDIR /Backend
COPY --from=build /Backend/build/libs/Backend-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]

FROM nginx:alpine
WORKDIR /Backend
COPY --from=build2 /Backend/build/libs/Backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080