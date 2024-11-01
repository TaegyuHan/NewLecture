package kr.co.rland.boot3.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TestFilter implements Filter {

    /**
     * 필터를 잘못 만들면 데이터가 안보일 수 있다.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        System.out.println("TestFilter: " + req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}