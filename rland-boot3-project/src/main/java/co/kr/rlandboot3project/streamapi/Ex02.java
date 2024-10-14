
package co.kr.rlandboot3project.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Ex02 {

    public static void main(String[] args) throws IOException {

        int[] ages = {10, 20, 30, 43, 23, 45, 12, 32, 42};
        IntStream stream = IntStream.of(ages);

        int[] result = stream
                .filter(age -> 20 < age)
                .sorted()
                .map(age -> age / 10 * 10)
                .toArray();

//        for (int i : result) {
//            System.out.println(i);
//        }

        List<Exam> exams = Files
            .lines(Path.of("exams.txt"))
            .skip(1) // 첫번째 줄은 제외
            .map(Exam::of)
            .filter(exam -> exam.getTotal() <= 100)
            .sorted(Exam::compareTo)
            .toList();

        OptionalInt sum = Files
            .lines(Path.of("exams.txt"))
            .skip(1)
            .map(Exam::of)
            .mapToInt(Exam::getTotal)
            .max();

        System.out.println("sum = " + sum.getAsInt());

        for (Exam exam : exams) {
            System.out.println(exam);
        }
    }
}