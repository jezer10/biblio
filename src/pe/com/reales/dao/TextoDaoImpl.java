/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.dao;

import java.sql.PreparedStatement;
import java.util.List;
import pe.com.reales.config.bd.ConectaBD;
import pe.com.reales.modelo.Texto;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author david
 */
public class TextoDaoImpl implements TextoDao{
    ConectaBD db = new ConectaBD();
    Texto t = new Texto();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    @Override
    public List listartexto() {
        List<Texto> textos = new ArrayList<>();
        String sql = "SELECT * FROM TEXTO ORDER BY NOMBRE;";

        try {
            connection=db.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                Texto texto = new Texto();
                texto.setIdtexto(resultSet.getInt("idtexto"));
                texto.setNombre(resultSet.getString("nombre"));
                texto.setAutor(resultSet.getString("autor"));
                texto.setStock(resultSet.getInt("stock"));
                texto.setPrecio(resultSet.getInt("precio"));
                textos.add(texto);
            }
        } catch (Exception e) {
            System.out.println("No se pudo Listar");
        }
        return textos;
    }

    @Override
    public boolean agregar(Texto texto) {
        String sql =
                """
                INSERT INTO TEXTO(NOMBRE, AUTOR, STOCK, PRECIO) VALUES(?, ?, ?, ?);
                """;
        try {
            connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, texto.getNombre());
            preparedStatement.setString(2, texto.getAutor());
            preparedStatement.setInt(3, texto.getStock());
            preparedStatement.setInt(4, texto.getPrecio());
            preparedStatement.executeUpdate();
            System.out.println("Agregado Correctamente");  
        } catch (Exception e) {
            System.out.println("No se pudo Agregar");
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Texto texto) {
        String sql =
                """
                UPDATE TEXTO
                SET NOMBRE = ?,
                    AUTOR = ?,
                    STOCK = ?,
                    PRECIO = ?
                WHERE IDTEXTO = ?;
                """;
        try {
            connection=db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, texto.getNombre());
            preparedStatement.setString(2, texto.getAutor());
            preparedStatement.setInt(3, texto.getStock());
            preparedStatement.setInt(4, texto.getPrecio());
            preparedStatement.setInt(5, texto.getIdtexto());
            preparedStatement.executeUpdate();
            System.out.println("Editado Correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo Editar");
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int idtexto) {
        String sql =
                """
                DELETE FROM TEXTO WHERE IDTEXTO  = ?;
                """;
        try {
            connection=db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idtexto);
            preparedStatement.executeUpdate();
            System.out.println("Eliminado Correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo Eliminar");
            return false;
        }
        return true;
    }
    
}
