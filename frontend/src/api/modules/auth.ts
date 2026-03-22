import request from '@/utils/request'
import type { LoginParams, LoginResult, UserInfo } from '@/types'

export const authApi = {
  login: (data: LoginParams) =>
    request.post<LoginResult>('/auth/login', data),

  logout: () =>
    request.post<void>('/auth/logout'),

  getUserInfo: () =>
    request.get<UserInfo>('/auth/user-info'),

  refreshToken: () =>
    request.post<{ token: string }>('/auth/refresh'),
}
