package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.entity.Menu;
import com.example.boot3.demo.repository.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DefaultMenuService implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getList() {
        return menuRepository.findAll();
    }
}
