##
## Build stage
##
FROM maven:3.6.0-jdk-11-slim AS build

COPY target /home/app/target

#COPY src /home/app/src

#COPY pom.xml /home/app

WORKDIR /home/app

#RUN mvn clean install

#RUN mvn clean package -DskipTests

#
# Package stage
#
FROM tomcat:9.0.56-jdk8-corretto

COPY --from=build /home/app/target/hcm.war /usr/local/tomcat/webapps/

EXPOSE 9071
