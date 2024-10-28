<script setup>

</script>

<template>
  <header class="header">
    <h1><a href="/">Rland</a></h1>
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
        </ul>
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

<style scoped>
.header{
  flex-shrink: 0;
  height: 60px;
  background-color: var(--color-base-9);
  padding: 0 30px;

  display: flex;
  align-items: center;

  >h1{
    color:var(--color-base-1);
    font-size: 24px;
    font-weight: bold;
  }

  .top-mobile-menu{
    margin-left: auto;
  }

  >.top-menu{
    display: none;
    align-items: center;

    ul{
      display: flex;
      align-items: center;
    }
  }
}

@media (min-width: 922px) {
  .header{
    height: 80px;

    >.top-mobile-menu{
      display: none;
    }

    >.top-menu{
      margin-left: auto;

      display: flex;
    }
  }
}
</style>