#!/bin/bash
k3d cluster create --api-port 6550 -p "8080:80@loadbalancer" -p "8443:443@loadbalancer" --agents 1 --k3s-server-arg '--no-deploy=traefik'
