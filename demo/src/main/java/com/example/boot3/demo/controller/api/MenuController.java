package com.example.boot3.demo.controller.api;

import com.example.boot3.demo.entity.MenuView;
import com.example.boot3.demo.service.menu.CategoryService;
import com.example.boot3.demo.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("apiMenuController")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("api/menus")
    public List<MenuView> list(
            @RequestParam(value = "c", required = false) Integer categoryId,
            @RequestParam(value = "q", required = false) String query
    ) {
        return menuService.getList(categoryId, query);
    }
}