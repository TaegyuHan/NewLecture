package com.Hyeonjin.web.repository;

import java.io.FileNotFoundException;
import java.util.List;

public interface Repository<T> {

    List<T> findAll() throws FileNotFoundException;

    int save();

    int update();

    void delete();
}