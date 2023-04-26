FROM adoptopenjdk:11-jre-hotspot
COPY target/StudentWebApp*.jar /studentapp.jar
CMD java -jar /studentapp.jar