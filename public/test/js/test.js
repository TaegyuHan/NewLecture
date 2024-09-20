// true, false 판별

// 1. true
console.log("true == true", true == true); // true
console.log("true == 1", true == 1); // true
console.log("true == '1'", true == '1'); // true
console.log("true == '1.0'", true == '1.0'); // true
console.log("true == '1'", true == '1'); // true

console.log("true === true", true === true); // true
console.log("true === 1", true === 1); // false
console.log("true === '1'", true === '1'); // false
console.log("true === '1.0'", true === '1.0'); // false
console.log("true === '1'", true === '1'); // false

console.log('====================================================');

// 2. false
console.log("true == 'true'", true == 'true'); // false (1 == NaN)
console.log("true == false", true == false); // false (1 == 0)
console.log("true == ''", true == ''); // false (1 == 0)
console.log("true == 0", true == 0); // false (1 == 0)
console.log("true == '-1'", true == -1); // false (1 == -1)
console.log("true == null", true == null); // false (1 == NaN)
console.log("true == undefined", true == undefined); // false (1 == NaN)
console.log("true == NaN", true == NaN); // false (1 == NaN)
console.log("true == Infinity", true == Infinity); // false (1 == Infinity)
console.log("true == -Infinity", true == -Infinity); // false (1 == -Infinity)
console.log("true == {}", true == {}); // false (1 == NaN)
console.log("true == []", true == []); // false (1 == NaN)
console.log("true == function(){}", true == function(){}); // false (1 == NaN)

console.log("true === 'true'", true === 'true'); // false (1 == NaN)
console.log("true === false", true === false); // false (1 == 0)
console.log("true === ''", true === ''); // false (1 == 0)
console.log("true === 0", true === 0); // false (1 == 0)
console.log("true === '-1'", true === -1); // false (1 == -1)
console.log("true === null", true === null); // false (1 == NaN)
console.log("true === undefined", true === undefined); // false (1 == NaN)
console.log("true === NaN", true === NaN); // false (1 == NaN)
console.log("true === Infinity", true === Infinity); // false (1 == Infinity)
console.log("true === -Infinity", true === -Infinity); // false (1 == -Infinity)
console.log("true === {}", true === {}); // false (1 == NaN)
console.log("true === []", true === []); // false (1 == NaN)
console.log("true === function(){}", true === function(){}); // false (1 == NaN)

console.log(parseInt({}));
console.log(parseInt([]));
console.log(parseInt(null));
console.log(parseInt(undefined));
console.log(parseInt(function(){}));

console.log('====================================================');

// 자바 스크립트 조건문
// 1. if
if (true) {
    console.log('if');
}

// 2. if else
if (false) {
    console.log('if');
} else {
    console.log('else');
}

// 3. if else if else
if (false) {
    console.log('if');
} else if (true) {
    console.log('else if');
} else {
    console.log('else');
}

// 4. switch case
switch (1) {
    case 1:
        console.log('1');
        break;
    case 2:
        console.log('2');
        break;
    default:
        console.log('default');
}

// 자바 스크립트 반복문
// 1. for
const data = [1, 2, 3, 4, 5];
for (let i = 0; i < data.length; i++) {
    console.log(data[i]);
}

// 2. while
let i = 0;
while (i < data.length) {
    console.log(data[i]);
    i++;
}

// 3. do while
do {
    console.log(data[i]);
    i++;
} while (i < data.length);

// 4. for in
for (let i in data) {
    console.log(data[i]);
}

// 5. for of
for (let i of data) {
    console.log(i);
}

// 함수 선언
// 1. 함수 선언식
let sum = new Function('a', 'b', 'return a + b');
console.log(sum(1, 2));

// 2. 함수 표현식
function sum2(a, b) {
    return a + b;
}
console.log(sum2(1, 2));

// 3. 화살표 함수
const sum3 = (a, b) => {
    return a + b;
}
console.log(sum3(1, 2));

// 4. 화살표 함수 축약
const sum4 = (a, b) => a + b;

// 즉시 실행 함수
(function() {
    console.log('즉시 실행 함수');
})();

// 제너레이터 함수
function* gen() {
    yield 1;
    yield 2;
    yield 3;
}

// 비동기 함수
async function asyncFn() {
    return '비동기 함수';
}

// 호이스팅 (Hoisting)
// 변수 호이스팅
// console.log(hoisting0); // undefined
// var hoisting0 = '호이스팅';
//
// console.log(hoisting1); // ReferenceError: Cannot access 'hoisting1' before initialization
// const hoisting1 = '호이스팅';

// 함수 호이스팅
hoisting2(); // 호이스팅
function hoisting2() {
    console.log('호이스팅');
}

// 클래스 호이스팅
const hoisting3 = new Hoisting();
function Hoisting() {
    console.log('호이스팅');
}

// greet(); // TypeError: greet is not a function
// var greet = function() {
//     console.log('Hello');
// }

// 클로저
function closure() {
    let count = 0;
    return function() {
        return ++count;
    }
}
const closureFn = closure();
console.log(closureFn()); // 1
console.log(closureFn()); // 2
console.log(closureFn()); // 3

// 클로저 사용 이유
// 1. private 변수
function counter() {
    let count = 0;
    return {
        increase: function() {
            return ++count;
        },
        decrease: function() {
            return --count;
        }
    }
}

// 2. 상태 유지
// 3. 함수형 프로그래밍 지원
// 4. 모듈 패턴 구현
// 5. 콜백과 비동기 프로그래밍
// 6. 유연성과 강력함

