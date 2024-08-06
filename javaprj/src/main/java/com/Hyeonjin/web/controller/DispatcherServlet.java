package com.Hyeonjin.web.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet(urlPatterns = "/", loadOnStartup = 0, initParams = {
//         @WebInitParam(name = "spring", value = "/WEB-INF/spring-dispatcher.xml")
// })
public class DispatcherServlet extends HttpServlet {

    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        String path = config.getInitParameter("spring");
        String realPath = config.getServletContext().getRealPath(path);
        context = new FileSystemXmlApplicationContext(realPath);
        System.out.println("spring init 실행 완료");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (!context.containsBean(uri)) {
            System.out.println("빈이 존재하지 않습니다.");
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Controller controller = (Controller) context.getBean(uri);

        try {
            ModelAndView mv = controller.handleRequest(req, resp);
            for (Map.Entry<String, Object> entry : mv.getModel().entrySet()) {
                req.setAttribute(entry.getKey(), entry.getValue());
            }
            req.getRequestDispatcher(mv.getViewName()).forward(req, resp);
        } catch (Exception e) {
            System.out.println("ModelAndView 에러");
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
    }
}
