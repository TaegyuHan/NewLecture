package com.Hyeonjin.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("handleRequest > 실행완료");
        ModelAndView mv = new ModelAndView("/WEB-INF/view/index.jsp");
        System.out.println("ModelAndView > 실행 완료");
        mv.addObject("test", "Hello");
        return mv;
    }
}
