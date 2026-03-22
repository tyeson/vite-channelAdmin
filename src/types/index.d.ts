export interface UserInfo {
  id: number
  username: string
  nickname?: string
  avatar?: string
  email?: string
  phone?: string
  roles?: string[]
}

export interface LoginForm {
  username: string
  password: string
  remember?: boolean
}

export interface ApiResponse<T> {
  code: number
  data: T
  message: string
}
