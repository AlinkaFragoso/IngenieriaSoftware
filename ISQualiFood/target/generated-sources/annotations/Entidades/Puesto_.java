package Entidades;

import Entidades.Calificacion;
import Entidades.Comentario;
import Entidades.PuestoCategoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-25T17:38:40")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile SingularAttribute<Puesto, String> descripcion;
    public static volatile SingularAttribute<Puesto, Float> latitud;
    public static volatile SingularAttribute<Puesto, Float> longitud;
    public static volatile SingularAttribute<Puesto, Integer> numero;
    public static volatile ListAttribute<Puesto, PuestoCategoria> puestoCategoriaList;
    public static volatile ListAttribute<Puesto, Comentario> comentarioList;
    public static volatile SingularAttribute<Puesto, Long> idPuesto;
    public static volatile ListAttribute<Puesto, Calificacion> calificacionList;
    public static volatile SingularAttribute<Puesto, String> nombre;

}