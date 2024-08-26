package com.example.boot3.demo.service.menu;

import com.example.boot3.demo.entity.Category;
import com.example.boot3.demo.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getList() {
        return repository.findAll();
    }
}
