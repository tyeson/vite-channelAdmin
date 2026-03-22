import { defineStore } from 'pinia'
import { getToken, setToken, removeToken, getUserInfo, setUserInfo, removeUserInfo } from '@/utils/storage'
import type { UserInfo } from '@/types'

interface UserState {
  token: string | null
  userInfo: UserInfo | null
}

export const useUserStore = defineStore('user', {
  state: (): UserState => ({
    token: getToken(),
    userInfo: getUserInfo<UserInfo>(),
  }),

  getters: {
    isLoggedIn: (state) => !!state.token,
    username: (state) => state.userInfo?.username || state.userInfo?.nickname || '',
  },

  actions: {
    setToken(token: string) {
      this.token = token
      setToken(token)
    },

    setUserInfo(info: UserInfo) {
      this.userInfo = info
      setUserInfo(info)
    },

    login(token: string, userInfo: UserInfo) {
      this.setToken(token)
      this.setUserInfo(userInfo)
    },

    logout() {
      this.token = null
      this.userInfo = null
      removeToken()
      removeUserInfo()
    },

    clearAuth() {
      this.logout()
    },
  },
})
