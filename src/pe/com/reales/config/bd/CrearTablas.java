package pe.com.reales.config.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrearTablas {

    public static int countTables(){

        String sql = """
                 SELECT count(*) count
                FROM sqlite_master
                WHERE type='table' AND name IN ('EDITORIAL', 'LECTOR', 'TEXTO');
                 """;
        try {
            ConectaBD db = new ConectaBD();
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
             resultSet.next();
             return resultSet.getInt("count");
        }catch (Exception e){
            System.out.println("Error: "+e.getClass().getName()+": "+e.getMessage());
            return 0;
        }
    }
    public static void createTables(){
        ConectaBD db = new ConectaBD();
        Connection connection;
        Statement statement;
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            String creationSQL =
                    """
                    CREATE TABLE LECTOR (
                        IDLECTOR INTEGER PRIMARY KEY AUTOINCREMENT,
                        NOMBRE TEXT NOT NULL,
                        APELLIDO TEXT NOT NULL,
                        DNI CHAR(8),
                        EDAD INTEGER
                    );
                    CREATE TABLE TEXTO (
                        IDTEXTO INTEGER PRIMARY KEY AUTOINCREMENT NOMBRE TEXT NOT NULL,
                        AUTOR TEXT NOT NULL,
                        STOCK INTEGER,
                        PRECIO REAL
                    );
                    CREATE TABLE EDITORIAL (
                        IDEDITORIAL INTEGER PRIMARY KEY AUTOINCREMENT,
                        NOMBRE TEXT NOT NULL,
                        TELEFONO TEXT NOT NULL,
                        ESTADO TEXT,
                        RUC INTEGER
                    );
                    """;
            statement.executeUpdate(creationSQL);
            statement.close();
            connection.close();
            dataInsertion();
        } catch (Exception e){
            System.out.println("Error: "+e.getClass().getName()+": "+e.getMessage());
        }
    }
    public static void dataInsertion(){
        ConectaBD db = new ConectaBD();
        Connection connection;
        Statement statement;
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            String insertionSQL =
                    """
                    INSERT INTO EDITORIAL VALUES ("SANTILLAN", "+51 996 367 035", "1", "20538633021");
                    INSERT INTO EDITORIAL VALUES ("SANTILLAN", "+51 996 367 035", "1", "20538633021");
                    INSERT INTO EDITORIAL VALUES ("SANTILLAN", "+51 996 367 035", "1", "20538633021");
                    INSERT INTO EDITORIAL VALUES ("SANTILLAN", "+51 996 367 035", "1", "20538633021");
                    INSERT INTO EDITORIAL VALUES ("SANTILLAN", "+51 996 367 035", "1", "20538633021");
                    
                    INSERT INTO LECTOR VALUES ("KICK", "BUTTOWSKI", "66666666", "66");
                    INSERT INTO LECTOR VALUES ("KICK", "BUTTOWSKI", "66666666", "66");
                    INSERT INTO LECTOR VALUES ("KICK", "BUTTOWSKI", "66666666", "66");
                    INSERT INTO LECTOR VALUES ("KICK", "BUTTOWSKI", "66666666", "66");
                    INSERT INTO LECTOR VALUES ("KICK", "BUTTOWSKI", "66666666", "66");
                    
                    INSERT INTO TEXTO VALUES ("LA CIUDAD Y LOS PERROS", "MVLL", 12, 24);
                    INSERT INTO TEXTO VALUES ("LA CIUDAD Y LOS PERROS", "MVLL", 12, 24);
                    INSERT INTO TEXTO VALUES ("LA CIUDAD Y LOS PERROS", "MVLL", 12, 24);
                    INSERT INTO TEXTO VALUES ("LA CIUDAD Y LOS PERROS", "MVLL", 12, 24);
                    INSERT INTO TEXTO VALUES ("LA CIUDAD Y LOS PERROS", "MVLL", 12, 24);
                    """;
            statement.executeUpdate(insertionSQL);
            statement.close();
            connection.close();
        } catch (Exception e){
            System.out.println("Error: "+e.getClass().getName()+": "+e.getMessage());
        }
    }
    }
