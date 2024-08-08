package com.example.boot3.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/index")
    public String index(
            Model model
    ) {
        model.addAttribute("text", "Model 동작");
        return "index";
    }

}
