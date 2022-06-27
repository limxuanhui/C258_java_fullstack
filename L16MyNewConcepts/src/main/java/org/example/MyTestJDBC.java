package org.example;
/* Created by limxuanhui on 27/6/22 */

import java.sql.*;

public class MyTestJDBC {
    public static void main(String[] args) throws SQLException {
        // CRUD
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "");
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery("select * from employees");
        while(result.next()) {
            System.out.println(result.getString("first_name") + " | " + result.getString("salary"));
        }
    }
}
