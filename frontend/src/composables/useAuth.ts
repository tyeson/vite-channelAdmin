import { ref, computed } from 'vue'
import { useUserStore } from '@/stores/modules/user'
import { useRouter } from 'vue-router'
import { authApi } from '@/api'
import type { LoginParams } from '@/types'
import { ElMessage } from 'element-plus'

export function useAuth() {
  const userStore = useUserStore()
  const router = useRouter()
  const loading = ref(false)

  const isLoggedIn = computed(() => userStore.isLoggedIn)
  const userInfo = computed(() => userStore.userInfo)
  const token = computed(() => userStore.token)

  const login = async (params: LoginParams) => {
    loading.value = true
    try {
      const result = await authApi.login(params)
      userStore.setToken(result.token)
      userStore.setUserInfo(result.user)
      ElMessage.success('登录成功')
      await router.push('/')
      return true
    } catch (error) {
      ElMessage.error('登录失败')
      return false
    } finally {
      loading.value = false
    }
  }

  const logout = async () => {
    try {
      await authApi.logout()
    } finally {
      userStore.clearAuth()
      router.push('/login')
    }
  }

  const fetchUserInfo = async () => {
    try {
      const info = await authApi.getUserInfo()
      userStore.setUserInfo(info)
      return info
    } catch {
      userStore.clearAuth()
      router.push('/login')
      return null
    }
  }

  return {
    loading,
    isLoggedIn,
    userInfo,
    token,
    login,
    logout,
    fetchUserInfo,
  }
}
