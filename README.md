# 渠道管理系统

全栈项目，包含前端（Vue3 + Vite）和后端（Spring Boot）。

## 项目结构

```
vite-channelAdmin/
├── frontend/              # 前端项目
│   ├── src/
│   │   ├── api/           # API 接口管理
│   │   ├── components/    # 公共组件
│   │   ├── composables/   # 组合函数
│   │   ├── directives/    # 自定义指令
│   │   ├── layouts/       # 布局组件
│   │   ├── locales/       # 国际化
│   │   ├── pages/         # 页面组件
│   │   ├── router/        # 路由配置
│   │   ├── stores/        # 状态管理
│   │   ├── styles/        # 样式文件
│   │   ├── types/         # 类型定义
│   │   └── utils/         # 工具函数
│   └── package.json
│
├── backend/               # 后端项目
│   ├── src/main/java/com/channel/admin/
│   │   ├── config/        # 配置类
│   │   ├── common/        # 公共模块
│   │   ├── security/      # 安全认证
│   │   └── modules/       # 业务模块
│   └── pom.xml
│
├── shared/                # 前后端共享资源
│   ├── api-contracts/     # API 契约
│   └── types/             # 类型定义
│
├── docs/                  # 项目文档
├── scripts/               # 脚本目录
├── nginx/                 # Nginx 配置
├── docker-compose.yml     # Docker 编排
└── Makefile               # 常用命令
```

## 快速开始

### 环境要求

- Node.js >= 18
- Java >= 17
- MySQL >= 8.0
- Redis >= 7.0
- Maven >= 3.9

### 启动开发环境

**方式一：使用 Makefile**

```bash
make dev
```

**方式二：手动启动**

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

| 服务 | 地址 |
|------|------|
| 前端 | http://localhost:3000 |
| 后端 API | http://localhost:8080 |
| API 文档 | http://localhost:8080/swagger-ui.html |

## 技术栈

### 前端
| 技术 | 版本 |
|------|------|
| Vue | 3.5 |
| Vite | 8.0 |
| Element Plus | 2.9 |
| Pinia | 3.0 |
| Vue Router | 4.5 |
| Axios | 1.7 |
| TypeScript | 5.9 |

### 后端
| 技术 | 版本 |
|------|------|
| Spring Boot | 3.2 |
| MyBatis Plus | 3.5 |
| Spring Security | - |
| JWT | 0.12 |
| MySQL | 8.0 |
| Redis | 7.0 |

## 常用命令

```bash
make dev       # 启动开发环境
make build     # 构建项目
make deploy    # Docker 部署
make clean     # 清理构建产物
make install   # 安装依赖
```

## 文档

- [系统架构](docs/architecture/system-architecture.md)
- [前端开发指南](docs/development/frontend-guide.md)
- [后端开发指南](docs/development/backend-guide.md)
- [Docker 部署](docs/deploy/docker-deploy.md)

## License

MIT
