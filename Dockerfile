FROM openjdk:11
VOLUME /tmp
ADD ./target/java-argentina-dolar-api.jar java-argentina-dolar-api.jar
ENTRYPOINT ["java","-jar","/java-argentina-dolar-api.jar"]