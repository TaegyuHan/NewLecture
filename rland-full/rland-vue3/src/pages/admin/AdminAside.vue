<script setup>
</script>

<template>
  <aside class="">
    <header class="n-aside-menu">
      <h1 class="d:none"><a href="">관리자 메뉴</a></h1>
      <ul>
        <li class=""><RouterLink class="n-icon n-icon:dashboard n-deco n-deco-pos:top lg:n-deco-pos:left" href="/admin/index" to="/admin/index">대시보드</RouterLink></li>
      </ul>
    </header>
    <nav class="n-aside-menu">
      <h1>재품관리</h1>
      <ul>
        <li class="active">
          <RouterLink class="n-icon n-icon:local_cafe n-deco n-deco-pos:top lg:n-deco-pos:left" href="/admin/manus" to="/admin/manus">메뉴관리</RouterLink>
        </li>
        <li>
          <RouterLink class="n-icon n-icon:household_supplies n-deco n-deco-pos:top lg:n-deco-pos:left" href="/admin/supplies/list" to="/admin/supplies/list">비품관리</RouterLink>
        </li>
      </ul>
    </nav>
    <nav class="n-aside-menu">
      <h1>고객관리</h1>
      <ul>
        <li><a class="n-icon n-icon:bell n-deco n-deco-pos:top lg:n-deco-pos:left" href="/admin/notice/list">공지관리</a></li>
        <li><a class="n-icon n-icon:group n-deco n-deco-pos:top lg:n-deco-pos:left" href="/admin/member/list">회원관리</a></li>
      </ul>
    </nav>
    <nav class="n-aside-menu">
      <h1>통계관리</h1>
      <ul>
        <li><a class="n-icon n-icon:cardio_load n-deco n-deco-pos:top lg:n-deco-pos:left" href="">좋아요</a></li>
        <li><a class="n-icon n-icon:bookmarks n-deco n-deco-pos:top lg:n-deco-pos:left" href="">짐목록</a></li>
      </ul>
    </nav>

  </aside>
</template>

<style scoped>
</style>