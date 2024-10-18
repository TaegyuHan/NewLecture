// Promise
// 성공과, 실패를 다루는 객체

// 라이브러리 또는 API
function getList(page) {
    return new Promise(
    (resolve, reject) => {
        // resolve(`{"kor": 100, "eng: 200}`);
        reject("오마이갓!!");
    });
}

let promise = getList(5);

// 성공과 실패를 담는 그릇 이다.
promise // callBack 함수를 따로 담는 그릇이다.
.then((data) => {
    try {
        console.log('축하해', data);
        // 1. 파싱
        return JSON.parse(data);
        // -> 압축 / 키열기... 기타 등등
        // 2. 뽀개기
        // 3. 출력(사용)
    } catch (e) {
        console.log("중첩문 캐치");
    }
},
(error) => { // api가 봤을때 오류인 경우
    console.log('아이고 어쩌나..');
})
// .catch(error => { // 코드에서 예외가 발생한 경우
//     console.log("catch 실행됐음", error);
// });

// .then(d => {
//         return {...d, kor:300}
// })
// .then((json) => {
//     console.log(json.kor, json.eng);
// });

// 실제 동기화가 적용된 것처럼 사용한다.