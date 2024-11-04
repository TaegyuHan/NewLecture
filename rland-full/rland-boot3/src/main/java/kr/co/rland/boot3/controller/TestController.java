package kr.co.rland.boot3.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

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
        cookie.setPath("/");

        // 생명력이 길어야할 때는 쿠키를 사용한다.
        // 특정 경로별로 데이터를 관리해서 아주 유용하게 사용할 수 있다.
        // AI는 검색능력이 아주 빠른 신입이다. < 아닌것을 판단할 줄 알아야한다.
        cookie.setMaxAge(60 * 60 * 24 * 7); // 7일 (초 단위)

        HttpSession session = request.getSession();
        session.setAttribute("name", name);


        request.getServletContext().setAttribute("name", name);
        response.addCookie(cookie);

        return "hi";
    }

    @GetMapping("say")
    public String say(
            HttpServletRequest request,
            @CookieValue("name") String cookieValue
    ) {
        HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();

        // 예전 방식
//        Cookie[] cookies = request.getCookies();
//        String cookieValue = null;
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("name".equals(cookie.getName())) {
//                    cookieValue = cookie.getValue(); // 쿠키 값 출력
//                }
//            }
//        }

        return "HIHI" // 알고 AI의 도움을 받아야한다.
            + " session: " + session.getAttribute("name")
            + " application: " + application.getAttribute("name")
            + " cookie: " + cookieValue;
    }
}