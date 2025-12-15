package com.todocodeacademy.login.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.todocodeacademy.login.logica.Categorias;
import com.todocodeacademy.login.logica.Productos;
import com.todocodeacademy.login.persistencia.exceptions.NonexistentEntityException;
import com.todocodeacademy.login.persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Claudio De Jesus
 */
public class ProductosJpaController implements Serializable {

    public ProductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ProductosJpaController() {
        emf = Persistence.createEntityManagerFactory("loginPU");
    }

    public void create(Productos productos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categorias unCategoria = productos.getUnCategoria();
            if (unCategoria != null) {
                unCategoria = em.getReference(unCategoria.getClass(), unCategoria.getId());
                productos.setUnCategoria(unCategoria);
            }
            em.persist(productos);
            if (unCategoria != null) {
                unCategoria.getListaProductos().add(productos);
                unCategoria = em.merge(unCategoria);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductos(productos.getIdProducto()) != null) {
                throw new PreexistingEntityException("Productos " + productos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productos productos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productos persistentProductos = em.find(Productos.class, productos.getIdProducto());
            Categorias unCategoriaOld = persistentProductos.getUnCategoria();
            Categorias unCategoriaNew = productos.getUnCategoria();
            if (unCategoriaNew != null) {
                unCategoriaNew = em.getReference(unCategoriaNew.getClass(), unCategoriaNew.getId());
                productos.setUnCategoria(unCategoriaNew);
            }
            productos = em.merge(productos);
            if (unCategoriaOld != null && !unCategoriaOld.equals(unCategoriaNew)) {
                unCategoriaOld.getListaProductos().remove(productos);
                unCategoriaOld = em.merge(unCategoriaOld);
            }
            if (unCategoriaNew != null && !unCategoriaNew.equals(unCategoriaOld)) {
                unCategoriaNew.getListaProductos().add(productos);
                unCategoriaNew = em.merge(unCategoriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = productos.getIdProducto();
                if (findProductos(id) == null) {
                    throw new NonexistentEntityException("The productos with id " + id + " no longer exists.");
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
            Productos productos;
            try {
                productos = em.getReference(Productos.class, id);
                productos.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productos with id " + id + " no longer exists.", enfe);
            }
            Categorias unCategoria = productos.getUnCategoria();
            if (unCategoria != null) {
                unCategoria.getListaProductos().remove(productos);
                unCategoria = em.merge(unCategoria);
            }
            em.remove(productos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productos> findProductosEntities() {
        return findProductosEntities(true, -1, -1);
    }

    public List<Productos> findProductosEntities(int maxResults, int firstResult) {
        return findProductosEntities(false, maxResults, firstResult);
    }

    private List<Productos> findProductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productos.class));
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

    public Productos findProductos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productos> rt = cq.from(Productos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Productos traerProductoPorCodigo(String texto) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT p FROM Productos p WHERE LOWER(p.codigo) = :texto OR LOWER(p.nombre) = :texto",
                    Productos.class)
                    .setParameter("texto", texto.toLowerCase()) // Búsqueda sin distinción de mayúsculas/minúsculas
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Producto no encontrado
        } finally {
            em.close();
        }
        
         
    }
    public Productos traerProducto() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT * FROM Productos",
                    Productos.class)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Producto no encontrado
        } finally {
            em.close();
        }
    }
}
