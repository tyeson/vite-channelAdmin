---
name: "fullstack-java-architecture"
description: "Provides full-stack project architecture with Vite frontend and Java Spring Boot backend. Invoke when setting up full-stack projects, organizing monorepo structure, or integrating Java backend with modern frontend."
---

# 全栈项目架构技能 (Full-Stack Java Architecture)

## 概述

本技能提供完整的全栈项目架构指南，包含前端（Vite + Vue3/React）和后端（Java Spring Boot）的标准化目录结构、最佳实践和集成方案。

## 适用场景

- 新建全栈项目
- 前后端分离项目架构设计
- 团队协作规范制定
- 微服务架构项目

---

## 1. 全栈项目目录结构

### 1.1 推荐目录结构

```
project-root/                                    # 项目根目录
├── README.md                                    # 项目说明文档
├── .gitignore                                   # Git 忽略配置
├── docker-compose.yml                           # Docker 编排配置
├── Makefile                                     # 常用命令脚本
│
├── frontend/                                    # 前端项目目录
│   ├── README.md
│   ├── package.json
│   ├── vite.config.ts
│   ├── tsconfig.json
│   ├── index.html
│   │
│   ├── public/                                  # 静态资源
│   │   ├── favicon.ico
│   │   └── assets/
│   │
│   ├── src/
│   │   ├── api/                                 # API 接口管理
│   │   │   ├── modules/                         # 按模块组织的接口
│   │   │   │   ├── user.ts
│   │   │   │   ├── system.ts
│   │   │   │   └── index.ts
│   │   │   ├── interceptors/                    # 请求/响应拦截器
│   │   │   │   ├── request.ts
│   │   │   │   └── response.ts
│   │   │   └── index.ts
│   │   │
│   │   ├── assets/                              # 需要构建的静态资源
│   │   │   ├── images/
│   │   │   ├── icons/
│   │   │   └── styles/
│   │   │       ├── variables.scss
│   │   │       ├── mixins.scss
│   │   │       └── global.scss
│   │   │
│   │   ├── components/                          # 公共组件
│   │   │   ├── common/                          # 通用组件
│   │   │   │   ├── BaseButton/
│   │   │   │   ├── BaseTable/
│   │   │   │   ├── BaseForm/
│   │   │   │   └── index.ts
│   │   │   ├── business/                        # 业务组件
│   │   │   │   ├── UserSelect/
│   │   │   │   ├── DataTable/
│   │   │   │   └── index.ts
│   │   │   └── index.ts
│   │   │
│   │   ├── composables/                         # Vue3 组合函数
│   │   │   ├── useAuth.ts
│   │   │   ├── usePermission.ts
│   │   │   ├── useTable.ts
│   │   │   └── index.ts
│   │   │
│   │   ├── directives/                          # 自定义指令
│   │   │   ├── permission.ts
│   │   │   ├── debounce.ts
│   │   │   └── index.ts
│   │   │
│   │   ├── layouts/                             # 布局组件
│   │   │   ├── DefaultLayout/
│   │   │   │   ├── index.vue
│   │   │   │   ├── components/
│   │   │   │   │   ├── Sidebar.vue
│   │   │   │   │   ├── Header.vue
│   │   │   │   │   └── index.ts
│   │   │   │   └── composables/
│   │   │   ├── AuthLayout/
│   │   │   └── index.ts
│   │   │
│   │   ├── locales/                             # 国际化
│   │   │   ├── zh-CN/
│   │   │   │   ├── common.ts
│   │   │   │   ├── menu.ts
│   │   │   │   └── index.ts
│   │   │   ├── en-US/
│   │   │   └── index.ts
│   │   │
│   │   ├── pages/                               # 页面组件
│   │   │   ├── login/
│   │   │   │   └── index.vue
│   │   │   ├── dashboard/
│   │   │   │   ├── index.vue
│   │   │   │   └── components/
│   │   │   ├── system/                          # 系统管理模块
│   │   │   │   ├── user/
│   │   │   │   │   ├── index.vue
│   │   │   │   │   ├── components/
│   │   │   │   │   └── composables/
│   │   │   │   ├── role/
│   │   │   │   └── menu/
│   │   │   └── index.ts
│   │   │
│   │   ├── router/                              # 路由配置
│   │   │   ├── modules/                         # 按模块的路由
│   │   │   │   ├── system.ts
│   │   │   │   └── index.ts
│   │   │   ├── guards/                          # 路由守卫
│   │   │   │   ├── permission.ts
│   │   │   │   └── index.ts
│   │   │   └── index.ts
│   │   │
│   │   ├── stores/                              # 状态管理
│   │   │   ├── modules/
│   │   │   │   ├── user.ts
│   │   │   │   ├── app.ts
│   │   │   │   ├── permission.ts
│   │   │   │   └── index.ts
│   │   │   └── index.ts
│   │   │
│   │   ├── styles/                              # 样式文件
│   │   │   ├── variables.css
│   │   │   ├── animation.scss
│   │   │   └── index.scss
│   │   │
│   │   ├── types/                               # TypeScript 类型定义
│   │   │   ├── api.d.ts
│   │   │   ├── global.d.ts
│   │   │   ├── user.d.ts
│   │   │   └── index.ts
│   │   │
│   │   ├── utils/                               # 工具函数
│   │   │   ├── cache.ts
│   │   │   ├── request.ts
│   │   │   ├── validate.ts
│   │   │   ├── format.ts
│   │   │   ├── crypto.ts                        # 加密工具
│   │   │   └── index.ts
│   │   │
│   │   ├── App.vue
│   │   ├── main.ts
│   │   └── vite-env.d.ts
│   │
│   ├── .env                                     # 环境变量
│   ├── .env.development
│   ├── .env.production
│   ├── .env.staging
│   ├── .eslintrc.cjs
│   ├── .prettierrc.cjs
│   └── dockerfile                               # 前端 Docker 配置
│
├── backend/                                     # 后端项目目录
│   ├── README.md
│   ├── pom.xml                                  # Maven 配置
│   ├── mvnw                                     # Maven Wrapper
│   ├── mvnw.cmd
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── project/
│   │   │   │               ├── ProjectApplication.java
│   │   │   │               │
│   │   │   │               ├── config/          # 配置类
│   │   │   │               │   ├── WebConfig.java
│   │   │   │               │   ├── SecurityConfig.java
│   │   │   │               │   ├── RedisConfig.java
│   │   │   │               │   ├── MybatisConfig.java
│   │   │   │               │   ├── SwaggerConfig.java
│   │   │   │               │   └── properties/  # 配置属性类
│   │   │   │               │       ├── AppProperties.java
│   │   │   │               │       └── JwtProperties.java
│   │   │   │               │
│   │   │   │               ├── common/          # 公共模块
│   │   │   │               │   ├── constant/    # 常量定义
│   │   │   │               │   │   ├── CommonConstant.java
│   │   │   │               │   │   ├── CacheConstant.java
│   │   │   │               │   │   └── SecurityConstant.java
│   │   │   │               │   ├── enums/       # 枚举类
│   │   │   │               │   │   ├── ResultCode.java
│   │   │   │               │   │   ├── UserStatus.java
│   │   │   │               │   │   └── Gender.java
│   │   │   │               │   ├── exception/   # 异常类
│   │   │   │               │   │   ├── BusinessException.java
│   │   │   │               │   │   ├── GlobalExceptionHandler.java
│   │   │   │               │   │   └── ErrorCode.java
│   │   │   │               │   ├── result/      # 统一响应结果
│   │   │   │               │   │   ├── Result.java
│   │   │   │               │   │   └── PageResult.java
│   │   │   │               │   └── utils/       # 工具类
│   │   │   │               │       ├── JwtUtil.java
│   │   │   │               │       ├── SecurityUtil.java
│   │   │   │               │       ├── RedisUtil.java
│   │   │   │               │       └── DateUtil.java
│   │   │   │               │
│   │   │   │               ├── security/        # 安全认证模块
│   │   │   │               │   ├── filter/      # 过滤器
│   │   │   │               │   │   ├── JwtAuthenticationFilter.java
│   │   │   │               │   │   └── RateLimitFilter.java
│   │   │   │               │   ├── handler/     # 处理器
│   │   │   │               │   │   ├── AuthenticationEntryPoint.java
│   │   │   │               │   │   └── AccessDeniedHandler.java
│   │   │   │               │   ├── service/     # Security 服务
│   │   │   │               │   │   └── UserDetailsServiceImpl.java
│   │   │   │               │   └── model/       # Security 模型
│   │   │   │               │       └── LoginUser.java
│   │   │   │               │
│   │   │   │               ├── modules/         # 业务模块
│   │   │   │               │   ├── system/      # 系统管理模块
│   │   │   │               │   │   ├── controller/
│   │   │   │               │   │   │   ├── UserController.java
│   │   │   │               │   │   │   ├── RoleController.java
│   │   │   │               │   │   │   ├── MenuController.java
│   │   │   │               │   │   │   └── DeptController.java
│   │   │   │               │   │   ├── service/
│   │   │   │               │   │   │   ├── UserService.java
│   │   │   │               │   │   │   ├── impl/
│   │   │   │               │   │   │   │   ├── UserServiceImpl.java
│   │   │   │               │   │   │   │   └── RoleServiceImpl.java
│   │   │   │               │   │   │   └── dto/
│   │   │   │               │   │   │       ├── UserDTO.java
│   │   │   │               │   │   │       ├── UserQuery.java
│   │   │   │               │   │   │       └── UserVO.java
│   │   │   │               │   │   ├── mapper/
│   │   │   │               │   │   │   ├── UserMapper.java
│   │   │   │               │   │   │   └── xml/
│   │   │   │               │   │   │       └── UserMapper.xml
│   │   │   │               │   │   ├── entity/
│   │   │   │               │   │   │   ├── User.java
│   │   │   │               │   │   │   ├── Role.java
│   │   │   │               │   │   │   └── Menu.java
│   │   │   │               │   │   └── param/   # 请求参数
│   │   │   │               │   │       ├── UserCreateParam.java
│   │   │   │               │   │       ├── UserUpdateParam.java
│   │   │   │               │   │       └── UserQueryParam.java
│   │   │   │               │   │
│   │   │   │               │   └── generator/   # 代码生成器
│   │   │   │               │       ├── CodeGenerator.java
│   │   │   │               │       └── template/
│   │   │   │               │
│   │   │   │               └── aspect/          # AOP 切面
│   │   │   │                   ├── LogAspect.java
│   │   │   │                   └── RateLimitAspect.java
│   │   │   │
│   │   │   └── resources/
│   │   │       ├── application.yml              # 主配置文件
│   │   │       ├── application-dev.yml          # 开发环境
│   │   │       ├── application-prod.yml         # 生产环境
│   │   │       ├── application-test.yml         # 测试环境
│   │   │       │
│   │   │       ├── mapper/                      # MyBatis XML
│   │   │       │   └── system/
│   │   │       │       └── UserMapper.xml
│   │   │       │
│   │   │       ├── db/                          # 数据库脚本
│   │   │       │   ├── schema.sql
│   │   │       │   └── data.sql
│   │   │       │
│   │   │       └── i18n/                        # 国际化
│   │   │           ├── messages.properties
│   │   │           └── messages_zh_CN.properties
│   │   │
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── example/
│   │                   └── project/
│   │                       ├── ProjectApplicationTests.java
│   │                       └── modules/
│   │                           └── system/
│   │                               └── UserServiceTest.java
│   │
│   ├── dockerfile                               # 后端 Docker 配置
│   └── docker-entrypoint.sh                     # Docker 启动脚本
│
├── shared/                                      # 前后端共享资源（可选）
│   ├── api-contracts/                           # API 契约定义
│   │   ├── openapi.yaml                         # OpenAPI 规范
│   │   └── schemas/
│   │       ├── user.schema.json
│   │       └── common.schema.json
│   │
│   └── types/                                   # 共享类型定义
│       └── index.d.ts
│
├── docs/                                        # 项目文档
│   ├── README.md
│   ├── architecture/                            # 架构文档
│   │   ├── system-architecture.md
│   │   └── database-design.md
│   ├── api/                                     # API 文档
│   │   └── README.md
│   ├── deploy/                                  # 部署文档
│   │   ├── docker-deploy.md
│   │   └── k8s-deploy.md
│   └── development/                             # 开发文档
│       ├── frontend-guide.md
│       ├── backend-guide.md
│       └── git-workflow.md
│
├── scripts/                                     # 脚本目录
│   ├── dev.sh                                   # 开发启动脚本
│   ├── build.sh                                 # 构建脚本
│   ├── deploy.sh                                # 部署脚本
│   ├── db/                                      # 数据库脚本
│   │   ├── init.sh
│   │   ├── backup.sh
│   │   └── migrate/
│   └── docker/                                  # Docker 脚本
│       ├── build-images.sh
│       └── push-images.sh
│
├── nginx/                                       # Nginx 配置
│   ├── nginx.conf
│   ├── conf.d/
│   │   ├── default.conf
│   │   └── ssl.conf
│   └── ssl/                                     # SSL 证书
│       ├── cert.pem
│       └── key.pem
│
└── .github/                                     # GitHub 配置
    ├── workflows/                               # CI/CD 工作流
    │   ├── ci.yml
    │   ├── build.yml
    │   └── deploy.yml
    ├── PULL_REQUEST_TEMPLATE.md
    └── ISSUE_TEMPLATE/
```

