package com.ovspms.dbConnection;

import com.ovspms.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ovspms";
    private static final String USERNAME = "karththi";
    private static final String PASSWORD = "example-password";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // insert product into database
    public static int insertProduct(String productName, String model, double price) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO products (productName, model, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, productName);
            statement.setString(2, model);
            statement.setDouble(3, price);

            return statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM products";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("productName"));
                product.setModel(rs.getString("model"));
                product.setPrice(rs.getDouble("price"));
                productList.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    // get product by id
    public static Product getProductById(int id) {
        Product product = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM products WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("productName"));
                product.setModel(rs.getString("model"));
                product.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static int updateProduct(int id, String productName, String model, double price) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE products SET productName = ?, model = ?, price = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, productName);
            statement.setString(2, model);
            statement.setDouble(3, price);
            statement.setInt(4, id);

            return statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int deleteProduct(int id) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            return statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}