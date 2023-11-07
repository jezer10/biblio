/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.vista;

import pe.com.reales.config.bd.ConectaBD;
import pe.com.reales.config.bd.CrearTablas;
import pe.com.reales.utils.Lectura;
import pe.com.reales.utils.Utilitarios;

/**
 *
 * @author david
 */
public class Index {
    private static Lectura leer=new Lectura();
    public static void menuPrincipal(){
        System.out.println("= MENU PRINCIPAL =");
        System.out.println("1. Editorial");
        System.out.println("2. Lector");
        System.out.println("3. Texto");
        System.out.println("4. Reporte");
        System.out.println("5. Salir");
        System.out.print("Elija una de las opciones: ");
    }
    public static void menuCreacion(){
        System.out.println("= MENU PRINCIPAL =");
        System.out.println("1. Crear Tablas");
        System.out.println("2. Salir");
        System.out.print("Elija una de las opciones: ");
    }
    public static void inicioMenuPrincipal(){
        int opcion;
        do{
            menuPrincipal();
            opcion=leer.entero();
            switch (opcion){
                case 1 -> IndexEditorial.inicio();
                case 2 -> IndexLector.inicio();
                case 3 -> IndexTexto.inicio();
                case 4 -> Utilitarios.salir();
            }
        } while(opcion!=5);
    }
    public static void inicioMenuCreacion(){
        int opcion;
        do{
            menuPrincipal();
            opcion = leer.entero();
            switch (opcion){
                case 1 -> IndexEditorial.inicio();
                case 2 -> Utilitarios.salir();
            }
        } while(opcion!=2);
    }
    public static void mostrarInicio(){
        System.out.println(CrearTablas.countTables());
        inicioMenuPrincipal();
    }

    public static void main(String[] args) {
        mostrarInicio();
    }
}
