// Promise
// 성공과, 실패를 다루는 객체

// 라이브러리 또는 API
function getList(page) {
    return new Promise(
    (resolve, reject) => {
        setTimeout(() => {
            resolve(`{"kor": 100, "eng": 200}`);
        }, 5000); // 5초
        // reject("오마이갓!!");
    });
}

// 동기 실행 await
// IIFE(Imediately Invoked Function Expression)
(async () => {
    let exam = await getList(5);
    console.log(exam);
    console.log("다음 라인");
})();

// 이것이 기본이다. 근본 콜백