<script setup lang="ts">
import AdminHeader from "@/pages/admin/AdminHeader.vue";
import AdminFooter from "@/pages/admin/AdminFooter.vue";
import AdminAside from "@/pages/admin/AdminAside.vue";
</script>


<template>

  <div class="n-layout n-aside-size:full1 n-aside-float1 n-aside-pos:right1">
    <!-- header 부분 -->
    <AdminHeader />

    <div class="xl:w:xlarge">
      <!-- aside 부분 -->
      <AdminAside />
      <!-- main 부분 -->
      <RouterView />
    </div>
    <!-- footer 부분 -->
    <AdminFooter />
  </div>

</template>
