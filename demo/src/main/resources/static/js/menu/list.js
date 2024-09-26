// 이벤트 찾기
const backGround = document.getElementById("back-ground-img");

const title = document.getElementById("h1-title");
title.onclick = function () {
    backGround.src = "https://images.pexels.com/photos/2836719/pexels-photo-2836719.jpeg";
};

const category = document.getElementById("category");
const ul = category.querySelector("ul");
const menuLIst = document.querySelector(".menu-list");

category.querySelectorAll("li")
    .forEach((li) => {
        li.addEventListener("click", function (e) {
            console.log("li event capture");
            let id = e.target.dataset.id;
            console.log("current target 캡쳐 :", e.currentTarget);
            console.log("li 캡쳐 :" + id);
        });
    });

category.querySelectorAll("li")
    .forEach((li) => {
        li.addEventListener("click", function (e) {
            console.log("li event bubble");
            let id = e.target.dataset.id;
            console.log("current target 버블 :", e.currentTarget);
            console.log("li 버블 :" + id);
        }, false);
    });

ul.onclick = function (e) {

    console.log(e.target.classList);

    if (!e.target.classList.contains("btn")) {
        return;
    }

    let id = e.target.dataset.id;

    // 별도로 두는게 좋다.
    let request = new window.XMLHttpRequest();
    request.open("GET", `/api/menus?c=${id}`, false);
    request.send(null); // 요청을 보냄

    menuLIst.innerHTML = "";
    menuLIst.textContent = ""; // 이렇게 해도 된다.

    var menus = JSON.parse(request.responseText);

    menus.forEach((menu) => { // 현재 가장 많이 사용하는 방법이다. React.에서 많이 사용한다. - 박용우 강사님 의견
        let template = `
            <section class="menu">
                <div>
                    <a href="detail.html">
                        <img src="/image/map.png" alt="${menu.korName}">
                    </a>
                </div>
                <h1>${menu.korName}</h1>
                <h2>${menu.engName}</h2>
                <div>${menu.price}원</div>
                <div>
                    <a href="" class="icon icon-heart">좋아요</a>
                    <span>1</span>
                </div>
                <div>
                    <a href="" class="icon icon-plus icon-lg">추가</a>
                    <a href="" class="icon icon-cart icon-lg">장바구니</a>
                </div>
            </section>
        `;

        // 누적 연산이 들어가 사용하지 않는다.
        // menuLIst.innerHTML += template;
        menuLIst.insertAdjacentHTML("beforeend", template); // 이렇게 사용한다.

    });

    e.preventDefault();
};

// ul.addEventListener("click", function (e) {
//     console.log("test1");
// });
//
// ul.addEventListener("click", function (e) {
//     console.log("test2");
// }, false);
//
// ul.addEventListener("click", function (e) {
//     e.stopPropagation() // 이벤트 전파를 막는다.
//     console.log("test3");
// }, true) // notification phase

// const li2 = category.querySelector("li:nth-child(2)");
// li2.onclick = function () {
//     console.log("li event bubble");
// };
//

// console.log(category);
// category.querySelector("li:nth-child(2) > a").onclick = function (e) {
//     console.log(e);
//     console.log(e.target); // 이것은 윈도우 프로그래밍이다.
//     e.preventDefault();
//     alert("category 2");
// };