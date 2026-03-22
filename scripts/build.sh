#!/bin/bash

echo "Building project..."

echo "Building frontend..."
cd frontend
npm ci
npm run build

echo "Building backend..."
cd ../backend
./mvnw clean package -DskipTests

echo "Build completed!"
