package com.todocodeacademy.login.persistencia;

import com.todocodeacademy.login.igu.Categoria;
import com.todocodeacademy.login.logica.Categorias;
import com.todocodeacademy.login.logica.Clientes;
import com.todocodeacademy.login.logica.Productos;
import com.todocodeacademy.login.logica.Proveedor;
import com.todocodeacademy.login.logica.Rol;
import com.todocodeacademy.login.logica.Usuario;
import com.todocodeacademy.login.logica.Venta_exitosa;
import com.todocodeacademy.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Claudio De Jesus
 */
public class ControladoraPersistencia {

    //Instancia de Clases
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    ClientesJpaController ClienJpa = new ClientesJpaController();
    ProveedorJpaController provJpa = new ProveedorJpaController();
    CategoriasJpaController categJpa = new CategoriasJpaController();
    ProductosJpaController productJpa = new ProductosJpaController();

    //Traer datos
    public List<Usuario> traerUsuarios() {
        List<Usuario> listaUsuario = usuJpa.findUsuarioEntities();
        return listaUsuario;
        //Select*from usuarios;
    }

    public List<Clientes> traerClientes() {
        List<Clientes> listaClientes = ClienJpa.findClientesEntities();
        return listaClientes;
        //Select*from Clientes;
    }

    public List<Proveedor> traerProveedor() {
        List<Proveedor> listaProveedor = provJpa.findProveedorEntities();
        return listaProveedor;
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    public List<Categorias> traerCategoria() {
        List<Categorias> listaCategorias = categJpa.findCategoriasEntities();
        return listaCategorias;
    }

    public List<Productos> traerProductos() {
        List<Productos> listaProductos = productJpa.findProductosEntities();
        return listaProductos;
    }

    ///////////////////////////////////////METODO PARA USUARIOS//////////////////////////
    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    }

    public void borrarUsuario(int id_Usuario) {
        try {
            usuJpa.destroy(id_Usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id_usuario) {
        return usuJpa.findUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu) {

        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ///////////////////////////////////////////METODO PARA CLIENTES///////////////////////////
    public void CrearClientes(Clientes clie) {
        ClienJpa.create(clie);
    }

    public void borrarCliente(int id_Cliente) throws NonexistentEntityException {
        ClienJpa.destroy(id_Cliente);
    }

    public Clientes traerClientes(int id_cliente) {
        return ClienJpa.findClientes(id_cliente);
    }

    public void editarCliente(Clientes cli) {
        try {
            ClienJpa.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //////////////////////////////////////////////////METODO PARA PROVEEDOR//////////////////////////////////////////
    public void CrearProveedor(Proveedor prov) {
        provJpa.create(prov);
    }

    public Proveedor traerProveedor(int id_proveedor) {
        return provJpa.findProveedor(id_proveedor);
    }

    public void editarProveedor(Proveedor prov) {
        try {
            provJpa.edit(prov);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarProveedor(int id_proveedor) throws NonexistentEntityException {
        provJpa.destroy(id_proveedor);
    }

    ////////////////////////////////////METODO PARA CATEGORIA///////////////////////////////////////////////
    //CREAR CATEGORIA
    public void crearCategoria(Categorias cat) {
        if (cat == null || cat.getNombre().trim().isEmpty() || cat.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("Los datos de la categoría no son válidos.");
        }
        try {
            categJpa.create(cat);
        } catch (Exception ex) {
            manejarExcepcionPersistencia(ex, "Error al crear la categoría.");
        }
    }
    // Método genérico para manejar excepciones de persistencia

    private void manejarExcepcionPersistencia(Exception ex, String mensajeError) {
        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, mensajeError, ex);
        throw new RuntimeException(mensajeError);
    }

    public Categorias traerCategoria(int id_categoria) {
        return categJpa.findCategorias(id_categoria);
    }

    public void editarCategoria(Categorias cat) {
        try {
            categJpa.edit(cat);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarCategoria(int id_categoria) throws NonexistentEntityException {
        categJpa.destroy(id_categoria);
    }
    /////////////////////////////////////////METODO PARA PRODUCTO//////////////////////////////////////////////////

    public void crearProducto(Productos prod) throws Exception {
        productJpa.create(prod);

    }

    public void borrarProducto(int id_producto) {
        try {
            productJpa.destroy(id_producto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Productos traerProductos(int idProducto) {
        return productJpa.findProductos(idProducto);
    }

    public void editarProducto(Productos prod) {
        try {
            productJpa.edit(prod);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public Productos traerProductoPorCodigoSQL(String codigo) {
//try {
//        return (Productos) productJpa.getEntityManager()
//            .createQuery("SELECT p FROM Productos p WHERE p.codigo = :codigo")
//            .setParameter("codigo", codigo)
//            .getSingleResult();
//    } catch (NoResultException e) {
//        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.WARNING, "Producto no encontrado con código: " + codigo);
//        return null;
//    } catch (Exception ex) {
//        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error en la búsqueda del producto", ex);
//        return null;
//    }
//    }
    public Productos traerProductoPorCodigoONombre(String texto) {
        // Convertir texto a minúsculas para búsqueda sin distinción de mayúsculas/minúsculas
        String textoBuscado = texto.toLowerCase();

        // Buscar producto por código o nombre en la lista de productos
        return traerProductos().stream()
                .filter(prod -> prod.getCodigo().toLowerCase().contains(textoBuscado)
                || prod.getNombre().toLowerCase().contains(textoBuscado))
                .findFirst()
                .orElse(null);
    }

    public Productos traerProductoPorCodigo(String codigo) {
       return productJpa.traerProductoPorCodigo(codigo);
    }



}
