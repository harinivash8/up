FROM tomcat:9.0-jdk17-openjdk
COPY target/twig.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
