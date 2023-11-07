package pe.com.reales.vista;

import pe.com.reales.config.bd.CrearTablas;
import pe.com.reales.config.bd.DatabaseConnection;
import pe.com.reales.utils.Lectura;
import pe.com.reales.utils.Utilitarios;

public class Index {
    private static Lectura leer = new Lectura();
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
        System.out.println("2. Eliminar Tablas");
        System.out.println("3. Salir");
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
                case 5 -> Utilitarios.salir();
            }
        } while(opcion!=5);
    }
    public static void inicioMenuCreacion(){
        int opcion;
        do{
            menuCreacion();
            opcion = leer.entero();
            switch (opcion){
                case 1 -> IndexTablas.menuTablas();
                case 2 -> CrearTablas.eliminarTablas();
                case 3 -> Utilitarios.salir();
            }
        } while(opcion!=3);
    }
    public static void mostrarInicio(){
        int conteoTablas = CrearTablas.countTables();
        System.out.println(conteoTablas);
        if(conteoTablas<3){
            inicioMenuCreacion();
        } else {
            inicioMenuPrincipal();
        }
    }

    public static void main(String[] args) {
        mostrarInicio();
    }
}
