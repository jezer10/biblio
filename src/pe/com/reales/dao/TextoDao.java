/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.reales.dao;

import java.util.List;
import pe.com.reales.modelo.Texto;

/**
 *
 * @author david
 */
public interface TextoDao {
    public List listartexto();
    public boolean agregar(Texto texto);
    public boolean editar(Texto texto);
    public boolean eliminar(int idtexto);
}
