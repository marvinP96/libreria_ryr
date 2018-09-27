/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.exceptions.NonexistentEntityException;
import entidades.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author marvin1
 */
public class CatProductoJpaController implements Serializable {

    public CatProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CatProducto catProducto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(catProducto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCatProducto(catProducto.getIdCatProducto()) != null) {
                throw new PreexistingEntityException("CatProducto " + catProducto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CatProducto catProducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            catProducto = em.merge(catProducto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = catProducto.getIdCatProducto();
                if (findCatProducto(id) == null) {
                    throw new NonexistentEntityException("The catProducto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CatProducto catProducto;
            try {
                catProducto = em.getReference(CatProducto.class, id);
                catProducto.getIdCatProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The catProducto with id " + id + " no longer exists.", enfe);
            }
            em.remove(catProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CatProducto> findCatProductoEntities() {
        return findCatProductoEntities(true, -1, -1);
    }

    public List<CatProducto> findCatProductoEntities(int maxResults, int firstResult) {
        return findCatProductoEntities(false, maxResults, firstResult);
    }

    private List<CatProducto> findCatProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CatProducto.class));
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

    public CatProducto findCatProducto(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CatProducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getCatProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CatProducto> rt = cq.from(CatProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
