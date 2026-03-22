export interface UserInfo {
  id: number
  username: string
  nickname?: string
  avatar?: string
  email?: string
  phone?: string
  roles?: string[]
  permissions?: string[]
  status?: number
  createTime?: string
  lastLoginTime?: string
}

export interface LoginParams {
  username: string
  password: string
  remember?: boolean
}

export interface LoginResult {
  token: string
  user: UserInfo
}

export interface ApiResponse<T = any> {
  code: number
  data: T
  message: string
  timestamp?: number
}

export interface PageResult<T> {
  list: T[]
  total: number
  page: number
  pageSize: number
}

export interface UserQuery {
  username?: string
  nickname?: string
  status?: number
  page?: number
  pageSize?: number
}

export interface User {
  id: number
  username: string
  nickname: string
  email?: string
  phone?: string
  status: number
  createTime: string
  lastLoginTime?: string
}

export interface Menu {
  id: number
  parentId: number
  name: string
  path: string
  component?: string
  icon?: string
  sort: number
  visible: boolean
  children?: Menu[]
}

export interface Role {
  id: number
  name: string
  code: string
  description?: string
  status: number
  createTime: string
}

export interface TableColumn {
  prop: string
  label: string
  width?: string | number
  minWidth?: string | number
  fixed?: 'left' | 'right' | boolean
  sortable?: boolean | 'custom'
  formatter?: (row: any, column: any, cellValue: any) => string
}

export interface FormItem {
  prop: string
  label: string
  type: 'input' | 'select' | 'date' | 'switch' | 'textarea'
  placeholder?: string
  options?: { label: string; value: any }[]
  rules?: any[]
  span?: number
}
