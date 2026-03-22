import { ref, onMounted, onUnmounted } from 'vue'

export function usePermission() {
  const permissions = ref<string[]>([])

  const hasPermission = (permission: string): boolean => {
    return permissions.value.includes(permission)
  }

  const hasAnyPermission = (perms: string[]): boolean => {
    return perms.some((p) => permissions.value.includes(p))
  }

  const hasAllPermissions = (perms: string[]): boolean => {
    return perms.every((p) => permissions.value.includes(p))
  }

  const setPermissions = (perms: string[]) => {
    permissions.value = perms
  }

  return {
    permissions,
    hasPermission,
    hasAnyPermission,
    hasAllPermissions,
    setPermissions,
  }
}
