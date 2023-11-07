/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.utils;

import pe.com.reales.vista.Index;

/**
 *
 * @author david
 */
public class Utilitarios {
    public static void salir(){
        System.out.println("\nGracias por la visita\n");
        System.exit(0);
    }
    public static void volver(){
        System.out.println("\nVolviendo...\n");
        Index.inicioprincipal();
    }
}
