package com.example.boot3.demo.controller;

import com.example.boot3.demo.entity.MenuView;
import com.example.boot3.demo.service.menu.CategoryService;
import com.example.boot3.demo.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller(value = "userTreeBookController")
@RequestMapping
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("menu/list")
    public String list(
            @RequestParam(value = "c", required = false) Integer categoryId,
            @RequestParam(value = "q", required = false) String query,
            Model model
    ) {
        System.out.println(query);
        model.addAttribute("categoryList", categoryService.getList());
        model.addAttribute("menuList", menuService.getList(categoryId, query));
        return "menu/list";
    }
}