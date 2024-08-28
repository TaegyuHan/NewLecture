package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getList();
    List<Menu> getList(Integer categoryId);
    List<Menu> getList(Integer categoryId, String query);
}
