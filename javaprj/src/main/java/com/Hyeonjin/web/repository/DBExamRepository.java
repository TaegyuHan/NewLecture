package com.Hyeonjin.web.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Hyeonjin.web.entity.Exam;

public class DBExamRepository implements Repository<Exam> {

    private final String PATH = "C:/res/data.csv";

    // 3. DAO > Repository 로 IO로 빼기
    public List<Exam> findAll() throws FileNotFoundException {

        Scanner scan = connect();

        List<Exam> list = new ArrayList<>();
        for (int i = 0; scan.hasNextLine() && i < 6; i++) {

            String line = scan.nextLine();
            String[] tokens = line.split(",");

            String name = tokens[0];

            int kor = 0;
            if (isNumeric(tokens[1])) {
                kor = Integer.parseInt(tokens[1]);
                if (!(0 <= kor && kor <= 100)) {
                    kor = 0;
                }
            }

            int eng = 0;
            if (isNumeric(tokens[1])) {
                eng = Integer.parseInt(tokens[1]);
                if (!(0 <= eng && eng <= 100)) {
                    eng = 0;
                }
            }

            int math = 0;
            if (isNumeric(tokens[1])) {
                math = Integer.parseInt(tokens[1]);
                if (!(0 <= math && math <= 100)) {
                    math = 0;
                }
            }

            list.add(new Exam(name, kor, eng, math));
        }

        scan.close();

        return list;
    }

    @Override
    public int save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public int update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    private Scanner connect() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(PATH);
        return new Scanner(fis);
    }
}
