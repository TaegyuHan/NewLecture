package com.example.boot3.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(
            Model model
    ) {
        System.out.println("HelloController.index");
        model.addAttribute("text", "Model 동작");
        return "index";
    }
}
