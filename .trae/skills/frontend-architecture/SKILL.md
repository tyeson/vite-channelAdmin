---
name: "frontend-architecture"
description: "Provides frontend project architecture templates, coding standards, and best practices. Invoke when starting a new frontend project, refactoring existing codebase, or needing standardized project structure guidance."
---

# 前端架构技能 (Frontend Architecture Skill)

## 概述

本技能提供标准化的前端项目架构模板、编码规范和最佳实践，帮助快速搭建高质量、可维护的前端项目。

## 适用场景

- 新项目初始化
- 现有项目重构
- 团队协作规范制定
- 技术选型参考

---

## 1. 项目目录结构

### 1.1 推荐目录结构

```
project-root/
├── public/                     # 静态资源
│   ├── favicon.ico
│   ├── robots.txt
│   └── assets/                 # 不需要构建的静态资源
│
├── src/
│   ├── api/                    # API 接口管理
│   │   ├── modules/            # 按模块组织的接口
│   │   ├── interceptors/       # 请求/响应拦截器
│   │   └── index.ts            # API 统一导出
│   │
│   ├── assets/                 # 需要构建的静态资源
│   │   ├── images/
│   │   ├── icons/
│   │   └── styles/             # 全局样式
│   │       ├── variables.scss  # SCSS 变量
│   │       ├── mixins.scss     # SCSS 混入
│   │       └── global.scss     # 全局样式
│   │
│   ├── components/             # 公共组件
│   │   ├── common/             # 通用组件
│   │   ├── business/           # 业务组件
│   │   └── index.ts            # 组件统一导出
│   │
│   ├── composables/            # Vue3 Composition API 组合函数
│   │   ├── useAuth.ts
│   │   ├── usePermission.ts
│   │   └── index.ts
│   │
│   ├── directives/             # 自定义指令
│   │   ├── permission.ts
│   │   └── index.ts
│   │
│   ├── hooks/                  # React Hooks / Vue 组合式函数
│   │   ├── useTable.ts
│   │   ├── useForm.ts
│   │   └── index.ts
│   │
│   ├── layouts/                # 布局组件
│   │   ├── DefaultLayout/
│   │   ├── AuthLayout/
│   │   └── index.ts
│   │
│   ├── locales/                # 国际化
│   │   ├── zh-CN/
│   │   ├── en-US/
│   │   └── index.ts
│   │
│   ├── mock/                   # Mock 数据
│   │   ├── modules/
│   │   └── index.ts
│   │
│   ├── pages/                  # 页面组件
│   │   ├── home/
│   │   ├── login/
│   │   └── system/
│   │       └── user/
│   │           ├── index.vue
│   │           ├── components/
│   │           └── composables/
│   │
│   ├── plugins/                # 插件
│   │   ├── permission.ts
│   │   └── index.ts
│   │
│   ├── router/                 # 路由配置
│   │   ├── modules/            # 按模块的路由
│   │   ├── guards/             # 路由守卫
│   │   └── index.ts
│   │
│   ├── stores/                 # 状态管理
│   │   ├── modules/
│   │   │   ├── user.ts
│   │   │   ├── app.ts
│   │   │   └── permission.ts
│   │   └── index.ts
│   │
│   ├── styles/                 # 样式文件
│   │   ├── variables.css       # CSS 变量
│   │   ├── animation.scss
│   │   └── index.scss
│   │
│   ├── types/                  # TypeScript 类型定义
│   │   ├── api.d.ts
│   │   ├── global.d.ts
│   │   └── index.ts
│   │
│   ├── utils/                  # 工具函数
│   │   ├── cache.ts            # 缓存管理
│   │   ├── request.ts          # HTTP 请求封装
│   │   ├── validate.ts         # 表单验证
│   │   ├── format.ts           # 格式化工具
│   │   └── index.ts
│   │
│   ├── App.vue
│   ├── main.ts
│   └── vite-env.d.ts
│
├── .husky/                     # Git hooks
├── .vscode/                    # VS Code 配置
│   ├── extensions.json
│   ├── settings.json
│   └── launch.json
│
├── tests/                      # 测试文件
│   ├── unit/
│   ├── e2e/
│   └── setup.ts
│
├── .editorconfig
├── .env                        # 环境变量
├── .env.development
├── .env.production
├── .eslintignore
├── .eslintrc.cjs
├── .gitignore
├── .prettierignore
├── .prettierrc.cjs
├── commitlint.config.cjs
├── index.html
├── package.json
├── README.md
├── tsconfig.json
├── tsconfig.node.json
└── vite.config.ts
```

