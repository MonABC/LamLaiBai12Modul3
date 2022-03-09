package com.codegym.dao;

import com.codegym.model.Product;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private Connection connection= DBConnection.getConnection();  // tạo kết nối mới có thể truyền câu lệnh mysql
    public ProductDAO() {
    }

    @Override
    public List<Product> findALl() {

        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet= preparedStatement.executeQuery(); // ResultSet trả về 1 bảng giờ phải bóc tách từng dòng
            while (resultSet.next()) {// lấy từng dòng
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                Product product = new Product(id, name, price, description);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product findById(int id) {

        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product where id=?");
            preparedStatement.setInt(1,id);// set gia tri cho ?
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name=  resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description= resultSet.getString("description");
                product = new Product(id, name, price, description);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean create(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product (name, price, description) value (?, ?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
          return   preparedStatement.executeUpdate() >0; // chi dung cho insert, update, deete. select thi dung  preparedStatement.executeQuery(). và dòng này để return >0 nếu mà thêm thành công. vậy >0 sẽ là true ngược lại se là false


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean updateById(int id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET name = ?, price=?, description=? where  id= ?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, id);
            return preparedStatement.executeUpdate()>0;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product where id = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()>0;



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
