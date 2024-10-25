<script setup>

import { onBeforeMount, onBeforeUpdate, onMounted, onUpdated, reactive, ref, watch } from 'vue';
import { useRoute } from 'vue-router';
// 문제 1 : 어떤 API를 사용할 것인가?

// 문제 2 : 그걸 어느 블록에서 호출해야 하는가?
// private Long totalCount;
//     private Long totalPages;
//     private Boolean hasPreviousPage;
//     private Boolean hasNextPage;
//     private List<MenuDto> menus;

const menus = ref([]);
const keyWord = ref([]);
const pageNumbers = ref([]);

const totalCount = ref(0);
const totalPage = ref(0);
const hasPreviousPage = ref(false);
const hasNextPage = ref(false);
// const query = ref({});

let query = {
  p: 1,
};
let startNum = 0;

// --- Data Functions ------------------------------------------------
const queryString = () => {
  // let query = useRoute().query;
  console.log(query);
  console.log(`?k=${query.k || ''}&p=${query.p || 1}`)
  return `?k=${query.k || ''}&p=${query.p || 1}`;
};

// watch(
//     [()=>query.value.p, ()=>pageNumbers],
//     [(newQuery, prevQuery)=>{
//         console.log(newQuery);
//         let page = useRoute().query.p || 1;
//         let offset = (page-1)%5;
//         startNum = page-offset;
//         console.log(startNum);
//         let nums = Array.from({length:5}).map((_,i)=>i+startNum);
//         console.log(nums);
//         pageNumbers.value = nums;
//         fetchMenus();
//     }],
//     [(number)=>{
//       console.log(number);
//     }]
// );

// --- Life Cycle functions -------------------------------------------
onBeforeMount(()=>{
  console.log("before Mount");
});

onMounted(()=> {
  // console.log("Mounted");
  // let page = useRoute().query.p || 1;
  // let offset = (page-1)%5;
  // startNum = page-offset;
  // console.log(startNum);
  // let nums = Array.from({length:5}).map((_,i)=>i+startNum);
  // console.log(nums);
  // pageNumbers.value = nums;

  fetchMenus();
});

onBeforeUpdate(() => {
  // console.log("BeforeUpdate");
});

onUpdated(() => {
  // console.log("Updated");
  // query.value.p = useRoute().query.p;
});


// ------------------------------------------------------
const fetchMenus = async () => {
  const response = await fetch(`http://localhost:8080/api/v1/admin/menus${queryString()}`)
  const data = await response.json();
  // console.log(result);
  menus.value = data.menus;
  totalCount.value = data.totalCount;
  console.log("totalPages", data.totalPage);
  totalPage.value = data.totalPage;
  hasPreviousPage.value = data.hasPreviousPage;
  hasNextPage.value = data.hasNextPage;
  pageNumbers.value = data.pages;
  console.log(data.pages);
  startNum = data.pages[0];
}

// --- callback functions -------------------------
const searchButtonClickHandler = (e) => {
  fetchMenus();
}

const addButtonClickHandler = (e) => {
  // console.log("add");
  list.push({korName: "아샷추"});

  // 2. MVC 처리 방법 : 모델(문서에 바인딩된 객체)을 처리하는 방법

  // 1. DOM 처리 방법 : 화면(문서)를 직접 처리하는 방법
  // let trTemplate = `<tbody>
  //                     <tr>
  //                         <td>1</td>
  //                     </tr>
  //                     <tr>
  //                         <td>2</td>
  //                     </tr>
  //                 </tbody>`
  // const table = document.querySelector("table");
  // table.insertAdjacentHTML("beforeend", trTemplate);
}

const delButtonClickHandler = (e) => {
  // console.log("del");
  list.pop();
}

// DOM을 사용하지 않고 데이터 바인딩을 사용하는게 좋다.
const pageClickHandler = (page) => {
  if (page < 1) {
    alert("이전 페이지가 없습니다.");
    return;
  }

  if (page > totalPage.value) {
    alert("다음 페이지가 없습니다.");
    return;
  }
  query.p = page;
  fetchMenus();
}

</script>


