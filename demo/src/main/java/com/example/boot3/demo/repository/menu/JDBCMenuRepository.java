package com.example.boot3.demo.repository.menu;

import com.example.boot3.demo.entity.Menu;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class JDBCMenuRepository implements MenuRepository {
    @Override
    public List<Menu> findAll() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@//hi.newlecture.com:1521/XEPDB1";
        Connection conn = DriverManager.getConnection(url, "rland", "0530");

        Statement stmt = conn.createStatement();
        String sql = """    
                    SELECT * 
                    FROM MENU
                """;
        ResultSet rs = stmt.executeQuery(sql);

        List<Menu> list = new ArrayList<>();

        while (rs.next()) {
            Long id = rs.getLong("ID");
            String korName = rs.getString("KOR_NAME");
            String engName = rs.getString("ENG_NAME");
            Integer price = rs.getInt("PRICE");
            String img = rs.getString("IMG");
            Date regDate = rs.getTimestamp("REG_DATE");
            Long categoryId = rs.getLong("CATEGORY_ID");
            Long regMemberId = rs.getLong("REG_MEMBER_ID");

            Menu menu = Menu.builder()
                    .id(id)
                    .korName(korName)
                    .engName(engName)
                    .price(price)
                    .img(img)
                    .regDate(regDate)
                    .categoryId(categoryId)
                    .regMemberId(regMemberId)
                    .build();

            list.add(menu);
        }
        conn.close();

        return list;
    }
}
