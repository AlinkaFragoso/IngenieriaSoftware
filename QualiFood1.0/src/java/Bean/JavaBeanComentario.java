/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controladores.ComentarioJpaController;
import Entidades.Comentario;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alinka
 */
public class JavaBeanComentario {
    private EntityManagerFactory emf;
    private ComentarioJpaController ComentarioControl;
    
    public JavaBeanComentario(){
        emf = Persistence.createEntityManagerFactory("QualiFoodPU");
        ComentarioControl = new ComentarioJpaController(emf);
    }

    public void guardar(Comentario comentario){
    ComentarioControl.create(comentario);
    }
    
    public List<Comentario> buscarTodos(){
        return ComentarioControl.findComentarioEntities();
    } 
    
}
