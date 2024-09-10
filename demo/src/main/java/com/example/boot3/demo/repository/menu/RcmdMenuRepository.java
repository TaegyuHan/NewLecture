package com.example.boot3.demo.repository.menu;

import com.example.boot3.demo.entity.RcmdMenuView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RcmdMenuRepository {
    List<RcmdMenuView> findByMenuId(Long menuId);
}