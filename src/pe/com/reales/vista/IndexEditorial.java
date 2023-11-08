/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.reales.vista;

import java.util.List;
import pe.com.reales.dao.EditorialDao;
import pe.com.reales.dao.EditorialDaoImpl;
import pe.com.reales.modelo.Editorial;
import pe.com.reales.utils.Lectura;
import pe.com.reales.utils.Utilitarios;

/**
 *
 * @author david
 */
public class IndexEditorial {
    private static Lectura leer=new Lectura();
    private static EditorialDao daoimpl=new EditorialDaoImpl();
    public static void datoscargados(){
        Editorial e1=new Editorial(1, "Angel", "944512463", "A", 21);
    }
    public static void agregar(){
        System.out.println("\n=Agregar Datos=\n");
        System.out.print("Nombre: ");
        String nombre=leer.cadena();
        System.out.print("Telefono: ");
        String telefono=leer.cadena();
        System.out.print("Estado: ");
        String estado=leer.cadena();
        System.out.print("Ruc: ");
        int ruc=leer.entero();
        Editorial editorial = new Editorial(0, nombre, telefono, estado, ruc);
        daoimpl.agregar(editorial);
    }
    public static void editar(){
        System.out.println("\n=Editar Datos=\n");
        listar();
        System.out.print("Seleccione la ID: ");
        int id=leer.entero();
        System.out.print("Nuevo Nombre: ");
        String nombre=leer.cadena();
        System.out.print("Nuevo Telefono: ");
        String telefono=leer.cadena();
        System.out.print("Nuevo Estado: ");
        String estado=leer.cadena();
        System.out.print("Nuevo Ruc: ");
        int ruc=leer.entero();
        Editorial editorial = new Editorial(id, nombre, telefono, estado, ruc);
        daoimpl.editar(editorial);
        
    }
    public static void eliminar(){
        System.out.println("");
        System.out.println("=Eliminar Datos=");
        System.out.println("");
        listar();
        System.out.print("Seleccione la ID: ");
        int id=leer.entero();
        daoimpl.eliminar(id);
        
    }
    public static void listar(){
        StringBuilder output = new StringBuilder();
        EditorialDaoImpl daoimpl=new EditorialDaoImpl();
        List<Editorial> editorials = daoimpl.listareditorial();
        System.out.println();
        output.append("\n=Listado de Datos LECTOR=\n");
        output.append("\nID\tNOMBRE\tTELEFONO\tRUC\tESTADO");
        for (Editorial editorial : editorials) {
            output.append("\n%d\t%s\t%s\t%s\t%s".formatted(editorial.getIdeditorial(), editorial.getNombre(), editorial.getTelefono(), editorial.getRuc(), editorial.getEstado()));

        }
        System.out.print(output);
    }
    public static void menu(){
        System.out.println("\n=MENU EDITORIALES=\n");
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
