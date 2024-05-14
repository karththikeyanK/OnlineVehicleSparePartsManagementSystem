package com.ovspms.dbConnection;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ovspms";
    private static final String USERNAME = "karththi";
    private static final String PASSWORD = "example-password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // inset product into database
    public static int insertProduct(String productName, String model, double price) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO products (productName, model, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, productName);
            statement.setString(2, model);
            statement.setDouble(3, price);

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }



}
