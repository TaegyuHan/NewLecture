<script setup>

const props = defineProps({
  href: {
    type: String,
    default: './'
  },
  pageNumbers: {
    type: Array,
    default: []
  },
  startNum: {
    type: Number,
    default: 1
  },
  totalPage: {
    type: Number,
    default: 0
  }
});

const emit = defineEmits(['pageChange']);

</script>

<template>
  <div class="mt:4 text-align:center">
    <ul class="n-bar">
      <li>
        <RouterLink @click.prevent="emit('pageChange', startNum - 1)"
                    class="n-btn"
                    :to="`${href}?p=${startNum - 1 < 1 ? 1 : startNum - 1}`">이전</RouterLink>
      </li>
      <li v-for="p in pageNumbers" :key="p">
        <RouterLink @click.prevent="emit('pageChange', p)" class="n-btn" :class="{active: p == useRoute().query.p}"
                    :to="`${href}?p=${p}`">{{ p }}
        </RouterLink>
      </li>
      <li>
        <RouterLink @click.prevent="emit('pageChange', startNum + 5)"
                    class="n-btn"
                    :to="`${href}?p=${startNum + 5 > totalPage ? totalPage : startNum + 5}`">다음</RouterLink>
      </li>
    </ul>
  </div>
</template>

<style scoped>

</style>