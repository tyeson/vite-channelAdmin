# 项目创建计划：Vite + Vue3 + TypeScript + Element Plus 后台管理系统

## 项目概述
创建一个基于 Vite 8.0 + TypeScript + Vue 3.0 + Element Plus 的后台管理系统项目，并实现登录页面功能。

---

## 一、项目初始化

### 1.1 使用 Vite 创建项目
- 使用 `npm create vite@latest` 创建 Vue + TypeScript 项目
- 项目名称：在当前目录初始化

### 1.2 安装核心依赖
- **vue-router**: 路由管理
- **pinia**: 状态管理
- **element-plus**: UI 组件库
- **axios**: HTTP 请求
- **sass**: CSS 预处理器

### 1.3 安装开发依赖
- **unplugin-auto-import**: 自动导入 Vue API
- **unplugin-vue-components**: 组件自动导入
- **@element-plus/icons-vue**: Element Plus 图标库

---

## 二、项目结构搭建

```
src/
├── api/                    # API 接口管理
│   ├── modules/
│   │   └── user.ts        # 用户相关接口
│   └── index.ts           # 请求封装
├── assets/                 # 静态资源
│   └── styles/
│       ├── variables.scss  # SCSS 变量
│       └── global.scss     # 全局样式
├── components/             # 公共组件
├── composables/            # 组合函数
├── layouts/                # 布局组件
│   └── DefaultLayout.vue
├── pages/                  # 页面组件
│   ├── login/
│   │   └── index.vue      # 登录页面
│   └── home/
│       └── index.vue      # 首页
├── router/                 # 路由配置
│   └── index.ts
├── stores/                 # 状态管理
│   ├── modules/
│   │   └── user.ts        # 用户状态
│   └── index.ts
├── types/                  # TypeScript 类型
│   └── index.d.ts
├── utils/                  # 工具函数
│   ├── request.ts         # HTTP 请求封装
│   └── storage.ts         # 本地存储
├── App.vue
└── main.ts
```

---

## 三、配置文件设置

### 3.1 Vite 配置 (vite.config.ts)
- 配置路径别名 `@`
- 配置 Element Plus 自动导入
- 配置开发服务器代理

### 3.2 TypeScript 配置 (tsconfig.json)
- 配置路径映射
- 添加必要的类型声明

### 3.3 环境变量
- `.env.development`: 开发环境配置
- `.env.production`: 生产环境配置

---

## 四、核心功能实现

### 4.1 登录页面功能
- 用户名/密码登录表单
- 表单验证（用户名、密码必填）
- 记住密码功能
- 登录按钮 loading 状态
- 登录成功后跳转到首页

### 4.2 用户状态管理 (Pinia)
- 用户信息存储
- Token 管理
- 登录/登出方法

### 4.3 路由配置
- 配置登录页面路由 `/login`
- 配置首页路由 `/`
- 路由守卫：未登录重定向到登录页

### 4.4 HTTP 请求封装
- Axios 实例创建
- 请求拦截器（添加 Token）
- 响应拦截器（错误处理）

---

## 五、样式设计

### 5.1 登录页面样式
- 居中布局
- 登录卡片设计
- 响应式适配

### 5.2 全局样式
- CSS 变量定义
- 主题色配置
- 常用工具类

---

## 六、执行步骤

| 步骤 | 任务 | 说明 |
|------|------|------|
| 1 | 创建 Vite 项目 | 使用 npm create vite 初始化 |
| 2 | 安装依赖 | 安装所有必要的 npm 包 |
| 3 | 配置 Vite | 配置别名、插件、代理 |
| 4 | 创建目录结构 | 按照规划创建目录和文件 |
| 5 | 实现 HTTP 封装 | 创建 axios 请求工具 |
| 6 | 实现状态管理 | 创建 Pinia store |
| 7 | 实现路由配置 | 配置路由和守卫 |
| 8 | 实现登录页面 | 创建登录组件和样式 |
| 9 | 测试验证 | 启动项目验证功能 |

---

## 七、预期成果

完成后项目将具备：
1. ✅ 完整的项目结构和配置
2. ✅ 登录页面（用户名/密码登录）
3. ✅ 路由守卫（登录验证）
4. ✅ 状态管理（用户信息）
5. ✅ HTTP 请求封装
6. ✅ Element Plus UI 集成
