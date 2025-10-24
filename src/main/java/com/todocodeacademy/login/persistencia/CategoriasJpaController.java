package com.todocodeacademy.login.persistencia;

import com.todocodeacademy.login.logica.Categorias;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.todocodeacademy.login.logica.Productos;
import com.todocodeacademy.login.persistencia.exceptions.NonexistentEntityException;
import com.todocodeacademy.login.persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Claudio De Jesus
 */
public class CategoriasJpaController implements Serializable {

    public CategoriasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
 public CategoriasJpaController(){
    emf=Persistence.createEntityManagerFactory("loginPU");
    }
    public void create(Categorias categorias) throws PreexistingEntityException, Exception {
        if (categorias.getListaProductos() == null) {
            categorias.setListaProductos(new ArrayList<Productos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Productos> attachedListaProductos = new ArrayList<Productos>();
            for (Productos listaProductosProductosToAttach : categorias.getListaProductos()) {
                listaProductosProductosToAttach = em.getReference(listaProductosProductosToAttach.getClass(), listaProductosProductosToAttach.getIdProducto());
                attachedListaProductos.add(listaProductosProductosToAttach);
            }
            categorias.setListaProductos(attachedListaProductos);
            em.persist(categorias);
            for (Productos listaProductosProductos : categorias.getListaProductos()) {
                Categorias oldUnCategoriaOfListaProductosProductos = listaProductosProductos.getUnCategoria();
                listaProductosProductos.setUnCategoria(categorias);
                listaProductosProductos = em.merge(listaProductosProductos);
                if (oldUnCategoriaOfListaProductosProductos != null) {
                    oldUnCategoriaOfListaProductosProductos.getListaProductos().remove(listaProductosProductos);
                    oldUnCategoriaOfListaProductosProductos = em.merge(oldUnCategoriaOfListaProductosProductos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCategorias(categorias.getId()) != null) {
                throw new PreexistingEntityException("Categorias " + categorias + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categorias categorias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categorias persistentCategorias = em.find(Categorias.class, categorias.getId());
            List<Productos> listaProductosOld = persistentCategorias.getListaProductos();
            List<Productos> listaProductosNew = categorias.getListaProductos();
            List<Productos> attachedListaProductosNew = new ArrayList<Productos>();
            for (Productos listaProductosNewProductosToAttach : listaProductosNew) {
                listaProductosNewProductosToAttach = em.getReference(listaProductosNewProductosToAttach.getClass(), listaProductosNewProductosToAttach.getIdProducto());
                attachedListaProductosNew.add(listaProductosNewProductosToAttach);
            }
            listaProductosNew = attachedListaProductosNew;
            categorias.setListaProductos(listaProductosNew);
            categorias = em.merge(categorias);
            for (Productos listaProductosOldProductos : listaProductosOld) {
                if (!listaProductosNew.contains(listaProductosOldProductos)) {
                    listaProductosOldProductos.setUnCategoria(null);
                    listaProductosOldProductos = em.merge(listaProductosOldProductos);
                }
            }
            for (Productos listaProductosNewProductos : listaProductosNew) {
                if (!listaProductosOld.contains(listaProductosNewProductos)) {
                    Categorias oldUnCategoriaOfListaProductosNewProductos = listaProductosNewProductos.getUnCategoria();
                    listaProductosNewProductos.setUnCategoria(categorias);
                    listaProductosNewProductos = em.merge(listaProductosNewProductos);
                    if (oldUnCategoriaOfListaProductosNewProductos != null && !oldUnCategoriaOfListaProductosNewProductos.equals(categorias)) {
                        oldUnCategoriaOfListaProductosNewProductos.getListaProductos().remove(listaProductosNewProductos);
                        oldUnCategoriaOfListaProductosNewProductos = em.merge(oldUnCategoriaOfListaProductosNewProductos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = categorias.getId();
                if (findCategorias(id) == null) {
                    throw new NonexistentEntityException("The categorias with id " + id + " no longer exists.");
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
            Categorias categorias;
            try {
                categorias = em.getReference(Categorias.class, id);
                categorias.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categorias with id " + id + " no longer exists.", enfe);
            }
            List<Productos> listaProductos = categorias.getListaProductos();
            for (Productos listaProductosProductos : listaProductos) {
                listaProductosProductos.setUnCategoria(null);
                listaProductosProductos = em.merge(listaProductosProductos);
            }
            em.remove(categorias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categorias> findCategoriasEntities() {
        return findCategoriasEntities(true, -1, -1);
    }

    public List<Categorias> findCategoriasEntities(int maxResults, int firstResult) {
        return findCategoriasEntities(false, maxResults, firstResult);
    }

    private List<Categorias> findCategoriasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categorias.class));
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

    public Categorias findCategorias(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categorias.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categorias> rt = cq.from(Categorias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
