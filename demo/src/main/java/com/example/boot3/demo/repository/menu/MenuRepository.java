
package com.example.boot3.demo.repository.menu;

import com.example.boot3.demo.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface MenuRepository {

//    @Select("SELECT * FROM MENU")
    List<Menu> findAll();

}
