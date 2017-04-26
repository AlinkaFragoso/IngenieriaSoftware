package Entidades;

import Entidades.Calificacion;
import Entidades.Comentario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-25T17:38:40")
@StaticMetamodel(UsuarioCiencias.class)
public class UsuarioCiencias_ { 

    public static volatile ListAttribute<UsuarioCiencias, Comentario> comentarioList;
    public static volatile SingularAttribute<UsuarioCiencias, Long> idUsuario;
    public static volatile SingularAttribute<UsuarioCiencias, String> apellido;
    public static volatile SingularAttribute<UsuarioCiencias, String> correo;
    public static volatile SingularAttribute<UsuarioCiencias, String> contrasenia;
    public static volatile SingularAttribute<UsuarioCiencias, String> nombreUsuario;
    public static volatile ListAttribute<UsuarioCiencias, Calificacion> calificacionList;
    public static volatile SingularAttribute<UsuarioCiencias, String> nombre;

}