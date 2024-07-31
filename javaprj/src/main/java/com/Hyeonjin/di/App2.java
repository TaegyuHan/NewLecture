package com.Hyeonjin.di;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.io.File;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.Hyeonjin.web.repository.Repository;

public class App2 {

    @SuppressWarnings({ "resource" })
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {

        // 탐색 부분 설정
        // ApplicationContext context = new
        // AnnotationConfigApplicationContext("com.Hyeonjin.web");

        // 빈 객체를 불러오는 방법
        // Repository<Exam> repository = context.getBean(Repository.class);
        // List<Exam> list = repository.findAll();
        // System.out.println(list);

        String pack = "com.Hyeonjin.web.repository";
        String path = pack.replace(".", "/");
        ClassLoader classLoader = Repository.class.getClassLoader();
        String classPath = classLoader.getResource(path).getFile();

        File file = new File(classPath);
        for (File f : file.listFiles()) {

            if (f.isDirectory()) {
                continue;
            }

            String packageClassPath = pack + "." + f.getName().replace(".class", "");
            Class<?> clazz = Class.forName(packageClassPath);

            Annotation[] annotations = clazz.getAnnotations();

            for (Annotation a : annotations) {
                if (a.annotationType() != Component.class) {
                    continue;
                }
                // 빈객체로 생성해서 IOC 컨테이너에 객체를 넣어야함
                System.out.println(a.annotationType().getName());
            }
        }

        // String pack = "com.Hyeonjin.web";
        // String path = pack.replace(".", "/");
        // System.out.println(path);

        // String realPath = classLoader.getResource(path).toString();

        // System.out.println(realPath);

        // // 프로젝트 경로를 작성하고 자신이 객체를 로드하는 경험을 해보자.

        // {
        // path = "C:\\8th\\WebWork\\javaprj\\src\\main\\java\\com\\Hyeonjin";
        // File directory = new File(path);
        // File[] files = directory.listFiles();
        // for (File f : files) {

        // String type = "";
        // if (f.isDirectory()) {
        // type = "directory";
        // } else if (f.isFile()) {
        // type = "file";
        // }

        // System.out.printf("%s : %s\n", type, f.getName());
        // }

        // Class clz = classLoader.loadClass(path);

        // Class 정보 객체를 얻는 방법 4가지
        // Exam exam = new Exam();
        // exam.getClass();
        // Exam.class;
        // Class.forName("com.Hyeonjin.web.entity.Exam");
        // App2.class.getClassLoader().loadClass("");
    }

}
