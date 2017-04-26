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
@Table(name = "Puesto_Categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuestoCategoria.findAll", query = "SELECT p FROM PuestoCategoria p")
    , @NamedQuery(name = "PuestoCategoria.findByIdPuestoCategoria", query = "SELECT p FROM PuestoCategoria p WHERE p.idPuestoCategoria = :idPuestoCategoria")})
public class PuestoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_puesto_categoria")
    private Long idPuestoCategoria;
    @JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
    @ManyToOne(optional = false)
    private Puesto idPuesto;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;

    public PuestoCategoria() {
    }

    public PuestoCategoria(Long idPuestoCategoria) {
        this.idPuestoCategoria = idPuestoCategoria;
    }

    public Long getIdPuestoCategoria() {
        return idPuestoCategoria;
    }

    public void setIdPuestoCategoria(Long idPuestoCategoria) {
        this.idPuestoCategoria = idPuestoCategoria;
    }

    public Puesto getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Puesto idPuesto) {
        this.idPuesto = idPuesto;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuestoCategoria != null ? idPuestoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuestoCategoria)) {
            return false;
        }
        PuestoCategoria other = (PuestoCategoria) object;
        if ((this.idPuestoCategoria == null && other.idPuestoCategoria != null) || (this.idPuestoCategoria != null && !this.idPuestoCategoria.equals(other.idPuestoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PuestoCategoria[ idPuestoCategoria=" + idPuestoCategoria + " ]";
    }
    
}
