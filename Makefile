.PHONY: dev build deploy clean install

dev:
	@echo "Starting development environment..."
	@cd frontend && npm run dev &
	@cd backend && ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

build:
	@echo "Building project..."
	@cd frontend && npm ci && npm run build
	@cd backend && ./mvnw clean package -DskipTests

deploy:
	@echo "Deploying with Docker..."
	@docker-compose up -d --build

clean:
	@echo "Cleaning..."
	@rm -rf frontend/dist
	@rm -rf backend/target
	@docker-compose down -v

install:
	@echo "Installing dependencies..."
	@cd frontend && npm install
	@cd backend && ./mvnw dependency:go-offline

logs:
	@docker-compose logs -f

ps:
	@docker-compose ps

stop:
	@docker-compose down
