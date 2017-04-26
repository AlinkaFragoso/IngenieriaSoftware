/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alinka
 */
@Entity
@Table(name = "Usuario_Ciencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioCiencias.findAll", query = "SELECT u FROM UsuarioCiencias u")
    , @NamedQuery(name = "UsuarioCiencias.findByIdUsuario", query = "SELECT u FROM UsuarioCiencias u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuarioCiencias.findByNombre", query = "SELECT u FROM UsuarioCiencias u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsuarioCiencias.findByApellido", query = "SELECT u FROM UsuarioCiencias u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "UsuarioCiencias.findByNombreUsuario", query = "SELECT u FROM UsuarioCiencias u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "UsuarioCiencias.findByCorreo", query = "SELECT u FROM UsuarioCiencias u WHERE u.correo = :correo")
    , @NamedQuery(name = "UsuarioCiencias.findByContrase\u00f1a", query = "SELECT u FROM UsuarioCiencias u WHERE u.contrasenia = :contrasenia")})
public class UsuarioCiencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "contrasenia")
    private String contrasenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Comentario> comentarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Calificacion> calificacionList;

    public UsuarioCiencias() {
    }

    public UsuarioCiencias(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioCiencias(Long idUsuario, String nombre, String apellido, String nombreUsuario, String correo, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioCiencias)) {
            return false;
        }
        UsuarioCiencias other = (UsuarioCiencias) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioCiencias[ idUsuario=" + idUsuario + " ]";
    }
    
}
