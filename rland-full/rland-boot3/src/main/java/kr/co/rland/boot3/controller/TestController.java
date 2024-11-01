package kr.co.rland.boot3.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // 단발성으로 서비스를 하는것
    @GetMapping("hello")
    public String sayHello() {
        return "Hello World!";
    }

    // 세션 테스트
    @GetMapping("hi")
    public String hi(
        @RequestParam("name") String name,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        Cookie cookie = new Cookie("name", name);
        HttpSession session = request.getSession();
        session.setAttribute("name", name);


        request.getServletContext().setAttribute("name", name);
        response.addCookie(cookie);

        return "hi";
    }

    @GetMapping("say")
    public String say(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();

        return (String) session.getAttribute("name") + " / " + (String) application.getAttribute("name");
    }
}