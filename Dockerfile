FROM dorowu/ubuntu-desktop-lxde-vnc

# Install Java and Maven
USER root
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven git

# Set workdir and copy project
WORKDIR /app
COPY . /app

# Build Java project
RUN mvn clean package

# Set display and run the app
CMD ["bash", "-c", "export DISPLAY=:1 && java -jar target/twig-0.0.4-core.jar"]