### 1.2 目录说明

| 目录 | 用途 | 说明 |
|------|------|------|
| `src/api` | 接口管理 | 按业务模块组织，统一错误处理 |
| `src/components` | 组件 | 区分通用组件和业务组件 |
| `src/composables` | 组合函数 | Vue3 特有的逻辑复用 |
| `src/hooks` | Hooks | React/Vue 通用逻辑复用 |
| `src/layouts` | 布局 | 页面级布局组件 |
| `src/pages` | 页面 | 按路由结构组织 |
| `src/stores` | 状态管理 | Pinia/Vuex 状态模块 |
| `src/utils` | 工具函数 | 纯函数，无副作用 |

---

## 2. 编码规范示例

### 2.1 JavaScript/TypeScript 规范

#### 命名规范

```typescript
// ✅ 正确
// 变量 - 小驼峰
const userName = 'John';
const userList: User[] = [];

// 常量 - 全大写下划线
const MAX_RETRY_COUNT = 3;
const API_BASE_URL = '/api';

// 类 - 大驼峰
class UserService {
  // 私有属性 - 下划线前缀
  private _token: string;
  
  // 静态属性
  static readonly VERSION = '1.0.0';
}

// 接口 - 大驼峰 I 前缀（可选）
interface IUserInfo {
  id: number;
  name: string;
}

// 类型别名 - 大驼峰
interface UserInfo {
  id: number;
  name: string;
}

// 枚举 - 大驼峰
enum UserStatus {
  Active = 'active',
  Inactive = 'inactive',
}

// 函数 - 动词开头小驼峰
function getUserById(id: number): User {}
function handleUserLogin() {}

// React 组件 - 大驼峰
function UserProfile() {}

// Vue 组件 - 大驼峰
const UserProfile = defineComponent({});
```

#### 代码风格

```typescript
// ✅ 正确
// 1. 使用严格类型
function calculateTotal(price: number, quantity: number): number {
  return price * quantity;
}

// 2. 优先使用 const/let，避免 var
const config = { timeout: 5000 };
let retryCount = 0;

// 3. 使用可选链和空值合并
const userName = user?.profile?.name ?? 'Anonymous';

// 4. 使用解构
const { id, name, email } = user;
const [first, ...rest] = items;

// 5. 使用 async/await
async function fetchUserData(userId: number): Promise<User> {
  try {
    const response = await api.get(`/users/${userId}`);
    return response.data;
  } catch (error) {
    console.error('Failed to fetch user:', error);
    throw error;
  }
}

// 6. 使用模板字符串
const message = `Hello, ${userName}! You have ${count} new messages.`;

// 7. 避免嵌套过深
// ❌ 错误
if (user) {
  if (user.isActive) {
    if (user.hasPermission) {
      // ...
    }
  }
}

// ✅ 正确
if (!user?.isActive) return;
if (!user.hasPermission) return;
// ...
```

### 2.2 Vue 组件规范

#### 单文件组件结构

```vue
<script setup lang="ts">
// 1. 导入（按类型分组）
import { ref, computed, onMounted } from 'vue';
import type { PropType } from 'vue';

// 组件
import BaseButton from '@/components/common/BaseButton.vue';

// 组合函数
import { useUserStore } from '@/stores/modules/user';
import { usePermission } from '@/composables/usePermission';

// 类型
import type { UserInfo } from '@/types';

// 工具
import { formatDate } from '@/utils/format';

// 2. Props 定义
interface Props {
  userId: number;
  editable?: boolean;
}

const props = withDefaults(defineProps<Props>(), {
  editable: false,
});

// 3. Emits 定义
const emit = defineEmits<{
  (e: 'update', id: number): void;
  (e: 'delete', id: number): void;
}>();

// 4. 状态定义
const loading = ref(false);
const userInfo = ref<UserInfo | null>(null);

// 5. 计算属性
const displayName = computed(() => {
  return userInfo.value?.nickname || userInfo.value?.username || 'Unknown';
});

// 6. 方法
async function loadUserData() {
  loading.value = true;
  try {
    userInfo.value = await fetchUser(props.userId);
  } finally {
    loading.value = false;
  }
}

function handleUpdate() {
  emit('update', props.userId);
}

// 7. 生命周期
onMounted(() => {
  loadUserData();
});
</script>

<template>
  <div class="user-card">
    <div v-if="loading" class="loading">Loading...</div>
    <template v-else-if="userInfo">
      <h3 class="user-name">{{ displayName }}</h3>
      <p class="user-email">{{ userInfo.email }}</p>
      <BaseButton v-if="editable" @click="handleUpdate">
        Edit
      </BaseButton>
    </template>
  </div>
</template>

<style scoped lang="scss">
.user-card {
  padding: 16px;
  border-radius: 8px;
  background: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .user-name {
    font-size: 18px;
    font-weight: 600;
    margin-bottom: 8px;
  }

  .user-email {
    color: #666;
    font-size: 14px;
  }
}
</style>
```

