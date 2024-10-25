<template>

  <Head>
    <Meta charset="UTF-8" />
    <Meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <Link rel="icon" href="/favicon.ico" />
    <Link rel="stylesheet" href="https://www.newlecture.com/dist/v0.2.2/style.min.css" crossorigin />
    <Link rel="stylesheet" href="/css/style.css" />
    <Title>알랜드에 오신 것을 환영합니다.</Title>
  </Head>

  <div>
    <div>header</div>
    <NuxtLayout>
      <NuxtPage />
    </NuxtLayout>
    <div>footer</div>
  </div>
</template>
<script setup lang="ts">
</script>