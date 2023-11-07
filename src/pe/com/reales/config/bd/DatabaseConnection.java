/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.config.bd;
import java.sql.*;
/**
 *
 * @author david
 */
public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection() {}
    public static Connection getConnection() throws SQLException{
        if(connection == null){
            try {
                Class.forName("org.sqlite.JDBC");
                connection=DriverManager.getConnection("jdbc:sqlite:BDBiblioteca.db");
                System.out.println("Opened database successfully");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

