FROM openjdk:8
ENV APP_VERSION 1.0.0
RUN rm -rf /myapp && mkdir /myapp
WORKDIR /myapp
ADD build/libs/crudspring-${APP_VERSION}.jar /myapp
ENTRYPOINT java -Dserver.port=80 -jar crudspring-${APP_VERSION}.jar
EXPOSE 80