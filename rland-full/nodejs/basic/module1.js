import exam from "./exam.js";


// 디폴트 모듈
export default function () {
    console.log('module1 f1');
    exam.kor = 100;
}

// 네임드 모듈
function f2() {
    console.log('module1 f2');
}

function f3() {
    console.log('module1 f3');
}

export {
    f2, f3
}