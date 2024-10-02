// var utill = require("./utill.js");
// var utill2 = require("./utill2.js");
// var s = utill.sum(3, 4);
// console.log(s);

// var x = utill2.x;
// console.log(x);
// import aa from "./utill.js";
// console.log(aa.sum(3, 4));

// comand.js 알아보기
// module.exports: 이해하기
// exports: 이해하기
// 전역 객체 이해하기
// require: 이해하기

// node의 내장 API인 FileSystem API import
var fs = require("node:fs"); // ES5 방식
var data = fs.readFileSync('data.txt', 'utf-8');
console.log(data.toString());

// 비동기형 API를 이용한 코드
fs.readFile('data.txt', 'utf-8', function(err, data) {
    console.log(data.toString());
});
console.log("프로그램 종료");

var newlec = require("newlec-hello");
newlec.hello();