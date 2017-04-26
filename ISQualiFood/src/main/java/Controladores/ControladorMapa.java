/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Puesto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author beto
 */
public class ControladorMapa extends Conexion{
    
    
    public LinkedList<Puesto> listaPuestos(){
        LinkedList<Puesto> lista = new LinkedList<>();            
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "Select * from puesto";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
//                Long idPuesto= rs.getLong(1);
//                System.out.println(idPuesto);
//                String puesto= rs.getString(2);
//                System.out.println(puesto);
//                int numPuesto= rs.getInt(3);
//                System.out.println(numPuesto);
//                String descripcion = rs.getString(4);
//                System.out.println(descripcion);
//                Float latitud = rs.getFloat(5);
//                System.out.println(latitud);
//                Float longitud= rs.getFloat(6);
//                System.out.println(longitud);
                
                Puesto p = new Puesto();
                p.setIdPuesto(rs.getLong(1));
                p.setNumero(rs.getInt(3));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(4));
                p.setLatitud(rs.getFloat(5));
                p.setLongitud(rs.getFloat(6));
                
                lista.add(p);
                
            }
            
            return lista;
                
            
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return lista;
    }
    
    
    public ResultSet listaPuestosBeto(){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "Select * from Puesto";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Error en la consulta");
            return null;
        }
    }
    
//    public static void main(String[] args) {
//        ControladorMapa mapa = new ControladorMapa();
//        mapa.listaPuestos();
//    }
    
}
