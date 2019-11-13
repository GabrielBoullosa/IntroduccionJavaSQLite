package introduccionjavasqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IntroduccionJavaSQLite {

    public static void main(String[] args) {
        String URL_BD_SQLite = new String("jdbc:sqlite:C:\\Users\\Documents\\NetBeansProjects\\DB_SQLite:PRUEBA.db");
        connect(URL_BD_SQLite);
    }

    private static void connect(String URL_BD_SQLite) {
        Connection connection = null;
        try{
            connection =  DriverManager.getConnection(URL_BD_SQLite);
            System.out.println("Base de Datos conectada...");
        } catch (SQLException exception) {
            System.out.print("ERROR Kata5 Ejemplo SQLite");
        }
        finally{
            try{
                if (connection != null) connection.close();
            } catch (SQLException exception){
                System.out.print("ERROR Kata5 Ejemplo SQLite");
            }
        }
    }
    
    
}
