FROM openjdk:11

ADD ./target/moviedata-populator-service-1.0.0.jar /usr/src/moviedata-populator-service-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "moviedata-populator-service-1.0.0.jar"]
