import request from '@/utils/request'
import type { User, PageResult, UserQuery } from '@/types'

export const userApi = {
  getPage: (params: UserQuery) =>
    request.get<PageResult<User>>('/system/user/page', { params }),

  getById: (id: number) =>
    request.get<User>(`/system/user/${id}`),

  create: (data: Partial<User>) =>
    request.post<number>('/system/user', data),

  update: (id: number, data: Partial<User>) =>
    request.put<void>(`/system/user/${id}`, data),

  delete: (id: number) =>
    request.delete<void>(`/system/user/${id}`),
}
