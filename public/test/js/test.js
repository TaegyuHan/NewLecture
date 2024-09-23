// true, false 판별

function aaa() {
    console.log('hehe');
}

aaa();

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
    return function tt() {
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

// 함수 변수에 저장하여 사용
var fun1 = function() { console.log(1); }
var fun2 = function() { console.log(2); }
var fun3 = function() { console.log(3); }

fun1();
fun2();
fun3();


// 이렇게 사용하면 클로저 함수 문제가 발생한다.
var farr = [];
for (i = 0; i < 3; i++) { // for문의 i를 사용하여
    farr[i] = function() { console.log(i + 1); }
}
for (var j = 0; j < 3; j++) {
    farr[j](); // 4, 4, 4가 출력된다.
}

// 배열의 정렬은 모두 String 값으로 변환되어 정렬된다.
var nums = [2, 4, 3, 3, 3, 3, 12, 3, 14, 5, 17, 7, 8 , 28, 111, 1011];
nums.sort(function (a, b) {
    return a - b; // 따라서 숫자 정렬은 이렇게 해야 한다.
});
// arrow function
// nums.sort((a, b) => a - b);

console.log(nums); // 원하는 필터링 기능에는 filter를 사용한다.
nums = nums.filter(function (value, index) { return index > 3; });
// arrow function : lambda < 람다를 사용하는 것을 습관화 하는게 좋다.
// nums = nums.filter((value, index) => index > 3);
//nums = nums.filter(function (item, index, array) { return array.indexOf(item) === index; });

// 원하는 객체 정렬은 이렇게 한다.
var points = [
    {kor: 10, eng: 20},
    {kor: 11, eng: 21},
    {kor: 12, eng: 22},
    {kor: 13, eng: 23},
    {kor: 14, eng: 24},
    {kor: 16, eng: 26}
]

// 정렬 기준
points.sort(function(a, b) {
    if (a.kor > b.kor) return 1;
    if (a.kor < b.kor) return -1;
    if (a.eng > b.eng) return 1;
    if (a.eng < b.eng) return -1;
    return 0;
});

console.log(points);

{
    // 함수 선언 방법
    function print() {
        console.log('print', this);
    }

    var pr1 = print(); // 함수 호출 방식
    var pr2 = new print(); // 생성자 방식

    function Exam() {
        this.kor = 10;
        this.eng = 20;
        this.math = 30;

        this.total = function() {
            return this.kor + this.eng + this.math;
        }
    }

    var exam = new Exam();
    var ftotal = exam.total;

    console.log(
        exam.total(), // 생성자 함수의 함수를 호출하여 사용하면 this필드를 사용할 수 있다.
        ftotal()) // 그러나 함수를 변수에 저장하여 사용하면 this필드를 사용할 수 없다.
    ; // NaN 문제

    // setTimeout을 사용할 떄는 lambda를 사용하는 것이 좋다.
    // 클로저 문제를 예방할 수 있다.
    setTimeout(() => {}, 3000); // 3초 후에 실행

    setTimeout(aaa, 3000); // 3초 후에 실행
    // 함수를 위임 했다.

    // let, const // 는 상수이다.

    // 2진수, 8진수 추가
    // 변수 추가 let, const 추가
    let x = 30;
    console.log(x);
    console.log(window.x); // undefined

    // Template String // 문자열을 표현하는 방법
    // ECMAScript 6에서는 Template String을 사용하여 View의 문자열 더하기 문제를 해결한다.
    let name = 'Hong';
    let string = `
        <div>
            <h1>${name}</h1>
            <p>내용</p>
        </div>
    `;
}