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
