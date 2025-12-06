package com.todocodeacademy.login.logica;

import ConexionBD.ConexionBD;
import com.todocodeacademy.login.persistencia.ControladoraPersistencia;
import com.todocodeacademy.login.persistencia.ProveedorJpaController;
import com.todocodeacademy.login.persistencia.exceptions.NonexistentEntityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 

public Clientes traerCliente(int idCliente) {
    return controlPersis.traerClientes(idCliente);
}

public void editarCliente(
        Clientes cli,
        String primerNombre,
        String segundoNombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String tipoDeCliente,
        String telefono,
        String correoElectronico,
        String rfc,
        String calle,
        String numeroExterior,
        String numeroInterior,
        String colonia,
        String codigoPostal,
        String municipio,
        String ciudad,
        String referencia
) {

    // Nombres
    cli.setPrimerNombre(primerNombre);
    cli.setSegundoNombre(segundoNombre);
    cli.setApellidoPaterno(apellidoPaterno);
    cli.setApellidoMaterno(apellidoMaterno);

    // Datos cliente
    cli.setTipoDeCliente(tipoDeCliente);
    cli.setTelefono(telefono);
    cli.setCorreoElectronico(correoElectronico);
    cli.setRfc(rfc);

    // Dirección
    cli.setCalle(calle);
    cli.setNumeroExterior(numeroExterior);
    cli.setNumeroInterior(numeroInterior);
    cli.setColonia(colonia);
    cli.setCodigoPostal(codigoPostal);
    cli.setMunicipio(municipio);
    cli.setCiudad(ciudad);
    cli.setReferencia(referencia);

    controlPersis.editarCliente(cli);
}

public void borrarCliente(int idCliente) {
    try {
        controlPersis.borrarCliente(idCliente);
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
    }
}

///////////////////////////////////////////////Crear Proveedor///////////////////////////////////////////////
// DEJAR SOLO ESTE MÉTODO (con 1 parámetro)
public void crearProveedor(Proveedor proveedor) {
    // Asignar valores por defecto si es necesario
    if (proveedor.getEstado() == null || proveedor.getEstado().isEmpty()) {
        proveedor.setEstado("ACTIVO");
    }
    if (proveedor.getFechaRegistro() == null || proveedor.getFechaRegistro().isEmpty()) {
        proveedor.setFechaRegistro(obtenerFechaActual());
    }
    
    // IMPORTANTE: Cambia "crearProveedor" por "CrearProveedor" para coincidir con ControladoraPersistencia
    controlPersis.CrearProveedor(proveedor);
}

 public void crearProveedor(String nombreProveedor, String nombreContacto, String tipoProveedor,
                          String telefono1, String telefono2, String correo, String rfc,
                          String calle, String numeroInterior, String numeroExterior, 
                          String colonia, String municipio, String ciudad, String codigoPostal, 
                          String referencia, String estado, String fechaRegistro) {
    
    Proveedor prov = new Proveedor();
    
    // Datos generales
    prov.setNombreProveedor(nombreProveedor);
    prov.setNombreContacto(nombreContacto);
    prov.setTipoProveedor(tipoProveedor);
    
    // Contacto
    prov.setTelefono1(telefono1);
    prov.setTelefono2(telefono2);
    prov.setCorreo(correo);
    
    // Datos fiscales
    prov.setRfc(rfc);
    
    // Dirección
    prov.setCalle(calle);
    prov.setNumeroInterior(numeroInterior);
    prov.setNumeroExterior(numeroExterior);
    prov.setColonia(colonia);
    prov.setMunicipio(municipio);
    prov.setCiudad(ciudad);
    prov.setCodigoPostal(codigoPostal);
    prov.setReferencia(referencia);
    
    // Administración
    prov.setEstado(estado);
    prov.setFechaRegistro(fechaRegistro);
    
    controlPersis.CrearProveedor(prov);
}

public void editarProveedor(Proveedor proveedor) {
    try {
        controlPersis.editarProveedor(proveedor);
        System.out.println("Proveedor editado exitosamente. ID: " + proveedor.getId());
    } catch (Exception ex) {
        Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        throw new RuntimeException("Error al editar proveedor: " + ex.getMessage());
    }
}
public void borrarProveedor(int idProveedor) {
    try {
        controlPersis.borrarProveedor(idProveedor);
        System.out.println("Proveedor eliminado exitosamente. ID: " + idProveedor);
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        throw new RuntimeException("No se pudo eliminar el proveedor. ID no encontrado: " + idProveedor);
    }
}

// También agrega este método para traer un proveedor específico por ID
public Proveedor traerProveedor(int idProveedor) {
    return controlPersis.traerProveedor(idProveedor);
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
    return controlPersis.buscarProductoPorCodigoventa(codigo); // Implementa una consulta SQL SELECT * WHERE codigo = ?
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

public void crearClienteCompleto(String primerNombre, String segundoNombre, 
                                 String apellidoPaterno, String apellidoMaterno, 
                                 String tipoCliente, String telefono, String correo, 
                                 String rfc, String calle, String numeroExterior, 
                                 String numeroInterior, String colonia, 
                                 String codigoPostal, String municipio, 
                                 String ciudad, String referencia) {
    
    try {
        System.out.println("DEBUG: Entrando a crearClienteCompleto"); // Agrega esto
        
        // Crear nuevo cliente (sin ID, se genera automáticamente)
        Clientes cliente = new Clientes();
        cliente.setPrimerNombre(primerNombre);
        cliente.setSegundoNombre(segundoNombre);
        cliente.setApellidoPaterno(apellidoPaterno);
        cliente.setApellidoMaterno(apellidoMaterno);
        cliente.setTipoDeCliente(tipoCliente);
        cliente.setTelefono(telefono);
        cliente.setCorreoElectronico(correo);
        cliente.setRfc(rfc);
        cliente.setCalle(calle);
        cliente.setNumeroExterior(numeroExterior);
        cliente.setNumeroInterior(numeroInterior);
        cliente.setColonia(colonia);
        cliente.setCodigoPostal(codigoPostal);
        cliente.setMunicipio(municipio);
        cliente.setCiudad(ciudad);
        cliente.setReferencia(referencia);
        
        System.out.println("DEBUG: Cliente creado en memoria: " + cliente.getPrimerNombre());
        
        // IMPORTANTE: Verifica que esta línea se ejecute
        controlPersis.crearCliente(cliente);
        
        System.out.println("DEBUG: Cliente guardado con ID: " + cliente.getId());
        
    } catch (Exception e) {
        System.err.println("ERROR en crearClienteCompleto:");
        e.printStackTrace();
    }
}

    public void editarCliente(Clientes cli) {
         controlPersis.editarCliente(cli);
    }

  // En ControladoraPersistencia, agrega esto temporalmente:
// En Controladora.java 

    private String obtenerFechaActual() {
  try {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new java.util.Date());
    } catch (Exception e) {
        return java.time.LocalDateTime.now().toString();
    }
    }
    
}
