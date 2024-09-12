package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.dto.MenuRegDto;
import com.example.boot3.demo.entity.Menu;
import com.example.boot3.demo.entity.MenuView;
import com.example.boot3.demo.model.MenuDetailModel;

import java.util.List;

public interface MenuService {
    List<MenuView> getList();
    List<MenuView> getList(Integer categoryId);
    List<MenuView> getList(Integer categoryId, String query);

    void reg(MenuRegDto menu);

    MenuDetailModel findDetailById(Long id);

    Menu findById(Long id);

    void deleteById(Long id);
}
