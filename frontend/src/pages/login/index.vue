<template>
  <div class="login-container">
    <!-- 背景装饰元素 -->
    <div class="bg-decoration">
      <div class="circle circle-1"></div>
      <div class="circle circle-2"></div>
      <div class="circle circle-3"></div>
      <div class="grid-pattern"></div>
    </div>

    <!-- 登录卡片 -->
    <div class="login-wrapper">
      <div class="login-card">
        <!-- Logo区域 -->
        <div class="logo-section">
          <div class="logo-icon">
            <el-icon :size="40" color="#fff"><Lock /></el-icon>
          </div>
          <h1 class="title">渠道管理系统</h1>
          <p class="subtitle">欢迎回来，请登录您的账号</p>
        </div>

        <!-- 登录表单 -->
        <el-form ref="loginFormRef" :model="loginForm" :rules="loginRules" class="login-form" @keyup.enter="handleLogin">
          <el-form-item prop="username">
            <div class="input-wrapper">
              <el-icon class="input-icon"><User /></el-icon>
              <el-input v-model="loginForm.username" placeholder="请输入用户名" size="large" class="custom-input" />
            </div>
          </el-form-item>

          <el-form-item prop="password">
            <div class="input-wrapper">
              <el-icon class="input-icon"><Lock /></el-icon>
              <el-input v-model="loginForm.password" type="password" placeholder="请输入密码" size="large" class="custom-input" show-password />
            </div>
          </el-form-item>

          <div class="form-options">
            <el-checkbox v-model="loginForm.remember" class="remember-checkbox"> 记住密码 </el-checkbox>
            <a href="#" class="forgot-link" @click.prevent="handleForgotPassword"> 忘记密码？ </a>
          </div>

          <el-form-item class="login-btn-item">
            <el-button type="primary" size="large" class="login-btn" :loading="loading" @click="handleLogin">
              <span class="btn-text">登 录</span>
              <el-icon class="btn-icon"><ArrowRight /></el-icon>
            </el-button>
          </el-form-item>
        </el-form>

        <!-- 底部信息 -->
        <div class="login-footer">
          <p class="footer-text">还没有账号？ <a href="#" class="register-link" @click.prevent="handleRegister">立即注册</a></p>
        </div>
      </div>

      <!-- 版权信息 -->
      <p class="copyright">© 2024 渠道管理系统 版权所有</p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { User, Lock, ArrowRight } from '@element-plus/icons-vue'
import { ElMessage, type FormInstance, type FormRules } from 'element-plus'
import { useAuth } from '@/composables/useAuth'

const router = useRouter()
const route = useRoute()
const { login, loading } = useAuth()

const loginFormRef = ref<FormInstance>()

const loginForm = reactive({
  username: '',
  password: '',
  remember: false
})

const loginRules: FormRules = {
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 3, max: 20, message: '用户名长度在 3 到 20 个字符', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 6, max: 20, message: '密码长度在 6 到 20 个字符', trigger: 'blur' }
  ]
}

const handleLogin = async () => {
  if (!loginFormRef.value) return

  await loginFormRef.value.validate(async valid => {
    if (!valid) return

    const success = await login({
      username: loginForm.username,
      password: loginForm.password,
      remember: loginForm.remember
    })

    if (success) {
      const redirect = (route.query.redirect as string) || '/'
      router.push(redirect)
    }
  })
}

const handleForgotPassword = () => {
  ElMessage.info('请联系管理员重置密码')
}

const handleRegister = () => {
  ElMessage.info('请联系管理员开通账号')
}
</script>

<style scoped lang="scss">
// 颜色变量
$primary-color: #6366f1;
$primary-hover: #4f46e5;
$primary-light: #818cf8;
$bg-gradient-start: #667eea;
$bg-gradient-end: #764ba2;
$card-bg: rgba(255, 255, 255, 0.95);
$text-primary: #1f2937;
$text-secondary: #6b7280;
$border-color: #e5e7eb;

.login-container {
  width: 100%;
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(135deg, $bg-gradient-start 0%, $bg-gradient-end 100%);
  position: relative;
  overflow: hidden;
  padding: 20px;
}

// 背景装饰
.bg-decoration {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  pointer-events: none;
  overflow: hidden;

  .circle {
    position: absolute;
    border-radius: 50%;
    background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(1px);

    &-1 {
      width: 600px;
      height: 600px;
      top: -200px;
      right: -100px;
      animation: float 20s ease-in-out infinite;
    }

    &-2 {
      width: 400px;
      height: 400px;
      bottom: -100px;
      left: -100px;
      animation: float 25s ease-in-out infinite reverse;
    }

    &-3 {
      width: 300px;
      height: 300px;
      top: 50%;
      left: 20%;
      background: rgba(255, 255, 255, 0.05);
      animation: float 30s ease-in-out infinite;
    }
  }

  .grid-pattern {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: linear-gradient(rgba(255, 255, 255, 0.03) 1px, transparent 1px), linear-gradient(90deg, rgba(255, 255, 255, 0.03) 1px, transparent 1px);
    background-size: 50px 50px;
  }
}

@keyframes float {
  0%,
  100% {
    transform: translateY(0) rotate(0deg);
  }
  50% {
    transform: translateY(-30px) rotate(5deg);
  }
}

// 登录包装器
.login-wrapper {
  position: relative;
  z-index: 1;
  width: 100%;
  max-width: 440px;
  animation: slideUp 0.6s ease-out;
}

