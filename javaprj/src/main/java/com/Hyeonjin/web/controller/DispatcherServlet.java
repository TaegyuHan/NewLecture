package com.Hyeonjin.web.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/", loadOnStartup = 0, initParams = {
        @WebInitParam(name = "path", value = "/WEB-INF/app.properties")
})
public class DispatcherServlet extends HttpServlet {

    private Properties props; // Map + 파일 설정

    @Override
    public void init(ServletConfig config) throws ServletException {
        props = new Properties();
        String path = config.getInitParameter("path");

        try {

            String realPath = config.getServletContext().getRealPath(path);
            System.out.println(realPath);
            InputStream is = new FileInputStream(realPath);
            props.load(is);

            System.out.println(props);
        } catch (IOException e) {
            System.out.print("에러");
            // TODO
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("수정 요청이 왔습니다.");

        String uri = req.getRequestURI();
        System.out.println("URL > " + uri);
        String className = props.getProperty(uri);

        if (className == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        System.out.println("CLASS_PATH > " + className);
    }
}
