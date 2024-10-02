// function sum(x, y) {
//     return x + y;
// }

function Calc() {

}

// commonJS 방식 CJS 방식
exports.sum = sum;
exports.x = x;
module.exports.y = y;

// ESM 방식
export default function sum(x, y) {
    return x + y;
}