---

## 2. 各模块详细说明

### 2.1 前端模块 (frontend/)

| 目录 | 用途 | 说明 |
|------|------|------|
| `src/api` | API 管理 | 按业务模块组织，统一错误处理 |
| `src/components` | 组件 | common 通用组件，business 业务组件 |
| `src/composables` | 组合函数 | Vue3 逻辑复用 |
| `src/pages` | 页面 | 按路由结构组织，支持嵌套 |
| `src/stores` | 状态管理 | Pinia 状态模块 |
| `src/utils` | 工具函数 | 包含加密、缓存等工具 |

### 2.2 后端模块 (backend/)

| 目录 | 用途 | 说明 |
|------|------|------|
| `config` | 配置类 | 应用配置、安全配置、缓存配置 |
| `common` | 公共模块 | 常量、枚举、异常、工具类 |
| `security` | 安全认证 | JWT 认证、权限控制 |
| `modules` | 业务模块 | 按功能模块划分 |
| `aspect` | AOP 切面 | 日志、限流等横切关注点 |

### 2.3 共享模块 (shared/)

| 目录 | 用途 | 说明 |
|------|------|------|
| `api-contracts` | API 契约 | OpenAPI 规范，前后端共享 |
| `types` | 类型定义 | TypeScript 类型定义 |

