/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Calificacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.UsuarioCiencias;
import Entidades.Puesto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alinka
 */
public class CalificacionJpaController implements Serializable {

    public CalificacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calificacion calificacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioCiencias idUsuario = calificacion.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                calificacion.setIdUsuario(idUsuario);
            }
            Puesto idPuesto = calificacion.getIdPuesto();
            if (idPuesto != null) {
                idPuesto = em.getReference(idPuesto.getClass(), idPuesto.getIdPuesto());
                calificacion.setIdPuesto(idPuesto);
            }
            em.persist(calificacion);
            if (idUsuario != null) {
                idUsuario.getCalificacionList().add(calificacion);
                idUsuario = em.merge(idUsuario);
            }
            if (idPuesto != null) {
                idPuesto.getCalificacionList().add(calificacion);
                idPuesto = em.merge(idPuesto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calificacion calificacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calificacion persistentCalificacion = em.find(Calificacion.class, calificacion.getIdCalificacion());
            UsuarioCiencias idUsuarioOld = persistentCalificacion.getIdUsuario();
            UsuarioCiencias idUsuarioNew = calificacion.getIdUsuario();
            Puesto idPuestoOld = persistentCalificacion.getIdPuesto();
            Puesto idPuestoNew = calificacion.getIdPuesto();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                calificacion.setIdUsuario(idUsuarioNew);
            }
            if (idPuestoNew != null) {
                idPuestoNew = em.getReference(idPuestoNew.getClass(), idPuestoNew.getIdPuesto());
                calificacion.setIdPuesto(idPuestoNew);
            }
            calificacion = em.merge(calificacion);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getCalificacionList().remove(calificacion);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getCalificacionList().add(calificacion);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            if (idPuestoOld != null && !idPuestoOld.equals(idPuestoNew)) {
                idPuestoOld.getCalificacionList().remove(calificacion);
                idPuestoOld = em.merge(idPuestoOld);
            }
            if (idPuestoNew != null && !idPuestoNew.equals(idPuestoOld)) {
                idPuestoNew.getCalificacionList().add(calificacion);
                idPuestoNew = em.merge(idPuestoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = calificacion.getIdCalificacion();
                if (findCalificacion(id) == null) {
                    throw new NonexistentEntityException("The calificacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calificacion calificacion;
            try {
                calificacion = em.getReference(Calificacion.class, id);
                calificacion.getIdCalificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calificacion with id " + id + " no longer exists.", enfe);
            }
            UsuarioCiencias idUsuario = calificacion.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getCalificacionList().remove(calificacion);
                idUsuario = em.merge(idUsuario);
            }
            Puesto idPuesto = calificacion.getIdPuesto();
            if (idPuesto != null) {
                idPuesto.getCalificacionList().remove(calificacion);
                idPuesto = em.merge(idPuesto);
            }
            em.remove(calificacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calificacion> findCalificacionEntities() {
        return findCalificacionEntities(true, -1, -1);
    }

    public List<Calificacion> findCalificacionEntities(int maxResults, int firstResult) {
        return findCalificacionEntities(false, maxResults, firstResult);
    }

    private List<Calificacion> findCalificacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calificacion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Calificacion findCalificacion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calificacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalificacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calificacion> rt = cq.from(Calificacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
