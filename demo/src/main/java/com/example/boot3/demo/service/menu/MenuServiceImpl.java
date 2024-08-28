package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.entity.MenuView;
import com.example.boot3.demo.repository.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuView> getList(Integer categoryId, String query) {
        return menuRepository.findAll(categoryId, query);
    }

    @Override
    public List<MenuView> getList(Integer categoryId) {
        return getList(categoryId, null);
    }

    @Override
    public List<MenuView> getList() {
        return getList(null);
    }
}
