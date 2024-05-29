/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class UserDAO {

    String dbURL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    String uName = "root";
    String password = "root";

    String createUser(String fName, String lName, String city) {

        String status = "unsuccess";

        try {

            //Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            //Connect to DB
            Connection conn = DriverManager.getConnection(dbURL, uName, password);

            //SQL Query
            String query = "insert into users(first_name,last_name,city) values (?,?,?)";

            //Insert data into the database
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, city);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                status = "success";
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    String updateUser(String id, String fName, String lName, String city) {

        String status = "unsuccess";

        try {

            //Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            //Connect to DB
            Connection conn = DriverManager.getConnection(dbURL, uName, password);

            //SQL Query
            String query = "update users set first_name = ?, last_name = ?, city = ? where id = ?";

            //Insert data into the database
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, city);
            pstmt.setString(4, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                status = "success";
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return status;

    }

    String deleteUser(String id) {

        String status = "unsuccess";

        try {

            //Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            //Connect to DB
            Connection conn = DriverManager.getConnection(dbURL, uName, password);

            //SQL Query
            String query = "delete from users where id = ?";

            //Insert data into the database
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                status = "success";
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return status;

    }

    User readUser(String id) {

        String status = "unsuccess";
        User user = null;
        try {

            //Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            //Connect to DB
            Connection conn = DriverManager.getConnection(dbURL, uName, password);

            //SQL Query
            String query = "select * from users where id = ?";

            //Insert data into the database
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setfName(rs.getString("first_name"));
                user.setlName(rs.getString("last_name"));
                user.setCity(rs.getString("city"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    List<User> readUsers() {

        String status = "unsuccess";
        
        List<User> users = new ArrayList<>();
        
        try {

            //Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            //Connect to DB
            Connection conn = DriverManager.getConnection(dbURL, uName, password);

            //SQL Query
            String query = "select * from users";

            //Insert data into the database
            PreparedStatement pstmt = conn.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setfName(rs.getString("first_name"));
                user.setlName(rs.getString("last_name"));
                user.setCity(rs.getString("city"));
                users.add(user);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return users;

    }

}
