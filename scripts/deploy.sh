#!/bin/bash

echo "Deploying project..."

echo "Building Docker images..."
docker-compose build

echo "Starting services..."
docker-compose up -d

echo "Waiting for services to be ready..."
sleep 10

echo "Checking service status..."
docker-compose ps

echo "Deployment completed!"
echo ""
echo "Application: http://localhost"
echo "API Docs: http://localhost/swagger-ui.html"
