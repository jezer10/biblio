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
public class ConectaBD {
    public Connection getConnection()throws SQLException{
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection=DriverManager.getConnection("jdbc:sqlite:BDBiblioteca.db");
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return connection;
    }
}

