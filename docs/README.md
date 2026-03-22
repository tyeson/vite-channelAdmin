# 渠道管理系统

全栈项目，包含前端（Vue3 + Vite）和后端（Spring Boot）。

## 项目结构

```
vite-channelAdmin/
├── frontend/          # 前端项目
├── backend/           # 后端项目
├── shared/            # 共享资源
├── docs/              # 项目文档
├── scripts/           # 脚本
├── nginx/             # Nginx 配置
└── docker-compose.yml
```

## 快速开始

### 环境要求

- Node.js >= 18
- Java >= 17
- MySQL >= 8.0
- Redis >= 7.0
- Maven >= 3.9

### 启动开发环境

1. 启动后端服务：
```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

2. 启动前端服务：
```bash
cd frontend
npm install
npm run dev
```

### 访问地址

- 前端：http://localhost:3000
- 后端 API：http://localhost:8080
- API 文档：http://localhost:8080/swagger-ui.html

## 技术栈

### 前端
- Vue 3.5 + TypeScript
- Vite 8
- Element Plus
- Pinia
- Vue Router
- Axios

### 后端
- Spring Boot 3.2
- MyBatis Plus
- Spring Security + JWT
- Redis
- MySQL

## 更多文档

- [系统架构](./architecture/system-architecture.md)
- [前端开发指南](./development/frontend-guide.md)
- [后端开发指南](./development/backend-guide.md)
- [Docker 部署](./deploy/docker-deploy.md)
