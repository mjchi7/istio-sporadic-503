#!/bin/bash
k3d cluster create --image "rancher/k3d:4.4-dind-linux-amd64" --k3s-server-arg="--docker"
