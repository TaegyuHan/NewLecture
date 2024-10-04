const calculator = require('./test/import-test');
const fs = require('node:fs');

console.log(calculator.add(1, 3)); // 4
console.log(calculator.subtract(1, 3)); // -2
console.log(calculator.multiply(1, 3)); // 3
console.log(calculator.divide(1, 3)); // 0.3333333333333333

// node.js의변수 저장
// node.js의 변수는 다음과 같이 저장됩니다.

// 1. 전역 객체
global.myVariable = 'Hello';
console.log(myVariable); // Hello

function printVariable() {
    console.log(this);
}

printVariable(); // global

// 비동기 처리 방식
fs.readFile('test.txt', 'utf8', function(err, data) {
    console.log(data);
});

async function readTest() {
    try {
        const data = await fs.promises.readFile('test.txt', 'utf8');
        console.log(data);
    } catch (err) {
        console.error(err);
    }
}




















