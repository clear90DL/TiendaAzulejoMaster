package com.todocodeacademy.login.logica;

import com.todocodeacademy.login.persistencia.ControladoraPersistencia;
import com.todocodeacademy.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudio De Jesus
 */
public class Controladora {

    ControladoraPersistencia controlPersis;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
///////////////////////////////////////////VALIDAR USUARIO EN EL LOGIN/////////////////////////////////

    public Usuario validarUsuario(String usuario, String contrasenia) {

        //String mensaje="";
        //boolean ok = false;
        Usuario usr = null;
        List<Usuario> listaUsuario = controlPersis.traerUsuarios();
        for (Usuario usu : listaUsuario) {

            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    //mensaje="Usuario y contraseña correcto, Bienvenido";
                    //ok=true;
                    usr = usu;
                    return usr;
                } else {
                    usr = null;
                    return usr;
                }
            } else {
                usr = null;
                //    return usr;
            }
        }
        return usr;
    }

    //////////////////////////////////////Traer Datos y almacernarlos //////////////////////////////////
    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Clientes> traerClientes() {
        return controlPersis.traerClientes();
    }

    public List<Proveedor> traerProveedor() {
        return controlPersis.traerProveedor();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public List<Categorias> TraerCategoria() {
        return controlPersis.traerCategoria();
    }

    public List<Productos> TraerProducto() {
        return controlPersis.traerProductos();
    }

    //////////////////////////////////////////Crear Usuario///////////////////////////////////////////////////////
    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);

        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }

        int id = this.buscarUltimaIdUsuario();
        usu.setId(id + 1);

        controlPersis.crearUsuario(usu);

    }

    private Rol traerRol(String rolRecibido) {

        List<Rol> listaRoles = controlPersis.traerRoles();
        for (Rol rol : listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUsuario() {
        List<Usuario> listaUsuarios = this.traerUsuarios();

        Usuario usu = listaUsuarios.get(listaUsuarios.size() - 1);
        return usu.getId();

    }

    public void borrarUsuario(int id_Usuario) {
        controlPersis.borrarUsuario(id_Usuario);

    }

    public Usuario traerUsuario(int id_Usuario) {
        return controlPersis.traerUsuario(id_Usuario);
    }

    public void editarUsuario(Usuario usu, String usuario, String contra, String rolRecibido) {
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);

        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        controlPersis.editarUsuario(usu);

    }

    /////////////////////////////////////////////////Crear Cliente///////////////////////////////////////////////////
    public void crearClientes(String nombre, String Direccion, String numero) {
        Clientes clie = new Clientes();

        clie.setNombre(nombre);
        clie.setDireccion(Direccion);
        clie.setNumero(numero);
       

        controlPersis.CrearClientes(clie);
    }

    public Clientes traerCliente(int id_Cliente) {
        return controlPersis.traerClientes(id_Cliente);
    }

    public void editarCliente(Clientes cli, String nombre, String direccion, String numero) {
        cli.setNombre(nombre);
        cli.setDireccion(direccion);
        cli.setNumero(numero);
     

        controlPersis.editarCliente(cli);

    }

    public void borrarCliente(int id_Cliente) {
        try {
            controlPersis.borrarCliente(id_Cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
///////////////////////////////////////////////Crear Proveedor///////////////////////////////////////////////

    public void crearProveedor(String nombre, String direccion, String correo, String telefono) {
        Proveedor prov = new Proveedor();

        prov.setNombre(nombre);
        prov.setDireccion(direccion);
        prov.setCorreo(correo);
        prov.setCorreo(correo);
        prov.setTelefono(telefono);

        controlPersis.CrearProveedor(prov);
    }

    public void editarProveedor(Proveedor prov, String nombre, String direccion, String correo, String telefono) {
        prov.setNombre(nombre);
        prov.setDireccion(direccion);
        prov.setCorreo(correo);
        prov.setTelefono(telefono);

        controlPersis.editarProveedor(prov);
    }

    public Proveedor traerProveedor(int id_Proveedor) {
        return controlPersis.traerProveedor(id_Proveedor);
    }

    public void borrarProveedor(int id_proveedor) {
        try {
            controlPersis.borrarProveedor(id_proveedor);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/////////////////////////////////////////Crear Categoria///////////////////////////////7

    public void crearCategoria(String nombre, String descripcion) {

        Categorias cat = new Categorias();
        cat.setNombre(nombre);
        cat.setDescripcion(descripcion);

        int id = this.buscarUltimaIdCategoria();
        cat.setId(id + 1);
        controlPersis.crearCategoria(cat);

    }

    public Categorias traerCategorias(int id_Categoria) {
        return controlPersis.traerCategoria(id_Categoria);
    }


    public int buscarUltimaIdCategoria() {
    List<Categorias> listaCategorias = TraerCategoria();

    if (listaCategorias == null || listaCategorias.isEmpty()) {
        // No hay categorías aún → devuelve 0 o maneja como caso nuevo
        return 0;
    }

    Categorias ultima = listaCategorias.get(listaCategorias.size() - 1);
    return ultima.getId();
}


    public void borrarCategoria(int id_categoria) {
        try {
            controlPersis.borrarCategoria(id_categoria);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public Categorias traercat(String categoriaNombre) {
//        // Obtener todas las categorías de la base de datos
//        List<Categorias> listaCategoria = controlPersis.traerCategoria();
//
//        // Buscar por nombre de categoría
//        for (Categorias cat : listaCategoria) {
//            if (cat.getNombre().equalsIgnoreCase(categoriaNombre)) {
//                return cat; // Retornar la categoría encontrada
//            }
//        }
//
//        // Si no se encuentra, retornar null
//        return null;
//    }

public Categorias traercat(String categoriaNombre) {
    // Obtener todas las categorías de la base de datos
    List<Categorias> listaCategoria = controlPersis.traerCategoria();

    if (listaCategoria == null || listaCategoria.isEmpty()) {
        System.out.println("La lista de categorías está vacía o no se pudo cargar.");
        return null;
    }

    // Buscar por nombre de categoría
    for (Categorias cat : listaCategoria) {
        if (cat.getNombre().equalsIgnoreCase(categoriaNombre.trim())) { // Trim para evitar problemas de espacios
            return cat; // Retornar la categoría encontrada
        }
    }

    // Si no se encuentra, mostrar mensaje para depuración
    System.out.println("Categoría no encontrada: " + categoriaNombre);
    return null;
}


    public void editarCategoria(Categorias cat, String nombre, String descripcion) {
        cat.setNombre(nombre);
        cat.setDescripcion(descripcion);

        controlPersis.editarCategoria(cat);

    }
/////////////////////////////////////////////METODO PRODUCTO/////////////////////////////////////////////////

    public void crearProducto(String codigo, String nombre, String color, String dimension, int precioVenta, int stock, int precioCompra, String material,String categoria) throws Exception {
        // Crear una instancia del producto
        Productos prod = new Productos();

        // Asignar valores a los atributos del producto
        prod.setCodigo(codigo);
        prod.setNombre(nombre);
        prod.setColor(color);
        prod.setDimension(dimension);
        prod.setPrecioVenta(precioVenta);
        prod.setStockDisponible(stock);
        prod.setPrecioCompra(precioCompra);
        prod.setMaterial(material);

         // Buscar y asignar la categoría correspondiente
    Categorias categoriaSeleccionada = this.traercat(categoria); // Buscar categoría por su nombre
    if (categoriaSeleccionada != null) {
        prod.setUnCategoria(categoriaSeleccionada); // Asignar la categoría seleccionada
    } else {
        // Si la categoría no existe, asignar una categoría predeterminada (opcional)
        Categorias categoriaDefault = this.traercat("General"); // Buscar categoría "General"
        prod.setUnCategoria(categoriaDefault); // Asignar categoría "General" si existe
    }
        // Generar ID único para el producto
        int id = this.buscarUltimaIdProducto();
        prod.setIdProducto(id + 1);

        // Persistir el producto en la base de datos
        controlPersis.crearProducto(prod);
    }

    private int buscarUltimaIdProducto() {
        List<Productos> listaProductos = controlPersis.traerProductos(); // Método que trae todos los productos

        if (listaProductos.isEmpty()) {
            return 0; // Si no hay productos, retorna 0
        }

        // Retorna el ID del último producto de la lista
        Productos ultimoProducto = listaProductos.get(listaProductos.size() - 1);
        return ultimoProducto.getIdProducto();
    }

    public void borrarProducto(int id_producto) {

        controlPersis.borrarProducto(id_producto);

    }

    public Productos traerProducto(int idProducto) {
        return controlPersis.traerProductos(idProducto);
    }

public void editarProducto(Productos prod, String codigo, String nombre, String color, String dimension, 
                           int precioVenta, int stock, int precioCompra, String material, Categorias categoria) {
    // Validar que el objeto producto no sea nulo
    if (prod == null) {
        throw new IllegalArgumentException("El producto no puede ser nulo.");
    }

    // Validar que la categoría no sea nula
    if (categoria == null) {
        throw new IllegalArgumentException("La categoría no puede ser nula.");
    }

    // Actualizar los valores del producto
    prod.setCodigo(codigo);
    prod.setNombre(nombre);
    prod.setColor(color);
    prod.setDimension(dimension);
    prod.setPrecioVenta(precioVenta);
    prod.setStockDisponible(stock);
    prod.setPrecioCompra(precioCompra);
    prod.setMaterial(material);
    prod.setUnCategoria(categoria); // Asignar la nueva categoría

    // Persistir cambios
    try {
        controlPersis.editarProducto(prod);
    } catch (Exception e) {
        // Manejar excepciones y relanzar si es necesario
        throw new RuntimeException("Error al editar el producto: " + e.getMessage(), e);
    }
}

public Productos buscarProductoPorCodigo(String codigo) {
    return controlPersis.traerProductoPorCodigoONombre(codigo); // Implementa una consulta SQL SELECT * WHERE codigo = ?
}
    public void actualizarProducto(Productos producto) {
  controlPersis.editarProducto(producto);
    }
    
    public boolean existeProductoConCodigo(String codigo) {
    Productos producto = controlPersis.traerProductoPorCodigo(codigo);
    return producto != null; // Si existe el producto, devuelve true
}

    
    
////////////////////////////////////////////////////////////Venta////////////////////////////////////////////////////////////////
    
    public Productos buscarProductoPorCodigoVenta(String codigo) {
    return controlPersis.traerProductoPorCodigo(codigo); // Implementa una consulta SQL SELECT * WHERE codigo = ?
}
    
}
