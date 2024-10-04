// ESM (ECMAScript Module)
import test, {f2 as fa, f3} from './module1.js';
import exam1, {Exam} from "./exam.js";

test(); // f1 호출 kor = 100;
fa(); // module1 f2
f3(); // module1 f3

let exam = new Exam();
exam.kor = 30;
exam.eng = 40;

console.log(exam.total()); // 70
console.log(exam1.total()); // 0