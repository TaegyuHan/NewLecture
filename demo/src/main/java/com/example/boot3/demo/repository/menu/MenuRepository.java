
package com.example.boot3.demo.repository.menu;

import com.example.boot3.demo.entity.Menu;
import com.example.boot3.demo.entity.MenuView;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface MenuRepository {
    List<MenuView> findAll(Integer categoryId, String query);

    void save(Menu menu);

    Menu findById(Long id);
}
