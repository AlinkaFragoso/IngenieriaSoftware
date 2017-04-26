/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alinka
 */
public class RegistroUsuario extends Conexion {

    public boolean validarCampos(String nombre, String apellido, String nombre_usuario, String correo, String contrasenia) {
        if (nombre == "" || apellido == "" || nombre_usuario == ""
                || correo == "" || contrasenia == "") {

            return false;
        } else {
            return true;
        }
    }

    public boolean validarCamposInicio(String nombre_usuario, String contrasenia) {
        if (nombre_usuario == "" || contrasenia == "") {

            return false;
        } else {
            return true;
        }
    }
//    public boolean validarCorreo(String correo){
//        if()
//    }

    public boolean validarContrasenia(String contrasenia) {
        if (contrasenia.length() <= 3) {
            System.out.println(contrasenia);
            return false;
            
        }
        return true;
    }

    public boolean validarCorreo(String correo) {
        String patternEmail = "^[_A-Za-z0-0-\\+]+(\\.[_A-Za-z0-9-]+)*@ciencias.unam.mx";

        Pattern pattern = Pattern.compile(patternEmail);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();

    }

    public boolean autenticarInicio(String nombre_usuario, String contrasenia) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            if (!validarCamposInicio(nombre_usuario, contrasenia)) {
                System.err.println("");
            } else {
                String consulta = "Select nombre_usuario, contrasenia from Usuario_Ciencias Where nombre_usuario = ? and contrasenia = ?";
                pst = (PreparedStatement) getConexion().prepareStatement(consulta);
                pst.setString(1, nombre_usuario);
                pst.setString(2, contrasenia);
                rs = pst.executeQuery();

            }
            if (rs.absolute(1)) {
                return true;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception e) {
            }
        }

        return false;
    }

    public boolean existeUsuario(String nombre_usuario) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select nombre_usuario from Usuario_Ciencias where nombre_usuario = ?";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            pst.setString(1, nombre_usuario);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return false;
    }

    public boolean existeCorreo(String correo) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select correo from Usuario_Ciencias where correo = ?";
            pst = (PreparedStatement) getConexion().prepareStatement(consulta);
            pst.setString(1, correo);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return false;
    }

    public boolean registrar(String nombre, String apellido, String nombre_usuario, String correo, String contrasenia) {
        PreparedStatement pst = null;

        try {
//            if (validarCorreo(correo) == true) {
//                System.err.print("Error al validar correo");
//            } else {
                if (validarCampos(nombre, apellido, nombre_usuario, correo, contrasenia) == false) {
                    System.err.println("Error al validar campos");
                } else {
                    if (!validarContrasenia(contrasenia)) {
                        System.err.println("Error al validar contraseña");
                    } else {
                        if (existeUsuario(nombre_usuario) == true) {
                            System.err.println("Error: el nombre de usuario no está disponible");
                        } else {
                            if (existeCorreo(correo) == true) {
                                System.err.println("Error: el correo ya está registrado");

                            } else {
                                String consulta = "insert into Usuario_Ciencias(nombre, apellido, nombre_usuario, correo, contrasenia) values (?, ?, ?, ?, ?)";
                                pst = (PreparedStatement) getConexion().prepareStatement(consulta);
                                pst.setString(1, nombre);
                                pst.setString(2, apellido);
                                pst.setString(3, nombre_usuario);
                                pst.setString(4, correo);
                                pst.setString(5, contrasenia);

                                if (pst.executeUpdate() == 1) {
                                    return true;
                                }
                            }
                        }
//                    }
                }
            }

        } catch (Exception ex) {
            System.err.println("Error " + ex);
        }
        return false;
    }

    /**
     * public static void main(String[] args) { RegistroUsuario re = new
     * RegistroUsuario(); System.out.println(re.registrar("Ali", "jkjsd", "sdk",
     * "jkan", "jkslkd")); }
     */
}