<template>
  <main>
    <section class="">
      <header class="n-bar">
        <h1 class="n-heading:5">제품관리 / 메뉴관리</h1>
        <div class="ml:3 d:flex">
          <RouterLink href="reg" class="n-icon n-icon:plus n-btn n-btn:rounded n-btn-size:small" to="menus/new">추가</RouterLink>
        </div>
      </header>

      <section class="n-frame:rounded-shadow">
        <header>
          <h1><span class="n-icon n-icon:search n-deco">검색</span></h1>
          <div class="ml:auto">
            <label class="n-icon n-icon:caret_down cursor:pointer">
              <span>확장버튼</span>
              <input class="d:none n-panel-expander" type="checkbox">
            </label>
          </div>
        </header>
        <form action="list" method="get" class="n-form n-label-pos:left">
          <div>
            <label>
              <span>한글명</span>
              <input type="text" name="q" v-model="keyWord">
            </label>
          </div>
          <div class="d:flex flex-direction:row jc:center">
            <label class="">
              <input type="checkbox" value="0" class="fl-grow:0">
              <span class="w:auto">전체</span>
            </label>
            <label th:each="c : ${categories}">
              <input th:if="${param.c} == ${c.id}" type="checkbox" name="c" th:value="${c.id}" class="fl-grow:0"
                     checked>
              <input th:if="${param.c} != ${c.id}" type="checkbox" name="c" th:value="${c.id}" class="fl-grow:0">
              <span class="w:auto" th:text="${c.name}">쿠키</span>
            </label>
          </div>
          <div class="d:flex">
            <button @click.prevent="searchButtonClickHandler" class="n-btn n-btn-color:main">검색</button>
            <button class="n-btn ml:1">취소</button>
          </div>
        </form>
      </section>

      <section class="n-frame:rounded-shadow">

        <header>
          <h1 class="d:none2">
            <span class="n-icon n-icon:view_list n-deco n-deco-gap:2">메뉴목록</span>
          </h1>
          <div>
            <span class="ml:1 n-heading:6">(2)</span>
            <button class="n-btn ml:3" @click="addButtonClickHandler">추가</button>
            <button class="n-btn ml:3" @click="delButtonClickHandler">삭제</button>
          </div>
        </header>

        <table class="n-table n-table:expandable">
          <thead>
          <tr>
            <th class="w:1">번호</th>
            <th class="w:0 md:w:4 overflow:hidden">사진</th>
            <th>한글명</th>
            <th class="w:0 md:w:2 n-heading-truncate">공개</th>
            <th class="w:3">비고</th>
          </tr>
          </thead>
          <tbody v-for="m in menus">
          <tr class="vertical-align:middle">
            <td th:text="${m.id}">2</td>
            <td class="w:0 md:w:4 overflow:hidden">
              <img class="w:100p h:0 md:h:3 object-fit:cover"
                   src="/image/product/americano.svg"
                   th:src="@{/image/product/{img}(img=${m.img})}"></td>
            <td class="text-align:start n-heading-truncate text-indent:4 text-align:cetner">
              <RouterLink href="detail" th:href="@{detail(id=${m.id})}" :to="`menus/${m.id}`">{{ m.korName }}</RouterLink>
            </td>
            <td class="w:0 md:w:2 n-heading-truncate">
              <label>
                <span class="d:none">공개</span>
                <input type="checkbox" class="n-toggle ml:auto">
              </label>
            </td>
            <td>
                <span class="d:inline-flex align-items:center">
                    <label class="n-icon n-icon:caret_down n-icon-size:2 n-btn mr:2">
                        <input type="checkbox" class="d:none n-row-expander">
                        <span>상세보기</span>
                    </label>
                    <RouterLink class="n-icon n-icon:edit_square n-icon-color:base-6" :to="`menus/${m.id}/edit`">수정</RouterLink>
                    <form action="del" method="post" class="d:flex ai:center">
                        <input type="hidden" name="id" th:value="${m.id}">
                        <button class="n-icon n-icon:delete n-icon-color:base-6"
                                type="submit">삭제</button>
                    </form>
                </span>
            </td>
          </tr>
          <tr>
            <td colspan="5" class="bg-color:base-2">
              <section class="">
                <h1 class="d:none">상세내용</h1>
                <dl class="n-list:dash-lined">
                  <div class="md:d:none">
                    <dt>공개</dt>
                    <dd class="ml:1">
                      <label>
                        <span class="d:none">공개</span>
                        <input type="checkbox" class="n-toggle n-toggle-size:1 ml:auto">
                      </label>
                    </dd>
                  </div>
                  <div>
                    <dt>영문명</dt>
                    <dd class="ml:1" th:text="${m.engName}">Cafe Latte</dd>
                  </div>
                  <div>
                    <dt>사진</dt>
                    <dd class="ml:1">
                      <ul class="n-bar flex-wrap:wrap">
                        <li th:each="img : ${m.images}" th:classappend="'active:border'">
                          <img class="max-width:5" th:src="@{/image/product/{img}(img=${img.src})}"
                               src="/image/product/americano.svg"></li>
                      </ul>
                    </dd>
                  </div>
                  <div>
                    <dt>가격</dt>
                    <!--/*
                    참고자료
                    타임리프 숫자포맷 유틸객체 :  https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf#numbers
                    */-->
                    <dd class="ml:1" th:text="${#numbers.formatInteger(m.price,3,'COMMA')}+'원'">1,000원</dd>
                  </div>
                  <div>
                    <dt>등록일자</dt>
                    <!--/*
                    참고자료
                    타임리프 날짜포맷 유틸객체 : https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf#dates
                    자바 날짜포맷 문자들 : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat
                    */-->

                    <dd class="ml:1" th:text="${#dates.format(m.regDate, 'yyyy-MM-dd a HH:mm')}">2024-12-25 12:00:00
                    </dd>
                  </div>
                </dl>

              </section>
            </td>
          </tr>
          </tbody>
        </table>
        <div class="mt:4 text-align:center">
          <ul class="n-bar">
            <li>
              <RouterLink @click="pageClickHandler(startNum - 1)"
                          class="n-btn"
                          :to="`./list?p=${startNum - 1 < 1 ? 1 : startNum - 1}`">이전</RouterLink>
            </li>
            <li v-for="p in pageNumbers" :key="p">
              <RouterLink @click="pageClickHandler(p)" class="n-btn" :class="{active: p == useRoute().query.p}"
                          :to="`./list?p=${p}`">{{ p }}
              </RouterLink>
            </li>
            <li>
              <RouterLink @click="pageClickHandler(startNum + 5)"
                          class="n-btn"
                          :to="`./list?p=${startNum + 5 > totalPage ? totalPage : startNum + 5}`">다음</RouterLink>
            </li>
          </ul>
        </div>
      </section>

    </section>
  </main>
</template>