# Docker 部署指南

## 环境要求

- Docker >= 20.0
- Docker Compose >= 2.0

## 快速部署

```bash
# 构建并启动所有服务
docker-compose up -d

# 查看服务状态
docker-compose ps

# 查看日志
docker-compose logs -f
```

## 服务说明

| 服务 | 端口 | 说明 |
|------|------|------|
| nginx | 80 | 反向代理 |
| frontend | 3000 | 前端服务 |
| backend | 8080 | 后端服务 |
| mysql | 3306 | 数据库 |
| redis | 6379 | 缓存 |

## 单独构建

```bash
# 构建前端镜像
docker build -t channel-admin-frontend ./frontend

# 构建后端镜像
docker build -t channel-admin-backend ./backend
```

## 环境变量

在 `docker-compose.yml` 中配置：

```yaml
environment:
  - DB_HOST=mysql
  - DB_PORT=3306
  - DB_USERNAME=root
  - DB_PASSWORD=password
  - REDIS_HOST=redis
  - REDIS_PORT=6379
```

## 数据持久化

数据存储在 Docker volumes 中：

- `mysql_data`: MySQL 数据
- `redis_data`: Redis 数据
