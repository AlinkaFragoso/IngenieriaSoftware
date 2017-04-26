/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alinka
 */
@Entity
@Table(name = "Calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByIdCalificacion", query = "SELECT c FROM Calificacion c WHERE c.idCalificacion = :idCalificacion")
    , @NamedQuery(name = "Calificacion.findByCalificacion", query = "SELECT c FROM Calificacion c WHERE c.calificacion = :calificacion")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificacion")
    private Long idCalificacion;
    @Basic(optional = false)
    @Column(name = "calificacion")
    private int calificacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioCiencias idUsuario;
    @JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
    @ManyToOne(optional = false)
    private Puesto idPuesto;

    public Calificacion() {
    }

    public Calificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Calificacion(Long idCalificacion, int calificacion, int numPuesto) {
        this.idCalificacion = idCalificacion;
        this.calificacion = calificacion;;
    }

    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
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
        hash += (idCalificacion != null ? idCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idCalificacion == null && other.idCalificacion != null) || (this.idCalificacion != null && !this.idCalificacion.equals(other.idCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Calificacion[ idCalificacion=" + idCalificacion + " ]";
    }
    
}
