package com.example.boot3.demo.repository.menu;

import com.example.boot3.demo.entity.MenuImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuImageRepository {
    List<MenuImage> findByMenuId(Long menuId);
}