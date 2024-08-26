
package com.example.boot3.demo.repository.category;

import com.example.boot3.demo.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryRepository {
    List<Category> findAll();
}
