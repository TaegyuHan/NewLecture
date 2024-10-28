<script setup lang="ts">

const config = useRuntimeConfig();
const { data } = useFetch(`/admin/menus`, {
  baseURL: config.public.apiBase,
  params: query
}); // 비동기 함수

const totalCount = ref(0);
const totalPage = ref(0);
const hasNextPage = ref(false);
const hasPrevPage = ref(false);
const menus = ref([]);
const pages = ref([]);

watchEffect(() => {
  if (data.value) {
    totalCount.value = data.value.totalCount;
    totalPage.value = data.value.totalPage;
    hasNextPage.value = data.value.hasNextPage;
    hasPrevPage.value = data.value.hasPrevPage;
    menus.value = data.value.menus;
    pages.value = data.value.pages;
  }
});

</script>

<template>

  {{ data }}

</template>

<style scoped>

</style>