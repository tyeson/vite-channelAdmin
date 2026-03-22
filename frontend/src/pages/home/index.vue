<template>
  <div class="home-page">
    <el-card>
      <template #header>
        <span>欢迎使用后台管理系统</span>
      </template>
      <div class="welcome">
        <el-icon :size="60" color="#409eff"><HomeFilled /></el-icon>
        <h2>欢迎回来，{{ userStore.username || '管理员' }}！</h2>
        <p>这是一个基于 Vite + Vue3 + TypeScript + Element Plus 构建的后台管理系统模板</p>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { HomeFilled } from '@element-plus/icons-vue'
import { useUserStore } from '@/stores/modules/user'

const userStore = useUserStore()
</script>

<style scoped lang="scss">
.home-page {
  .welcome {
    text-align: center;
    padding: 40px 0;

    h2 {
      margin: 20px 0 10px;
      color: #333;
    }

    p {
      color: #666;
    }
  }
}
</style>
