<script setup>

import { useRoute } from 'vue-router';
import {useAuthFetch} from "~/composables/useAuthFetch.js";

const config = useRuntimeConfig();

// const { data, refresh } = useFetch(`/admin/menus`, {
//   baseURL: config.public.apiBase
// }); // 비동기 함수

// const { data } = useAuthFetch(`/admin/menus`, {
//   baseURL: config.public.apiBase
// });

// let query = ref({ ...useRoute().query });
const menus = ref([]);
const keyWord = ref('');
const pageNumbers = ref([]);

let totalCount = 0;
let hasPrevPage = false;
let hasNextPage = false;
let totalPage = 0;
let startNum = 0;
let pages = [];

watchEffect(() => {
  // if (data.value) {
  //   totalCount = data.value.totalCount;
  //   totalPage = data.value.totalPage;
  //   hasNextPage = data.value.hasNextPage;
  //   hasPrevPage = data.value.hasPrevPage;
  //   menus.value = data.value.menus;
  //   pages = data.value.pages[0];
  // }
});

// ------------------------------------------------------------------------ //
onBeforeUnmount(() => {
  console.log('onBeforeUnmount');
});

onUnmounted(() => {
  console.log('onUnmounted');
});

onBeforeRouteUpdate((to, from, next) => {
  console.log('onBeforeRouteUpdate');
  next();
});

// ------------------------------------------------------------------------ //

const searchButtonClickHandler = (e) => {
}

</script>


<template>
amdin
</template>