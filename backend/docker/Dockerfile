FROM adoptopenjdk/openjdk11:latest

RUN mkdir -p /opt/spring/bin/config
COPY /target/kk-backend.jar /opt/spring/bin/kk-backend.jar

EXPOSE 8080

USER 997

CMD java -jar /opt/spring/bin/kk-backend.jar
