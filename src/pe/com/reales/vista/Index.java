/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.vista;

import pe.com.reales.utils.Lectura;
import pe.com.reales.utils.Utilitarios;

/**
 *
 * @author david
 */
public class Index {
    private static Lectura leer=new Lectura();
    public static void menuprincipal(){
        System.out.println("= MENU PRINCIPAL =");
        System.out.println("1. Editorial");
        System.out.println("2. Lector");
        System.out.println("3. Texto");
        System.out.println("4. Salir");
        System.out.print("Elija una de las opciones: ");
    }
    public static void inicioprincipal(){
        int opcion;
        do{
            menuprincipal();
            opcion=leer.entero();
            switch (opcion){
                case 1 -> IndexEditorial.inicio();
                case 2 -> IndexLector.inicio();
                case 3 -> IndexTexto.inicio();
                case 4 -> Utilitarios.salir();
            }
        } while(opcion!=2);
    }
    public static void main(String[] args) {
        inicioprincipal();
    }
}
