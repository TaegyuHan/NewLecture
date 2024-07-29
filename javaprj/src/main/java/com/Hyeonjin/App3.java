package com.Hyeonjin;

import java.lang.reflect.InvocationTargetException;

import com.Hyeonjin.web.entity.Exam;

public class App3 {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {

        {
            Exam exam = new Exam(); // 객체 생성
            String csv = CSVParser.toCSV(exam);
            System.out.println(csv);
            // CSVParser.from("C:/8th/WebWork/javaprj/src/main/resources");
        }

        // {
        // // Exam exam = new Exam();

        // String className = "com.Hyeonjin.web.entity.Exam";
        // Exam exam = (Exam)
        // Class.forName(className).getDeclaredConstructor().newInstance();

        // Class clazz = exam.getClass();

        // // 리플렉션 공부해보기
        // Method[] methods = clazz.getDeclaredMethods();

        // for (Method m : methods) {
        // System.out.println(m.getName());
        // }

        // exam.setKor(30);
        // System.out.println(exam);
        // }
    }
}
