package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.entity.Menu;
import com.example.boot3.demo.entity.MenuView;

import java.util.List;

public interface MenuService {
    List<MenuView> getList();
    List<MenuView> getList(Integer categoryId);
    List<MenuView> getList(Integer categoryId, String query);

    void reg(Menu menu);
}
