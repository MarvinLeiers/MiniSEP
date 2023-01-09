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

#FROM gradle:7.6.0-jdk17-alpine AS build
#WORKDIR /Backend
#COPY --chown=gradle:gradle . .
#RUN gradle assemble --no-daemon
#
#FROM nginx:alpine
#WORKDIR /Backend
#COPY --from=build /Backend/build/libs/Backend-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
#
#FROM openjdk:17-alpine
#WORKDIR /Backend
#COPY --from=build /Backend/build/libs/Backend-0.0.1-SNAPSHOT.jar app.jar
#CMD ["java", "-jar", "app.jar"]

#FROM openjdk:17-jdk-alpine as build
#WORKDIR /Backend
#
#COPY gradle gradle
#COPY build.gradle settings.gradle gradlew ./
#COPY src src
#
#EXPOSE 8080
#
#RUN ./gradlew build -x test
#RUN mkdir -p build/libs/dependency && (cd build/libs/dependency; jar -xf ../*.jar)
#
#FROM openjdk:17-jdk-alpine
#VOLUME /tmp
#ARG DEPENDENCY=/Backend/build/libs/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","app"]

FROM gradle:7.6.0-jdk17-alpine AS build
WORKDIR /Backend
COPY --chown=gradle:gradle . .
RUN gradle assemble --no-daemon

FROM openjdk:18-jdk-alpine
VOLUME /tmp
COPY --from=build /Backend/build/libs/Backend-0.0.1-SNAPSHOT.jar /Backend
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Backend/Backend-0.0.1-SNAPSHOT.jar"]