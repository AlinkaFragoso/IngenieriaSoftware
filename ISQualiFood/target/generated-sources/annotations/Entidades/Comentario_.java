package Entidades;

import Entidades.Puesto;
import Entidades.UsuarioCiencias;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-25T17:38:40")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, Date> fecha;
    public static volatile SingularAttribute<Comentario, Date> hora;
    public static volatile SingularAttribute<Comentario, UsuarioCiencias> idUsuario;
    public static volatile SingularAttribute<Comentario, Puesto> idPuesto;
    public static volatile SingularAttribute<Comentario, String> comentario;
    public static volatile SingularAttribute<Comentario, Long> idComentario;

}