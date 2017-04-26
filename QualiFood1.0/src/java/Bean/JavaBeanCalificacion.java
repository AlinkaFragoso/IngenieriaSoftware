/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controladores.CalificacionJpaController;
import Entidades.Calificacion;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alinka
 */
public class JavaBeanCalificacion {
    private final EntityManagerFactory emf;
    private final CalificacionJpaController CalificacionControl;
    
    public JavaBeanCalificacion(){
        emf = Persistence.createEntityManagerFactory("QualiFoodPU");
        CalificacionControl = new CalificacionJpaController(emf);
    }

    public void guardar(Calificacion calificacion){
    CalificacionControl.create(calificacion);
    }
    
    public List<Calificacion> buscarTodos(){
        return CalificacionControl.findCalificacionEntities();
    } 
}
