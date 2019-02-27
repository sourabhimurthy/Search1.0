FROM openjdk:11.0-oracle
ADD ./target/searchservice-0.0.1-SNAPSHOT.jar /usr/src/searchservice-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","searchservice-0.0.1-SNAPSHOT.jar"]