### 2.3 React 组件规范

```tsx
// 1. 导入排序
import React, { useState, useEffect, useCallback } from 'react';
import type { FC } from 'react';

// 第三方库
import { useQuery } from '@tanstack/react-query';

// 组件
import { Button } from '@/components/ui/Button';

// Hooks
import { useAuth } from '@/hooks/useAuth';

// 类型
import type { User } from '@/types';

// 工具
import { formatDate } from '@/utils/format';

// 样式
import styles from './UserCard.module.scss';

// 2. Props 接口
interface UserCardProps {
  userId: string;
  editable?: boolean;
  onUpdate?: (user: User) => void;
}

// 3. 组件定义
export const UserCard: FC<UserCardProps> = ({
  userId,
  editable = false,
  onUpdate,
}) => {
  // 4. Hooks
  const { user: currentUser } = useAuth();
  const { data: user, isLoading } = useQuery(['user', userId], fetchUser);

  // 5. 状态
  const [isEditing, setIsEditing] = useState(false);

  // 6. 计算值
  const canEdit = editable && currentUser?.id === userId;

  // 7. 事件处理
  const handleEdit = useCallback(() => {
    setIsEditing(true);
  }, []);

  const handleSave = useCallback(
    (updatedUser: User) => {
      onUpdate?.(updatedUser);
      setIsEditing(false);
    },
    [onUpdate]
  );

  // 8. 渲染
  if (isLoading) {
    return <div className={styles.loading}>Loading...</div>;
  }

  if (!user) {
    return <div className={styles.error}>User not found</div>;
  }

  return (
    <div className={styles.card}>
      <h3 className={styles.name}>{user.name}</h3>
      <p className={styles.email}>{user.email}</p>
      {canEdit && <Button onClick={handleEdit}>Edit</Button>}
    </div>
  );
};

export default UserCard;
```

### 2.4 CSS/SCSS 规范

```scss
// variables.scss
:root {
  // 颜色系统
  --color-primary: #1890ff;
  --color-success: #52c41a;
  --color-warning: #faad14;
  --color-error: #f5222d;
  
  // 中性色
  --color-black: #000;
  --color-white: #fff;
  --color-gray-100: #f7f8fa;
  --color-gray-200: #e5e6eb;
  --color-gray-300: #c9cdd4;
  --color-gray-400: #86909c;
  --color-gray-500: #4e5969;
  
  // 字体
  --font-family-base: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
    'Helvetica Neue', Arial, sans-serif;
  --font-size-xs: 12px;
  --font-size-sm: 14px;
  --font-size-base: 16px;
  --font-size-lg: 18px;
  --font-size-xl: 20px;
  
  // 间距
  --spacing-xs: 4px;
  --spacing-sm: 8px;
  --spacing-md: 16px;
  --spacing-lg: 24px;
  --spacing-xl: 32px;
  
  // 圆角
  --radius-sm: 4px;
  --radius-md: 8px;
  --radius-lg: 12px;
  
  // 阴影
  --shadow-sm: 0 1px 2px rgba(0, 0, 0, 0.05);
  --shadow-md: 0 4px 6px rgba(0, 0, 0, 0.1);
  --shadow-lg: 0 10px 15px rgba(0, 0, 0, 0.1);
}

// mixins.scss
@mixin flex-center {
  display: flex;
  align-items: center;
  justify-content: center;
}

@mixin text-ellipsis {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

@mixin multi-ellipsis($lines: 2) {
  display: -webkit-box;
  -webkit-line-clamp: $lines;
  -webkit-box-orient: vertical;
  overflow: hidden;
}

@mixin responsive($breakpoint) {
  @if $breakpoint == sm {
    @media (min-width: 640px) { @content; }
  } @else if $breakpoint == md {
    @media (min-width: 768px) { @content; }
  } @else if $breakpoint == lg {
    @media (min-width: 1024px) { @content; }
  } @else if $breakpoint == xl {
    @media (min-width: 1280px) { @content; }
  }
}

// 使用示例
.user-card {
  @include flex-center;
  padding: var(--spacing-md);
  background: var(--color-white);
  border-radius: var(--radius-md);
  box-shadow: var(--shadow-sm);
  
  .user-name {
    @include text-ellipsis;
    font-size: var(--font-size-lg);
    color: var(--color-gray-500);
  }
  
  @include responsive(md) {
    padding: var(--spacing-lg);
  }
}
```

