#!/bin/bash

docker compose up $(docker-compose config --services | grep -v "^spring-app$")