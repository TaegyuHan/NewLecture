package com.Hyeonjin.di;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Hyeonjin.web.entity.Exam;
import com.Hyeonjin.web.service.ExamService;

public class App3 {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-settings2.xml");

        ExamService service = context.getBean(ExamService.class);
        List<Exam> list = service.getList();
        System.out.println(list);
    }
}
