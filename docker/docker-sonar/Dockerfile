FROM ubuntu:16.04

MAINTAINER Alfredo Bello <jose.bello@astrazeneca.com>

ADD ./sonar.properties ./startup.sh /tmp/

ENV sonar_name 'sonarqube-'
ENV sonar_version '5.6.6'
ENV sonar_extention '.zip'

## install unzip
RUN apt-get update -y && \
    apt-get install unzip curl openjdk-8-jdk -y -f && \

## install sonar
   sonar=$sonar_name$sonar_version$sonar_extention && \
   echo $sonar && \
   curl -O -L "https://sonarsource.bintray.com/Distribution/sonarqube/"$sonar && \
   #mv /tmp/sonarqube-5.6.6.zip / && \   
   unzip /$sonar && \
   mv /$sonar_name$sonar_version /opt/ && \  
   rm /opt/$sonar_name$sonar_version/conf/sonar.properties && \
   mv /tmp/sonar.properties /opt/$sonar_name$sonar_version/conf && \
   chmod 777 -R /opt/$sonar_name$sonar_version && \

## startup script
   mv /tmp/startup.sh / && \
   chmod +x /startup.sh && \

## clean up
   rm -rf /tmp/* && \
   rm -rf /$sonar

EXPOSE 9000
VOLUME /opt/sonarqube-5.6.6

CMD /startup.sh
