
package com.example.boot3.demo.repository.menu;

import com.example.boot3.demo.entity.Menu;

import java.sql.SQLException;
import java.util.List;

public interface MenuRepository {

    List<Menu> findAll() throws SQLException, ClassNotFoundException;

}
