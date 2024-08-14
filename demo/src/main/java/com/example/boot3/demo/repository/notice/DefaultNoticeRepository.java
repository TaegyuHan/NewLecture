package com.example.boot3.demo.repository.notice;

import java.util.ArrayList;
import java.util.List;

import com.example.boot3.demo.entity.Notice;

//@Repository
public class DefaultNoticeRepository implements NoticeRepository {

    @Override
    public List<Notice> findAll() {
        List<Notice> list = new ArrayList<>(3);
        for (int i = 1; i <= 3; ++i) {
            list.add(new Notice());
        }
        return list;
    }
}
