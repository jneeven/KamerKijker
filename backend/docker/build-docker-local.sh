#!/usr/bin/env bash

mvn clean verify

# TODO add docker repo
docker build -t ********:local .
