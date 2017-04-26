/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alinka
 */
@Entity
@Table(name = "Comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.idComentario = :idComentario")
    , @NamedQuery(name = "Comentario.findByComentario", query = "SELECT c FROM Comentario c WHERE c.comentario = :comentario")
    , @NamedQuery(name = "Comentario.findByFecha", query = "SELECT c FROM Comentario c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Comentario.findByHora", query = "SELECT c FROM Comentario c WHERE c.hora = :hora")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private Long idComentario;
    
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;
    
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioCiencias idUsuario;
    
    @JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
    @ManyToOne(optional = false)
    private Puesto idPuesto;

    public Comentario() {
    }

    public Comentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(Long idComentario, String comentario, int numPuesto, String nombreUsuario, Date fecha, Date hora) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public UsuarioCiencias getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioCiencias idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Puesto getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Puesto idPuesto) {
        this.idPuesto = idPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Comentario[ idComentario=" + idComentario + " ]";
    }
    
}
