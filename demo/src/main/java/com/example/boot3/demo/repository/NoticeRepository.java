package com.example.boot3.demo.repository;

import java.util.List;

import com.example.boot3.demo.entity.Notice;

public interface NoticeRepository {

    List<Notice> findAll();

}
