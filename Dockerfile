FROM openjdk:12.0.1-jdk-oraclelinux7

ARG SERVICE_LOCATION=/apps/docker/nmdp-utils

RUN mkdir -p "$SERVICE_LOCATION"
WORKDIR $SERVICE_LOCATION
RUN cd $SERVICE_LOCATION

ADD target/nmdputils-1.0-SNAPSHOT.jar $SERVICE_LOCATION
ADD resources/WMDA_EXAMPLES $SERVICE_LOCATION/WMDA_EXAMPLES

CMD java -jar nmdputils-1.0-SNAPSHOT.jar WMDA_EXAMPLES