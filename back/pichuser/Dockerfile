FROM adoptopenjdk:8
MAINTAINER monksoft.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pichuser-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/pichuser-0.0.1-SNAPSHOT.jar"]
