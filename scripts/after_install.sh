#!/bin/bash
# Build the Docker image locally on EC2
cd /home/ec2-user/twig-application
docker build -t twig-app:latest .
