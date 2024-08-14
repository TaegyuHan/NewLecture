package com.example.boot3.demo.controller;

import com.example.boot3.demo.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller(value = "userTreeBookController")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public String list(
            Model model
    ) throws SQLException, ClassNotFoundException {
        model.addAttribute("list", menuService.getList());
        return "menu/list";
    }
}
