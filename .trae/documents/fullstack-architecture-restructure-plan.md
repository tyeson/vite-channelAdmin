# 全栈项目架构重构计划

## 项目概述

将当前的前端项目 `vite-channelAdmin` 重构为标准的全栈项目架构，包含前端（Vite + Vue3）和后端（Java Spring Boot）。

## 当前项目状态

**技术栈：**
- 前端：Vue 3.5 + Vite 8 + TypeScript
- UI 框架：Element Plus 2.9
- 状态管理：Pinia 3.0
- 路由：Vue Router 4.5
- HTTP 客户端：Axios

**当前目录结构：**
```
vite-channelAdmin/
├── src/
│   ├── assets/
│   ├── components/
│   ├── layouts/
│   ├── pages/
│   ├── router/
│   ├── stores/
│   ├── types/
│   └── utils/
├── public/
├── package.json
└── vite.config.ts
```

## 目标架构

```
vite-channelAdmin/
├── frontend/                           # 前端项目目录
├── backend/                            # 后端项目目录
├── shared/                             # 前后端共享资源
├── docs/                               # 项目文档
├── scripts/                            # 脚本目录
├── nginx/                              # Nginx 配置
├── docker-compose.yml                  # Docker 编排配置
├── Makefile                            # 常用命令脚本
└── README.md                           # 项目说明文档
```

---

## 实施步骤

### 第一阶段：前端目录重构

#### 步骤 1.1：创建 frontend 目录结构
- 创建 `frontend/` 目录
- 将现有前端文件移动到 `frontend/` 目录下
- 保持原有 `src/` 结构不变

#### 步骤 1.2：更新前端配置文件
- 更新 `frontend/vite.config.ts` 配置
- 创建环境配置文件：
  - `.env` - 默认环境变量
  - `.env.development` - 开发环境
  - `.env.production` - 生产环境
  - `.env.staging` - 预发布环境

#### 步骤 1.3：完善前端目录结构
- 创建 `src/api/` 目录及模块化 API 管理
- 创建 `src/composables/` 目录用于组合函数
- 创建 `src/directives/` 目录用于自定义指令
- 创建 `src/locales/` 目录用于国际化
- 创建 `src/styles/` 目录整合样式文件
- 完善组件目录结构（common/business）

---

### 第二阶段：后端项目搭建

#### 步骤 2.1：创建后端基础结构
```
backend/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/channel/admin/
│   │   │   ├── ChannelAdminApplication.java
│   │   │   ├── config/
│   │   │   ├── common/
│   │   │   ├── security/
│   │   │   └── modules/
│   │   └── resources/
│   │       ├── application.yml
│   │       ├── application-dev.yml
│   │       ├── application-prod.yml
│   │       └── mapper/
│   └── test/
└── dockerfile
```

#### 步骤 2.2：创建后端核心模块
- **config/** - 配置类（WebConfig, SecurityConfig, RedisConfig, MybatisConfig）
- **common/** - 公共模块
  - `constant/` - 常量定义
  - `enums/` - 枚举类
  - `exception/` - 异常处理
  - `result/` - 统一响应结果
  - `utils/` - 工具类
- **security/** - 安全认证模块
  - `filter/` - JWT 过滤器
  - `handler/` - 认证处理器
  - `service/` - Security 服务
- **modules/** - 业务模块
  - `system/` - 系统管理模块示例

#### 步骤 2.3：创建配置文件
- `pom.xml` - Maven 依赖配置
- `application.yml` - 主配置文件
- `application-dev.yml` - 开发环境配置
- `application-prod.yml` - 生产环境配置

---

### 第三阶段：共享模块与文档

#### 步骤 3.1：创建共享模块
```
shared/
├── api-contracts/
│   ├── openapi.yaml
│   └── schemas/
└── types/
    └── index.d.ts
```

#### 步骤 3.2：创建项目文档
```
docs/
├── README.md
├── architecture/
│   └── system-architecture.md
├── api/
│   └── README.md
├── deploy/
│   └── docker-deploy.md
└── development/
    ├── frontend-guide.md
    └── backend-guide.md
```

---

### 第四阶段：部署配置

#### 步骤 4.1：创建脚本目录
```
scripts/
├── dev.sh
├── build.sh
├── deploy.sh
└── docker/
    └── build-images.sh
```

#### 步骤 4.2：创建 Nginx 配置
```
nginx/
├── nginx.conf
└── conf.d/
    └── default.conf
```

#### 步骤 4.3：创建 Docker 配置
- `docker-compose.yml` - Docker 编排配置
- `frontend/dockerfile` - 前端 Docker 配置
- `backend/dockerfile` - 后端 Docker 配置

#### 步骤 4.4：创建 Makefile
- 提供常用命令快捷方式
- 包含 dev、build、deploy、clean 等命令

---

### 第五阶段：根目录配置

#### 步骤 5.1：更新根目录文件
- 更新 `.gitignore` 适配全栈项目
- 更新 `README.md` 项目说明文档

---

## 文件变更清单

### 需要移动的文件
| 原路径 | 新路径 |
|--------|--------|
| `src/*` | `frontend/src/*` |
| `public/*` | `frontend/public/*` |
| `package.json` | `frontend/package.json` |
| `vite.config.ts` | `frontend/vite.config.ts` |
| `tsconfig.json` | `frontend/tsconfig.json` |
| `tsconfig.app.json` | `frontend/tsconfig.app.json` |
| `tsconfig.node.json` | `frontend/tsconfig.node.json` |
| `index.html` | `frontend/index.html` |

### 需要创建的目录
- `frontend/src/api/`
- `frontend/src/composables/`
- `frontend/src/directives/`
- `frontend/src/locales/`
- `frontend/src/styles/`
- `backend/`（完整结构）
- `shared/`
- `docs/`
- `scripts/`
- `nginx/`

### 需要创建的文件
- `docker-compose.yml`
- `Makefile`
- `frontend/.env` 系列
- `backend/pom.xml`
- `backend/src/main/resources/application*.yml`
- 各模块的基础代码文件

---

## 技术栈确认

### 前端技术栈
| 类别 | 技术选型 | 版本 |
|------|----------|------|
| 构建工具 | Vite | ^8.0.x |
| 框架 | Vue 3 | ^3.5.x |
| 路由 | Vue Router | ^4.5.x |
| 状态管理 | Pinia | ^3.0.x |
| UI 组件库 | Element Plus | ^2.9.x |
| HTTP 客户端 | Axios | ^1.7.x |
| 样式 | SCSS | - |

### 后端技术栈
| 类别 | 技术选型 | 版本 |
|------|----------|------|
| 框架 | Spring Boot | 3.2.x |
| ORM | MyBatis Plus | 3.5.x |
| 数据库 | MySQL | 8.0 |
| 缓存 | Redis | 7.x |
| 安全 | Spring Security + JWT | - |
| 文档 | SpringDoc OpenAPI | 2.x |
| 构建 | Maven | 3.9.x |

---

## 执行顺序

1. **前端重构** - 移动文件、完善目录结构
2. **后端搭建** - 创建 Java Spring Boot 项目结构
3. **共享模块** - 创建 API 契约和类型定义
4. **文档编写** - 创建项目文档
5. **部署配置** - Docker、Nginx、脚本配置
6. **根目录整理** - 更新配置文件

---

## 预估工作量

- 前端目录重构：约 15 个文件移动/创建
- 后端项目搭建：约 30 个文件创建
- 共享模块：约 5 个文件创建
- 文档编写：约 6 个文件创建
- 部署配置：约 10 个文件创建
- 根目录配置：约 3 个文件更新

**总计：约 70 个文件操作**
