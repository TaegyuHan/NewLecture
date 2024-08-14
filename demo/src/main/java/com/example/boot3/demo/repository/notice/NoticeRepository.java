package com.example.boot3.demo.repository.notice;

import java.sql.SQLException;
import java.util.List;

import com.example.boot3.demo.entity.Notice;

public interface NoticeRepository {

    List<Notice> findAll() throws SQLException, ClassNotFoundException;

}
