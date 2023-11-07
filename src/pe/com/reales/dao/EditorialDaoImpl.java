/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.dao;

import java.sql.PreparedStatement;
import java.util.List;

import pe.com.reales.config.bd.ConectaBD;
import pe.com.reales.modelo.Editorial;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author david
 */
public class EditorialDaoImpl implements EditorialDao {
    ConectaBD db = new ConectaBD();
    Editorial e = new Editorial();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public List<Editorial> listareditorial() {
        List<Editorial> editorials = new ArrayList<>();
        String sql = " SELECT * FROM EDITORIAL ORDER BY NOMBRE;";
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Editorial editorial = new Editorial();
                editorial.setIdeditorial(resultSet.getInt("ideditorial"));
                editorial.setNombre(resultSet.getString("nombre"));
                editorial.setTelefono(resultSet.getString("telefono"));
                editorial.setEstado(resultSet.getString("estado"));
                editorial.setRuc(resultSet.getInt("ruc"));
                editorials.add(editorial);
            }
        } catch (Exception e) {
            System.out.println("No se pudo Listar");
        }
        return editorials;
    }

    @Override
    public boolean agregar(Editorial editorial) {
        String sql = """
                INSERT INTO EDITORIAL(NOMBRE, TELEFONO, ESTADO, RUC)
                VALUES(?, ?, ?, ?)
                """;
        try {
            connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, editorial.getNombre());
            preparedStatement.setString(2, editorial.getTelefono());
            preparedStatement.setString(3, editorial.getEstado());
            preparedStatement.setInt(4, editorial.getRuc());
            preparedStatement.executeUpdate();
            System.out.println("Se insertó Correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo Insertar");
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Editorial editorial) {
        String sql = """
                UPDATE EDITORIAL
                SET
                NOMBRE = ?,
                TELEFONO = ?,
                ESTADO = ?,
                RUC = ?
                WHERE
                IDEDITORIAL = ?
                """;
        try {
            connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, editorial.getNombre());
            preparedStatement.setString(2, editorial.getTelefono());
            preparedStatement.setString(3, editorial.getEstado());
            preparedStatement.setInt(4, editorial.getRuc());
            preparedStatement.setInt(5, editorial.getIdeditorial());
            preparedStatement.executeUpdate();
            System.out.println("Se editó Correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo Editar");
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int ideditorial) {
        String sql = """
                DELETE FROM EDITORIAL
                WHERE
                IDEDITORIAL = ?
                """;
        try {
            connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ideditorial);
            preparedStatement.executeUpdate();
            System.out.println("Eliminado Correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo Eliminar");
            return false;
        }
        return true;
    }

}
