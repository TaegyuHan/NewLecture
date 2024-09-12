package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.dto.MenuRegDto;
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
    public void reg(MenuRegDto menuRegDto) {
        Menu menu = menuRegDto.getMenu();
        List<MenuImage> images = menuRegDto.getImages();
        images.getFirst().setIsDefault(true); // 첫번째 이미지를 대표이미지로 설정
        menuRepository.save(menu);
        menuImageRepository.saveAll(images);
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
    public Menu findById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        menuRepository.deleteById(id);
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