package co.kr.rlandboot3project.streamapi;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {

        String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };

        System.out.println(Arrays.toString(stringArray));

        Arrays.sort(stringArray, String::compareTo);

        System.out.println(Arrays.toString(stringArray));

        Exam[] exams = {
            new Exam(100, 90, 80),
            new Exam(90, 80, 70),
            new Exam(80, 70, 60),
            new Exam(70, 60, 50),
            new Exam(60, 50, 40),
            new Exam(50, 40, 30),
            new Exam(40, 30, 20),
            new Exam(30, 20, 10)
        };

        Arrays.sort(exams, Exam::compareTo);

        System.out.println(Arrays.toString(exams));



    }
}