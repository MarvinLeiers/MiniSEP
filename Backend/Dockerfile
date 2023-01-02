FROM openjdk:17 as build
ARG JAR_FILE=jar/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

FROM nginx:alpine
COPY --from=build /usr/src/app/target/* /usr/app/
EXPOSE 8080