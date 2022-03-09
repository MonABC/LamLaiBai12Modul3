package com.codegym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() { //tạo thêm 1 phương thức để kết nối
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // câu lệnh trong phải nhớ tránh viết nhầm sẽ sẻ ta lỗi 500
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management13", "root", "123456"); // kết nối với database
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
