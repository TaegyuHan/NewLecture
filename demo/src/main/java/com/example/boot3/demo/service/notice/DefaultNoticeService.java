package com.example.boot3.demo.service.notice;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot3.demo.entity.Notice;
import com.example.boot3.demo.repository.notice.NoticeRepository;

@Service
public class DefaultNoticeService implements NoticeService {

    @Autowired
    private NoticeRepository repository;

    @Override
    public List<Notice> getList() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }

}
