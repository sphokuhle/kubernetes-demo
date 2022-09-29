FROM adoptopenjdk/openjdk8:jre-nightly
ARG JAR_FILE=kubernetes-project-0.0.1-SNAPSHOT.jar
ADD target/${JAR_FILE} ${JAR_FILE}
EXPOSE 80
ENTRYPOINT ["java","-jar","kubernetes-project-0.0.1-SNAPSHOT.jar"]