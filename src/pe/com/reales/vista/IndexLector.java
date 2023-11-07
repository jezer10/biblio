/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.vista;

import java.util.List;
import pe.com.reales.dao.LectorDao;
import pe.com.reales.dao.LectorDaoImpl;
import pe.com.reales.modelo.Lector;
import pe.com.reales.utils.Lectura;
import pe.com.reales.utils.Utilitarios;

/**
 *
 * @author david
 */
public class IndexLector {
    private static Lectura leer = new Lectura();
    private static LectorDao daoimpl = new LectorDaoImpl();
    public static void agregar(){
        System.out.println("\n=Agregar Datos=\n");
        System.out.print("Nombre: ");
        String nombre=leer.cadena();
        System.out.print("Apellido: ");
        String apellido=leer.cadena();
        System.out.print("DNI: ");
        String dni=leer.cadena();
        System.out.print("Edad: ");
        int edad=leer.entero();
        Lector lector = new Lector(0, nombre, apellido, dni, edad);
        daoimpl.agregar(lector);
        
    }
    public static void editar(){
        System.out.println("\n=Editar Datos=\n");
        listar();
        System.out.print("Seleccione la ID: ");
        int id = leer.entero();
        System.out.print("Nuevo Nombre: ");
        String nombre=leer.cadena();
        System.out.print("Nuevo Apellido: ");
        String apellido=leer.cadena();
        System.out.print("Nuevo DNI: ");
        String dni=leer.cadena();
        System.out.print("Nueva Edad: ");
        int edad=leer.entero();
        Lector lector= new Lector(id, nombre, apellido, dni, edad);
        daoimpl.editar(lector);
    }
            
    public static void eliminar(){
        System.out.println("\n=Eliminar Datos=\n");
        listar();
        System.out.print("Seleccione la ID: ");
        daoimpl.eliminar(leer.entero());
        
    }
    public static void listar(){
        LectorDaoImpl daoimpl = new LectorDaoImpl();
        List<Lector> lectors = daoimpl.listarlector();
        System.out.println("\n=Listado de Datos=\n");
        for (Lector lector : lectors) {
            System.out.println(lector.getIdlector()+"\t"
                            +  lector.getNombreCompleto()+"\t"
                            +  lector.getDni()+"\t"
                            +  lector.getEdad());
        }
        
    }
    public static void menu(){
        System.out.println("\n=MENU LECTORES=\n");
        System.out.println("1. Agregar");
        System.out.println("2. Editar");
        System.out.println("3. Eliminar");
        System.out.println("4. Listar");
        System.out.println("5. Volver");
        System.out.println("6. Salir");
        System.out.print("Elija una Opcion: ");
        
    }
    public static void inicio(){
        int opcion;
        do{
            menu();
            opcion=leer.entero();
            switch(opcion){
                case 1 -> agregar();
                case 2 -> editar();
                case 3 -> eliminar();
                case 4 -> listar();
                case 5 -> Utilitarios.volver();
                case 6 -> Utilitarios.salir();
            }
        } while(opcion!=5);
    }
}
