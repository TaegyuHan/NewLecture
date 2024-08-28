
package com.example.boot3.demo.repository.menu;

import com.example.boot3.demo.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface MenuRepository {
    List<Menu> findAll(Integer categoryId, String query);
}
