/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.reales.dao;

import java.util.List;
import pe.com.reales.modelo.Lector;

/**
 *
 * @author david
 */
public interface LectorDao {
    public List listarlector();
    public boolean agregar(Lector lector);
    public boolean editar(Lector lector);
    public boolean eliminar(int idlector);
}
