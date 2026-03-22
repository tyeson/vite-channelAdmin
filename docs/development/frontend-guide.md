# 前端开发指南

## 目录结构

```
frontend/
├── src/
│   ├── api/              # API 接口
│   ├── components/       # 组件
│   ├── composables/      # 组合函数
│   ├── directives/       # 指令
│   ├── layouts/          # 布局
│   ├── locales/          # 国际化
│   ├── pages/            # 页面
│   ├── router/           # 路由
│   ├── stores/           # 状态
│   ├── styles/           # 样式
│   ├── types/            # 类型
│   └── utils/            # 工具
├── public/               # 静态资源
├── .env                  # 环境变量
└── vite.config.ts        # Vite 配置
```

## 开发规范

### 组件命名

- 组件文件使用 PascalCase：`UserList.vue`
- 组件目录使用 PascalCase：`UserList/index.vue`

### API 管理

```typescript
// src/api/modules/user.ts
export const userApi = {
  getPage: (params) => request.get('/user/page', { params }),
  getById: (id) => request.get(`/user/${id}`),
}
```

### 状态管理

```typescript
// src/stores/modules/user.ts
export const useUserStore = defineStore('user', {
  state: () => ({ userInfo: null }),
  actions: {
    setUserInfo(info) { this.userInfo = info }
  }
})
```

### 组合函数

```typescript
// src/composables/useAuth.ts
export function useAuth() {
  const login = async (params) => { /* ... */ }
  return { login }
}
```

## 常用命令

```bash
npm run dev      # 启动开发服务
npm run build    # 构建生产版本
npm run preview  # 预览构建结果
```
