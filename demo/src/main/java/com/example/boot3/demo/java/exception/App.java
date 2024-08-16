package com.example.boot3.demo.java.exception;

public class App {
    public static void main(String[] args) {
        System.out.println(Calc.add(20, 30));

//        try (
//                FileInputStream fis = new FileInputStream("a.txt")
//        ) {
//            System.out.println(Calc.sub(20, 30));
//        } catch (NoMinusException e) {
//            System.out.println(e.getMessage());
//        } catch (매개변수가10000을넘는Exception e) {
//            System.out.println(e.getMessage());
//        } catch (FileNotFoundException e) {
//        } catch (IOException e) {
//        }

        System.out.println(Calc.mul(20, 30));

        System.out.println("프로그램 종료");
    }
}