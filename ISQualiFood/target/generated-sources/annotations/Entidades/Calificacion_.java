package Entidades;

import Entidades.Puesto;
import Entidades.UsuarioCiencias;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-25T17:38:40")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, Integer> calificacion;
    public static volatile SingularAttribute<Calificacion, UsuarioCiencias> idUsuario;
    public static volatile SingularAttribute<Calificacion, Puesto> idPuesto;
    public static volatile SingularAttribute<Calificacion, Long> idCalificacion;

}