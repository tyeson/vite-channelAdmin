#!/bin/bash

echo "Starting development environment..."

echo "Starting backend..."
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev &
BACKEND_PID=$!

echo "Starting frontend..."
cd ../frontend
npm run dev &
FRONTEND_PID=$!

echo "Development environment started!"
echo "Backend PID: $BACKEND_PID"
echo "Frontend PID: $FRONTEND_PID"
echo ""
echo "Frontend: http://localhost:3000"
echo "Backend: http://localhost:8080"
echo "API Docs: http://localhost:8080/swagger-ui.html"

wait
