/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.dao;

import java.sql.PreparedStatement;
import java.util.List;

import pe.com.reales.config.bd.ConectaBD;
import pe.com.reales.modelo.Lector;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author david
 */
public class LectorDaoImpl implements LectorDao {
    ConectaBD db = new ConectaBD();
    Lector l = new Lector();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public List<Lector> listarlector() {
        List<Lector> lectors = new ArrayList<>();
        String sql = "SELECT * FROM LECTOR ORDER BY APELLIDO;";
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Lector lector = new Lector();
                lector.setIdlector(resultSet.getInt("idlector"));
                lector.setNombre(resultSet.getString("nombre"));
                lector.setApellido(resultSet.getString("apellido"));
                lector.setDni(resultSet.getString("dni"));
                lector.setEdad(resultSet.getInt("edad"));
                lectors.add(lector);
            }
        } catch (Exception e) {
            System.out.println("No se pudo Listar");
        }
        return lectors;
    }

    @Override
    public boolean agregar(Lector lector) {
        String sql = "INSERT INTO LECTOR(NOMBRE, APELLIDO, DNI, EDAD) VALUES(?, ?, ?, ?)";
        try {
            connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lector.getNombre());
            preparedStatement.setString(2, lector.getApellido());
            preparedStatement.setString(3, lector.getDni());
            preparedStatement.setInt(4, lector.getEdad());
            preparedStatement.executeUpdate();
            System.out.println("Agregado Correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo Agregar");
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Lector lector) {
        String sql = """
                UPDATE LECTOR
                SET NOMBRE = ?,
                    APELLIDO = ?,
                    DNI = ?,
                    EDAD = ?
                WHERE IDLECTOR = ?;
                """;
        try {
            connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lector.getNombre());
            preparedStatement.setString(2, lector.getApellido());
            preparedStatement.setString(3, lector.getDni());
            preparedStatement.setInt(4, lector.getEdad());
            preparedStatement.setInt(5, lector.getIdlector());
            preparedStatement.executeUpdate(sql);
            System.out.println("Edito Correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo Editar");
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int idlector) {

        String sql = """
                DELETE FROM LECTOR WHERE IDLECTOR  = ?;
                """;
        try {
            connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idlector);
            preparedStatement.executeUpdate();
            System.out.println("Eliminado Correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo Eliminar");
            return false;
        }
        return true;
    }

}