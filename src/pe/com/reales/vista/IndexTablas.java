package pe.com.reales.vista;

import pe.com.reales.config.bd.CrearTablas;
import pe.com.reales.utils.Utilitarios;

public class IndexTablas {

    public static void menuTablas(){
        System.out.println("Creando Tablas");
        CrearTablas.createTables();
        System.out.println("Tablas Creadas Correctamente");
        Utilitarios.volver();
    }
}
