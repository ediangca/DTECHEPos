/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.*;

/**
 *
 * @author Administrator
 */
public class DBConnection {

    Connection connection;
    Statement statement;
    ResultSet result;

    public DBConnection(String host, String db, String username, String password) {
        try {

            Class.forName("com.mysql.jdbc.Driver");//System.out.println("Driver Loaded");

            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + db, "root", "");
            //Database Name - testDB, Username - "root", Password - ""
            System.out.println("Database Successfully Connected...");
            statement = connection.createStatement();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new DBConnection("localhost", "dtech_sales_inventory_db", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
