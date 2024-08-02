package com.Hyeonjin.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

// @WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("톰캣 실행 완료!");

        String xml = "spring-settings2.xml";
        Object location = sce.getServletContext().getInitParameter("location"); // 설정이 있는 경우 데이터를 갖고 옴
        if (location != null) {
            xml = String.valueOf(location);
        }

        ApplicationContext context = new ClassPathXmlApplicationContext(xml);

        sce.getServletContext()
                .setAttribute("context", context);

        System.out.println("[OK] Spring Application Context On");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("톰캣 종료 완료!");
    }
}
