#Notice that we are using two FROM in the Dockerfile, we called it multi-stage builds.
#Multi-stage builds can help to optimize the docker image.
#We copy the built jar file from stage one which is maven and store only the jar file into the current working directory.
#Then, we discard the local Maven repositories and class files generated in the target directory.

# AS <NAME> to name this stage as maven
#FROM maven:3.6.1-alpine AS maven
#LABEL MAINTAINER="sphokuhle"

#WORKDIR /usr/src/app
#COPY . /usr/src/app
# Compile and package the application to an executable JAR
#RUN mvn package

# For Java 8,
FROM adoptopenjdk/openjdk8:jre-nightly

ARG JAR_FILE=kubernetes-project-0.0.1-SNAPSHOT.jar
ARG MAVEN=/var/lib/jenkins/.m2/repository/com/example/kubernetes-project/0.0.1-SNAPSHOT

WORKDIR /opt/app
# Copy the demo.jar from the maven stage to the /opt/app directory of the current stage.
COPY ${MAVEN}/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","kubernetes-project-0.0.1-SNAPSHOT.jar"]