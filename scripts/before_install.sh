#!/bin/bash
# Install or update Docker if needed
if ! command -v docker &> /dev/null; then
    # For Amazon Linux 2
    sudo yum update -y
    sudo amazon-linux-extras install docker -y
    sudo systemctl start docker
    sudo systemctl enable docker
    sudo usermod -a -G docker ec2-user
    
    # For Ubuntu, uncomment these instead:
    # sudo apt-get update
    # sudo apt-get install -y docker.io
    # sudo systemctl start docker
    # sudo systemctl enable docker
    # sudo usermod -a -G docker ubuntu
fi

# Create directory for output if it doesn't exist
mkdir -p /home/ec2-user/twig-output