@keyframes slideUp {
  from {
    opacity: 0;
    transform: translateY(30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

// 登录卡片
.login-card {
  width: 100%;
  padding: 48px 40px;
  background: $card-bg;
  border-radius: 24px;
  box-shadow:
    0 25px 50px -12px rgba(0, 0, 0, 0.25),
    0 0 0 1px rgba(255, 255, 255, 0.1) inset;
  backdrop-filter: blur(20px);
  transition:
    transform 0.3s ease,
    box-shadow 0.3s ease;

  &:hover {
    transform: translateY(-2px);
    box-shadow:
      0 30px 60px -12px rgba(0, 0, 0, 0.3),
      0 0 0 1px rgba(255, 255, 255, 0.15) inset;
  }
}

// Logo区域
.logo-section {
  text-align: center;
  margin-bottom: 32px;

  .logo-icon {
    width: 72px;
    height: 72px;
    margin: 0 auto 20px;
    background: linear-gradient(135deg, $primary-color 0%, $primary-hover 100%);
    border-radius: 20px;
    display: flex;
    align-items: center;
    justify-content: center;
    box-shadow:
      0 10px 25px -5px rgba($primary-color, 0.4),
      0 0 0 4px rgba($primary-color, 0.1);
    animation: pulse 2s ease-in-out infinite;
  }

  @keyframes pulse {
    0%,
    100% {
      box-shadow:
        0 10px 25px -5px rgba($primary-color, 0.4),
        0 0 0 4px rgba($primary-color, 0.1);
    }
    50% {
      box-shadow:
        0 15px 35px -5px rgba($primary-color, 0.5),
        0 0 0 8px rgba($primary-color, 0.15);
    }
  }

  .title {
    font-size: 28px;
    font-weight: 700;
    color: $text-primary;
    margin-bottom: 8px;
    letter-spacing: -0.5px;
  }

  .subtitle {
    font-size: 15px;
    color: $text-secondary;
    font-weight: 400;
  }
}

// 登录表单
.login-form {
  .el-form-item {
    margin-bottom: 20px;

    &:last-child {
      margin-bottom: 0;
    }
  }

  .input-wrapper {
    position: relative;
    display: flex;
    align-items: center;

    .input-icon {
      position: absolute;
      left: 16px;
      z-index: 1;
      font-size: 18px;
      color: $text-secondary;
      transition: color 0.3s ease;
    }

    &:focus-within .input-icon {
      color: $primary-color;
    }

    :deep(.el-input__wrapper) {
      padding-left: 44px;
      border-radius: 12px;
      box-shadow: 0 0 0 1px $border-color inset;
      transition: all 0.3s ease;

      &:hover {
        box-shadow: 0 0 0 1px $primary-light inset;
      }

      &.is-focus {
        box-shadow:
          0 0 0 2px rgba($primary-color, 0.2),
          0 0 0 1px $primary-color inset;
      }
    }

    :deep(.el-input__inner) {
      height: 48px;
      font-size: 15px;

      &::placeholder {
        color: #9ca3af;
      }
    }
  }

  .form-options {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin: 8px 0 24px;

    .remember-checkbox {
      :deep(.el-checkbox__label) {
        font-size: 14px;
        color: $text-secondary;
      }

      :deep(.el-checkbox__input.is-checked .el-checkbox__inner) {
        background-color: $primary-color;
        border-color: $primary-color;
      }
    }

    .forgot-link {
      font-size: 14px;
      color: $primary-color;
      text-decoration: none;
      font-weight: 500;
      transition: color 0.3s ease;

      &:hover {
        color: $primary-hover;
        text-decoration: underline;
      }
    }
  }

  .login-btn-item {
    margin-bottom: 0;
  }

  .login-btn {
    width: 100%;
    height: 52px;
    border-radius: 12px;
    font-size: 16px;
    font-weight: 600;
    background: linear-gradient(135deg, $primary-color 0%, $primary-hover 100%);
    border: none;
    box-shadow: 0 4px 14px 0 rgba($primary-color, 0.39);
    transition: all 0.3s ease;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 8px;

    &:hover {
      transform: translateY(-2px);
      box-shadow: 0 6px 20px rgba($primary-color, 0.5);
    }

    &:active {
      transform: translateY(0);
    }

    .btn-text {
      letter-spacing: 2px;
    }

    .btn-icon {
      font-size: 18px;
      transition: transform 0.3s ease;
    }

    &:hover .btn-icon {
      transform: translateX(4px);
    }

    &:deep(.el-loading-mask) {
      border-radius: 12px;
    }
  }
}

// 登录底部
.login-footer {
  margin-top: 24px;
  text-align: center;
  padding-top: 24px;
  border-top: 1px solid $border-color;

  .footer-text {
    font-size: 14px;
    color: $text-secondary;

    .register-link {
      color: $primary-color;
      font-weight: 600;
      text-decoration: none;
      transition: color 0.3s ease;

      &:hover {
        color: $primary-hover;
        text-decoration: underline;
      }
    }
  }
}

// 版权信息
.copyright {
  text-align: center;
  margin-top: 24px;
  font-size: 13px;
  color: rgba(255, 255, 255, 0.6);
}

// 响应式设计
@media (max-width: 480px) {
  .login-card {
    padding: 36px 24px;
    border-radius: 20px;
  }

  .logo-section {
    .title {
      font-size: 24px;
    }

    .subtitle {
      font-size: 14px;
    }
  }

  .login-form {
    .input-wrapper :deep(.el-input__inner) {
      height: 44px;
    }

    .login-btn {
      height: 48px;
    }
  }
}
</style>
