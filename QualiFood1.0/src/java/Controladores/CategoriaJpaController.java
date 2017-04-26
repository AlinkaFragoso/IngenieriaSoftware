/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import Entidades.Categoria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.PuestoCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alinka
 */
public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) {
        if (categoria.getPuestoCategoriaList() == null) {
            categoria.setPuestoCategoriaList(new ArrayList<PuestoCategoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PuestoCategoria> attachedPuestoCategoriaList = new ArrayList<PuestoCategoria>();
            for (PuestoCategoria puestoCategoriaListPuestoCategoriaToAttach : categoria.getPuestoCategoriaList()) {
                puestoCategoriaListPuestoCategoriaToAttach = em.getReference(puestoCategoriaListPuestoCategoriaToAttach.getClass(), puestoCategoriaListPuestoCategoriaToAttach.getIdPuestoCategoria());
                attachedPuestoCategoriaList.add(puestoCategoriaListPuestoCategoriaToAttach);
            }
            categoria.setPuestoCategoriaList(attachedPuestoCategoriaList);
            em.persist(categoria);
            for (PuestoCategoria puestoCategoriaListPuestoCategoria : categoria.getPuestoCategoriaList()) {
                Categoria oldIdCategoriaOfPuestoCategoriaListPuestoCategoria = puestoCategoriaListPuestoCategoria.getIdCategoria();
                puestoCategoriaListPuestoCategoria.setIdCategoria(categoria);
                puestoCategoriaListPuestoCategoria = em.merge(puestoCategoriaListPuestoCategoria);
                if (oldIdCategoriaOfPuestoCategoriaListPuestoCategoria != null) {
                    oldIdCategoriaOfPuestoCategoriaListPuestoCategoria.getPuestoCategoriaList().remove(puestoCategoriaListPuestoCategoria);
                    oldIdCategoriaOfPuestoCategoriaListPuestoCategoria = em.merge(oldIdCategoriaOfPuestoCategoriaListPuestoCategoria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria categoria) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getIdCategoria());
            List<PuestoCategoria> puestoCategoriaListOld = persistentCategoria.getPuestoCategoriaList();
            List<PuestoCategoria> puestoCategoriaListNew = categoria.getPuestoCategoriaList();
            List<String> illegalOrphanMessages = null;
            for (PuestoCategoria puestoCategoriaListOldPuestoCategoria : puestoCategoriaListOld) {
                if (!puestoCategoriaListNew.contains(puestoCategoriaListOldPuestoCategoria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PuestoCategoria " + puestoCategoriaListOldPuestoCategoria + " since its idCategoria field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<PuestoCategoria> attachedPuestoCategoriaListNew = new ArrayList<PuestoCategoria>();
            for (PuestoCategoria puestoCategoriaListNewPuestoCategoriaToAttach : puestoCategoriaListNew) {
                puestoCategoriaListNewPuestoCategoriaToAttach = em.getReference(puestoCategoriaListNewPuestoCategoriaToAttach.getClass(), puestoCategoriaListNewPuestoCategoriaToAttach.getIdPuestoCategoria());
                attachedPuestoCategoriaListNew.add(puestoCategoriaListNewPuestoCategoriaToAttach);
            }
            puestoCategoriaListNew = attachedPuestoCategoriaListNew;
            categoria.setPuestoCategoriaList(puestoCategoriaListNew);
            categoria = em.merge(categoria);
            for (PuestoCategoria puestoCategoriaListNewPuestoCategoria : puestoCategoriaListNew) {
                if (!puestoCategoriaListOld.contains(puestoCategoriaListNewPuestoCategoria)) {
                    Categoria oldIdCategoriaOfPuestoCategoriaListNewPuestoCategoria = puestoCategoriaListNewPuestoCategoria.getIdCategoria();
                    puestoCategoriaListNewPuestoCategoria.setIdCategoria(categoria);
                    puestoCategoriaListNewPuestoCategoria = em.merge(puestoCategoriaListNewPuestoCategoria);
                    if (oldIdCategoriaOfPuestoCategoriaListNewPuestoCategoria != null && !oldIdCategoriaOfPuestoCategoriaListNewPuestoCategoria.equals(categoria)) {
                        oldIdCategoriaOfPuestoCategoriaListNewPuestoCategoria.getPuestoCategoriaList().remove(puestoCategoriaListNewPuestoCategoria);
                        oldIdCategoriaOfPuestoCategoriaListNewPuestoCategoria = em.merge(oldIdCategoriaOfPuestoCategoriaListNewPuestoCategoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = categoria.getIdCategoria();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getIdCategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<PuestoCategoria> puestoCategoriaListOrphanCheck = categoria.getPuestoCategoriaList();
            for (PuestoCategoria puestoCategoriaListOrphanCheckPuestoCategoria : puestoCategoriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Categoria (" + categoria + ") cannot be destroyed since the PuestoCategoria " + puestoCategoriaListOrphanCheckPuestoCategoria + " in its puestoCategoriaList field has a non-nullable idCategoria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