---

## 3. 技术栈推荐

### 3.1 前端技术栈

| 类别 | 技术选型 | 版本 |
|------|----------|------|
| 构建工具 | Vite | ^6.0.x |
| 框架 | Vue 3 | ^3.4.x |
| 路由 | Vue Router | ^4.x |
| 状态管理 | Pinia | ^2.x |
| UI 组件库 | Element Plus / Ant Design Vue | - |
| HTTP 客户端 | Axios | ^1.x |
| 样式 | SCSS + CSS Variables | - |
| 国际化 | Vue I18n | ^9.x |

### 3.2 后端技术栈

| 类别 | 技术选型 | 版本 |
|------|----------|------|
| 框架 | Spring Boot | 3.x |
| ORM | MyBatis Plus | 3.5.x |
| 数据库 | MySQL / PostgreSQL | - |
| 缓存 | Redis | - |
| 安全 | Spring Security + JWT | - |
| 文档 | SpringDoc OpenAPI | 2.x |
| 构建 | Maven | 3.x |

---

## 4. 配置文件示例

### 4.1 前端环境配置

```bash
# .env.development
VITE_APP_TITLE=全栈开发平台
VITE_APP_BASE_API=/api
VITE_APP_API_URL=http://localhost:8080
VITE_APP_UPLOAD_URL=http://localhost:8080/upload
```

