package com.example.boot3.demo.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot3.demo.entity.Notice;
import com.example.boot3.demo.service.NoticeService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {

    @Autowired
    private NoticeService service;

    @GetMapping("list")
    public String list(
            @RequestParam(name = "p", defaultValue = "0") Integer page,
            Model model
    ) {
        System.out.println(page + 1);
        List<Notice> notices = service.getList();
        model.addAttribute("notices", notices);
        model.addAttribute("test", "Model 동작함");
        return "admin/notice/list";
    }

    @GetMapping("test")
    public void test(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("hello");
    }

}
