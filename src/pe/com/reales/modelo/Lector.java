/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author david
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lector {
    private int idlector;
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    public String getNombreCompleto(){
        return this.apellido+ ", " +this.nombre;
    }
}
