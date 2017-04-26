/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alinka
 */

public class Conexion {
    private String USERNAME = "root";
    private String PASSWORD = "1234";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "QualiFood";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    private Connection conexion;
    
    public Conexion(){
        try {
            Class.forName(CLASSNAME);
            conexion = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }   catch (ClassNotFoundException e) {
                System.err.println("Error " + e);
        }    catch (SQLException e){
                System.err.println("Error " + e);
        }            
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
    }
}
   
