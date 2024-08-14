package com.example.boot3.demo.repository.notice;

import com.example.boot3.demo.entity.Notice;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class JdbcNoticeRepository implements NoticeRepository {

    @Override
    public List<Notice> findAll() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@//hi.newlecture.com:1521/XEPDB1";
        Connection conn = DriverManager.getConnection(url, "rland", "0530");

        Statement stmt = conn.createStatement();
        String sql = """    
                    SELECT * 
                    FROM MEMBER
                """;
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Integer id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String content = rs.getString("CONTENT");
            Timestamp regDate = rs.getTimestamp("REG_DATE");
            Timestamp updateDate = rs.getTimestamp("UPDATE_DATE");
            Long hitCount = rs.getLong("HIT_COUNT");
            Long regMemberId = rs.getLong("REG_MEMBER_ID");

            Notice.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .regDate(regDate)
                    .updateDate(updateDate)
                    .hitCount(hitCount)
                    .regMemberId(regMemberId)
                    .build();
        }
        conn.close();
        return List.of();
    }
}