---

## 3. 常用工具脚本

### 3.1 HTTP 请求封装

```typescript
// utils/request.ts
import axios, { AxiosError, AxiosInstance, AxiosRequestConfig } from 'axios';
import { useUserStore } from '@/stores/modules/user';
import { showErrorMessage } from '@/utils/message';

interface ApiResponse<T> {
  code: number;
  data: T;
  message: string;
}

class Request {
  private instance: AxiosInstance;

  constructor(config?: AxiosRequestConfig) {
    this.instance = axios.create({
      baseURL: import.meta.env.VITE_API_BASE_URL,
      timeout: 10000,
      ...config,
    });

    this.setupInterceptors();
  }

  private setupInterceptors() {
    // 请求拦截器
    this.instance.interceptors.request.use(
      (config) => {
        const userStore = useUserStore();
        if (userStore.token) {
          config.headers.Authorization = `Bearer ${userStore.token}`;
        }
        return config;
      },
      (error) => Promise.reject(error)
    );

    // 响应拦截器
    this.instance.interceptors.response.use(
      (response) => {
        const { data } = response;
        if (data.code !== 200) {
          showErrorMessage(data.message);
          return Promise.reject(data);
        }
        return data.data;
      },
      (error: AxiosError) => {
        const { response } = error;
        if (response?.status === 401) {
          // 处理未授权
          const userStore = useUserStore();
          userStore.logout();
        } else {
          showErrorMessage(error.message);
        }
        return Promise.reject(error);
      }
    );
  }

  public get<T>(url: string, config?: AxiosRequestConfig): Promise<T> {
    return this.instance.get(url, config);
  }

  public post<T>(url: string, data?: unknown, config?: AxiosRequestConfig): Promise<T> {
    return this.instance.post(url, data, config);
  }

  public put<T>(url: string, data?: unknown, config?: AxiosRequestConfig): Promise<T> {
    return this.instance.put(url, data, config);
  }

  public delete<T>(url: string, config?: AxiosRequestConfig): Promise<T> {
    return this.instance.delete(url, config);
  }
}

export const request = new Request();
export default request;
```

### 3.2 缓存管理

```typescript
// utils/cache.ts
enum StorageType {
  Local = 'localStorage',
  Session = 'sessionStorage',
}

interface CacheOptions {
  type?: StorageType;
  expire?: number; // 过期时间（毫秒）
}

interface CacheItem<T> {
  data: T;
  expire: number;
}

class Cache {
  private storage: Storage;

  constructor(type: StorageType = StorageType.Local) {
    this.storage = type === StorageType.Local ? localStorage : sessionStorage;
  }

  set<T>(key: string, value: T, expire?: number): void {
    const data: CacheItem<T> = {
      data: value,
      expire: expire ? Date.now() + expire : 0,
    };
    this.storage.setItem(key, JSON.stringify(data));
  }

  get<T>(key: string): T | null {
    const item = this.storage.getItem(key);
    if (!item) return null;

    const { data, expire }: CacheItem<T> = JSON.parse(item);
    if (expire && Date.now() > expire) {
      this.remove(key);
      return null;
    }
    return data;
  }

  remove(key: string): void {
    this.storage.removeItem(key);
  }

  clear(): void {
    this.storage.clear();
  }
}

// 导出实例
export const localCache = new Cache(StorageType.Local);
export const sessionCache = new Cache(StorageType.Session);
export default Cache;
```

### 3.3 路由守卫

