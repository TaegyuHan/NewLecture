package com.example.boot3.demo.repository.notice;

import com.example.boot3.demo.entity.Notice;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcNoticeRepository implements NoticeRepository {

    public static void main(String[] args) {
        NoticeRepository repo = new JdbcNoticeRepository();
        List<Notice> list = repo.findAll();
        for (Notice n : list) {
            System.out.println(n);
        }
    }

    @Override
    public List<Notice> findAll() {
        List<Notice> list = new ArrayList<>();
        String url = "jdbc:oracle:thin:@//hi.newlecture.com:1521/XEPDB1";
        String sql = "SELECT * FROM NOTICE";

        try (
                Connection conn = DriverManager.getConnection(url, "rland", "0530");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {
                Integer id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                Timestamp regDate = rs.getTimestamp("REG_DATE");
                Timestamp updateDate = rs.getTimestamp("UPDATE_DATE");
                Long hitCount = rs.getLong("HIT_COUNT");
                Long regMemberId = rs.getLong("REG_MEMBER_ID");

                Notice notice = Notice.builder()
                        .id(id)
                        .title(title)
                        .content(content)
                        .regDate(regDate)
                        .updateDate(updateDate)
                        .hitCount(hitCount)
                        .regMemberId(regMemberId)
                        .build();
                list.add(notice);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}