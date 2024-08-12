package com.example.boot3.demo.repository;

import com.example.boot3.demo.entity.Notice;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

//@Repository
public class JdbcNoticeRepository implements NoticeRepository {

    @Override
    public List<Notice> findAll() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mariadb://hi.newlecture.com:3306/rlanddb";

        Class.forName("org.mariadb.jdbc.Driver");

        Connection conn = DriverManager.getConnection(url, "rland", "20231111");
        Statement stmt = null;
        ResultSet rs = null;

        conn.close();
        return List.of();
    }
}
