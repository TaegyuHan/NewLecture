package com.example.boot3.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.example.boot3.demo.entity.Notice;

public interface NoticeService {

    List<Notice> getList() throws SQLException;
}
