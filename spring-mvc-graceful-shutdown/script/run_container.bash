#!/bin/bash

docker create --name example-app -p 8080:8080 example-app
docker start example-app
echo "Server is running!"