```typescript
// router/guards/index.ts
import type { Router, NavigationGuardNext, RouteLocationNormalized } from 'vue-router';
import { useUserStore } from '@/stores/modules/user';
import { usePermissionStore } from '@/stores/modules/permission';
import { whiteList } from '@/config/routes';

export function setupRouterGuards(router: Router) {
  // 前置守卫
  router.beforeEach(
    async (
      to: RouteLocationNormalized,
      from: RouteLocationNormalized,
      next: NavigationGuardNext
    ) => {
      // 设置页面标题
      document.title = to.meta.title || 'App';

      const userStore = useUserStore();
      const permissionStore = usePermissionStore();

      // 1. 检查是否在白名单
      if (whiteList.includes(to.path)) {
        return next();
      }

      // 2. 检查登录状态
      const token = userStore.token;
      if (!token) {
        return next(`/login?redirect=${encodeURIComponent(to.fullPath)}`);
      }

      // 3. 检查用户信息
      if (!userStore.userInfo) {
        try {
          await userStore.getUserInfo();
        } catch {
          userStore.logout();
          return next(`/login?redirect=${encodeURIComponent(to.fullPath)}`);
        }
      }

      // 4. 检查权限
      if (to.meta.permission && !permissionStore.hasPermission(to.meta.permission)) {
        return next('/403');
      }

      next();
    }
  );

  // 后置守卫
  router.afterEach((to) => {
    // 可以在这里处理页面统计等
    console.log('Route changed to:', to.path);
  });

  // 错误处理
  router.onError((error) => {
    console.error('Router error:', error);
  });
}
```

### 3.4 常用 Hooks

```typescript
// hooks/useTable.ts
import { ref, computed, onMounted } from 'vue';
import type { Ref } from 'vue';

interface Pagination {
  page: number;
  pageSize: number;
  total: number;
}

interface UseTableOptions<T, Q> {
  api: (params: Q & Pagination) => Promise<{ list: T[]; total: number }>;
  defaultQuery?: Q;
  defaultPageSize?: number;
  immediate?: boolean;
}

export function useTable<T, Q extends Record<string, unknown>>(options: UseTableOptions<T, Q>) {
  const { api, defaultQuery = {} as Q, defaultPageSize = 10, immediate = true } = options;

  const loading = ref(false);
  const data: Ref<T[]> = ref([]);
  const query = ref<Q>({ ...defaultQuery });
  const pagination = ref<Pagination>({
    page: 1,
    pageSize: defaultPageSize,
    total: 0,
  });

  const fetchData = async () => {
    loading.value = true;
    try {
      const res = await api({
        ...query.value,
        page: pagination.value.page,
        pageSize: pagination.value.pageSize,
      });
      data.value = res.list;
      pagination.value.total = res.total;
    } finally {
      loading.value = false;
    }
  };

  const handlePageChange = (page: number) => {
    pagination.value.page = page;
    fetchData();
  };

  const handleSizeChange = (size: number) => {
    pagination.value.pageSize = size;
    pagination.value.page = 1;
    fetchData();
  };

  const handleSearch = () => {
    pagination.value.page = 1;
    fetchData();
  };

  const handleReset = () => {
    query.value = { ...defaultQuery };
    pagination.value.page = 1;
    fetchData();
  };

  if (immediate) {
    onMounted(fetchData);
  }

  return {
    loading,
    data,
    query,
    pagination,
    fetchData,
    handlePageChange,
    handleSizeChange,
    handleSearch,
    handleReset,
  };
}
```

---

## 4. 配置文件模板

### 4.1 ESLint 配置

```javascript
// .eslintrc.cjs
module.exports = {
  root: true,
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  extends: [
    'eslint:recommended',
    'plugin:@typescript-eslint/recommended',
    'plugin:vue/vue3-recommended',
    'plugin:prettier/recommended',
  ],
  parser: 'vue-eslint-parser',
  parserOptions: {
    ecmaVersion: 'latest',
    parser: '@typescript-eslint/parser',
    sourceType: 'module',
  },
  plugins: ['@typescript-eslint', 'vue'],
  rules: {
    // Vue
    'vue/multi-word-component-names': 'off',
    'vue/no-v-html': 'off',
    'vue/require-default-prop': 'off',
    
    // TypeScript
    '@typescript-eslint/no-explicit-any': 'warn',
    '@typescript-eslint/no-unused-vars': ['error', { argsIgnorePattern: '^_' }],
    
    // 通用
    'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
  },
};
```

### 4.2 Prettier 配置

```javascript
// .prettierrc.cjs
module.exports = {
  semi: true,
  singleQuote: true,
  tabWidth: 2,
  trailingComma: 'es5',
  printWidth: 100,
  bracketSpacing: true,
  arrowParens: 'always',
  endOfLine: 'lf',
  vueIndentScriptAndStyle: true,
};
```

