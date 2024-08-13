package com.example.boot3.demo.repository;

import com.example.boot3.demo.entity.Notice;
import groovyjarjarasm.asm.tree.MultiANewArrayInsnNode;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class JdbcNoticeRepository implements NoticeRepository {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
            System.out.println(rs.getString("USERNAME"));
        }
        conn.close();
    }

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