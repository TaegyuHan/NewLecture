package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.entity.Menu;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    List<Menu> getList() throws SQLException, ClassNotFoundException;
}
