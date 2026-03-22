import type { Directive, DirectiveBinding } from 'vue'
import { usePermission } from '@/composables'

export const permission: Directive = {
  mounted(el: HTMLElement, binding: DirectiveBinding) {
    const { value } = binding
    const { hasPermission } = usePermission()

    if (value && typeof value === 'string') {
      if (!hasPermission(value)) {
        el.parentNode?.removeChild(el)
      }
    } else if (Array.isArray(value)) {
      if (!value.some((p) => hasPermission(p))) {
        el.parentNode?.removeChild(el)
      }
    }
  },
}

export default permission
