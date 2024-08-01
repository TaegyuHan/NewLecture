package com.Hyeonjin.web.listener;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Hyeonjin.web.entity.Exam;
import com.Hyeonjin.web.service.ExamService;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("톰캣 실행 완료!");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-settings2.xml");

        sce.getServletContext()
                .setAttribute("context", context);
        System.out.println("[OK] Spring Application Context On");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("톰캣 종료 완료!");
    }
}
