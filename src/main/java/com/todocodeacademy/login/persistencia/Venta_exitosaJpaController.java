package com.todocodeacademy.login.persistencia;

import com.todocodeacademy.login.logica.Venta_exitosa;
import com.todocodeacademy.login.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Claudio De Jesus
 */
public class Venta_exitosaJpaController implements Serializable {

    public Venta_exitosaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   public  Venta_exitosaJpaController(){
    emf=Persistence.createEntityManagerFactory("loginPU");
    }
    public void create(Venta_exitosa venta_exitosa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(venta_exitosa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta_exitosa venta_exitosa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            venta_exitosa = em.merge(venta_exitosa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = venta_exitosa.getId_venta();
                if (findVenta_exitosa(id) == null) {
                    throw new NonexistentEntityException("The venta_exitosa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta_exitosa venta_exitosa;
            try {
                venta_exitosa = em.getReference(Venta_exitosa.class, id);
                venta_exitosa.getId_venta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta_exitosa with id " + id + " no longer exists.", enfe);
            }
            em.remove(venta_exitosa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta_exitosa> findVenta_exitosaEntities() {
        return findVenta_exitosaEntities(true, -1, -1);
    }

    public List<Venta_exitosa> findVenta_exitosaEntities(int maxResults, int firstResult) {
        return findVenta_exitosaEntities(false, maxResults, firstResult);
    }

    private List<Venta_exitosa> findVenta_exitosaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta_exitosa.class));
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

    public Venta_exitosa findVenta_exitosa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta_exitosa.class, id);
        } finally {
            em.close();
        }
    }

    public int getVenta_exitosaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta_exitosa> rt = cq.from(Venta_exitosa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
