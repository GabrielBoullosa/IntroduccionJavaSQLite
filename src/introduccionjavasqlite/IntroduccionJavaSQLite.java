package introduccionjavasqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IntroduccionJavaSQLite {
    
    public static void main(String[] args) {
        String URL_BD_SQLite = new String("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\DB_SQLite\\PRUEBA.db");
        Connection connection = connect(URL_BD_SQLite);
    }

    private static Connection connect(String URL_BD_SQLite) {
        Connection connection = null;
        try{
            connection =  DriverManager.getConnection(URL_BD_SQLite);
            System.out.println("Base de Datos conectada...");
            selectData_PEOPLE(connection);
            insertData_PEOPLE(connection);
        } catch (SQLException exception) {
            System.out.print("ERROR Kata5 Ejemplo SQLite" + exception.getMessage());
        }
        finally{
            try{
                if (connection != null) connection.close();
            } catch (SQLException exception){
                System.out.print("ERROR Kata5 Ejemplo SQLite" + exception.getMessage());
            }
        }
        return connection;
    }

    private static void selectData_PEOPLE(Connection connection) {
        String SQL = "SELECT * FROM PEOPLE";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("Id \t Name \t Apellidos \t Departamento");
            while(resultset.next()){
                System.out.println(resultset.getInt("Id") + " \t " + 
                        resultset.getString("Name") + " \t " + 
                        resultset.getString("Apellidos") + " \t "  +
                        resultset.getString("Departamento"));
            }
        }catch (SQLException exception){
            System.out.print("ERROR Kata5 Ejemplo SQLite" + exception.getMessage());
        }
    }
    
    private static void insertData_PEOPLE(Connection connection) {
        String SQL = "INSERT INTO PEOPLE(ID, NAME, APELLIDOS, DEPARTAMENTO) VALUES (?, ?, ?, ?)" ;
        try {
            PreparedStatement preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setInt(1, 28);
            preparedstatement.setString(2, "Juan");
            preparedstatement.setString(3, "Quesada");
            preparedstatement.setString(4, "Compras");
            preparedstatement.executeUpdate();
        }catch (SQLException exception){
            System.out.print("ERROR Kata5 Ejemplo SQLite" + exception.getMessage());
        }
        
    }
    
    
}
