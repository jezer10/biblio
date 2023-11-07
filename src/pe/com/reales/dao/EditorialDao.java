/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.reales.dao;

import java.util.List;
import pe.com.reales.modelo.Editorial;

/**
 *
 * @author david
 */
public interface EditorialDao {
    public List listareditorial();
    public boolean agregar(Editorial editorial);
    public boolean editar(Editorial editorial);
    public boolean eliminar(int ideditorial);    
}