```typescript
// vite.config.ts
import { defineConfig, loadEnv } from 'vite';
import vue from '@vitejs/plugin-vue';
import { resolve } from 'path';

export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '');
  
  return {
    base: '/',
    plugins: [vue()],
    resolve: {
      alias: {
        '@': resolve(__dirname, 'src'),
      },
    },
    server: {
      port: 3000,
      proxy: {
        '/api': {
          target: env.VITE_APP_API_URL,
          changeOrigin: true,
          rewrite: (path) => path.replace(/^\/api/, ''),
        },
      },
    },
  };
});
```

### 4.2 后端配置文件

```yaml
# application.yml
server:
  port: 8080

spring:
  application:
    name: fullstack-project
  profiles:
    active: dev
  
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/project_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
    username: ${DB_USERNAME:root}
    password: ${DB_PASSWORD:password}
  
  redis:
    host: localhost
    port: 6379
    password: ${REDIS_PASSWORD:}
    database: 0
    timeout: 5000ms
    lettuce:
      pool:
        max-active: 8
        max-idle: 8
        min-idle: 0

mybatis-plus:
  mapper-locations: classpath*:/mapper/**/*.xml
  type-aliases-package: com.example.project.modules.**.entity
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      logic-delete-field: deleted
      logic-delete-value: 1
      logic-not-delete-value: 0

# JWT 配置
jwt:
  secret: ${JWT_SECRET:your-secret-key}
  expiration: 86400000  # 24小时
  header: Authorization
  token-prefix: Bearer

# 日志配置
logging:
  level:
    com.example.project: DEBUG
```

---

## 5. 前后端集成方案

### 5.1 API 接口规范

