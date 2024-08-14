package com.example.boot3.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "userTreeBookController")
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/list")
    public String list() {
        return "menu/list";
    }
}
