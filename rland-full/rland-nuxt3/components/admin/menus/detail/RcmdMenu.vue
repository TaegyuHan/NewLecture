<script setup>

const menus = ref([
  { "id": 1798,  "korName": "올드올드",  "engName": "oldmericano",  "price": 3000,  "regDate": "2024-10-27T12:55:17Z",  "categoryId": null,  "regMemberId": null,  "images": [],  "checked": false },
  { "id": 1797,  "korName": "올드올드",  "engName": "oldmericano",  "price": 3000,  "regDate": "2024-10-27T12:55:11Z",  "categoryId": null,  "regMemberId": null,  "images": [],  "checked": true }
]);

const isPanelShow = ref(true);

const addHandler = (addMenus) => {
  console.log('add handler', addMenus);
  addMenus.forEach(addMenu => {
    menus.value.push(addMenu);
  });
};

const deleteHandler = (deleteMenus) => {
  console.log('delete handler', deleteMenus);
  menus.value = menus.value.filter(menu => menu.id !== deleteMenus.id);
};

const closeHandler = () => {
  isPanelShow.value = false;
};

const showHandler = () => {
  isPanelShow.value = true;
};

</script>

<template>
  <section class="n-frame:rounded-shadow n-panel:card-grid">
    <header>
      <h1><span class="n-icon n-icon:recommend n-deco">추천목록</span></h1>
      <div class="ml:3 d:flex ai:center">
        <a href="#" @click.prevent="showHandler" class="n-icon n-icon:plus n-btn n-btn:rounded n-btn-size:small">추가</a>
      </div>
    </header>

    <!-- 추천 메뉴 검색 패널 -->
    <AdminMenusDetailRcmdMenuSearchPanel :show="isPanelShow" @add="addHandler" @close="closeHandler" />

    <div>
      <section v-for="m in menus" :key="m.id">
        <header>
          <h1 class="d:none">{{ m.korName }}</h1>
          <form method="post" class="mb:5 n-icon n-icon:remove_selection n-deco">
            <input type="hidden" value="1">
            <button @click.prevent="deleteHandler(m)" >삭제</button>
          </form>
        </header>
        <div><img src="/image/product/latte.svg"></div>
        <dl class="n-list:dash-lined">
          <div>
            <dt>한글명</dt>
            <dd>{{ m.korName }}</dd>
          </div>
          <div>
            <dt>등록일자</dt>
            <dd>{{ m.regDate }}</dd>
          </div>
        </dl>
      </section>
    </div>
  </section>
</template>