#!/bin/bash
# Run the application
docker run -d \
  --name twig-app \
  -v /home/ec2-user/twig-output:/app/output \
  twig-app:latest
