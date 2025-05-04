#!/bin/bash
# Stop any running container
if [ "$(docker ps -q -f name=twig-app)" ]; then
    docker stop twig-app
    docker rm twig-app
fi
