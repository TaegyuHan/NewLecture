package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.entity.*;
import com.example.boot3.demo.model.MenuDetailModel;
import com.example.boot3.demo.repository.menu.MenuImageRepository;
import com.example.boot3.demo.repository.menu.MenuRepository;
import com.example.boot3.demo.repository.menu.RcmdMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private RcmdMenuRepository rcmdMenuRepository;
    @Autowired
    private MenuImageRepository menuImageRepository;

    @Override
    public List<MenuView> getList(Integer categoryId, String query) {
        return menuRepository.findAll(categoryId, query);
    }

    @Override
    public void reg(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public MenuDetailModel findDetailById(Long id) {
        Menu menu = menuRepository.findById(id);
        List<MenuImage> images = menuImageRepository.findByMenuId(id);
        List<RcmdMenuView> rcmdMenus = rcmdMenuRepository.findByMenuId(id);

        return MenuDetailModel.builder()
                .menu(menu)
                .images(images)
                .rcmdMenuViews(rcmdMenus)
                .build();
    }

    @Override
    public List<MenuView> getList(Integer categoryId) {
        return getList(categoryId, null);
    }

    @Override
    public List<MenuView> getList() {
        return getList(null, null);
    }
}