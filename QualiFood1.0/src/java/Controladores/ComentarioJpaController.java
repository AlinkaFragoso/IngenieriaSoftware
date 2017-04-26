/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Comentario;
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
public class ComentarioJpaController implements Serializable {

   public ComentarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comentario comentario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioCiencias idUsuario = comentario.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                comentario.setIdUsuario(idUsuario);
            }
            Puesto idPuesto = comentario.getIdPuesto();
            if (idPuesto != null) {
                idPuesto = em.getReference(idPuesto.getClass(), idPuesto.getIdPuesto());
                comentario.setIdPuesto(idPuesto);
            }
            em.persist(comentario);
            if (idUsuario != null) {
                idUsuario.getComentarioList().add(comentario);
                idUsuario = em.merge(idUsuario);
            }
            if (idPuesto != null) {
                idPuesto.getComentarioList().add(comentario);
                idPuesto = em.merge(idPuesto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comentario comentario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comentario persistentComentario = em.find(Comentario.class, comentario.getIdComentario());
            UsuarioCiencias idUsuarioOld = persistentComentario.getIdUsuario();
            UsuarioCiencias idUsuarioNew = comentario.getIdUsuario();
            Puesto idPuestoOld = persistentComentario.getIdPuesto();
            Puesto idPuestoNew = comentario.getIdPuesto();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                comentario.setIdUsuario(idUsuarioNew);
            }
            if (idPuestoNew != null) {
                idPuestoNew = em.getReference(idPuestoNew.getClass(), idPuestoNew.getIdPuesto());
                comentario.setIdPuesto(idPuestoNew);
            }
            comentario = em.merge(comentario);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getComentarioList().remove(comentario);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getComentarioList().add(comentario);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            if (idPuestoOld != null && !idPuestoOld.equals(idPuestoNew)) {
                idPuestoOld.getComentarioList().remove(comentario);
                idPuestoOld = em.merge(idPuestoOld);
            }
            if (idPuestoNew != null && !idPuestoNew.equals(idPuestoOld)) {
                idPuestoNew.getComentarioList().add(comentario);
                idPuestoNew = em.merge(idPuestoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = comentario.getIdComentario();
                if (findComentario(id) == null) {
                    throw new NonexistentEntityException("The comentario with id " + id + " no longer exists.");
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
            Comentario comentario;
            try {
                comentario = em.getReference(Comentario.class, id);
                comentario.getIdComentario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comentario with id " + id + " no longer exists.", enfe);
            }
            UsuarioCiencias idUsuario = comentario.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getComentarioList().remove(comentario);
                idUsuario = em.merge(idUsuario);
            }
            Puesto idPuesto = comentario.getIdPuesto();
            if (idPuesto != null) {
                idPuesto.getComentarioList().remove(comentario);
                idPuesto = em.merge(idPuesto);
            }
            em.remove(comentario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comentario> findComentarioEntities() {
        return findComentarioEntities(true, -1, -1);
    }

    public List<Comentario> findComentarioEntities(int maxResults, int firstResult) {
        return findComentarioEntities(false, maxResults, firstResult);
    }

    private List<Comentario> findComentarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comentario.class));
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

    public Comentario findComentario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comentario.class, id);
        } finally {
            em.close();
        }
    }

    public int getComentarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comentario> rt = cq.from(Comentario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
