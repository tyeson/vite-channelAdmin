import type { Directive, DirectiveBinding } from 'vue'

export const debounce: Directive = {
  mounted(el: HTMLElement, binding: DirectiveBinding) {
    const { value, arg = 'click' } = binding
    const delay = typeof binding.value === 'number' ? binding.value : 300

    let timer: ReturnType<typeof setTimeout> | null = null

    el.addEventListener(arg as string, () => {
      if (timer) {
        clearTimeout(timer)
      }
      timer = setTimeout(() => {
        if (typeof value === 'function') {
          value()
        }
      }, delay)
    })
  },
}

export default debounce
