FROM openjdk:8
RUN mkdir /app
WORKDIR /app
ADD . /app
RUN ./gradlew clean build -x test