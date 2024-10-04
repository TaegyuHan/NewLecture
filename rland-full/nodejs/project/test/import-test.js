// calculator.js

// 덧셈 함수
function add(a, b) {
    return a + b;
}

// 뺄셈 함수
function subtract(a, b) {
    return a - b;
}

// 곱셈 함수
function multiply(a, b) {
    return a * b;
}

// 나눗셈 함수
function divide(a, b) {
    if (b === 0) {
        return "Error: Division by zero";
    }
    return a / b;
}

// module.exports를 사용하여 함수들을 내보냅니다
module.exports = {
    add: add,
    subtract: subtract,
    multiply: multiply,
    divide: divide
};