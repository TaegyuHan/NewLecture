package com.example.boot3.demo.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public List<Notice> list() {
        return service.getList();
        // model.addAttribute("list", service.getList());
        // return "/admin/notice/list";
    }

    @GetMapping("test")
    public void test(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("hello");
    }

}
