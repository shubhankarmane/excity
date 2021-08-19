#!/bin/sh

echo "Waiting for database to start"
./wait-for db:3306

echo "Starting the application"
java -jar excity.jar