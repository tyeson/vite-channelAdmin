import { ref, computed, onMounted, onUnmounted } from 'vue'

export function useTable<T>(
  fetchData: (params: any) => Promise<{ list: T[]; total: number }>
) {
  const loading = ref(false)
  const tableData = ref<T[]>([]) as any
  const pagination = ref({
    page: 1,
    pageSize: 10,
    total: 0,
  })

  const searchParams = ref<Record<string, any>>({})

  const loadData = async () => {
    loading.value = true
    try {
      const { list, total } = await fetchData({
        ...searchParams.value,
        page: pagination.value.page,
        pageSize: pagination.value.pageSize,
      })
      tableData.value = list
      pagination.value.total = total
    } finally {
      loading.value = false
    }
  }

  const handleSearch = () => {
    pagination.value.page = 1
    loadData()
  }

  const handleReset = () => {
    searchParams.value = {}
    handleSearch()
  }

  const handlePageChange = (page: number) => {
    pagination.value.page = page
    loadData()
  }

  const handleSizeChange = (size: number) => {
    pagination.value.pageSize = size
    pagination.value.page = 1
    loadData()
  }

  const refresh = () => {
    loadData()
  }

  onMounted(() => {
    loadData()
  })

  return {
    loading,
    tableData,
    pagination,
    searchParams,
    handleSearch,
    handleReset,
    handlePageChange,
    handleSizeChange,
    refresh,
  }
}
