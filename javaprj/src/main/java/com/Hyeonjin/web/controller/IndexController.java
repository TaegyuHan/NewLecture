package com.Hyeonjin.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.Hyeonjin.web.entity.Exam;
import com.Hyeonjin.web.service.ExamService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        ExamService service = context.getBean(ExamService.class);
        List<Exam> list;

        try {
            list = service.getList();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