```typescript
// 前端 API 定义示例 - src/api/modules/user.ts
import request from '@/utils/request';
import type { User, PageResult, UserQuery } from '@/types';

export const userApi = {
  // 分页查询
  getPage: (params: UserQuery) => 
    request.get<PageResult<User>>('/system/user/page', { params }),
  
  // 获取详情
  getById: (id: number) => 
    request.get<User>(`/system/user/${id}`),
  
  // 创建
  create: (data: Partial<User>) => 
    request.post<number>('/system/user', data),
  
  // 更新
  update: (id: number, data: Partial<User>) => 
    request.put<void>(`/system/user/${id}`, data),
  
  // 删除
  delete: (id: number) => 
    request.delete<void>(`/system/user/${id}`),
};
```

```java
// 后端 Controller 示例
@RestController
@RequestMapping("/system/user")
@Tag(name = "用户管理")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/page")
    @Operation(summary = "分页查询用户")
    public Result<PageResult<UserVO>> page(UserQueryParam param) {
        return Result.success(userService.page(param));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "获取用户详情")
    public Result<UserVO> getById(@PathVariable Long id) {
        return Result.success(userService.getById(id));
    }
    
    @PostMapping
    @Operation(summary = "创建用户")
    @PreAuthorize("@ss.hasPermi('system:user:create')")
    public Result<Long> create(@Valid @RequestBody UserCreateParam param) {
        return Result.success(userService.create(param));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "更新用户")
    @PreAuthorize("@ss.hasPermi('system:user:update')")
    public Result<Void> update(@PathVariable Long id, 
                               @Valid @RequestBody UserUpdateParam param) {
        userService.update(id, param);
        return Result.success();
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户")
    @PreAuthorize("@ss.hasPermi('system:user:delete')")
    public Result<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return Result.success();
    }
}
```

### 5.2 统一响应格式

```java
// 后端统一响应
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    private Long timestamp;
    
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }
    
    public static <T> Result<T> success() {
        return success(null);
    }
    
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }
}
```

```typescript
// 前端响应拦截器处理
instance.interceptors.response.use(
  (response) => {
    const { data } = response;
    if (data.code !== 200) {
      // 统一错误处理
      handleError(data);
      return Promise.reject(data);
    }
    return data.data;
  },
  (error) => {
    // HTTP 错误处理
    handleHttpError(error);
    return Promise.reject(error);
  }
);
```

---

## 6. 开发工作流

### 6.1 启动开发环境

```bash
# 1. 启动后端（端口 8080）
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# 2. 启动前端（端口 3000）
cd frontend
npm install
npm run dev

# 或使用脚本一键启动
cd scripts
./dev.sh
```

### 6.2 构建部署

```bash
# 构建前端
cd frontend
npm run build

# 构建后端
cd backend
./mvnw clean package -DskipTests

# Docker 构建
docker-compose up -d

# 或使用脚本
cd scripts
./build.sh
./deploy.sh
```

---

## 7. 扩展架构方案

### 7.1 微服务架构

```
project-root/
├── frontend/
├── gateway/                    # API 网关
├── auth-service/               # 认证服务
├── user-service/               # 用户服务
├── system-service/             # 系统服务
├── message-service/            # 消息服务
└── infrastructure/
    ├── nacos/                  # 注册中心
    ├── sentinel/               # 限流熔断
    └── seata/                  # 分布式事务
```

### 7.2 多环境部署架构

```
project-root/
├── k8s/                        # Kubernetes 配置
│   ├── base/
│   │   ├── deployment.yaml
│   │   ├── service.yaml
│   │   └── configmap.yaml
│   └── overlays/
│       ├── dev/
│       ├── staging/
│       └── prod/
├── helm/                       # Helm Charts
└── terraform/                  # 基础设施即代码
```

---

## 8. 快速开始

### 8.1 初始化项目

```bash
# 1. 克隆项目模板
git clone https://github.com/your-org/fullstack-template.git my-project
cd my-project

# 2. 初始化数据库
mysql -u root -p < backend/src/main/resources/db/schema.sql

# 3. 配置环境变量
cp backend/.env.example backend/.env
cp frontend/.env.example frontend/.env.local

# 4. 启动开发环境
make dev
```

### 8.2 添加新模块

```bash
# 前端添加新模块
mkdir -p frontend/src/pages/business/order

# 后端添加新模块
mkdir -p backend/src/main/java/com/example/project/modules/business/order
```

---

需要我详细展开其中任何一个方面吗？例如：
- 完整的 Docker Compose 配置
- Kubernetes 部署配置
- 微服务拆分方案
- CI/CD 流水线配置
