FROM eclipse-temurin:17-jdk

# Install X11 and other dependencies for Java GUI applications
RUN apt-get update && apt-get install -y \
    xvfb \
    x11-utils \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    && rm -rf /var/lib/apt/lists/*

# Set up working directory
WORKDIR /app

# Copy Maven POM and source code
COPY pom.xml ./
COPY src/ src/

# Install Maven and build the application
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/* \
    && mvn package -DskipTests

# Set up environment for X11 forwarding
ENV DISPLAY=:99

# Create startup script
RUN echo '#!/bin/bash\nXvfb :99 -screen 0 1280x1024x24 &\nsleep 1\njava -jar /app/target/twig-*-core.jar "$@"' > /app/start.sh \
    && chmod +x /app/start.sh

# Command to run when container starts
ENTRYPOINT ["/app/start.sh"]
