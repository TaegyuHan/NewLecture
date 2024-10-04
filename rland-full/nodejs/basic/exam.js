class Exam {

    #kor;
    #eng;

    constructor() {
        this.#kor = 0;
        this.#eng = 0;
    }

    total() {
        return this.#kor + this.#eng;
    }

    get kor() {
        return this.#kor;
    }

    set kor(value) {
        this.#kor = value;
    }

    get eng() {
        return this.#eng;
    }

    set eng(value) {
        this.#eng = value;
    }
}

let exam = new Exam(); // 전역 객체를 사용하는 방법이다.
exam.kor = 30;
export default exam;
export {
    Exam
}