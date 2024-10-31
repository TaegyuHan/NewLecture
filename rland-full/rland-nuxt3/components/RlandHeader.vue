<script setup>
import useUserDetails from "~/composables/useUserDetails.js";
</script>

<template>
  <header class="header">
    <h1>
      <a href="/">Rland</a>
      <NuxtLink to="/admin">관리자</NuxtLink>
      <NuxtLink v-if="useUserDetails().isAnonymous()" to="/signin">로그인 {{ useUserDetails().username }} </NuxtLink>
      <NuxtLink v-else to="/signin">로그아웃</NuxtLink>
    </h1>
    <div class="top-mobile-menu">
      <a class="n-icon n-icon:list n-icon-color:base-1" href="top-menu=1">숨김버튼</a>
    </div>
    <div class="top-menu">
      <nav>
        <h1 class="d:none">상단메뉴</h1>
        <ul>
          <li><a class="n-icon n-icon:home n-icon-color:base-1" href="/">홈</a></li>
          <li><a class="n-icon n-icon:dashboard n-icon-color:base-1" href="/admin/index">대시보드</a></li>
          <li><a class="n-icon n-icon:user n-icon-color:base-1" href="/">로그인</a></li>
          query    </ul>
      </nav>
      <section>
        <h1 class="d:none">로그아웃 폼</h1>
        <form>
          <input type="hidden">
          <button class="n-icon n-icon:sign_out n-icon-color:base-1">로그아웃</button>
        </form>
      </section>
    </div>
  </header>
</template>

<style>
</style>