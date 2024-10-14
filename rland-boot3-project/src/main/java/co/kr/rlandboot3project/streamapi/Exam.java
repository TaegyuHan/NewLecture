package co.kr.rlandboot3project.streamapi;

import lombok.Data;

@Data
public class Exam implements Comparable<Exam> {

    private int kor;
    private int eng;
    private int math;

    public Exam(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return kor + eng + math;
    }

    public static Exam of(String line) {
        String[] values = line.split(",");
        int kor = Integer.parseInt(values[0]);
        int eng = Integer.parseInt(values[1]);
        int math = Integer.parseInt(values[2]);
        return new Exam(kor, eng, math);
    }

    @Override
    public int compareTo(Exam o) {
        return this.getTotal() - o.getTotal();
    }
}
