/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.vista;

import java.util.List;
import pe.com.reales.dao.TextoDao;
import pe.com.reales.dao.TextoDaoImpl;
import pe.com.reales.modelo.Texto;
import pe.com.reales.utils.Lectura;
import pe.com.reales.utils.Utilitarios;

/**
 *
 * @author david
 */
public class IndexTexto {
    private static Lectura leer=new Lectura();
    private static TextoDao daoimpl = new TextoDaoImpl();
    public static void agregar(){
        System.out.println("\n=Agregar Datos=\n");
        System.out.print("Nombre: ");
        String nombre=leer.cadena();
        System.out.print("Autor: ");
        String autor=leer.cadena();
        System.out.print("Stock: ");
        int stock=leer.entero();
        System.out.print("Precio: ");
        int precio=leer.entero();
        Texto texto = new Texto(0, nombre, autor, stock, precio);
        daoimpl.agregar(texto);

    }
    public static void editar(){
        System.out.println("\n=Editar Datos=\n");
        listar();
        System.out.print("Seleccione la ID: ");
        int id=leer.entero();
        System.out.print("Nuevo Nombre: ");
        String nombre=leer.cadena();
        System.out.print("Nuevo Autor: ");
        String autor=leer.cadena();
        System.out.print("Nuevo Stock: ");
        int stock=leer.entero();
        System.out.print("Nuevo Precio: ");
        int precio=leer.entero();
        Texto texto = new Texto(id, nombre, autor, stock, precio);
        daoimpl.editar(texto);
    }
    public static void eliminar(){
        System.out.println("\n=Eliminar Datos=\n");
        listar();
        System.out.print("Seleccione la ID: ");
        daoimpl.eliminar(leer.entero());
    }
    public static void listar(){
        TextoDaoImpl daoimpl = new TextoDaoImpl();
        List<Texto> textos = daoimpl.listartexto();
        System.out.println("\n=Listado de Datos=\n");
        for (Texto texto : textos) {
            System.out.println(texto.getIdtexto()+"\t"
                             + texto.getNombre()+"\t"
                             + texto.getAutor() +"\t"
                             + texto.getStock() +"\t"
                             + texto.getPrecio());
            
        }
        
    }
    public static void menu(){
        System.out.println("");
        System.out.println("=MENU EDITORIALES=");
        System.out.println("1.Agregar");
        System.out.println("2.Editar");
        System.out.println("3.Eliminar");
        System.out.println("4.Listar");
        System.out.println("5.Volver");
        System.out.println("6.Salir");
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
        } while (opcion!=5);
        
    }
}
