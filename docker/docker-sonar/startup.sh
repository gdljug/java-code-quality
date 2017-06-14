#!/bin/bash 

JAVA_HOME=/usr/lib/jvm/jdk1.8.0_91
export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_91

cd /opt/sonarqube-5.6.6/bin
/opt/sonarqube-5.6.6/bin/linux-x86-64/sonar.sh start
tail -100f /opt/sonarqube-5.6.6/logs/sonar.log