### 4.3 Vite 配置

```typescript
// vite.config.ts
import { defineConfig, loadEnv } from 'vite';
import vue from '@vitejs/plugin-vue';
import { resolve } from 'path';
import AutoImport from 'unplugin-auto-import/vite';
import Components from 'unplugin-vue-components/vite';
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers';

export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '');

  return {
    base: env.VITE_BASE_URL || '/',
    
    plugins: [
      vue(),
      
      // 自动导入
      AutoImport({
        imports: ['vue', 'vue-router', 'pinia'],
        dts: 'src/types/auto-imports.d.ts',
        resolvers: [ElementPlusResolver()],
      }),
      
      // 组件自动导入
      Components({
        dts: 'src/types/components.d.ts',
        resolvers: [ElementPlusResolver()],
      }),
    ],

    resolve: {
      alias: {
        '@': resolve(__dirname, 'src'),
        '~': resolve(__dirname, 'src/assets'),
      },
    },

    css: {
      preprocessorOptions: {
        scss: {
          additionalData: `
            @use "@/styles/variables.scss" as *;
            @use "@/styles/mixins.scss" as *;
          `,
        },
      },
    },

    server: {
      port: 3000,
      open: true,
      proxy: {
        '/api': {
          target: env.VITE_API_BASE_URL,
          changeOrigin: true,
          rewrite: (path) => path.replace(/^\/api/, ''),
        },
      },
    },

    build: {
      target: 'es2015',
      outDir: 'dist',
      assetsDir: 'assets',
      sourcemap: mode !== 'production',
      rollupOptions: {
        output: {
          manualChunks: {
            vendor: ['vue', 'vue-router', 'pinia'],
          },
        },
      },
    },
  };
});
```

---

## 5. 最佳实践建议

### 5.1 性能优化

1. **代码分割**: 使用动态导入实现路由级代码分割
2. **图片优化**: 使用 WebP 格式，实现懒加载
3. **缓存策略**: 合理使用浏览器缓存和 Service Worker
4. **虚拟列表**: 大数据量列表使用虚拟滚动

### 5.2 安全建议

1. **XSS 防护**: 使用 v-html 时确保内容已转义
2. **CSRF 防护**: 使用 CSRF Token 或 SameSite Cookie
3. **敏感信息**: 不在前端存储敏感信息
4. **输入验证**: 前端和后端都要进行输入验证

### 5.3 可访问性

1. **语义化 HTML**: 使用正确的 HTML 标签
2. **ARIA 属性**: 为复杂组件添加 ARIA 属性
3. **键盘导航**: 确保所有功能可通过键盘访问
4. **对比度**: 确保文字和背景对比度符合 WCAG 标准

---

## 6. 快速开始

### 创建新项目

```bash
# 使用 Vite 创建项目
npm create vite@latest my-project -- --template vue-ts

# 安装依赖
cd my-project
npm install

# 安装常用依赖
npm install vue-router@4 pinia axios element-plus
npm install -D sass typescript @types/node
npm install -D eslint prettier eslint-plugin-vue @typescript-eslint/eslint-plugin @typescript-eslint/parser
npm install -D unplugin-auto-import unplugin-vue-components
```

### 应用本架构

1. 复制上述目录结构到你的项目
2. 复制配置文件（ESLint、Prettier、Vite 等）
3. 根据项目需求调整配置
4. 开始开发！

---

## 7. 扩展建议

以下是一些可以让项目架构更完整的建议，你可以根据项目需求选择：

### 7.1 微前端架构
- 使用 qiankun 或 single-spa 实现微前端
- 适用于大型、多团队协作的项目

### 7.2 Monorepo 架构
- 使用 pnpm workspace + Turborepo
- 适用于包含多个相关项目的场景

### 7.3 组件库开发
- 使用 Storybook 进行组件开发和文档管理
- 发布私有 npm 包供多个项目使用

### 7.4 测试体系
- 单元测试：Vitest + Vue Test Utils
- E2E 测试：Playwright 或 Cypress
- 视觉回归测试：Chromatic

### 7.5 CI/CD 流程
- GitHub Actions / GitLab CI
- 自动化测试、构建、部署
- 代码质量门禁（SonarQube）

### 7.6 监控体系
- 错误监控：Sentry
- 性能监控：Web Vitals
- 用户行为分析

需要我详细展开其中任何一个方面吗？
