package com.todocodeacademy.login.persistencia;

import com.todocodeacademy.login.logica.Proveedor;
import com.todocodeacademy.login.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Usuario
 */
public class ProveedorJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;
    
    // Constructor con EntityManagerFactory (para inyección)
    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    // Constructor sin parámetros (crea su propio EMF)
    public ProveedorJpaController() {
        // ¡IMPORTANTE! Usa el mismo nombre que en persistence.xml
        // "TiendaAzulejoPU" o "loginPU" - verifica cuál tienes
        emf = Persistence.createEntityManagerFactory("loginPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            proveedor = em.merge(proveedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proveedor.getId();  // ← CAMBIADO: getId() en lugar de getId_proveedor()
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("El proveedor con id " + id + " ya no existe.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getId();  // ← CAMBIADO: Solo llamar getId() para verificar existencia
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El proveedor con id " + id + " ya no existe.", enfe);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    // Método adicional para buscar por nombre (útil)
    public List<Proveedor> findProveedorByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Proveedor p WHERE p.nombreProveedor LIKE :nombre");
            q.setParameter("nombre", "%" + nombre + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    // Cerrar el EntityManagerFactory cuando ya no se necesite
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}