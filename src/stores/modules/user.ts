import { defineStore } from 'pinia'
import { getToken, setToken, removeToken, setUserInfo, removeUserInfo } from '@/utils/storage'
import type { UserInfo } from '@/types'

interface UserState {
  token: string | null
  userInfo: UserInfo | null
}

export const useUserStore = defineStore('user', {
  state: (): UserState => ({
    token: getToken(),
    userInfo: null,
  }),

  getters: {
    isLoggedIn: (state) => !!state.token,
    username: (state) => state.userInfo?.username || '',
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
  },
})
