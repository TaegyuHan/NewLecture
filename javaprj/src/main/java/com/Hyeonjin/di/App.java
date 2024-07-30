package com.Hyeonjin.di;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Hyeonjin.web.entity.Exam;
import com.Hyeonjin.web.service.ExamService;
import com.Hyeonjin.web.repository.Repository;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-settings.xml");

        Object exam = context.getBean("exam");
        System.out.println(exam);

        ExamService service = context.getBean(ExamService.class);
        List<Exam> list0 = service.getList();
        System.out.println(list0);

        Repository<Exam> repository = context.getBean(Repository.class);
        List<Exam> list1 = service.getList();
        System.out.println(list1);
    }
}
