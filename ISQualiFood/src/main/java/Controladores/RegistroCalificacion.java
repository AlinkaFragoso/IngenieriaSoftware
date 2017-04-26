/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author alinka
 */
public class RegistroCalificacion extends Conexion {
    
    public boolean registrar(int calificacion, int idUsuario, int idPuesto){
        PreparedStatement pst = null;
        
        try {
            String consulta = "insert into calificacion(calificacion, id_usuario, id_puesto) values (?, ?, ?)";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            pst.setInt(1, calificacion);
            pst.setInt(2, idUsuario);
            pst.setInt(3, idPuesto);
            
            if(pst.executeUpdate() == 1){
                return true;
            }

            
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        } finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println("Error "+ e);
            }
        }
        
        return false;
    }
    
    /**public static void main(String[] args) {
        RegistroUsuario regis = new RegistroUsuario();
        regis.registrar("atenas", "fragoso", "aten", "ali_1", "2345");
    }*/
}
