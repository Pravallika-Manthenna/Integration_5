FROM openjdk:11

ADD ./target/web-search-services-1.0.0.jar /usr/src/web-search-services-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "web-search-services-1.0.0.jar"]