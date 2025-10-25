package com.todocodeacademy.login.igu;

import ConexionBD.ConexionBD;
import com.todocodeacademy.login.logica.Categorias;
import com.todocodeacademy.login.logica.Clientes;
import com.todocodeacademy.login.logica.Controladora;
import com.todocodeacademy.login.logica.Productos;
import com.todocodeacademy.login.logica.Proveedor;
import com.todocodeacademy.login.logica.Rol;
import com.todocodeacademy.login.logica.Usuario;
import com.todocodeacademy.login.logica.Venta_exitosa;
import com.todocodeacademy.login.persistencia.ControladoraPersistencia;
import java.awt.Color;
import java.awt.Component;
import static java.awt.SystemColor.control;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Claudio De Jesus
 */
public class MenuPrincipalAdministrador extends javax.swing.JFrame {

    Controladora control;
    Usuario usr;
    Proveedor prov;
    int id_cliente;
    int id_producto;
    Productos prod;
    Clientes cli;
// Lista temporal de productos en el pedido actual
    private List<Object[]> listaPedido = new ArrayList<>();

    private String usuarioActual;
    private int idUsuarioActual;
    private HashSet<String> permisosUsuario = new HashSet<>();

    public MenuPrincipalAdministrador(Controladora control, Usuario usr, Proveedor prov, Productos prod) {
        initComponents();

        this.control = control;
        this.usr = usr;
        this.prov = prov;
        this.prod = prod;

        this.usuarioActual = usr.getNombreUsuario();
        this.idUsuarioActual = usr.getId();

        configurarListeners();
        cargarPermisosDesdeBD();
        configurarMenus();
    }

    public MenuPrincipalAdministrador(Controladora control, Usuario usr) {
        this(control, usr, null, null);  // Llama al otro constructor
    }

    public MenuPrincipalAdministrador() {

    }

///////////////////////////////////////////////////Eventos de las tablas////////////////////////////////////
    private void configurarListeners() {
        tblClientes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Aseguramos que no sea un cambio intermedio
                cargarDatosDesdeTabla();
            }
        });
        tblUsuarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblUsuarios.getSelectedRow() != -1) {
                cargarDatosDesdeTablaUsuario();
            }
        });

        tblProveedor.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblProveedor.getSelectedRow() != -1) {
                cargarDatosDesdeTablaProveedor();
            }
        });
        tblProducto.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblProducto.getSelectedRow() != -1) {
                cargarDatosDesdeTablaProducto();
            }
        });
        tblVenta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblVenta.getSelectedRow() != -1) {
                cargarDatosVentaDesdeTabla();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jPanelProveedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccionProveedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCorreoProveedor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        btnAgregarProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnBuscarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        jPanel1Inicio = new javax.swing.JPanel();
        jPanelProductos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoABuscar = new javax.swing.JTextField();
        btnBuscarProudcto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        btnActualizarProducto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMaterialProducto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDimensionProducto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtPrecioVentaProducto = new javax.swing.JTextField();
        txtPrecioCompraProducto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtStockProducto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtColorProducto = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnAgregarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        brnBorrarProducto = new javax.swing.JButton();
        btnLimpiarProducto = new javax.swing.JButton();
        jPanelClientes = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnActualizarCliente = new javax.swing.JButton();
        btnAgregarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jPanelUsuarios = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtContraseñaUsuario = new javax.swing.JTextField();
        cmbRolUsuario = new javax.swing.JComboBox<>();
        btnPermiso = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnAgregarUsuario1 = new javax.swing.JButton();
        jPanelVentas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnBuscarProductoV = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtCodigoVenta = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtNombreVenta = new javax.swing.JTextField();
        txtStockVenta = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtHoraVenta = new javax.swing.JTextField();
        txtFechaVenta = new javax.swing.JTextField();
        btnBuscarProductoVenta2 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        txtNombreVendedor = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtCantidadVenta = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        btnEliminarVenta = new javax.swing.JButton();
        btnGuardarVenta = new javax.swing.JButton();
        btnModificarVenta = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtClienteVenta = new javax.swing.JTextField();
        btnBuscarClienteVenta = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        txtNumeroClienteVenta = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtCambioVenta = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtTotalAPagarVenta = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtDescuentoVenta = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnRecibo = new javax.swing.JButton();
        btnNuevaVenta = new javax.swing.JButton();
        btnGenerarVenta = new javax.swing.JButton();
        btnImporte = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanelConfiguracion = new javax.swing.JPanel();
        btnCategoria = new javax.swing.JButton();
        btnCopiaDeSeguridad = new javax.swing.JButton();
        btnRestaurarBD = new javax.swing.JButton();
        btnMiEmpresa = new javax.swing.JButton();
        jPanelReportes = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        btnGenerarReporte = new javax.swing.JToggleButton();
        btnExportarPdf = new javax.swing.JToggleButton();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        cmbEstadoReporte = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();
        lblTotalVentas = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        txtFechaInicioVenta = new com.toedter.calendar.JDateChooser();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtFechaFinalVenta = new com.toedter.calendar.JDateChooser();
        jLabel60 = new javax.swing.JLabel();
        cmbEstadoReporte1 = new javax.swing.JComboBox<>();
        btnGenerarReporteVentas = new javax.swing.JToggleButton();
        btnGenerarpdfVenta = new javax.swing.JToggleButton();
        jPanelPedido = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtClientePedido = new javax.swing.JTextField();
        txtTelefonoPedido = new javax.swing.JTextField();
        txtDireccionPedido = new javax.swing.JTextField();
        txtFechaPedido = new javax.swing.JTextField();
        BuscarClientePedido = new javax.swing.JToggleButton();
        cmbPedido = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btnAgregarPedido = new javax.swing.JButton();
        txtProductoPedido = new javax.swing.JTextField();
        BuscarProductoPedido = new javax.swing.JButton();
        txtColorPedido = new javax.swing.JTextField();
        txtDimensionPedido = new javax.swing.JTextField();
        txtMaterialPedido = new javax.swing.JTextField();
        txtCantidadPedido = new javax.swing.JTextField();
        txtPrecioUnitarioPedido = new javax.swing.JTextField();
        txtSubtotalPedido = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtCodigoProductoPedido = new javax.swing.JTextField();
        btnEliminarPedido = new javax.swing.JButton();
        btnLimpiarPedido = new javax.swing.JButton();
        btnEditarPedido = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        btnGuardarPedido = new javax.swing.JButton();
        btnMostrarPedido = new javax.swing.JToggleButton();
        btnGenerarpdfDelPedido = new javax.swing.JToggleButton();
        txtTotalPedido = new javax.swing.JTextField();
        mbMenu = new javax.swing.JMenuBar();
        jMenu1Principal = new javax.swing.JMenu();
        jMenuItemIrAlLogin = new javax.swing.JMenuItem();
        jMenu4Ventas = new javax.swing.JMenu();
        jMenuProductos = new javax.swing.JMenu();
        jMenuClientes = new javax.swing.JMenu();
        jMenu3Proveedor = new javax.swing.JMenu();
        jMenuPedidos = new javax.swing.JMenu();
        jMenuReportes = new javax.swing.JMenu();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenu5Configuracion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelProveedor.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProveedor.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanelProveedor.setMinimumSize(new java.awt.Dimension(1270, 540));
        jPanelProveedor.setPreferredSize(new java.awt.Dimension(1315, 570));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del proveedor"));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        txtIdProveedor.setEditable(false);
        txtIdProveedor.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        txtNombreProveedor.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Telefono:");

        txtDireccionProveedor.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Dirección:");

        txtTelefonoProveedor.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel24.setText("Correo:");

        txtCorreoProveedor.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2)))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtNombreProveedor))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(221, 221, 221)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24)
                                .addComponent(txtCorreoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel5)
                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblProveedor);

        btnAgregarProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-agregar-usuario.png"))); // NOI18N
        btnAgregarProveedor.setText("Agregar ");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        btnEditarProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEditarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-usuario_1.png"))); // NOI18N
        btnEditarProveedor.setText("Editar ");
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });

        btnBuscarProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-buscar.png"))); // NOI18N
        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-eliminar-amigo.png"))); // NOI18N
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminarProveedor)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProveedor))
                .addGap(95, 95, 95))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnAgregarProveedor)
                .addGap(30, 30, 30)
                .addComponent(btnEditarProveedor)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarProveedor)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarProveedor)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelProveedorLayout = new javax.swing.GroupLayout(jPanelProveedor);
        jPanelProveedor.setLayout(jPanelProveedorLayout);
        jPanelProveedorLayout.setHorizontalGroup(
            jPanelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProveedorLayout.createSequentialGroup()
                .addContainerGap(294, Short.MAX_VALUE)
                .addGroup(jPanelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelProveedorLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
        );
        jPanelProveedorLayout.setVerticalGroup(
            jPanelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProveedorLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelProveedorLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPanel1Inicio.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1Inicio.setPreferredSize(new java.awt.Dimension(1254, 621));

        javax.swing.GroupLayout jPanel1InicioLayout = new javax.swing.GroupLayout(jPanel1Inicio);
        jPanel1Inicio.setLayout(jPanel1InicioLayout);
        jPanel1InicioLayout.setHorizontalGroup(
            jPanel1InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1315, Short.MAX_VALUE)
        );
        jPanel1InicioLayout.setVerticalGroup(
            jPanel1InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanelProductos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelProductos.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanelProductos.setMinimumSize(new java.awt.Dimension(1270, 540));
        jPanelProductos.setPreferredSize(new java.awt.Dimension(1270, 540));
        jPanelProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelProductosMouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Productos"));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Buscar:");

        txtCodigoABuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        btnBuscarProudcto.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        btnBuscarProudcto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-buscar.png"))); // NOI18N
        btnBuscarProudcto.setText("Buscar");
        btnBuscarProudcto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProudctoActionPerformed(evt);
            }
        });

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblProducto);

        btnActualizarProducto.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        btnActualizarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/010-actualizar.png"))); // NOI18N
        btnActualizarProducto.setText("Actualizar");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnBuscarProudcto)
                        .addGap(32, 32, 32)
                        .addComponent(btnActualizarProducto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarProudcto)
                    .addComponent(btnActualizarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos producto"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setText("Codigo:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        txtCodigoProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel4.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 98, 30));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setText("Nombre:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        txtNombreProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });
        jPanel4.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 270, 30));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setText("Color:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        txtMaterialProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel4.add(txtMaterialProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 153, 30));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setText("Dimensión:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        txtDimensionProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel4.add(txtDimensionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 150, 30));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setText("Precio de Compra:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setText("Stock:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, -1));

        txtPrecioVentaProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPrecioVentaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaProductoActionPerformed(evt);
            }
        });
        jPanel4.add(txtPrecioVentaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 120, 30));

        txtPrecioCompraProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel4.add(txtPrecioCompraProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 153, 30));

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel19.setText("Precio venta:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        txtStockProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel4.add(txtStockProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 153, 30));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setText("Categoria:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        jPanel4.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 220, 30));

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel21.setText("Material:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, -1, -1));

        txtColorProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel4.add(txtColorProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 170, 30));

        btnAgregarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-disco-flexible.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEditarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/008-contrato.png"))); // NOI18N
        btnEditarProducto.setText("Editar");
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        brnBorrarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        brnBorrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-borrar.png"))); // NOI18N
        brnBorrarProducto.setText("Borrar");
        brnBorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnBorrarProductoActionPerformed(evt);
            }
        });

        btnLimpiarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpiarProducto.setText("Limpiar");
        btnLimpiarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarProducto))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brnBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brnBorrarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelProductosLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanelClientes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelClientes.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanelClientes.setMinimumSize(new java.awt.Dimension(1270, 540));
        jPanelClientes.setPreferredSize(new java.awt.Dimension(1270, 540));
        jPanelClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelClientesMouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("ID:");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Nombre:");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        txtNombreCliente.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Telefono:");

        txtDireccionCliente.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Dirección:");

        txtTelefonoCliente.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7))
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane4.setViewportView(tblClientes);

        btnActualizarCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-usuario_1.png"))); // NOI18N
        btnActualizarCliente.setText("Actualizar");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnAgregarCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-agregar-usuario.png"))); // NOI18N
        btnAgregarCliente.setText("Guardar");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-borrar-1.png"))); // NOI18N
        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-buscar.png"))); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(btnAgregarCliente)
                .addGap(29, 29, 29)
                .addComponent(btnBuscarCliente)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEliminarCliente)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClientesLayout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(214, 214, 214))
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanelUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUsuarios.setMinimumSize(new java.awt.Dimension(1270, 540));
        jPanelUsuarios.setName(""); // NOI18N
        jPanelUsuarios.setPreferredSize(new java.awt.Dimension(1270, 540));
        jPanelUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelUsuarios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 604, -1, -1));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jPanelUsuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 730, 193));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Usuarios"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel14.setText("Nombre:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel22.setText("Contraseña:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel23.setText("Rol:");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        txtNombreUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jPanel6.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 39, 220, 40));

        txtContraseñaUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jPanel6.add(txtContraseñaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, 40));

        jPanel6.add(cmbRolUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 220, 40));

        btnPermiso.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnPermiso.setText("Permisos");
        btnPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisoActionPerformed(evt);
            }
        });
        jPanel6.add(btnPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 180, -1));

        btnEditarUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/006-editar.png"))); // NOI18N
        btnEditarUsuario.setText("Editar ");
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });
        jPanel6.add(btnEditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 180, 40));

        btnEliminarUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-borrar-1.png"))); // NOI18N
        btnEliminarUsuario.setText("Eliminar ");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });
        jPanel6.add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 180, -1));

        btnAgregarUsuario1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnAgregarUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/010-agregar.png"))); // NOI18N
        btnAgregarUsuario1.setText("Agregar ");
        btnAgregarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuario1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnAgregarUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 180, -1));

        jPanelUsuarios.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 730, 220));

        jPanelVentas.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelVentasMouseClicked(evt);
            }
        });
        jPanelVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Cantidad", "Descuento", "Stock", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblVenta);
        if (tblVenta.getColumnModel().getColumnCount() > 0) {
            tblVenta.getColumnModel().getColumn(0).setResizable(false);
            tblVenta.getColumnModel().getColumn(1).setResizable(false);
            tblVenta.getColumnModel().getColumn(2).setResizable(false);
            tblVenta.getColumnModel().getColumn(3).setResizable(false);
            tblVenta.getColumnModel().getColumn(4).setResizable(false);
            tblVenta.getColumnModel().getColumn(5).setResizable(false);
            tblVenta.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanelVentas.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 900, 150));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Venta"));

        btnBuscarProductoV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarProductoV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-buscar_1.png"))); // NOI18N
        btnBuscarProductoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoVActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 204));
        jLabel30.setText("FECHA:");

        txtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVentaActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtNombre.setText("Nombre:");

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel31.setText("Codigo:");

        jLabel32.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel32.setText("Stock");

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel34.setText("Precio:");

        txtNombreVenta.setEditable(false);
        txtNombreVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreVentaActionPerformed(evt);
            }
        });

        txtStockVenta.setEditable(false);
        txtStockVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockVentaActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 204));
        jLabel38.setText("HORA:");

        txtHoraVenta.setEditable(false);
        txtHoraVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtHoraVenta.setForeground(new java.awt.Color(0, 0, 255));
        txtHoraVenta.setBorder(null);

        txtFechaVenta.setEditable(false);
        txtFechaVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtFechaVenta.setForeground(new java.awt.Color(0, 0, 255));
        txtFechaVenta.setBorder(null);

        btnBuscarProductoVenta2.setText("detalles");
        btnBuscarProductoVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoVenta2ActionPerformed(evt);
            }
        });

        jLabel36.setText("Nombre de vendedor:");

        txtNombreVendedor.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel32)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel34))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(647, 647, 647)
                        .addComponent(txtHoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(txtNombreVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(txtStockVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBuscarProductoVenta2)
                                            .addComponent(btnBuscarProductoV, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel31)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel38)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel30)
                                .addGap(36, 36, 36)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscarProductoVenta2)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel36)
                                        .addComponent(txtNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProductoV)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelVentas.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 900, -1));

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel33.setText("Cantidad:");

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel35.setText("Total:");

        txtTotalVenta.setEditable(false);

        btnEliminarVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-borrar-1.png"))); // NOI18N
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });

        btnGuardarVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/003-salvado.png"))); // NOI18N
        btnGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVentaActionPerformed(evt);
            }
        });

        btnModificarVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnModificarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/006-editar.png"))); // NOI18N
        btnModificarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnModificarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        jPanelVentas.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 900, 60));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel37.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel37.setText("Nombre:");

        txtClienteVenta.setEditable(false);
        txtClienteVenta.setText("Publico general");

        btnBuscarClienteVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarClienteVenta.setText("buscar");
        btnBuscarClienteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteVentaActionPerformed(evt);
            }
        });

        jLabel61.setText("Buscar por telefono");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(35, 35, 35)))
                .addGap(44, 44, 44))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnBuscarClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumeroClienteVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelVentas.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 280, 180));

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel27.setText("Cambio:");

        jLabel42.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel42.setText("$");

        txtCambioVenta.setEditable(false);
        txtCambioVenta.setBackground(new java.awt.Color(51, 255, 51));
        txtCambioVenta.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtCambioVenta.setForeground(new java.awt.Color(0, 0, 204));
        txtCambioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCambioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(105, 105, 105))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCambioVenta)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelVentas.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 320, 100));

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel28.setText("Total a pagar:");

        txtTotalAPagarVenta.setEditable(false);
        txtTotalAPagarVenta.setBackground(new java.awt.Color(0, 51, 255));
        txtTotalAPagarVenta.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        txtTotalAPagarVenta.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalAPagarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        txtTotalAPagarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalAPagarVentaActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel39.setText("%");

        jLabel40.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel40.setText("Descuento:");

        txtDescuentoVenta.setText("0");
        txtDescuentoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoVentaActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel41.setText("$");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(txtDescuentoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalAPagarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addGap(51, 51, 51))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuentoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel41)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalAPagarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanelVentas.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 570, 100));

        btnRecibo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnRecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/009-impresora.png"))); // NOI18N
        btnRecibo.setText("Recibo");
        btnRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReciboActionPerformed(evt);
            }
        });

        btnNuevaVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/005-registro.png"))); // NOI18N
        btnNuevaVenta.setText("Nuevo venta");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnGenerarVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/007-ventas.png"))); // NOI18N
        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        btnImporte.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnImporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/008-contrato.png"))); // NOI18N
        btnImporte.setText("Importe");
        btnImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImporteActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/010-rechazar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnRecibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(btnGenerarVenta))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(btnNuevaVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerarVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImporte)
                .addGap(18, 18, 18)
                .addComponent(btnRecibo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        jPanelVentas.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 210, 250, 320));

        jPanelConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        jPanelConfiguracion.setMinimumSize(new java.awt.Dimension(1270, 540));
        jPanelConfiguracion.setPreferredSize(new java.awt.Dimension(1270, 540));
        jPanelConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCategoria.setBackground(new java.awt.Color(0, 0, 255));
        btnCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria.setText("Categorias");
        btnCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCategoriaMouseClicked(evt);
            }
        });
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 210, 70));

        btnCopiaDeSeguridad.setBackground(new java.awt.Color(0, 0, 255));
        btnCopiaDeSeguridad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCopiaDeSeguridad.setForeground(new java.awt.Color(255, 255, 255));
        btnCopiaDeSeguridad.setText("Copia de seguridad");
        btnCopiaDeSeguridad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCopiaDeSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiaDeSeguridadActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(btnCopiaDeSeguridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 230, 70));

        btnRestaurarBD.setBackground(new java.awt.Color(0, 0, 255));
        btnRestaurarBD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRestaurarBD.setForeground(new java.awt.Color(255, 255, 255));
        btnRestaurarBD.setText("Restaurar BD");
        btnRestaurarBD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRestaurarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarBDActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(btnRestaurarBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 150, 220, 70));

        btnMiEmpresa.setBackground(new java.awt.Color(0, 0, 255));
        btnMiEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMiEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        btnMiEmpresa.setText("Mi empresa");
        btnMiEmpresa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMiEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiEmpresaActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(btnMiEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 210, 70));

        jPanelReportes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelReportes.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanelReportes.setMinimumSize(new java.awt.Dimension(1270, 540));
        jPanelReportes.setPreferredSize(new java.awt.Dimension(1270, 540));
        jPanelReportes.setRequestFocusEnabled(false);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte de pedidos"));

        btnGenerarReporte.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        btnExportarPdf.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnExportarPdf.setText("Exportar pdf");
        btnExportarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarPdfActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel52.setText("Seleccionar fecha:");

        jLabel53.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel53.setText("Inicio:");

        jLabel54.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel54.setText("Final:");

        jLabel55.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel55.setText("Tipos:");

        cmbEstadoReporte.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cmbEstadoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendientes", "Entregados", "Cancelados" }));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel52)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(18, 18, 18)
                        .addComponent(cmbEstadoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnGenerarReporte)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(btnExportarPdf)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel53))
                .addGap(26, 26, 26)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(cmbEstadoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarReporte)
                    .addComponent(btnExportarPdf))
                .addGap(43, 43, 43))
        );

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tblReporte);

        lblTotalVentas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte de ventas"));

        jLabel57.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel57.setText("Inicio:");

        jLabel58.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel58.setText("Final:");

        jLabel59.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel59.setText("Seleccionar fecha:");

        jLabel60.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel60.setText("Tipos:");

        cmbEstadoReporte1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cmbEstadoReporte1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Exitoso", "Cancelados" }));

        btnGenerarReporteVentas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnGenerarReporteVentas.setText("Generar Reporte");
        btnGenerarReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteVentasActionPerformed(evt);
            }
        });

        btnGenerarpdfVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnGenerarpdfVenta.setText("Exportar pdf");
        btnGenerarpdfVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarpdfVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel59)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaInicioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaFinalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(18, 18, 18)
                                .addComponent(cmbEstadoReporte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnGenerarReporteVentas)
                                .addGap(35, 35, 35)
                                .addComponent(btnGenerarpdfVenta)))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel59)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaInicioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaFinalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57))
                .addGap(26, 26, 26)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(cmbEstadoReporte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarReporteVentas)
                    .addComponent(btnGenerarpdfVenta))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanelReportesLayout = new javax.swing.GroupLayout(jPanelReportes);
        jPanelReportes.setLayout(jPanelReportesLayout);
        jPanelReportesLayout.setHorizontalGroup(
            jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReportesLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelReportesLayout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelReportesLayout.setVerticalGroup(
            jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReportesLayout.createSequentialGroup()
                .addGroup(jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReportesLayout.createSequentialGroup()
                        .addGroup(jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelReportesLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelReportesLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReportesLayout.createSequentialGroup()
                        .addComponent(lblTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelPedido.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPedido.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanelPedido.setMinimumSize(new java.awt.Dimension(1270, 540));
        jPanelPedido.setPreferredSize(new java.awt.Dimension(1270, 540));
        jPanelPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelPedidoMouseClicked(evt);
            }
        });

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("Nombre del cliente:");

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel25.setText("Dirección:");

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel26.setText("Telefono:");

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel29.setText("Fecha de pedido:");

        jLabel43.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel43.setText("Estado de pedido:");

        txtClientePedido.setEditable(false);
        txtClientePedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtTelefonoPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtDireccionPedido.setEditable(false);
        txtDireccionPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtFechaPedido.setEditable(false);
        txtFechaPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        BuscarClientePedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        BuscarClientePedido.setText("Buscar");
        BuscarClientePedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarClientePedidoActionPerformed(evt);
            }
        });

        cmbPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cmbPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "En proceso", "Entregado" }));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel29))
                        .addGap(3, 3, 3)))
                .addGap(29, 29, 29)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(txtClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BuscarClientePedido))
                    .addComponent(txtTelefonoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbPedido, javax.swing.GroupLayout.Alignment.LEADING, 0, 155, Short.MAX_VALUE)
                        .addComponent(txtFechaPedido, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(16, 16, 16))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarClientePedido))
                .addGap(12, 12, 12)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefonoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(cmbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel44.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel44.setText("Producto:");

        jLabel45.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel45.setText("Color:");

        jLabel46.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel46.setText("Cantidad:");

        jLabel47.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel47.setText("Dimensión:");

        jLabel48.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel48.setText("Material:");

        jLabel49.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel49.setText("Precio Unitario:");

        jLabel50.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel50.setText("Subtotal:");

        btnAgregarPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgregarPedido.setText("Agregar al pedido");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        txtProductoPedido.setEditable(false);
        txtProductoPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        BuscarProductoPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        BuscarProductoPedido.setText("Buscar");
        BuscarProductoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProductoPedidoActionPerformed(evt);
            }
        });

        txtColorPedido.setEditable(false);
        txtColorPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtDimensionPedido.setEditable(false);
        txtDimensionPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtMaterialPedido.setEditable(false);
        txtMaterialPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtCantidadPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtPrecioUnitarioPedido.setEditable(false);
        txtPrecioUnitarioPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtSubtotalPedido.setEditable(false);
        txtSubtotalPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel51.setText("codigo:");

        txtCodigoProductoPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        btnEliminarPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminarPedido.setText("Eliminar pedido");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        btnLimpiarPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpiarPedido.setText("Limpiar pedido");
        btnLimpiarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPedidoActionPerformed(evt);
            }
        });

        btnEditarPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEditarPedido.setText("Editar pedido");
        btnEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel45)
                                .addComponent(jLabel46)
                                .addComponent(jLabel51)))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(txtColorPedido)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel47)
                                .addGap(18, 18, 18)
                                .addComponent(txtDimensionPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaterialPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(txtCodigoProductoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProductoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarProductoPedido))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSubtotalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(txtCantidadPedido)
                                    .addComponent(txtPrecioUnitarioPedido))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(btnAgregarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarPedido)
                        .addContainerGap(9, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtProductoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarProductoPedido)
                    .addComponent(jLabel51)
                    .addComponent(txtCodigoProductoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(txtColorPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDimensionPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaterialPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtCantidadPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtPrecioUnitarioPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtSubtotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPedido)
                    .addComponent(btnEliminarPedido)
                    .addComponent(btnLimpiarPedido)
                    .addComponent(btnEditarPedido))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblPedido);

        btnGuardarPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnGuardarPedido.setText("Guardar pedido");
        btnGuardarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPedidoActionPerformed(evt);
            }
        });

        btnMostrarPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnMostrarPedido.setText("Mostrar pedidos");
        btnMostrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPedidoActionPerformed(evt);
            }
        });

        btnGenerarpdfDelPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnGenerarpdfDelPedido.setText("Generar pdf de pedido");
        btnGenerarpdfDelPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarpdfDelPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPedidoLayout = new javax.swing.GroupLayout(jPanelPedido);
        jPanelPedido.setLayout(jPanelPedidoLayout);
        jPanelPedidoLayout.setHorizontalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPedidoLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPedidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarPedido)
                        .addGap(22, 22, 22)
                        .addComponent(btnGenerarpdfDelPedido)
                        .addGap(62, 62, 62)
                        .addComponent(txtTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(jPanelPedidoLayout.createSequentialGroup()
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        jPanelPedidoLayout.setVerticalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPedidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarPedido)
                            .addComponent(btnGenerarpdfDelPedido)
                            .addComponent(btnMostrarPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPedidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 1315, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 1315, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addComponent(jPanelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addComponent(jPanelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addComponent(jPanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addComponent(jPanel1Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addComponent(jPanelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addComponent(jPanelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 66, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
        );

        mbMenu.setBackground(new java.awt.Color(204, 204, 255));
        mbMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenu1Principal.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1Principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-casa.png"))); // NOI18N
        jMenu1Principal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItemIrAlLogin.setText("Ir al login");
        jMenuItemIrAlLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIrAlLoginActionPerformed(evt);
            }
        });
        jMenu1Principal.add(jMenuItemIrAlLogin);

        mbMenu.add(jMenu1Principal);

        jMenu4Ventas.setBackground(new java.awt.Color(204, 204, 255));
        jMenu4Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/004-bienes.png"))); // NOI18N
        jMenu4Ventas.setText("Ventas    ");
        jMenu4Ventas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu4Ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4VentasMouseClicked(evt);
            }
        });
        jMenu4Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4VentasActionPerformed(evt);
            }
        });
        mbMenu.add(jMenu4Ventas);

        jMenuProductos.setBackground(new java.awt.Color(204, 204, 255));
        jMenuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/005-cajas.png"))); // NOI18N
        jMenuProductos.setText("Inventario");
        jMenuProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuProductosMouseClicked(evt);
            }
        });
        jMenuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProductosActionPerformed(evt);
            }
        });
        mbMenu.add(jMenuProductos);

        jMenuClientes.setBackground(new java.awt.Color(204, 204, 255));
        jMenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-agregar-usuario.png"))); // NOI18N
        jMenuClientes.setText("Clientes     ");
        jMenuClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuClientesMouseClicked(evt);
            }
        });
        jMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClientesActionPerformed(evt);
            }
        });
        mbMenu.add(jMenuClientes);

        jMenu3Proveedor.setBackground(new java.awt.Color(204, 204, 255));
        jMenu3Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/003-agregar-usuario-1.png"))); // NOI18N
        jMenu3Proveedor.setText("Proveedor");
        jMenu3Proveedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu3Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3ProveedorMouseClicked(evt);
            }
        });
        mbMenu.add(jMenu3Proveedor);

        jMenuPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/006-metodo-de-pago.png"))); // NOI18N
        jMenuPedidos.setText("Pedidos");
        jMenuPedidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuPedidosMouseClicked(evt);
            }
        });
        mbMenu.add(jMenuPedidos);

        jMenuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/008-contrato.png"))); // NOI18N
        jMenuReportes.setText("Reportes");
        jMenuReportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuReportesMouseClicked(evt);
            }
        });
        mbMenu.add(jMenuReportes);

        jMenuUsuarios.setBackground(new java.awt.Color(204, 204, 255));
        jMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/008-jefe-de-equipo.png"))); // NOI18N
        jMenuUsuarios.setText("Usuario   ");
        jMenuUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuUsuariosMouseClicked(evt);
            }
        });
        jMenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuariosActionPerformed(evt);
            }
        });
        mbMenu.add(jMenuUsuarios);

        jMenu5Configuracion.setBackground(new java.awt.Color(204, 204, 255));
        jMenu5Configuracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/009-sistema-de-seguridad.png"))); // NOI18N
        jMenu5Configuracion.setText("Configuración     ");
        jMenu5Configuracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu5Configuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5ConfiguracionMouseClicked(evt);
            }
        });
        jMenu5Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ConfiguracionActionPerformed(evt);
            }
        });
        mbMenu.add(jMenu5Configuracion);

        setJMenuBar(mbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProductosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuProductosActionPerformed

    private void jMenuProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuProductosMouseClicked
        if (permisosUsuario.contains("PRODUCTOS")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de productos
            cambiarVista(jPanelProductos);
            cargarTablaProductos();
            actualizarComboCategoriasProductos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de Productos.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuProductosMouseClicked

    private void jMenuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuClientesMouseClicked
        // TODO add your handling code here:

        if (permisosUsuario.contains("CLIENTES")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de cliente
            cambiarVista(jPanelClientes);
            cargarTablaClientes();

        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de cliente.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuClientesMouseClicked

    private void jMenuUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuUsuariosMouseClicked
        // TODO add your handling code here:

        this.txtNombreUsuario.setText(usr.getNombreUsuario());

        cargarTablaUsuario();
        // Usuar.setEnabled(false);
        if (permisosUsuario.contains("USUARIOS")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de cliente
            cambiarVista(jPanelUsuarios);
            cargarTablaUsuario();

        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de Usuario.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuUsuariosMouseClicked

    private void jMenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClientesActionPerformed
        // TODO add your handling code here:
        if (tblClientes.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tblClientes.getSelectedRow() != -1) {
                //Obtengo la id del elemento a eliminar
                int id_Cliente = Integer.parseInt(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)));

                //Buscamos el id
                cli = control.traerCliente(id_Cliente);
                //cargamos datos 
                txtNombreCliente.setText(cli.getNombre());
                txtDireccionCliente.setText(cli.getDireccion());
                txtTelefonoCliente.setText(cli.getNumero());

            }
        }
    }//GEN-LAST:event_jMenuClientesActionPerformed

    private void jMenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuariosActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jMenuUsuariosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        cambiarVista(jPanelVentas);
        List<Categorias> listaCategorias = control.TraerCategoria();

        if (listaCategorias != null) {
            for (Categorias cat : listaCategorias) {
                cmbCategoria.addItem(cat.getNombre());
            }
        }

        List<Rol> listaRoles = control.traerRoles();

        if (listaRoles != null) {
            for (Rol rol : listaRoles) {
                cmbRolUsuario.addItem(rol.getNombreRol());
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void actualizarComboCategoriasProductos() {
        // Limpia el contenido actual del combo box de productos
        cmbCategoria.removeAllItems();

        // Obtener la lista de categorías desde la base de datos
        List<Categorias> listaCategorias = control.TraerCategoria();

        // Verificar que la lista no sea nula y cargar las categorías
        if (listaCategorias != null) {
            for (Categorias cat : listaCategorias) {
                cmbCategoria.addItem(cat.getNombre());
            }
        }
    }

    private void btnPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisoActionPerformed
        int fila = tblUsuarios.getSelectedRow();

        if (fila != -1) {
            // Supongamos que la columna 1 tiene el nombre de usuario
            String usuarioSeleccionado = tblUsuarios.getValueAt(fila, 1).toString();

            // Abre la ventana de permisos y le pasa el nombre
            Permiso permiso = new Permiso(usuarioSeleccionado);
            permiso.setLocationRelativeTo(this);
            permiso.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "⚠️ No seleccionaste ningún usuario en la tabla.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_btnPermisoActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed

        actualizarUsuario();
        cargarTablaUsuario();

    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // TODO add your handling code here:
        //Que la tabla tenga elemento
        if (tblUsuarios.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tblUsuarios.getSelectedRow() != -1) {
                //Obtengo la id del elemento a eliminar
                int id_Usuario = Integer.parseInt(String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0)));

                //Llamamos el metodo borrar
                control.borrarUsuario(id_Usuario);

                //Avisar al usuario que se borro completamente
                mostrarMensaje("Se borro el usuario correctamente", "info", "Eliminación correctamente");
                cargarTablaUsuario();
            } else {
                mostrarMensaje("No selecciono ningun registor", "Error", "Error al borrar");
            }
        } else {
            mostrarMensaje("La tabla esta vacia", "Error", "Error al borrar");

        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombreProveedor.getText();
        String direccion = txtDireccionProveedor.getText();
        String correo = txtCorreoProveedor.getText();
        String telefono = txtTelefonoProveedor.getText();

        control.crearProveedor(nombre, direccion, correo, telefono);
        mostrarMensaje("Proveedor creado correctamente", "Info", "Creacion exitosa");
        cargarTablaProveedor();


    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void jMenu3ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3ProveedorMouseClicked

        if (permisosUsuario.contains("PROVEEDOR")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de cliente
            cambiarVista(jPanelProveedor);
            cargarTablaProveedor();

        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de proveedor.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jMenu3ProveedorMouseClicked

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        // TODO add your handling code here:
        actualizarProveedor();
        cargarTablaProveedor();


    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void jMenu4VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4VentasMouseClicked
        // Cambia la vista

        if (permisosUsuario.contains("VENTAS")) {
            cambiarVista(jPanelVentas);
            this.txtNombreVendedor.setText(usr.getNombreUsuario());
            this.txtClienteVenta.setText("CLIENTE PUBLICO EN GENERAL");
            // Inicia un Timer para actualizar la fecha y hora automáticamente
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date fecha = new Date();

                    // Formatear fecha y hora
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("MM/dd/yyyy");
                    SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm a"); // Formato de 12 horas con AM/PM

                    // Actualiza los campos de texto
                    txtFechaVenta.setText(formatoFecha.format(fecha));  // Ejemplo: 12/17/2024
                    txtHoraVenta.setText(formatoHora.format(fecha));   // Ejemplo: 02:15 PM
                }
            });

            // Inicia el Timer
            timer.start();
        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de venta.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jMenu4VentasMouseClicked

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombreCliente.getText();
        String direccion = txtDireccionCliente.getText();
        String numero = txtTelefonoCliente.getText();

        control.crearClientes(nombre, direccion, numero);
        mostrarMensaje("Cliente creado correctamente", "Info", "Creacion exitosa");
        cargarTablaClientes();


    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        if (tblClientes.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tblClientes.getSelectedRow() != -1) {
                //Obtengo la id del elemento a eliminar
                int id_Cliente = Integer.parseInt(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)));

                //Llamamos el metodo borrar
                control.borrarCliente(id_Cliente);

                //Avisar al usuario que se borro completamente
                mostrarMensaje("Se borro el Cliente correctamente", "info", "Eliminación correctamente");
                cargarTablaClientes();
            } else {
                mostrarMensaje("No selecciono ningun registor", "Error", "Error al borrar");
            }
        } else {
            mostrarMensaje("La tabla esta vacia", "Error", "Error al borrar");

        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void jPanelClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelClientesMouseClicked


    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        actualizarCliente();
        cargarTablaClientes();

    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void jMenuItemIrAlLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIrAlLoginActionPerformed
        // TODO add your handling code here:
        Logininicial lo = new Logininicial();
        lo.setVisible(true);
        lo.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenuItemIrAlLoginActionPerformed

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        // TODO add your handling code here:
        if (tblProveedor.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tblProveedor.getSelectedRow() != -1) {
                //Obtengo la id del elemento a eliminar
                int id_proveedor = Integer.parseInt(String.valueOf(tblProveedor.getValueAt(tblProveedor.getSelectedRow(), 0)));

                //Llamamos el metodo borrar
                control.borrarProveedor(id_proveedor);

                //Avisar al usuario que se borro completamente
                mostrarMensaje("Se borro el proveedor correctamente", "info", "Eliminación correctamente");
                cargarTablaProveedor();
            } else {
                mostrarMensaje("No selecciono ningun registor", "Error", "Error al borrar");
            }
        } else {
            mostrarMensaje("La tabla esta vacia", "Error", "Error al borrar");

        }

    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        JTextField[] campos = {txtCodigoProducto, txtNombreProducto, txtColorProducto, txtDimensionProducto,
            txtPrecioVentaProducto, txtStockProducto, txtPrecioCompraProducto, txtMaterialProducto};

        // Validar campos vacíos
        if (!validarCampos(campos)) {
            mostrarMensaje("Todos los campos son obligatorios", "Error", "Campos incompletos");
            return;
        }

        // Obtener valores
        String codigo = txtCodigoProducto.getText();
        String nombre = txtNombreProducto.getText();
        String color = txtColorProducto.getText();
        String dimension = txtDimensionProducto.getText();
        String material = txtMaterialProducto.getText();
        String categoria = cmbCategoria.getSelectedItem().toString(); // Obtener la categoría seleccionada

        int precioVenta, stock, precioCompra;
        try {
            precioVenta = Integer.parseInt(txtPrecioVentaProducto.getText());
            stock = Integer.parseInt(txtStockProducto.getText());
            precioCompra = Integer.parseInt(txtPrecioCompraProducto.getText());
            if (precioVenta <= 0 || stock <= 0 || precioCompra <= 0) {
                mostrarMensaje("Los valores numéricos deben ser mayores a cero", "Error", "Datos inválidos");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("Precio de venta, stock y precio de compra deben ser valores numéricos", "Error", "Datos inválidos");
            return;
        }

        // Validar que el código no exista
        if (control.existeProductoConCodigo(codigo)) {
            mostrarMensaje("El código del producto ya existe. Ingrese un código diferente", "Error", "Código duplicado");
            return;
        }

        try {
            control.crearProducto(codigo, nombre, color, dimension, precioVenta, stock, precioCompra, material, categoria);
            mostrarMensaje("Producto agregado correctamente", "Info", "Operación exitosa");
            cargarTablaProductos();
        } catch (Exception e) {
            mostrarMensaje("Error al agregar el producto: " + e.getMessage(), "Error", "Operación fallida");
        }

    }//GEN-LAST:event_btnAgregarProductoActionPerformed
    private void limpiarCamposProducto() {
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        cmbCategoria.setSelectedIndex(0);
        txtColorProducto.setText("");
        txtDimensionProducto.setText("");
        txtPrecioVentaProducto.setText("");
        txtStockProducto.setText("");
        txtPrecioCompraProducto.setText("");
        txtMaterialProducto.setText("");
    }
    private void brnBorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnBorrarProductoActionPerformed
        // TODO add your handling code here:
        // Verificar si la tabla tiene datos
        if (tblProducto.getRowCount() > 0) {
            // Controlar que se haya seleccionado un elemento
            if (tblProducto.getSelectedRow() != -1) {
                // Obtener la ID del producto a eliminar
                int id_producto = Integer.parseInt(String.valueOf(tblProducto.getValueAt(tblProducto.getSelectedRow(), 0)));

                // Llamar al método borrar
                control.borrarProducto(id_producto);

                // Avisar al usuario que se eliminó correctamente
                mostrarMensaje("Se eliminó el producto correctamente", "Info", "Eliminación exitosa");
                cargarTablaProductos();
            } else {
                mostrarMensaje("No seleccionó ningún registro", "Error", "Error al eliminar");
            }
        } else {
            mostrarMensaje("La tabla está vacía", "Error", "Error al eliminar");
        }

    }//GEN-LAST:event_brnBorrarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        if (tblProducto.getSelectedRow() != -1) {
            try {
                // Obtener el ID del producto seleccionado
                int id_producto = Integer.parseInt(tblProducto.getValueAt(tblProducto.getSelectedRow(), 0).toString());

                // Traer el producto desde la base de datos
                Productos producto = control.traerProducto(id_producto);

                // Validar campos numéricos
                int precioVenta, stock, precioCompra;

                // Verificar si los campos están vacíos antes de convertirlos
                String precioVentaTexto = txtPrecioVentaProducto.getText().trim();
                String stockTexto = txtStockProducto.getText().trim();
                String precioCompraTexto = txtPrecioCompraProducto.getText().trim();

                if (precioVentaTexto.isEmpty() || stockTexto.isEmpty() || precioCompraTexto.isEmpty()) {
                    mostrarMensaje("Por favor, llena todos los campos numéricos.", "Error", "Campos vacíos");
                    return; // Salir del método si hay campos vacíos
                }

                // Convertir los valores a enteros
                precioVenta = Integer.parseInt(precioVentaTexto);
                stock = Integer.parseInt(stockTexto);
                precioCompra = Integer.parseInt(precioCompraTexto);

                // Actualizar los valores del producto con los datos de los JTextField
                producto.setCodigo(txtCodigoProducto.getText().trim());
                producto.setNombre(txtNombreProducto.getText().trim());
                producto.setColor(txtColorProducto.getText().trim());
                producto.setDimension(txtDimensionProducto.getText().trim());
                producto.setPrecioVenta(precioVenta);
                producto.setStockDisponible(stock);
                producto.setPrecioCompra(precioCompra);
                producto.setMaterial(txtMaterialProducto.getText().trim());

                // Asignar la categoría seleccionada
                String categoriaSeleccionada = (String) cmbCategoria.getSelectedItem();
                Categorias categoria = control.traercat(categoriaSeleccionada);

                if (categoria != null) {
                    producto.setUnCategoria(categoria);
                } else {
                    mostrarMensaje("No se pudo encontrar la categoría seleccionada", "Error", "Categoría inválida");
                    return;
                }

                // Actualizar el producto
                control.actualizarProducto(producto);

                // Actualizar la tabla y mostrar mensaje
                cargarTablaProductos();
                mostrarMensaje("Producto editado correctamente", "Info", "Edición Exitosa");
                limpiarCamposProducto();

            } catch (NumberFormatException e) {
                mostrarMensaje("Error en los datos numéricos. Verifique los campos.", "Error", "Datos inválidos");
                System.out.println(e.toString());
            } catch (Exception e) {
                mostrarMensaje("Ocurrió un error al editar el producto: " + e.getMessage(), "Error", "Error al editar");
            }
        } else {
            mostrarMensaje("Debe seleccionar un producto de la tabla", "Error", "Sin selección");
        }
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void jPanelProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProductosMouseClicked
        // TODO add your handling code here:// Actualizar el combo box de categorías
        //  actualizarComboBoxCategorias();

    }//GEN-LAST:event_jPanelProductosMouseClicked

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVentaActionPerformed

    private void txtCambioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioVentaActionPerformed

    private void txtNombreVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreVentaActionPerformed

    private void txtStockVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockVentaActionPerformed

    private void txtTotalAPagarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalAPagarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalAPagarVentaActionPerformed

    private void btnBuscarProductoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoVActionPerformed
        // Obtener el texto ingresado por el usuario
        // Obtener el texto ingresado por el usuario
        String textoBusqueda = txtCodigoVenta.getText().trim();

        // Verificar que el campo no esté vacío
        if (textoBusqueda.isEmpty()) {
            mostrarMensaje("Debe ingresar un código de producto.", "Error", "Campo vacío");
            return;
        }

        // Buscar el producto por código
        Productos producto = control.buscarProductoPorCodigo(textoBusqueda);

        // Verificar si el producto existe
        if (producto != null) {
            // Llenar los JTextField con los datos del producto
            txtNombreVenta.setText(producto.getNombre());
            txtStockVenta.setText(String.valueOf(producto.getStockDisponible()));
            txtPrecioVenta.setText(String.valueOf(producto.getPrecioVenta()));
        } else {
            // Mostrar mensaje si no se encuentra el producto
            mostrarMensaje("Producto no encontrado. Verifique el código ingresado.", "Error", "Producto no encontrado");

            // Limpiar los campos
            txtNombreVenta.setText("");
            txtStockVenta.setText("");
            txtPrecioVenta.setText("");
        }

    }//GEN-LAST:event_btnBuscarProductoVActionPerformed

    private void btnBuscarProudctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProudctoActionPerformed
        // TODO add your handling code here:
        // Obtener el código ingresado por el usuario
        // Obtener el texto ingresado por el usuario
        String textoBusqueda = txtCodigoABuscar.getText().trim();

        // Validar que el campo no esté vacío
        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un código o nombre de producto.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Buscar el producto por código o nombre
            Productos producto = control.buscarProductoPorCodigo(textoBusqueda);

            // Cargar la tabla con el producto encontrado
            cargarTablaProductosPrincipal(producto);
        } catch (Exception e) {
            // Manejar errores
            JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarProudctoActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
        // TODO add your handling code here:
        cargarTablaProductos();
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentaActionPerformed
        try {
            int codigo = Integer.parseInt(txtCodigoVenta.getText());
            String nombre = txtNombreVenta.getText();
            int precio = Integer.parseInt(txtPrecioVenta.getText());
            int cantidad = Integer.parseInt(txtCantidadVenta.getText());
            int descuento = Integer.parseInt(txtDescuentoVenta.getText());
            int stock = Integer.parseInt(txtStockVenta.getText());

            if (cantidad > stock) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser menor o igual a " + stock);
                return;
            }

            // Validar si el código ya existe en la tabla
            DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int codigoExistente = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                if (codigo == codigoExistente) {
                    JOptionPane.showMessageDialog(this, "El producto con el código " + codigo + " ya existe en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Evitar agregar el producto duplicado
                }
            }

            // Calcular el total
            int total = precio * cantidad;
            txtTotalVenta.setText(String.valueOf(total));
txtTotalAPagarVenta.setText(String.valueOf(total));
            // Agregar los datos a la tabla si no hay duplicados
            modelo.addRow(new Object[]{codigo, nombre, precio, cantidad, descuento, stock, total});

            // Limpiar los campos después de agregar
            limpiarCamposVenta();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Verifique los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
        }

    }//GEN-LAST:event_btnGuardarVentaActionPerformed
    private void limpiarCamposVenta() {
        txtCodigoVenta.setText("");
        txtNombreVenta.setText("");
        txtStockVenta.setText("");
        txtPrecioVenta.setText("");
        txtCantidadVenta.setText("");
        txtTotalVenta.setText("");
        txtCodigoVenta.requestFocus(); // Colocar el foco en el campo de código
    }
    private void txtDescuentoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoVentaActionPerformed

    private void txtPrecioVentaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaProductoActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        // TODO add your handling code here:
        // Verificar si hay una fila seleccionada
        int filaSeleccionada = tblVenta.getSelectedRow();

        if (filaSeleccionada != -1) { // Si hay una fila seleccionada
            DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();

            // Eliminar la fila seleccionada del modelo
            modelo.removeRow(filaSeleccionada);

            // Mensaje de confirmación
            mostrarMensaje("Venta eliminada correctamente", "Info", "Operación Exitosa");
        } else {
            // Si no hay fila seleccionada, mostrar un mensaje de error
            mostrarMensaje("Debe seleccionar una fila para eliminar", "Error", "Sin Selección");
        }
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void btnModificarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVentaActionPerformed
        // TODO add your handling code here:
        // Verificar si hay una fila seleccionada
        int filaSeleccionada = tblVenta.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Obtener los valores actuales de la fila seleccionada
            DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();

            int precio = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 2).toString()); // Precio de la columna 2
            int stock = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 5).toString()); // Stock de la columna 5

            // Solicitar al usuario la nueva cantidad
            String cantidadStr = txtCantidadVenta.getText();
            if (cantidadStr == null || cantidadStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int nuevaCantidad = Integer.parseInt(cantidadStr);

            // Validar que la cantidad no sea mayor al stock
            if (nuevaCantidad > stock) {
                JOptionPane.showMessageDialog(this, "La cantidad no puede ser mayor al stock: " + stock, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calcular el nuevo total
            int nuevoTotal = precio * nuevaCantidad;

            // Actualizar la tabla con los nuevos valores
            modelo.setValueAt(nuevaCantidad, filaSeleccionada, 3); // Actualiza la cantidad (columna 3)
            modelo.setValueAt(nuevoTotal, filaSeleccionada, 6);    // Actualiza el total (columna 6)

            JOptionPane.showMessageDialog(this, "Cantidad modificada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarVentaActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
          DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();

    if (modelo.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No hay productos en la venta.");
        return;
    }

    String nombreCliente = txtClienteVenta.getText().trim();
    if (nombreCliente.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un cliente para la venta.");
        return;
    }

    int idCliente = obtenerIdCliente(nombreCliente);
    if (idCliente == 0) {
        JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
        return;
    }

    // 🔹 VERIFICAR STOCK ANTES DE PROCESAR LA VENTA
    if (!verificarStockDisponible(modelo)) {
        return; // Si no hay stock suficiente, salir del método
    }

    Connection conn = null;
    PreparedStatement psVenta = null;
    PreparedStatement psDetalle = null;

    try {
        conn = ConexionBD.getConnection();
        conn.setAutoCommit(false); // 🔹 Iniciar transacción

        // 1️⃣ Insertar venta
        String sqlVenta = "INSERT INTO venta (id_cliente, fecha_venta, total) VALUES (?, ?, ?)";
        psVenta = conn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);

        // Calcular total
        double totalGeneral = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            double subtotal = Double.parseDouble(modelo.getValueAt(i, 6).toString());
            totalGeneral += subtotal;
        }

        psVenta.setInt(1, idCliente);
        psVenta.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
        psVenta.setDouble(3, totalGeneral);
        psVenta.executeUpdate();

        ResultSet rs = psVenta.getGeneratedKeys();
        int idVenta = 0;
        if (rs.next()) {
            idVenta = rs.getInt(1);
        }

        // 2️⃣ Insertar detalle de la venta y actualizar stock
        String sqlDetalle = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        psDetalle = conn.prepareStatement(sqlDetalle);

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String codigo = modelo.getValueAt(i, 0).toString();
            int idProducto = obtenerIdProducto(codigo);
            int cantidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());
            double precioUnitario = Double.parseDouble(modelo.getValueAt(i, 4).toString());
            double subtotal = Double.parseDouble(modelo.getValueAt(i, 6).toString());

            // 🔹 Guardar detalle
            psDetalle.setInt(1, idVenta);
            psDetalle.setInt(2, idProducto);
            psDetalle.setInt(3, cantidad);
            psDetalle.setDouble(4, precioUnitario);
            psDetalle.setDouble(5, subtotal);
            psDetalle.executeUpdate();

            // 🔹 Descontar stock del producto - VERSIÓN MEJORADA
            try (PreparedStatement psStock = conn.prepareStatement(
                    "UPDATE productos SET STOCKDISPONIBLE = STOCKDISPONIBLE - ? WHERE IDPRODUCTO = ?"
            )) {
                psStock.setInt(1, cantidad);
                psStock.setInt(2, idProducto);
                int filasActualizadas = psStock.executeUpdate();
                
                if (filasActualizadas == 0) {
                    throw new SQLException("No se pudo actualizar el stock del producto ID: " + idProducto);
                }
                
                System.out.println("Stock actualizado - Producto ID: " + idProducto + " - Cantidad descontada: " + cantidad);
            }
        }

        conn.commit(); // 🔹 Confirmar transacción

        // Mostrar resumen de la venta
        mostrarResumenVenta(totalGeneral, modelo);
        
        // 🔹 LIMPIAR LA TABLA DESPUÉS DE LA VENTA EXITOSA
        modelo.setRowCount(0);
        txtTotalAPagarVenta.setText("0.00");
        txtClienteVenta.setText("");

    } catch (SQLException e) {
        try {
            if (conn != null) {
                conn.rollback();
                JOptionPane.showMessageDialog(this, "❌ Transacción cancelada. No se realizó la venta.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "❌ Error al registrar venta: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Cerrar recursos
        try {
            if (psVenta != null) psVenta.close();
            if (psDetalle != null) psDetalle.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        // Confirmar antes de limpiar
        int confirmar = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas iniciar una nueva venta? Se borrarán los datos actuales.",
                "Nueva Venta",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmar == JOptionPane.YES_OPTION) {
            // 🔹 Limpiar campos de texto
            txtClienteVenta.setText("");
            txtTotalAPagarVenta.setText("");
            if (txtCambioVenta != null) {
                txtCambioVenta.setText(""); // si tienes campo para cambio
            }
            // 🔹 Limpiar campos de producto (si existen)
            if (txtCodigoVenta != null) {
                txtCodigoVenta.setText("");
            }
            if (txtNombreVenta != null) {
                txtNombreVenta.setText("");
            }
            if (txtPrecioVenta != null) {
                txtPrecioVenta.setText("");
            }
            if (txtCantidadVenta != null) {
                txtCantidadVenta.setText("");
            }
            if (txtTotalVenta != null) {
                txtTotalVenta.setText("");
            }
            if (txtTotalAPagarVenta != null) {
                txtTotalAPagarVenta.setText("");
            }

            // 🔹 Limpiar tabla
            DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();
            modelo.setRowCount(0);

            // 🔹 (Opcional) Restablecer fecha de venta
            if (txtFechaVenta != null) {
                txtFechaVenta.setText(java.time.LocalDate.now().toString());
            }

            JOptionPane.showMessageDialog(this, "Formulario listo para una nueva venta.");
        }
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnLimpiarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProductoActionPerformed
        // TODO add your handling code here:
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtColorProducto.setText("");
        txtStockProducto.setText("");
        txtDimensionProducto.setText("");
        txtPrecioCompraProducto.setText("");
        txtPrecioVentaProducto.setText("");
        txtMaterialProducto.setText("");
    }//GEN-LAST:event_btnLimpiarProductoActionPerformed

    private void btnReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReciboActionPerformed
//     try {
//        // Crear la instancia de PrinterMatrix
//        PrinterMatrix printer = new PrinterMatrix();
//
//        // Información de la venta
//        String numeroFactura = "000001"; // Cambiar dinámicamente según sea necesario
//        String fecha = txtFechaVenta.getText(); // Fecha actual
//        String hora = txtHoraVenta.getText();   // Hora actual
//        String nombreVendedor = txtNombreVendedor.getText(); // Nombre del vendedor
//        String nombreComprador = txtNombreClienteVenta.getText(); // Nombre del comprador
//        double totalVenta = Double.parseDouble(txtTotalAPagarVenta.getText()); // Total de la venta
//
//        // Configurar el tamaño del ticket
//        int filas = 15 + tblVenta.getRowCount(); // 15 líneas base + filas de productos
//        int columnas = 48; // Tamaño de columnas (48 para papel de 80mm)
//        printer.setOutSize(filas, columnas);
//
//        // Encabezado del ticket
//        printer.printCharAtCol(1, 1, columnas, "=");
//        printer.printTextWrap(1, 2, 10, columnas, "TIENDA DE AZULEJOS");
//        printer.printTextWrap(2, 3, 1, columnas, "Num. Factura: " + numeroFactura);
//        printer.printTextWrap(3, 4, 1, columnas, "Fecha: " + fecha);
//        printer.printTextWrap(4, 5, 1, columnas, "Hora: " + hora);
//        printer.printTextWrap(5, 6, 1, columnas, "Vendedor: " + nombreVendedor);
//        printer.printTextWrap(6, 7, 1, columnas, "Comprador: " + nombreComprador);
//        printer.printCharAtCol(7, 1, columnas, "=");
//
//        // Encabezado de la tabla
//        printer.printTextWrap(8, 9, 1, columnas, "Producto      PrecioU Cant Desc Subtotal");
//        printer.printCharAtCol(9, 1, columnas, "-");
//
//        // Construir las filas de la tabla con los datos de tblVenta
//        int filaInicio = 10; // La fila donde empieza el detalle de productos
//        for (int i = 0; i < tblVenta.getRowCount(); i++) {
//            String nombreProducto = tblVenta.getValueAt(i, 1).toString(); // Nombre del producto
//            String precioUnitario = tblVenta.getValueAt(i, 2).toString(); // Precio unitario
//            String cantidad = tblVenta.getValueAt(i, 3).toString(); // Cantidad
//            String descuento = tblVenta.getValueAt(i, 4).toString(); // Descuento
//            String subtotal = tblVenta.getValueAt(i, 5).toString(); // Subtotal
//
//            // Alinear las columnas para que se vean como una tabla
//            String fila = String.format("%-12s %-7s %-4s %-4s %-7s", 
//                nombreProducto.length() > 12 ? nombreProducto.substring(0, 12) : nombreProducto, 
//                precioUnitario, 
//                cantidad, 
//                descuento, 
//                subtotal
//            );
//            printer.printTextWrap(filaInicio + i, filaInicio + i + 1, 1, columnas, fila);
//        }
//
//        // Total y pie de página
//        int filaTotal = filaInicio + tblVenta.getRowCount();
//        printer.printCharAtCol(filaTotal, 1, columnas, "-");
//        printer.printTextWrap(filaTotal + 1, filaTotal + 2, 1, columnas, "TOTAL: $" + totalVenta);
//        printer.printTextWrap(filaTotal + 2, filaTotal + 3, 1, columnas, "Gracias por su compra");
//        printer.printCharAtCol(filaTotal + 3, 1, columnas, "=");
//
//        // Guardar el ticket en un archivo
//        printer.toFile("Impresion.txt");
//
//        // Configuración para imprimir
//        FileInputStream inputStream = new FileInputStream("Impresion.txt");
//        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
//        Doc document = new SimpleDoc(inputStream, docFormat, null);
//
//        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
//        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
//
//        if (defaultPrintService != null) {
//            DocPrintJob printJob = defaultPrintService.createPrintJob();
//            printJob.print(document, attributeSet);
//        } else {
//            mostrarMensaje("No se encontró una impresora predeterminada", "Error", "Impresión");
//        }
//
//    } catch (FileNotFoundException ex) {
//        mostrarMensaje("Archivo no encontrado: " + ex.getMessage(), "Error", "Impresión");
//    } catch (Exception ex) {
//        mostrarMensaje("Ocurrió un error: " + ex.getMessage(), "Error", "Impresión");
//    }

    }//GEN-LAST:event_btnReciboActionPerformed

    private void btnBuscarClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteVentaActionPerformed
        // Crear un JDialog para mostrar la tabla
        String clienteBuscar = txtClienteVenta.getText().trim();
        String telefonoBuscar = txtNumeroClienteVenta.getText().trim();

        // Verificar que al menos haya un dato
        if (clienteBuscar.isEmpty() && telefonoBuscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre o número del cliente para buscar.");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conectar a la base de datos
            conn = ConexionBD.getConnection(); // Usa tu clase de conexión
            String sql = "SELECT * FROM clientes WHERE NOMBRE = ? OR NUMERO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, clienteBuscar);
            ps.setString(2, telefonoBuscar);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Cliente encontrado, llenar campos
                txtClienteVenta.setText(rs.getString("NOMBRE"));
                txtNumeroClienteVenta.setText(rs.getString("NUMERO"));

                JOptionPane.showMessageDialog(this, "Cliente encontrado.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el cliente en la base de datos.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar cliente: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBuscarClienteVentaActionPerformed

    private void btnBuscarProductoVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoVenta2ActionPerformed
        // Crear un diálogo modal
        JDialog dialogoProducto = new JDialog(this, "Seleccionar Producto", true);
        dialogoProducto.setSize(800, 600);
        dialogoProducto.setLocationRelativeTo(this);

        // Crear una nueva tabla para el diálogo
        JTable tablaVenta = new JTable(tblProducto.getModel()); // Usa el mismo modelo de datos

        // Crear un JScrollPane y añadir la tabla
        JScrollPane scrollPane = new JScrollPane(tablaVenta);
        dialogoProducto.add(scrollPane);

        // Agregar un MouseListener para detectar doble clic
        tablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Detectar doble clic
                    int filaSeleccionada = tablaVenta.getSelectedRow();

                    if (filaSeleccionada != -1) { // Verificar que hay una fila seleccionada
                        String codigo = tablaVenta.getValueAt(filaSeleccionada, 1).toString();
                        String nombre = tablaVenta.getValueAt(filaSeleccionada, 2).toString();
                        String precio = tablaVenta.getValueAt(filaSeleccionada, 5).toString();
                        String stock = tablaVenta.getValueAt(filaSeleccionada, 6).toString();

                        // Cargar los datos en los campos correspondientes
                        txtCodigoVenta.setText(codigo);
                        txtNombreVenta.setText(nombre);
                        txtStockVenta.setText(stock);
                        txtPrecioVenta.setText(precio);

                        // Cerrar el diálogo
                        dialogoProducto.dispose();
                    }
                }
            }
        });

        // Mostrar el diálogo
        dialogoProducto.setVisible(true);


    }//GEN-LAST:event_btnBuscarProductoVenta2ActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuario1ActionPerformed
        // TODO add your handling code here:
        String usuario = txtNombreUsuario.getText();
        String contrasenia = txtContraseñaUsuario.getText();
        String rolRecibido = cmbRolUsuario.getSelectedItem().toString();

        control.crearUsuario(usuario, contrasenia, rolRecibido);
        mostrarMensaje("Usuario creado correctamente", "Info", "Creación exitosa");
        cargarTablaUsuario();

    }//GEN-LAST:event_btnAgregarUsuario1ActionPerformed

    private void jMenu5ConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5ConfiguracionMouseClicked
        // TODO add your handling code here:
        if (permisosUsuario.contains("CONFIGURACION")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de cliente
            cambiarVista(jPanelConfiguracion);
            cargarTablaUsuario();

        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de configuracion.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenu5ConfiguracionMouseClicked

    private void jMenu5ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ConfiguracionActionPerformed
        // TODO add your handling code here:
        if (permisosUsuario.contains("CONFIGURACION")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de configuracion
            cambiarVista(jPanelConfiguracion);

        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de Configuración.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenu5ConfiguracionActionPerformed

    private void jMenu4VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4VentasActionPerformed
        // TODO add your handling code here:
        if (permisosUsuario.contains("VENTAS")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de venta
            cambiarVista(jPanelVentas);
            cargarTablaUsuario();

        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de Venta.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenu4VentasActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // TODO add your handling code here:

        int fila = tblUsuarios.getSelectedRow();
        if (fila != -1) {
            String nombreUsuario = tblUsuarios.getValueAt(fila, 1).toString(); // columna donde está el nombre

            if (nombreUsuario.equalsIgnoreCase("Administrador")) {
                JOptionPane.showMessageDialog(this,
                        "⚠️ No se puede seleccionar el usuario administrador.",
                        "Acción no permitida",
                        JOptionPane.WARNING_MESSAGE);
                tblUsuarios.clearSelection(); // deselecciona la fila
            }
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void jMenuReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuReportesMouseClicked
        // TODO add your handling code here:
        if (permisosUsuario.contains("REPORTES")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de cliente
            cambiarVista(jPanelReportes);
            cargarTablaUsuario();

        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de reporte.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuReportesMouseClicked

    private void jMenuPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuPedidosMouseClicked
        // TODO add your handling code here:
        if (permisosUsuario.contains("PEDIDOS")) {
            // 👇 Solo si tiene permiso, cambia la vista al panel de cliente
            cambiarVista(jPanelPedido);

            txtFechaPedido.setText(LocalDate.now().toString());
            actualizarTablaDesdeLista(); // 👈 vuelve a mostrar la lista

        } else {
            JOptionPane.showMessageDialog(this,
                    "⛔ No tienes permiso para acceder al módulo de pedido.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuPedidosMouseClicked

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        // TODO add your handling code here:
        Categoria categ = new Categoria(control);
        categ.setVisible(true);
        categ.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriaMouseClicked


    }//GEN-LAST:event_btnCategoriaMouseClicked

    private void btnMiEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiEmpresaActionPerformed
        // TODO add your handling code here:
        InformacionEmpresa informacion = new InformacionEmpresa();
        informacion.setVisible(true);
        informacion.setLocationRelativeTo(null); // centrado en pantalla

    }//GEN-LAST:event_btnMiEmpresaActionPerformed

    private void btnCopiaDeSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiaDeSeguridadActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar copia de seguridad");
        fileChooser.setSelectedFile(new File("backup.sql")); // nombre por defecto

        int seleccion = fileChooser.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String rutaBackup = archivo.getAbsolutePath();

            try {
                // Cambia estos valores según tu configuración de MySQL
                String usuario = "root";
                String contrasenia = ""; // tu password
                String nombreBD = "login"; // tu nombre de base de datos

                // Comando mysqldump
                String comando = "mysqldump -u" + usuario
                        + (contrasenia.isEmpty() ? "" : " -p" + contrasenia)
                        + " " + nombreBD + " -r \"" + rutaBackup + "\"";

                Process p = Runtime.getRuntime().exec(comando);
                int proceso = p.waitFor();

                if (proceso == 0) {
                    JOptionPane.showMessageDialog(this, "✅ Copia de seguridad creada exitosamente:\n" + rutaBackup);
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Error al crear copia de seguridad");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btnCopiaDeSeguridadActionPerformed

    private void btnRestaurarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarBDActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de respaldo");

        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String rutaBackup = archivo.getAbsolutePath();

            try {
                // Cambia estos valores según tu configuración de MySQL
                String usuario = "root";
                String contrasenia = ""; // tu password
                String nombreBD = "login"; // tu nombre de base de datos

                // Comando mysql para restaurar
                String comando = "mysql -u" + usuario
                        + (contrasenia.isEmpty() ? "" : " -p" + contrasenia)
                        + " " + nombreBD + " < \"" + rutaBackup + "\"";

                // Para ejecutar comandos con redirección < necesitamos usar cmd /c (Windows)
                String[] comandoWindows = {"cmd.exe", "/c", comando};

                Process p = Runtime.getRuntime().exec(comandoWindows);
                int proceso = p.waitFor();

                if (proceso == 0) {
                    JOptionPane.showMessageDialog(this, "✅ Base de datos restaurada correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Error al restaurar la base de datos");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnRestaurarBDActionPerformed

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        try {
            String codigo = txtCodigoProductoPedido.getText().trim();
            String producto = txtProductoPedido.getText().trim();
            String color = txtColorPedido.getText().trim();
            String dimension = txtDimensionPedido.getText().trim();
            String material = txtMaterialPedido.getText().trim();
            String cantidadTxt = txtCantidadPedido.getText().trim();
            String precioTxt = txtPrecioUnitarioPedido.getText().trim();

            // ✅ Solo validamos los campos que el usuario debe llenar o que vienen del producto
            if (codigo.isEmpty() || producto.isEmpty() || color.isEmpty()
                    || dimension.isEmpty() || material.isEmpty() || cantidadTxt.isEmpty() || precioTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor llena todos los campos del producto.");
                return;
            }

            int cantidad = Integer.parseInt(cantidadTxt);
            double precio = Double.parseDouble(precioTxt);
            double subtotal = cantidad * precio;

            // Crear modelo y fila
            DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
            Object[] fila = {codigo, producto, cantidad, precio, subtotal};

            // Evitar duplicados (opcional)
            boolean existe = false;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 0).equals(codigo)) {
                    existe = true;
                    break;
                }
            }

            if (existe) {
                JOptionPane.showMessageDialog(this, "Este producto ya está agregado al pedido.");
                return;
            }

            // Agregar fila y guardar en lista temporal
            modelo.addRow(fila);
            listaPedido.add(fila);

            // Calcular total
            calcularTotal();

            // Mostrar subtotal en el campo (solo visual)
            txtSubtotalPedido.setText(String.valueOf(subtotal));

            // Limpiar campos de producto (opcional)
            txtCodigoProducto.setText("");
            txtNombreProducto.setText("");
            txtCantidadPedido.setText("");
            txtPrecioUnitarioPedido.setText("");
            txtSubtotalPedido.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Verifica los valores numéricos de cantidad o precio.");
        }

    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    private void jPanelPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPedidoMouseClicked
        // TODO add your handling code here:
        txtFechaPedido.setText(LocalDate.now().toString());

    }//GEN-LAST:event_jPanelPedidoMouseClicked

    private void jPanelVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVentasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelVentasMouseClicked

    private void BuscarClientePedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarClientePedidoActionPerformed
        // TODO add your handling code here:
        String clienteBuscar = txtClientePedido.getText().trim();
        String telefonoBuscar = txtTelefonoPedido.getText().trim();

        // Verificar que al menos haya un dato
        if (clienteBuscar.isEmpty() && telefonoBuscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre o número del cliente para buscar.");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conectar a la base de datos
            conn = ConexionBD.getConnection(); // Usa tu clase de conexión
            String sql = "SELECT * FROM clientes WHERE NOMBRE = ? OR NUMERO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, clienteBuscar);
            ps.setString(2, telefonoBuscar);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Cliente encontrado, llenar campos
                txtClientePedido.setText(rs.getString("NOMBRE"));
                txtTelefonoPedido.setText(rs.getString("NUMERO"));
                txtDireccionPedido.setText(rs.getString("DIRECCION"));

                JOptionPane.showMessageDialog(this, "Cliente encontrado.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el cliente en la base de datos.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar cliente: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_BuscarClientePedidoActionPerformed

    private void BuscarProductoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProductoPedidoActionPerformed
        // TODO add your handling code here:
        // Obtener texto ingresado en el campo de producto (por nombre o código)
        String buscar = txtCodigoProductoPedido.getText().trim();

        // Validar que haya algo que buscar
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el código o nombre del producto para buscar.");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            conn = ConexionBD.getConnection();

            // Buscar por código o nombre
            String sql = "SELECT * FROM productos WHERE CODIGO = ? OR NOMBRE LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, buscar);
            ps.setString(2, "%" + buscar + "%");

            rs = ps.executeQuery();

            if (rs.next()) {
                // Producto encontrado → llenar campos
                txtProductoPedido.setText(rs.getString("NOMBRE"));
                txtColorPedido.setText(rs.getString("COLOR"));
                txtDimensionPedido.setText(rs.getString("DIMENSION"));
                txtMaterialPedido.setText(rs.getString("MATERIAL"));
                txtPrecioUnitarioPedido.setText(String.valueOf(rs.getInt("PRECIOVENTA")));

                JOptionPane.showMessageDialog(this, "Producto encontrado: " + rs.getString("NOMBRE"));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el producto en la base de datos.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar producto: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_BuscarProductoPedidoActionPerformed

    private void btnGuardarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPedidoActionPerformed
        // TODO add your handling code here:
       DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();

    if (modelo.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No hay productos en el pedido.");
        return;
    }

    String nombreCliente = txtClientePedido.getText().trim();
    String estado = cmbPedido.getSelectedItem().toString();
    int idCliente = obtenerIdCliente(nombreCliente);

    if (idCliente == 0) {
        JOptionPane.showMessageDialog(this, "Debe buscar o seleccionar un cliente válido.");
        return;
    }

    // 🔹 VERIFICAR STOCK SOLO SI EL ESTADO ES "ENTREGADO" o "EN PROCESO"
    if ((estado.equals("Entregado") || estado.equals("En proceso")) && !verificarStockDisponiblePedido(modelo)) {
        return; // Si no hay stock suficiente, salir del método
    }

    Connection conn = null;
    PreparedStatement psPedido = null;
    PreparedStatement psDetalle = null;

    try {
        conn = ConexionBD.getConnection();
        conn.setAutoCommit(false); // ✅ abre transacción

        // 1️⃣ Insertar pedido
        String sqlPedido = "INSERT INTO pedido (id_cliente, fecha_pedido, estado) VALUES (?, ?, ?)";
        psPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
        psPedido.setInt(1, idCliente);
        psPedido.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
        psPedido.setString(3, estado);
        psPedido.executeUpdate();

        ResultSet rs = psPedido.getGeneratedKeys();
        int idPedido = 0;
        if (rs.next()) {
            idPedido = rs.getInt(1);
        }

        // 2️⃣ Insertar detalle del pedido
        String sqlDetalle = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
        psDetalle = conn.prepareStatement(sqlDetalle);

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String codigo = modelo.getValueAt(i, 0).toString();
            int idProducto = obtenerIdProducto(codigo);
            int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(modelo.getValueAt(i, 3).toString());

            psDetalle.setInt(1, idPedido);
            psDetalle.setInt(2, idProducto);
            psDetalle.setInt(3, cantidad);
            psDetalle.setDouble(4, precio);
            psDetalle.executeUpdate();

            // 🔹 RESTAR STOCK SOLO SI EL ESTADO ES "ENTREGADO" o "EN PROCESO"
            if (estado.equals("Entregado") || estado.equals("En proceso")) {
                actualizarStock(conn, idProducto, -cantidad); // Restar stock
            }
        }

        conn.commit(); // ✅ guarda todo junto
        
        // 🔹 LIMPIAR INTERFAZ DESPUÉS DE GUARDAR
        modelo.setRowCount(0);
        txtClientePedido.setText("");
        txtTotalPedido.setText("0.00");
        
        JOptionPane.showMessageDialog(this, 
            "✅ Pedido guardado correctamente.\n" +
            "ID Pedido: " + idPedido + "\n" +
            "Estado: " + estado + "\n" +
            (estado.equals("Entregado") || estado.equals("En proceso") ? 
             "Stock actualizado correctamente." : "Stock pendiente por actualizar."));

    } catch (Exception e) {
        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException ex) {
        }
        JOptionPane.showMessageDialog(this, "❌ Error al guardar pedido: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (psPedido != null) psPedido.close();
            if (psDetalle != null) psDetalle.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
        }
    }
    }//GEN-LAST:event_btnGuardarPedidoActionPerformed

    private void btnEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPedidoActionPerformed
        // TODO add your handling code here:
       int filaSeleccionada = tblPedido.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un pedido para editar.");
        return;
    }

    int idPedido = Integer.parseInt(tblPedido.getValueAt(filaSeleccionada, 0).toString());
    String estadoActual = tblPedido.getValueAt(filaSeleccionada, 3).toString();
    String cliente = tblPedido.getValueAt(filaSeleccionada, 1).toString();
    double total = Double.parseDouble(tblPedido.getValueAt(filaSeleccionada, 4).toString().replace("$", ""));

    // 🔹 Opciones de nuevo estado
    String[] opciones = {"Pendiente", "En proceso", "Entregado", "Cancelado"};
    String nuevoEstado = (String) JOptionPane.showInputDialog(
            this,
            "Pedido #" + idPedido + " - " + cliente + 
            "\nTotal: $" + String.format("%.2f", total) +
            "\nEstado actual: " + estadoActual +
            "\n\nSelecciona el nuevo estado:",
            "Editar estado del pedido",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opciones,
            estadoActual
    );

    if (nuevoEstado != null && !nuevoEstado.equals(estadoActual)) {
        Connection conn = null;
        try {
            conn = ConexionBD.getConnection();
            conn.setAutoCommit(false);

            // 🔹 OBTENER DETALLES DEL PEDIDO PARA MANEJAR STOCK
            java.util.List<ProductoPedido> detalles = obtenerDetallesPedido(conn, idPedido);

            // 🔹 MANEJAR CAMBIOS DE STOCK SEGÚN EL ESTADO
            manejarCambioStock(conn, estadoActual, nuevoEstado, detalles);

            // 🔹 ACTUALIZAR ESTADO DEL PEDIDO
            try (PreparedStatement ps = conn.prepareStatement(
                    "UPDATE pedido SET estado = ? WHERE id_pedido = ?")) {

                ps.setString(1, nuevoEstado);
                ps.setInt(2, idPedido);
                int filas = ps.executeUpdate();

                if (filas > 0) {
                    conn.commit();
                    JOptionPane.showMessageDialog(this, 
                        "✅ Estado del pedido actualizado de '" + estadoActual + 
                        "' a '" + nuevoEstado + "'.\n" +
                        obtenerMensajeStock(estadoActual, nuevoEstado));
                    btnMostrarPedidoActionPerformed(null); // refrescar tabla
                } else {
                    conn.rollback();
                    JOptionPane.showMessageDialog(this, "No se encontró el pedido.");
                }
            }

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
            }
            JOptionPane.showMessageDialog(this, "❌ Error al actualizar pedido: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
    }
    }//GEN-LAST:event_btnEditarPedidoActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tblPedido.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un pedido para eliminar.");
            return;
        }

        int idPedido = Integer.parseInt(tblPedido.getValueAt(filaSeleccionada, 0).toString());
        String estado = tblPedido.getValueAt(filaSeleccionada, 3).toString();

        if (estado.equalsIgnoreCase("Entregado")) {
            JOptionPane.showMessageDialog(this, "No puedes eliminar un pedido entregado.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas eliminar el pedido #" + idPedido + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = ConexionBD.getConnection()) {
                conn.setAutoCommit(false); // 🔹 transacción

                // Primero eliminar detalle_pedido
                try (PreparedStatement psDetalle = conn.prepareStatement("DELETE FROM detalle_pedido WHERE id_pedido = ?")) {
                    psDetalle.setInt(1, idPedido);
                    psDetalle.executeUpdate();
                }

                // Luego eliminar el pedido
                try (PreparedStatement psPedido = conn.prepareStatement("DELETE FROM pedido WHERE id_pedido = ?")) {
                    psPedido.setInt(1, idPedido);
                    psPedido.executeUpdate();
                }

                conn.commit(); // confirmar transacción
                JOptionPane.showMessageDialog(this, "🗑️ Pedido eliminado correctamente.");
                btnMostrarPedidoActionPerformed(null); // refrescar tabla

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "❌ Error al eliminar pedido: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnLimpiarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPedidoActionPerformed
        // TODO add your handling code here:
        txtClientePedido.setText("");
        txtDireccionPedido.setText("");
        txtTelefonoPedido.setText("");
        txtFechaPedido.setText(LocalDate.now().toString());
        cmbPedido.setSelectedIndex(0);

        txtProductoPedido.setText("");
        txtColorPedido.setText("");
        txtDimensionPedido.setText("");
        txtMaterialPedido.setText("");
        txtCantidadPedido.setText("");
        txtPrecioUnitarioPedido.setText("");
        txtSubtotalPedido.setText("");
        txtSubtotalPedido.setText("");

        DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
        modelo.setRowCount(0);

        listaPedido.clear(); // 🔥 borra también la lista temporal
    }//GEN-LAST:event_btnLimpiarPedidoActionPerformed

    private void btnMostrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPedidoActionPerformed
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID Pedido", "Cliente", "Fecha", "Estado", "Total"}, 0
        );
        tblPedido.setModel(modelo);

        String sql = """
        SELECT p.id_pedido, c.nombre AS cliente, p.fecha_pedido, p.estado,
               SUM(d.cantidad * d.precio_unitario) AS total
        FROM pedido p
        JOIN clientes c ON p.id_cliente = c.id
        JOIN detalle_pedido d ON p.id_pedido = d.id_pedido
        GROUP BY p.id_pedido, c.nombre, p.fecha_pedido, p.estado
        ORDER BY p.id_pedido DESC
    """;

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_pedido"),
                    rs.getString("cliente"),
                    rs.getTimestamp("fecha_pedido"),
                    rs.getString("estado"),
                    rs.getDouble("total")
                };
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "❌ Error al cargar pedidos: " + e.getMessage());
        }
    }//GEN-LAST:event_btnMostrarPedidoActionPerformed

    private void btnGenerarpdfDelPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarpdfDelPedidoActionPerformed
        // TODO add your handling code here:
         DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID Pedido", "Cliente", "Fecha", "Estado", "Total"}, 0
    );
    tblReporte.setModel(modelo);

    String estadoSeleccionado = cmbEstadoReporte.getSelectedItem().toString();
    java.util.Date fi = txtFechaInicio.getDate();
    java.util.Date ff = txtFechaFin.getDate();

    if (fi == null || ff == null) {
        JOptionPane.showMessageDialog(this, "Selecciona las fechas de inicio y fin.");
        return;
    }

    // Configurar fechas con horas para incluir todo el día
    java.util.Calendar calInicio = java.util.Calendar.getInstance();
    calInicio.setTime(fi);
    calInicio.set(java.util.Calendar.HOUR_OF_DAY, 0);
    calInicio.set(java.util.Calendar.MINUTE, 0);
    calInicio.set(java.util.Calendar.SECOND, 0);
    
    java.util.Calendar calFin = java.util.Calendar.getInstance();
    calFin.setTime(ff);
    calFin.set(java.util.Calendar.HOUR_OF_DAY, 23);
    calFin.set(java.util.Calendar.MINUTE, 59);
    calFin.set(java.util.Calendar.SECOND, 59);

    String fechaInicio = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calInicio.getTime());
    String fechaFin = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calFin.getTime());

    // Construir la consulta SQL dinámicamente
    StringBuilder sql = new StringBuilder();
    sql.append("""
        SELECT p.id_pedido, c.nombre AS cliente, p.fecha_pedido, p.estado,
               SUM(d.cantidad * d.precio_unitario) AS total
        FROM pedido p
        JOIN clientes c ON p.id_cliente = c.id
        JOIN detalle_pedido d ON p.id_pedido = d.id_pedido
        WHERE p.fecha_pedido BETWEEN ? AND ?
        """);

    // Agregar filtro por estado según la selección
    switch (estadoSeleccionado) {
        case "Entregados":
            sql.append(" AND p.estado = 'Entregado'");
            break;
        case "Pendientes":
            sql.append(" AND p.estado = 'Pendiente'");
            break;
        case "Todos":
            // No agregar filtro adicional
            break;
        default:
            // Para cualquier otro estado específico
            sql.append(" AND p.estado = ?");
            break;
    }

    sql.append(" GROUP BY p.id_pedido, c.nombre, p.fecha_pedido, p.estado ORDER BY p.fecha_pedido DESC");

    try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql.toString())) {

        // Establecer parámetros
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        
        // Si se seleccionó un estado específico (no "Todos")
        if (!estadoSeleccionado.equals("Todos") && 
            !estadoSeleccionado.equals("Entregados") && 
            !estadoSeleccionado.equals("Pendientes")&&
            !estadoSeleccionado.equals("Cancelados")) {
            ps.setString(4, estadoSeleccionado);
        }

        System.out.println("Consulta SQL: " + ps.toString()); // Debug

        ResultSet rs = ps.executeQuery();
        double totalGeneral = 0;
        int filas = 0;

        while (rs.next()) {
            filas++;
            Object[] fila = {
                rs.getInt("id_pedido"),
                rs.getString("cliente"),
                new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(rs.getTimestamp("fecha_pedido")),
                rs.getString("estado"),
                String.format("$%.2f", rs.getDouble("total"))
            };
            modelo.addRow(fila);
            totalGeneral += rs.getDouble("total");
        }

        // Actualizar el total general
        lblTotalVentas.setText(String.format("Total General: $%.2f", totalGeneral));
        
        // Mostrar mensaje si no hay resultados
        if (filas == 0) {
            JOptionPane.showMessageDialog(this, 
                "No se encontraron pedidos con los criterios seleccionados.\n" +
                "Fechas: " + new java.text.SimpleDateFormat("dd/MM/yyyy").format(fi) + " - " + 
                new java.text.SimpleDateFormat("dd/MM/yyyy").format(ff) + "\n" +
                "Estado: " + estadoSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Reporte generado exitosamente.\n" +
                "Total de pedidos: " + filas + "\n" +
                "Total general: $" + String.format("%.2f", totalGeneral));
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Error al generar reporte: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGenerarpdfDelPedidoActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID Pedido", "Cliente", "Fecha", "Estado", "Total"}, 0
    );
    tblReporte.setModel(modelo);

    String estadoSeleccionado = cmbEstadoReporte.getSelectedItem().toString();
    java.util.Date fi = txtFechaInicio.getDate();
    java.util.Date ff = txtFechaFin.getDate();

    if (fi == null || ff == null) {
        JOptionPane.showMessageDialog(this, "Selecciona las fechas de inicio y fin.");
        return;
    }

    // Configurar fechas con horas para incluir todo el día
    java.util.Calendar calInicio = java.util.Calendar.getInstance();
    calInicio.setTime(fi);
    calInicio.set(java.util.Calendar.HOUR_OF_DAY, 0);
    calInicio.set(java.util.Calendar.MINUTE, 0);
    calInicio.set(java.util.Calendar.SECOND, 0);
    
    java.util.Calendar calFin = java.util.Calendar.getInstance();
    calFin.setTime(ff);
    calFin.set(java.util.Calendar.HOUR_OF_DAY, 23);
    calFin.set(java.util.Calendar.MINUTE, 59);
    calFin.set(java.util.Calendar.SECOND, 59);

    String fechaInicio = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calInicio.getTime());
    String fechaFin = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calFin.getTime());

    // Construir la consulta SQL dinámicamente
    StringBuilder sql = new StringBuilder();
    sql.append("""
        SELECT p.id_pedido, c.nombre AS cliente, p.fecha_pedido, p.estado,
               SUM(d.cantidad * d.precio_unitario) AS total
        FROM pedido p
        JOIN clientes c ON p.id_cliente = c.id
        JOIN detalle_pedido d ON p.id_pedido = d.id_pedido
        WHERE p.fecha_pedido BETWEEN ? AND ?
        """);

    // Agregar filtro por estado según la selección
    switch (estadoSeleccionado) {
        case "Pendientes":
            sql.append(" AND p.estado = 'Pendiente'");
            break;
        case "Entregados":
            sql.append(" AND p.estado = 'Entregado'");
            break;
        case "Cancelados":
            sql.append(" AND p.estado = 'Cancelado'");
            break;
        case "Todos":
            // No agregar filtro adicional
            break;
        default:
            // Para cualquier otro estado específico
            sql.append(" AND p.estado = ?");
            break;
    }

    sql.append(" GROUP BY p.id_pedido, c.nombre, p.fecha_pedido, p.estado ORDER BY p.fecha_pedido DESC");

    try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql.toString())) {

        // Establecer parámetros
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        
        // Si se seleccionó un estado específico personalizado (no los predefinidos)
        if (!estadoSeleccionado.equals("Todos") && 
            !estadoSeleccionado.equals("Pendientes") && 
            !estadoSeleccionado.equals("Entregados") &&
            !estadoSeleccionado.equals("Cancelados")) {
            ps.setString(3, estadoSeleccionado);
        }

        System.out.println("Consulta SQL: " + ps.toString()); // Debug

        ResultSet rs = ps.executeQuery();
        double totalGeneral = 0;
        int filas = 0;

        while (rs.next()) {
            filas++;
            Object[] fila = {
                rs.getInt("id_pedido"),
                rs.getString("cliente"),
                new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(rs.getTimestamp("fecha_pedido")),
                rs.getString("estado"),
                String.format("$%.2f", rs.getDouble("total"))
            };
            modelo.addRow(fila);
            totalGeneral += rs.getDouble("total");
        }

        // Actualizar el total general
        lblTotalVentas.setText(String.format("Total General: $%.2f | Pedidos: %d", totalGeneral, filas));
        
        // Mostrar mensaje si no hay resultados
        if (filas == 0) {
            JOptionPane.showMessageDialog(this, 
                "No se encontraron pedidos con los criterios seleccionados.\n" +
                "Fechas: " + new java.text.SimpleDateFormat("dd/MM/yyyy").format(fi) + " - " + 
                new java.text.SimpleDateFormat("dd/MM/yyyy").format(ff) + "\n" +
                "Estado: " + estadoSeleccionado);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Error al generar reporte: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnExportarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPdfActionPerformed
        // TODO add your handling code here:
         try {
        // Verificar si hay datos en la tabla
        if (tblReporte.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay datos para exportar. Genera un reporte primero.");
            return;
        }

        // Crear diálogo para seleccionar ubicación
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como PDF");
        fileChooser.setSelectedFile(new java.io.File("reporte_pedidos.pdf"));
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return; // Usuario canceló
        }

        java.io.File file = fileChooser.getSelectedFile();
        String filePath = file.getAbsolutePath();
        
        // Asegurar extensión .pdf
        if (!filePath.toLowerCase().endsWith(".pdf")) {
            filePath += ".pdf";
        }

        // Crear el documento PDF
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        com.itextpdf.text.pdf.PdfWriter.getInstance(document, new java.io.FileOutputStream(filePath));
        
        document.open();

        // Configurar fuentes
        com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(
            com.itextpdf.text.Font.FontFamily.HELVETICA, 18, com.itextpdf.text.Font.BOLD
        );
        
        com.itextpdf.text.Font headerFont = new com.itextpdf.text.Font(
            com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLD
        );
        
        com.itextpdf.text.Font normalFont = new com.itextpdf.text.Font(
            com.itextpdf.text.Font.FontFamily.HELVETICA, 10
        );

        // Título del reporte
        com.itextpdf.text.Paragraph title = new com.itextpdf.text.Paragraph(
            "REPORTE DE PEDIDOS - TIENDA AZULEJO", titleFont
        );
        title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);

        // Información del reporte
        String estadoFiltro = cmbEstadoReporte.getSelectedItem().toString();
        String fechaInicio = txtFechaInicio.getDate() != null ? 
            new java.text.SimpleDateFormat("dd/MM/yyyy").format(txtFechaInicio.getDate()) : "N/A";
        String fechaFin = txtFechaFin.getDate() != null ? 
            new java.text.SimpleDateFormat("dd/MM/yyyy").format(txtFechaFin.getDate()) : "N/A";
        
        com.itextpdf.text.Paragraph info = new com.itextpdf.text.Paragraph(
            "Fechas: " + fechaInicio + " - " + fechaFin + " | Estado: " + estadoFiltro + 
            " | Generado: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(new java.util.Date()),
            normalFont
        );
        info.setSpacingAfter(15);
        document.add(info);

        // Crear tabla
        int columnCount = tblReporte.getColumnCount();
        com.itextpdf.text.pdf.PdfPTable table = new com.itextpdf.text.pdf.PdfPTable(columnCount);
        table.setWidthPercentage(100);

        // Agregar encabezados de columna
        for (int i = 0; i < columnCount; i++) {
            com.itextpdf.text.Phrase header = new com.itextpdf.text.Phrase(
                tblReporte.getColumnName(i), headerFont
            );
            table.addCell(header);
        }

        // Agregar datos de la tabla
        int rowCount = tblReporte.getRowCount();
        double totalGeneral = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                Object value = tblReporte.getValueAt(i, j);
                String cellValue = (value != null) ? value.toString() : "";
                table.addCell(new com.itextpdf.text.Phrase(cellValue, normalFont));
                
                // Calcular total general (asumiendo que la última columna es el total)
                if (j == columnCount - 1 && value != null) {
                    try {
                        String totalStr = value.toString().replace("$", "").replace(",", "");
                        totalGeneral += Double.parseDouble(totalStr);
                    } catch (NumberFormatException e) {
                        // Ignorar si no es un número
                    }
                }
            }
        }

        document.add(table);

        // Agregar total general
        document.add(new com.itextpdf.text.Paragraph(" ")); // Espacio
        com.itextpdf.text.Paragraph totalParagraph = new com.itextpdf.text.Paragraph(
            "TOTAL GENERAL: $" + String.format("%.2f", totalGeneral), headerFont
        );
        totalParagraph.setSpacingBefore(10);
        document.add(totalParagraph);

        // Estadísticas
        com.itextpdf.text.Paragraph stats = new com.itextpdf.text.Paragraph(
            "Total de pedidos: " + rowCount, normalFont
        );
        stats.setSpacingBefore(5);
        document.add(stats);

        document.close();

        JOptionPane.showMessageDialog(this, 
            "✅ Reporte exportado exitosamente:\n" + filePath + 
            "\n\nTotal de registros: " + rowCount +
            "\nTotal general: $" + String.format("%.2f", totalGeneral));

        // Opcional: Abrir el PDF automáticamente
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop.getDesktop().open(new java.io.File(filePath));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "❌ Error al exportar PDF: " + e.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnExportarPdfActionPerformed

    private void btnGenerarReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteVentasActionPerformed
        // TODO add your handling code here:
         DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID Venta", "Cliente", "Fecha", "Productos", "Cantidad", "Total"}, 0
    );
    tblReporte.setModel(modelo);

    String estadoSeleccionado = cmbEstadoReporte1.getSelectedItem().toString();
    java.util.Date fi = txtFechaInicioVenta.getDate();
    java.util.Date ff = txtFechaFinalVenta.getDate();

    if (fi == null || ff == null) {
        JOptionPane.showMessageDialog(this, "Selecciona las fechas de inicio y fin.");
        return;
    }

    // Configurar fechas
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    java.util.Calendar cal = java.util.Calendar.getInstance();
    
    cal.setTime(fi);
    cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
    cal.set(java.util.Calendar.MINUTE, 0);
    cal.set(java.util.Calendar.SECOND, 0);
    String fechaInicio = sdf.format(cal.getTime());
    
    cal.setTime(ff);
    cal.set(java.util.Calendar.HOUR_OF_DAY, 23);
    cal.set(java.util.Calendar.MINUTE, 59);
    cal.set(java.util.Calendar.SECOND, 59);
    String fechaFin = sdf.format(cal.getTime());

    // Consulta SQL con detalles de productos
    String sql = """
        SELECT v.id_venta, c.nombre AS cliente, v.fecha_venta, 
               p.nombre AS producto, dv.cantidad, v.total
        FROM venta v
        JOIN clientes c ON v.id_cliente = c.id
        JOIN detalle_venta dv ON v.id_venta = dv.id_venta
        JOIN productos p ON dv.id_producto = p.IDPRODUCTO
        WHERE v.fecha_venta BETWEEN ? AND ?
        """;

    // Si necesitas filtrar por estado en el futuro, agrega aquí la lógica
    // Por ahora, todas las ventas se consideran exitosas

    sql += " ORDER BY v.fecha_venta DESC, v.id_venta";

    try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);

        ResultSet rs = ps.executeQuery();
        double totalGeneral = 0;
        int filas = 0;

        java.text.SimpleDateFormat fechaDisplay = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");

        while (rs.next()) {
            Object[] fila = {
                rs.getInt("id_venta"),
                rs.getString("cliente"),
                fechaDisplay.format(rs.getTimestamp("fecha_venta")),
                rs.getString("producto"),
                rs.getInt("cantidad"),
                String.format("$%.2f", rs.getDouble("total"))
            };
            modelo.addRow(fila);
            totalGeneral += rs.getDouble("total");
            filas++;
        }

        lblTotalVentas.setText(String.format("Total: $%.2f | Ventas: %d", totalGeneral, filas));

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "❌ Error al generar reporte de ventas: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnGenerarReporteVentasActionPerformed

    private void btnGenerarpdfVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarpdfVentaActionPerformed
        // TODO add your handling code here:
        // Código similar al btnExportarPdfActionPerformed pero para ventas
    // Solo cambia las referencias de tablas y labels
    try {
        if (tblReporte.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay datos de ventas para exportar.");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte de ventas como PDF");
        fileChooser.setSelectedFile(new java.io.File("reporte_ventas.pdf"));
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection != JFileChooser.APPROVE_OPTION) return;

        java.io.File file = fileChooser.getSelectedFile();
        String filePath = file.getAbsolutePath();
        
        if (!filePath.toLowerCase().endsWith(".pdf")) {
            filePath += ".pdf";
        }

        // ... (código similar al exportador de pedidos pero adaptado para ventas)
        
        JOptionPane.showMessageDialog(this, "✅ Reporte de ventas exportado exitosamente");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "❌ Error al exportar PDF de ventas: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGenerarpdfVentaActionPerformed

    private void btnImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImporteActionPerformed
        // TODO add your handling code here:
        if (tblVenta.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay productos en la venta para generar el PDF.");
            return;
        }

        try {
            // 📁 Ruta donde se guardará el PDF
            String ruta = "C:\\Users\\Usuario\\Documents\\ReportesAzulejo\\" + System.currentTimeMillis() + ".pdf";

            // 📄 Crear el documento PDF
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            com.itextpdf.text.pdf.PdfWriter.getInstance(doc, new java.io.FileOutputStream(ruta));
            doc.open();

            // 🧱 Encabezado del ticket
            doc.add(new com.itextpdf.text.Paragraph("🧾 COMPROBANTE DE VENTA"));
            doc.add(new com.itextpdf.text.Paragraph(" "));
            doc.add(new com.itextpdf.text.Paragraph("Cliente: " + txtClienteVenta.getText()));
            doc.add(new com.itextpdf.text.Paragraph("Fecha: " + java.time.LocalDateTime.now()));
            doc.add(new com.itextpdf.text.Paragraph(" "));
            doc.add(new com.itextpdf.text.Paragraph("---------------------------------------------"));

            // 🧮 Tabla de productos
            com.itextpdf.text.pdf.PdfPTable tabla = new com.itextpdf.text.pdf.PdfPTable(4);
            tabla.setWidths(new float[]{3, 1, 2, 2});
            tabla.addCell("Producto");
            tabla.addCell("Cant.");
            tabla.addCell("Precio");
            tabla.addCell("Subtotal");

            DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                tabla.addCell(modelo.getValueAt(i, 1).toString()); // Nombre producto
                tabla.addCell(modelo.getValueAt(i, 3).toString()); // Cantidad
                tabla.addCell("$" + modelo.getValueAt(i, 4).toString()); // Precio unitario
                tabla.addCell("$" + modelo.getValueAt(i, 6).toString()); // Subtotal
            }

            doc.add(tabla);
            doc.add(new com.itextpdf.text.Paragraph("---------------------------------------------"));

            // 💰 Totales
            double total = Double.parseDouble(txtTotalAPagarVenta.getText());
            double efectivo = 0;
            double cambio = 0;

            try {
                efectivo = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingresa el efectivo recibido:"));
                if (efectivo < total) {
                    JOptionPane.showMessageDialog(this, "El efectivo es menor al total. Intenta nuevamente.");
                    return;
                }
                cambio = efectivo - total;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valor de efectivo inválido.");
                return;
            }

            doc.add(new com.itextpdf.text.Paragraph("Total a pagar: $" + String.format("%.2f", total)));
            doc.add(new com.itextpdf.text.Paragraph("Efectivo recibido: $" + String.format("%.2f", efectivo)));
            doc.add(new com.itextpdf.text.Paragraph("Cambio: $" + String.format("%.2f", cambio)));
            doc.add(new com.itextpdf.text.Paragraph("---------------------------------------------"));
            doc.add(new com.itextpdf.text.Paragraph("¡Gracias por su compra!"));
            doc.add(new com.itextpdf.text.Paragraph(" "));

            doc.close();

            JOptionPane.showMessageDialog(this, "✅ Ticket generado correctamente:\n" + ruta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error al generar el PDF: " + e.getMessage());
        }
    }//GEN-LAST:event_btnImporteActionPerformed
    private void limpiarCamposVenta2() {
        txtCodigoVenta.setText("");
        txtNombreVenta.setText("");
        txtPrecioVenta.setText("");
        txtCantidadVenta.setText("");
        txtTotalVenta.setText("");
        txtDescuentoVenta.setText("");
        txtStockVenta.setText("");
    }

    private void cambiarVista(JPanel jPanel) {
        jPanel.setSize(jPanelPrincipal.getWidth(), jPanelPrincipal.getHeight());
        jPanelPrincipal.removeAll();
        jPanelPrincipal.add(jPanel);
        jPanelPrincipal.repaint();
    }

    private void ActivarVista(JPanel jPanel) {
        jPanelProductos.setEnabled(false);
        jPanelProductos.setVisible(false);

        jPanelClientes.setEnabled(false);
        jPanelClientes.setVisible(false);

        jPanelUsuarios.setEnabled(false);
        jPanelUsuarios.setVisible(false);

        jPanelVentas.setEnabled(false);
        jPanelVentas.setVisible(false);

        jPanelProveedor.setEnabled(false);
        jPanelProveedor.setVisible(false);

        jPanel.setVisible(true);
        jPanel.setEnabled(true);
    }

    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BuscarClientePedido;
    private javax.swing.JButton BuscarProductoPedido;
    private javax.swing.JButton brnBorrarProducto;
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnAgregarUsuario1;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarClienteVenta;
    private javax.swing.JButton btnBuscarProductoV;
    private javax.swing.JButton btnBuscarProductoVenta2;
    private javax.swing.JButton btnBuscarProudcto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnCopiaDeSeguridad;
    private javax.swing.JButton btnEditarPedido;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JToggleButton btnExportarPdf;
    private javax.swing.JToggleButton btnGenerarReporte;
    private javax.swing.JToggleButton btnGenerarReporteVentas;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JToggleButton btnGenerarpdfDelPedido;
    private javax.swing.JToggleButton btnGenerarpdfVenta;
    private javax.swing.JButton btnGuardarPedido;
    private javax.swing.JButton btnGuardarVenta;
    private javax.swing.JButton btnImporte;
    private javax.swing.JButton btnLimpiarPedido;
    private javax.swing.JButton btnLimpiarProducto;
    private javax.swing.JButton btnMiEmpresa;
    private javax.swing.JButton btnModificarVenta;
    private javax.swing.JToggleButton btnMostrarPedido;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnPermiso;
    private javax.swing.JButton btnRecibo;
    private javax.swing.JButton btnRestaurarBD;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstadoReporte;
    private javax.swing.JComboBox<String> cmbEstadoReporte1;
    private javax.swing.JComboBox<String> cmbPedido;
    private javax.swing.JComboBox<String> cmbRolUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1Principal;
    private javax.swing.JMenu jMenu3Proveedor;
    private javax.swing.JMenu jMenu4Ventas;
    private javax.swing.JMenu jMenu5Configuracion;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenuItem jMenuItemIrAlLogin;
    private javax.swing.JMenu jMenuPedidos;
    private javax.swing.JMenu jMenuProductos;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel1Inicio;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelConfiguracion;
    private javax.swing.JPanel jPanelPedido;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelProveedor;
    private javax.swing.JPanel jPanelReportes;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JPanel jPanelVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblTotalVentas;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTable tblReporte;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField txtCambioVenta;
    private javax.swing.JTextField txtCantidadPedido;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtClientePedido;
    private javax.swing.JTextField txtClienteVenta;
    private javax.swing.JTextField txtCodigoABuscar;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoProductoPedido;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtColorPedido;
    private javax.swing.JTextField txtColorProducto;
    private javax.swing.JTextField txtContraseñaUsuario;
    private javax.swing.JTextField txtCorreoProveedor;
    private javax.swing.JTextField txtDescuentoVenta;
    private javax.swing.JTextField txtDimensionPedido;
    private javax.swing.JTextField txtDimensionProducto;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionPedido;
    private javax.swing.JTextField txtDireccionProveedor;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaFinalVenta;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private com.toedter.calendar.JDateChooser txtFechaInicioVenta;
    private javax.swing.JTextField txtFechaPedido;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtHoraVenta;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtMaterialPedido;
    private javax.swing.JTextField txtMaterialProducto;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtNombreVendedor;
    private javax.swing.JTextField txtNombreVenta;
    private javax.swing.JTextField txtNumeroClienteVenta;
    private javax.swing.JTextField txtPrecioCompraProducto;
    private javax.swing.JTextField txtPrecioUnitarioPedido;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtPrecioVentaProducto;
    private javax.swing.JTextField txtProductoPedido;
    private javax.swing.JTextField txtStockProducto;
    private javax.swing.JTextField txtStockVenta;
    private javax.swing.JTextField txtSubtotalPedido;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoPedido;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtTotalAPagarVenta;
    private javax.swing.JTextField txtTotalPedido;
    private javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables

    ////////////////////////////CARGAR DATOS  DE BD EN LA TABLA////////////////////////////////////////
    private void cargarTablaUsuario() {
        //definir el modelo que queremos que tenga la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            //Que fila y columnas no sean editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //establecemos los nombres de las columnas
        String titulo[] = {"Id", "Usuario", "contraseña", "Rol"};
        modeloTabla.setColumnIdentifiers(titulo);

        //traer de la bd la lista de Usuario
        List<Usuario> listaUsuario = control.traerUsuarios();
        //preguntamos si la lista está vacia
        if (listaUsuario != null) {
            //Recorrer la lista
            for (Usuario usu : listaUsuario) {
                Object[] objeto = {usu.getId(), usu.getNombreUsuario(), usu.getContrasenia(), usu.getUnRol().getNombreRol()};

                modeloTabla.addRow(objeto);

            }
        }

        tblUsuarios.setModel(modeloTabla);
    }

    private void cargarTablaClientes() {
//definir el modelo que queremos que tenga la tabla
        DefaultTableModel modeloTabla1 = new DefaultTableModel() {

            //Que fila y columnas no sean editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //establecemos los nombres de las columnas
        String titulo[] = {"Id", "Nombre", "Direccion", "Numero"};
        modeloTabla1.setColumnIdentifiers(titulo);

        //traer de la bd la lista de Usuario
        List<Clientes> listaClientes = control.traerClientes();
        //preguntamos si la lista está vacia
        if (listaClientes != null) {
            //Recorrer la lista
            for (Clientes cli : listaClientes) {
                Object[] objeto1 = {cli.getId(), cli.getNombre(), cli.getDireccion(), cli.getNumero()};

                modeloTabla1.addRow(objeto1);
            }
        }

        tblClientes.setModel(modeloTabla1);

    }

    private void cargarTablaProveedor() {
        DefaultTableModel modeloTabla2 = new DefaultTableModel() {

            //Que fila y columnas no sean editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //establecemos los nombres de las columnas
        String titulo[] = {"Id", "Nombre", "Direccion", "Correo", "Telefono"};
        modeloTabla2.setColumnIdentifiers(titulo);

        //traer de la bd la lista de Usuario
        List<Proveedor> listaProveedor = control.traerProveedor();
        //preguntamos si la lista está vacia
        if (listaProveedor != null) {
            //Recorrer la lista
            for (Proveedor prov : listaProveedor) {
                Object[] objeto1 = {prov.getId_proveedor(), prov.getNombre(), prov.getDireccion(), prov.getCorreo(), prov.getTelefono()};

                modeloTabla2.addRow(objeto1);
            }
        }
        tblProveedor.setModel(modeloTabla2);
    }

    //CARGAR TABLA PRODUCTOS
    private void cargarTablaProductos() {
       try {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] titulos = {"Id", "Código", "Nombre", "Color", "Dimensión", "Precio Venta", "Stock", "Precio Compra", "Material", "Categoría"};
        modeloTabla.setColumnIdentifiers(titulos);

        List<Productos> listaProductos = control.TraerProducto();

        if (listaProductos != null && !listaProductos.isEmpty()) {
            for (Productos prod : listaProductos) {
                Object[] fila = {
                    prod.getIdProducto(),
                    prod.getCodigo(),
                    prod.getNombre(),
                    prod.getColor(),
                    prod.getDimension(),
                    prod.getPrecioVenta(),
                    prod.getStockDisponible(),
                    prod.getPrecioCompra(),
                    prod.getMaterial(),
                    prod.getUnCategoria() != null ? prod.getUnCategoria().getNombre() : "Sin categoría"
                };
                modeloTabla.addRow(fila);
            }
        }

        tblProducto.setModel(modeloTabla);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
    }
    }

    private void cargarTablaProductosPrincipal(Productos productoBuscado) {
        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {
                   
        };

        // Definir los nombres de las columnas
        String[] titulos = {"Id", "Código", "Nombre", "Color", "Dimensión", "Precio Venta", "Stock", "Precio Compra", "Material", "Categoría"};
        modeloTabla.setColumnIdentifiers(titulos);

        // Si el producto buscado no es nulo, cargar solo ese producto
        if (productoBuscado != null) {
            Object[] fila = {
                productoBuscado.getIdProducto(),
                productoBuscado.getCodigo(),
                productoBuscado.getNombre(),
                productoBuscado.getColor(),
                productoBuscado.getDimension(),
                productoBuscado.getPrecioVenta(),
                productoBuscado.getStockDisponible(),
                productoBuscado.getPrecioCompra(),
                productoBuscado.getMaterial(),
                productoBuscado.getUnCategoria() != null ? productoBuscado.getUnCategoria().getNombre() : "Sin categoría"
            };
            modeloTabla.addRow(fila);
        } else {
            // Mensaje opcional: No se encontró el producto
            mostrarMensaje("Producto no encontrado", "Error", "Sin resultados");
        }

        // Asignar el modelo a la tabla
        tblProducto.setModel(modeloTabla);
    }

    private void cargarTablaPedido() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"codigo", "producto", "cantidad", "precio_unitario", "subtotal"}, 0
        );
        tblPedido.setModel(modelo);

    }

    ////////////////////////////////////CARGAR DATOS DESDE LA TABLA///////////////////////////////////
    private void cargarDatosDesdeTabla() {
        // Verificamos que haya una fila seleccionada
        int filaSeleccionada = tblClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtenemos los datos de la fila seleccionada
            int id_Cliente = Integer.parseInt(String.valueOf(tblClientes.getValueAt(filaSeleccionada, 0)));
            cli = control.traerCliente(id_Cliente); // Buscamos el cliente por su ID

            // Cargamos los datos en los campos de texto
            txtNombreCliente.setText(cli.getNombre());
            txtDireccionCliente.setText(cli.getDireccion());
            txtTelefonoCliente.setText(cli.getNumero());

        }
    }

    private void cargarDatosDesdeTablaUsuario() {
        int filaSeleccionada = tblUsuarios.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener los valores de la fila seleccionada
            int idUsuario = (int) tblUsuarios.getValueAt(filaSeleccionada, 0);
            String nombreUsuario = (String) tblUsuarios.getValueAt(filaSeleccionada, 1);
            String contra = (String) tblUsuarios.getValueAt(filaSeleccionada, 2);
            String rolUsuario = (String) tblUsuarios.getValueAt(filaSeleccionada, 3);

            // Cargar los valores en los campos de texto y combo
            txtNombreUsuario.setText(nombreUsuario);
            txtContraseñaUsuario.setText(contra);
            cmbRolUsuario.setSelectedItem(rolUsuario);

            // Puedes almacenar el ID si necesitas usarlo para actualizar
            usr = control.traerUsuario(idUsuario); // Obtener el objeto completo del usuario desde la BD
        }
    }

    private void cargarDatosDesdeTablaProveedor() {
        int filaSeleccionada = tblProveedor.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener los valores de la fila seleccionada
            int idProveedor = (int) tblProveedor.getValueAt(filaSeleccionada, 0);
            String nombreProveedor = (String) tblProveedor.getValueAt(filaSeleccionada, 1);
            String direccionProveedor = (String) tblProveedor.getValueAt(filaSeleccionada, 2);
            String CorreoProveedor = (String) tblProveedor.getValueAt(filaSeleccionada, 3);
            String telefonoProveedor = (String) tblProveedor.getValueAt(filaSeleccionada, 4);

            // Cargar los valores en los campos de texto y combo
            txtNombreProveedor.setText(nombreProveedor);
            txtDireccionProveedor.setText(direccionProveedor);
            txtCorreoProveedor.setText(CorreoProveedor);
            txtTelefonoProveedor.setText(telefonoProveedor);

            // Puedes almacenar el ID si necesitas usarlo para actualizar
            prov = control.traerProveedor(idProveedor); // Obtener el objeto completo del usuario desde la BD
        }

    }

    private void cargarDatosDesdeTablaProducto() {
        // Obtener la fila seleccionada
        int filaSeleccionada = tblProducto.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener los valores de la fila seleccionada
            int idProducto = (int) tblProducto.getValueAt(filaSeleccionada, 0);
            String codigo = (String) tblProducto.getValueAt(filaSeleccionada, 1);
            String nombre = (String) tblProducto.getValueAt(filaSeleccionada, 2);
            String color = (String) tblProducto.getValueAt(filaSeleccionada, 3);
            String dimension = (String) tblProducto.getValueAt(filaSeleccionada, 4);
            int precioVenta = (int) tblProducto.getValueAt(filaSeleccionada, 5);
            int stock = (int) tblProducto.getValueAt(filaSeleccionada, 6);
            int precioCompra = (int) tblProducto.getValueAt(filaSeleccionada, 7);
            String material = (String) tblProducto.getValueAt(filaSeleccionada, 8);
            String categoria = (String) tblProducto.getValueAt(filaSeleccionada, 9);

            // Cargar los valores en los campos de texto
            txtCodigoProducto.setText(codigo);
            txtNombreProducto.setText(nombre);
            txtColorProducto.setText(color);
            txtDimensionProducto.setText(dimension);
            txtPrecioVentaProducto.setText(String.valueOf(precioVenta));
            txtStockProducto.setText(String.valueOf(stock));
            txtPrecioCompraProducto.setText(String.valueOf(precioCompra));
            txtMaterialProducto.setText(material);

            // Si tienes un campo para mostrar la categoría, podrías establecerlo aquí
            cmbCategoria.setSelectedItem(categoria);
            // Almacenar el objeto completo si es necesario
            prod = control.traerProducto(idProducto); // Objeto producto desde la BD
        } else {
            mostrarMensaje("No se seleccionó ninguna fila", "Error", "Selección vacía");
        }
    }

    private void cargarDatosVentaDesdeTabla() {
        // Verificar si hay una fila seleccionada
        int filaSeleccionada = tblVenta.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada
            String codigo = String.valueOf(tblVenta.getValueAt(filaSeleccionada, 0)); // Columna 0: Código
            String nombre = String.valueOf(tblVenta.getValueAt(filaSeleccionada, 1)); // Columna 1: Nombre
            String precio = String.valueOf(tblVenta.getValueAt(filaSeleccionada, 2)); // Columna 2: Precio
            String cantidad = String.valueOf(tblVenta.getValueAt(filaSeleccionada, 3)); // Columna 3: Cantidad
            String decuento = String.valueOf(tblVenta.getValueAt(filaSeleccionada, 4));//Columna 4: descuento
            String Stock = String.valueOf(tblVenta.getValueAt(filaSeleccionada, 5));//Columna 5: Stock
            String total = String.valueOf(tblVenta.getValueAt(filaSeleccionada, 6)); // Columna 4: Total

            // Cargar los datos en los campos de texto
            txtCodigoVenta.setText(codigo);
            txtNombreVenta.setText(nombre);
            txtPrecioVenta.setText(precio);
            txtCantidadVenta.setText(cantidad);
            txtDescuentoVenta.setText(decuento);
            txtStockVenta.setText(Stock);
            txtTotalVenta.setText(total);

        } else {
            // Mostrar un mensaje si no hay fila seleccionada
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila de la tabla", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    ///////////////////////////////////////////////////METODOS ACTUALIZAR DATOS///////////////////////////////////
    void actualizarCliente() {
        int fila = tblClientes.getSelectedRow(); // Obtenemos la fila seleccionada
        if (fila != -1) {
            // Obtenemos los valores de los campos de texto
            String nombre = txtNombreCliente.getText();
            String direccion = txtDireccionCliente.getText();
            String telefono = txtTelefonoCliente.getText();

            // Actualizamos el cliente
            control.editarCliente(cli, nombre, direccion, telefono);

            mostrarMensaje("Cliente editado correctamente", "Info", "Actualización exitosa");
        } else {
            mostrarMensaje("No seleccionaste ninguna fila para actualizar", "Error", "Error de actualización");
        }
    }

    void actualizarUsuario() {
        int fila = tblUsuarios.getSelectedRow(); // Obtenemos la fila seleccionada
        if (fila != -1) {
            // Obtenemos los valores de los campos de texto
            String Usuario = txtNombreUsuario.getText();
            String contrasenia = txtContraseñaUsuario.getText();
            String rol = (String) cmbRolUsuario.getSelectedItem();

            // Actualizamos el cliente
            control.editarUsuario(usr, Usuario, contrasenia, rol);

            mostrarMensaje("Usuario editado correctamente", "Info", "Actualización exitosa");
        } else {
            mostrarMensaje("No seleccionaste ninguna fila para actualizar", "Error", "Error de actualización");
        }
    }

    void actualizarProveedor() {

        int fila = tblProveedor.getSelectedRow(); // Obtenemos la fila seleccionada
        if (fila != -1) {
            // Obtenemos los valores de los campos de texto
            String nombre = txtNombreProveedor.getText();
            String direccion = txtDireccionProveedor.getText();
            String correo = txtCorreoProveedor.getText();
            String telefono = txtTelefonoProveedor.getText();

            // Actualizamos el cliente
            control.editarProveedor(prov, nombre, direccion, correo, telefono);

            mostrarMensaje("Proveedor editado correctamente", "Info", "Actualización exitosa");
        } else {
            mostrarMensaje("No seleccionaste ninguna fila para actualizar", "Error", "Error de actualización");
        }
    }

    private boolean validarCampos(JTextField[] campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void cargarPermisosDesdeBD() {
        try (Connection con = ConexionBD.getConnection()) {
            // 1️⃣ Obtener ID del usuario
            String sqlUsuario = "SELECT id FROM usuario WHERE nombreusuario = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlUsuario)) {
                ps.setString(1, usuarioActual);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    idUsuarioActual = rs.getInt("id");
                }
            }

            // 2️⃣ Obtener permisos
            String sqlPermisos = "SELECT permiso FROM permiso_usuario WHERE id_usuario = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlPermisos)) {
                ps.setInt(1, idUsuarioActual);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    permisosUsuario.add(rs.getString("permiso"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void configurarMenus() {
        jMenu1Principal.setEnabled(true);

        jMenu3Proveedor.setEnabled(permisosUsuario.contains("PROVEEDOR"));
        jMenuProductos.setEnabled(permisosUsuario.contains("PRODUCTOS"));
        jMenuClientes.setEnabled(permisosUsuario.contains("CLIENTES"));
        jMenuUsuarios.setEnabled(permisosUsuario.contains("USUARIOS"));
        jMenu4Ventas.setEnabled(permisosUsuario.contains("VENTAS"));
        jMenu5Configuracion.setEnabled(permisosUsuario.contains("CONFIGURACION"));
        jMenuReportes.setEnabled(permisosUsuario.contains("REPORTES"));
        jMenuPedidos.setEnabled(permisosUsuario.contains("PEDIDOS"));

    }

    private void calcularTotal() {
        DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
        double total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            total += Double.parseDouble(modelo.getValueAt(i, 4).toString());
        }
        txtSubtotalPedido.setText(String.valueOf(total));
    }

    private void limpiarFormulario() {
        DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
        modelo.setRowCount(0);
        txtClientePedido.setText("");
        txtDireccionPedido.setText("");
        txtTelefonoPedido.setText("");
        txtFechaPedido.setText("");
        txtSubtotalPedido.setText("");
    }

    private int obtenerIdProducto(String codigoProducto) {
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT IDPRODUCTO FROM productos WHERE CODIGO = ?")) {
            ps.setString(1, codigoProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDPRODUCTO");
            }
        } catch (SQLException e) {
            System.out.println("Error obtenerIdProducto: " + e.getMessage());
        }
        return 0;
    }

    private int obtenerIdCliente(String nombreCliente) {
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT ID FROM clientes WHERE NOMBRE = ?")) {
            ps.setString(1, nombreCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (SQLException e) {
            System.out.println("Error obtenerIdCliente: " + e.getMessage());
        }
        return 0;
    }

    private void actualizarTablaDesdeLista() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"codigo", "producto", "cantidad", "precio_unitario", "subtotal"}, 0
        );

        for (Object[] fila : listaPedido) {
            modelo.addRow(fila);
        }

        tblPedido.setModel(modelo);
    }

    private boolean verificarStockDisponible(DefaultTableModel modelo) {
        StringBuilder mensajeError = new StringBuilder();
    
    try (Connection conn = ConexionBD.getConnection()) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String codigo = modelo.getValueAt(i, 0).toString();
            int cantidadVenta = Integer.parseInt(modelo.getValueAt(i, 3).toString());
            String nombreProducto = modelo.getValueAt(i, 1).toString();
            
            int idProducto = obtenerIdProducto(codigo);
            
            // Consultar stock actual
            String sqlStock = "SELECT STOCKDISPONIBLE, NOMBRE FROM productos WHERE IDPRODUCTO = ?";
            try (PreparedStatement ps = conn.prepareStatement(sqlStock)) {
                ps.setInt(1, idProducto);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    int stockActual = rs.getInt("STOCKDISPONIBLE");
                    String nombre = rs.getString("NOMBRE");
                    
                    if (stockActual < cantidadVenta) {
                        mensajeError.append("• ").append(nombre)
                                  .append(" - Stock disponible: ").append(stockActual)
                                  .append(", Cantidad solicitada: ").append(cantidadVenta)
                                  .append("\n");
                    }
                }
            }
        }
        
        if (mensajeError.length() > 0) {
            JOptionPane.showMessageDialog(this, 
                "❌ Stock insuficiente para los siguientes productos:\n\n" + 
                mensajeError.toString() + 
                "\nPor favor ajusta las cantidades.", 
                "Stock Insuficiente", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al verificar stock: " + e.getMessage());
        return false;
    }
    
    return true; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // 🔹 MÉTODO MEJORADO PARA MOSTRAR RESUMEN DE VENTA
private void mostrarResumenVenta(double totalGeneral, DefaultTableModel modelo) {
    // Crear resumen de productos
    StringBuilder resumenProductos = new StringBuilder("Productos vendidos:\n");
    for (int i = 0; i < modelo.getRowCount(); i++) {
        String nombre = modelo.getValueAt(i, 1).toString();
        int cantidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());
        double precio = Double.parseDouble(modelo.getValueAt(i, 4).toString());
        
        resumenProductos.append("• ").append(nombre)
                       .append(" - ").append(cantidad).append(" uds x $").append(precio)
                       .append("\n");
    }
    
    // Pedir efectivo y calcular cambio
    double efectivo = 0;
    boolean entradaValida = false;
    
    while (!entradaValida) {
        try {
            String mensaje = resumenProductos.toString() + 
                           "\n───────────────────────\n" +
                           "TOTAL A PAGAR: $" + String.format("%.2f", totalGeneral) + 
                           "\n\nIngresa el efectivo recibido:";
            
            String entrada = JOptionPane.showInputDialog(this, mensaje);
            
            if (entrada == null) {
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
                return;
            }
            
            efectivo = Double.parseDouble(entrada);
            
            if (efectivo < totalGeneral) {
                JOptionPane.showMessageDialog(this, 
                    "❌ El efectivo recibido ($" + String.format("%.2f", efectivo) + 
                    ") es menor al total a pagar ($" + String.format("%.2f", totalGeneral) + 
                    ").\nFaltan: $" + String.format("%.2f", (totalGeneral - efectivo)));
            } else {
                entradaValida = true;
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "❌ Por favor ingresa un valor numérico válido.");
        }
    }
    
    // Calcular cambio
    double cambio = efectivo - totalGeneral;
    
    // Mostrar ticket de venta
    String ticket = "✅ VENTA REGISTRADA EXITOSAMENTE\n" +
                   "══════════════════════════════\n" +
                   resumenProductos.toString() +
                   "───────────────────────\n" +
                   "TOTAL: $" + String.format("%.2f", totalGeneral) + "\n" +
                   "EFECTIVO: $" + String.format("%.2f", efectivo) + "\n" +
                   "CAMBIO: $" + String.format("%.2f", cambio) + "\n" +
                   "───────────────────────\n" +
                   "¡Gracias por su compra!";
    
    JOptionPane.showMessageDialog(this, ticket, "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
}
// 🔹 MÉTODO PARA OBTENER DETALLES DEL PEDIDO
private java.util.List<ProductoPedido> obtenerDetallesPedido(Connection conn, int idPedido) throws SQLException {
    java.util.List<ProductoPedido> detalles = new java.util.ArrayList<>();
    
    String sql = """
        SELECT dp.id_producto, dp.cantidad, p.nombre 
        FROM detalle_pedido dp 
        JOIN productos p ON dp.id_producto = p.IDPRODUCTO 
        WHERE dp.id_pedido = ?
        """;
    
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idPedido);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            detalles.add(new ProductoPedido(
                rs.getInt("id_producto"),
                rs.getInt("cantidad"),
                rs.getString("nombre")
            ));
        }
    }
    
    return detalles;
}

// 🔹 MÉTODO PARA MANEJAR CAMBIOS DE STOCK
private void manejarCambioStock(Connection conn, String estadoAnterior, String estadoNuevo, 
                               java.util.List<ProductoPedido> detalles) throws SQLException {
    
    // CASO 1: Si cambia a "Cancelado" desde cualquier estado (excepto si ya estaba cancelado)
    if (estadoNuevo.equals("Cancelado") && !estadoAnterior.equals("Cancelado")) {
        // 🔹 REGRESAR STOCK SI EL PEDIDO ESTABA "En proceso" o "Entregado"
        if (estadoAnterior.equals("En proceso") || estadoAnterior.equals("Entregado")) {
            for (ProductoPedido detalle : detalles) {
                actualizarStock(conn, detalle.idProducto, detalle.cantidad); // Sumar stock
            }
        }
    }
    
    // CASO 2: Si cambia a "Entregado" o "En proceso" desde "Pendiente" o "Cancelado"
    else if ((estadoNuevo.equals("Entregado") || estadoNuevo.equals("En proceso")) && 
             (estadoAnterior.equals("Pendiente") || estadoAnterior.equals("Cancelado"))) {
        
        // Verificar stock disponible primero
        if (!verificarStockDisponiblePedido(detalles)) {
            throw new SQLException("Stock insuficiente para cambiar a estado: " + estadoNuevo);
        }
        
        // Restar stock
        for (ProductoPedido detalle : detalles) {
            actualizarStock(conn, detalle.idProducto, -detalle.cantidad); // Restar stock
        }
    }
    
    // CASO 3: Si cambia de "Entregado" a "En proceso" (no hay cambio de stock)
    // CASO 4: Si cambia de "En proceso" a "Entregado" (no hay cambio de stock)
    // CASO 5: Si cambia a "Pendiente" desde cualquier estado (no hay cambio de stock)
}

// 🔹 MÉTODO PARA ACTUALIZAR STOCK
private void actualizarStock(Connection conn, int idProducto, int cantidad) throws SQLException {
    String sql = "UPDATE productos SET STOCKDISPONIBLE = STOCKDISPONIBLE + ? WHERE IDPRODUCTO = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, cantidad);
        ps.setInt(2, idProducto);
        int filas = ps.executeUpdate();
        
        if (filas == 0) {
            throw new SQLException("No se pudo actualizar stock del producto ID: " + idProducto);
        }
    }
}

// 🔹 MÉTODO PARA VERIFICAR STOCK (PARA DETALLES)
private boolean verificarStockDisponiblePedido(java.util.List<ProductoPedido> detalles) {
    StringBuilder mensajeError = new StringBuilder();
    
    try (Connection conn = ConexionBD.getConnection()) {
        for (ProductoPedido detalle : detalles) {
            String sql = "SELECT STOCKDISPONIBLE, NOMBRE FROM productos WHERE IDPRODUCTO = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, detalle.idProducto);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    int stockActual = rs.getInt("STOCKDISPONIBLE");
                    String nombre = rs.getString("NOMBRE");
                    
                    if (stockActual < detalle.cantidad) {
                        mensajeError.append("• ").append(nombre)
                                  .append(" - Stock disponible: ").append(stockActual)
                                  .append(", Cantidad requerida: ").append(detalle.cantidad)
                                  .append("\n");
                    }
                }
            }
        }
        
        if (mensajeError.length() > 0) {
            JOptionPane.showMessageDialog(this, 
                "❌ Stock insuficiente:\n\n" + mensajeError.toString(), 
                "Stock Insuficiente", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al verificar stock: " + e.getMessage());
        return false;
    }
    
    return true;
}

// 🔹 MÉTODO PARA VERIFICAR STOCK (PARA TABLA)
private boolean verificarStockDisponiblePedido(DefaultTableModel modelo) {
    StringBuilder mensajeError = new StringBuilder();
    
    try (Connection conn = ConexionBD.getConnection()) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String codigo = modelo.getValueAt(i, 0).toString();
            int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());
            String nombre = modelo.getValueAt(i, 1).toString();
            
            int idProducto = obtenerIdProducto(codigo);
            
            String sql = "SELECT STOCKDISPONIBLE FROM productos WHERE IDPRODUCTO = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idProducto);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    int stockActual = rs.getInt("STOCKDISPONIBLE");
                    if (stockActual < cantidad) {
                        mensajeError.append("• ").append(nombre)
                                  .append(" - Stock disponible: ").append(stockActual)
                                  .append(", Cantidad requerida: ").append(cantidad)
                                  .append("\n");
                    }
                }
            }
        }
        
        if (mensajeError.length() > 0) {
            JOptionPane.showMessageDialog(this, 
                "❌ Stock insuficiente:\n\n" + mensajeError.toString(), 
                "Stock Insuficiente", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al verificar stock: " + e.getMessage());
        return false;
    }
    
    return true;
}

// 🔹 MÉTODO PARA OBTENER MENSAJE DE STOCK
private String obtenerMensajeStock(String estadoAnterior, String estadoNuevo) {
    if (estadoNuevo.equals("Cancelado") && (estadoAnterior.equals("En proceso") || estadoAnterior.equals("Entregado"))) {
        return "Stock regresado al inventario.";
    } else if ((estadoNuevo.equals("Entregado") || estadoNuevo.equals("En proceso")) && 
               (estadoAnterior.equals("Pendiente") || estadoAnterior.equals("Cancelado"))) {
        return "Stock descontado del inventario.";
    } else {
        return "Sin cambios en el stock.";
    }
}

// 🔹 MÉTODO PARA MOSTRAR ESTADÍSTICAS DE PRODUCTOS --------METODO PARA SABER DE STOCK BAJO
/*private void mostrarEstadisticasProductos(List<Productos> productos) {
    int totalProductos = productos.size();
    int stockBajo = 0;
    int sinStock = 0;
    double valorTotalInventario = 0;
    
    for (Productos prod : productos) {
        if (prod.getStockDisponible() < 10) {
            stockBajo++;
        }
        if (prod.getStockDisponible() == 0) {
            sinStock++;
        }
        valorTotalInventario += prod.getPrecioCompra() * prod.getStockDisponible();
    }
    
    // Actualizar labels si los tienes en tu interfaz
    if (lblTotalProductos != null) {
        lblTotalProductos.setText("Total: " + totalProductos);
    }
    if (lblValorInventario != null) {
        lblValorInventario.setText("Stock Bajo: " + stockBajo);
    }
    if (lblValorInventario != null) {
        lblValorInventario.setText("Valor Inventario: $" + String.format("%,.2f", valorTotalInventario));
    }
    
    System.out.println("📊 Estadísticas productos:");
    System.out.println("   - Total: " + totalProductos);
    System.out.println("   - Stock bajo: " + stockBajo);
    System.out.println("   - Sin stock: " + sinStock);
    System.out.println("   - Valor inventario: $" + String.format("%,.2f", valorTotalInventario));
}
*/
// 🔹 MÉTODO PARA MOSTRAR MENSAJES (si no lo tienes)

// 🔹 MÉTODO PARA FILTRAR PRODUCTOS (BÚSQUEDA)
private void filtrarProductos(String filtro) {
    DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
    tblProducto.setRowSorter(sorter);
    
    if (filtro != null && filtro.length() > 0) {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
    } else {
        sorter.setRowFilter(null);
    }
}

// 🔹 MÉTODO PARA OBTENER PRODUCTO SELECCIONADO
private Productos obtenerProductoSeleccionado() {
    int filaSeleccionada = tblProducto.getSelectedRow();
    if (filaSeleccionada == -1) {
        mostrarMensaje("Selecciona un producto de la tabla.", "Advertencia", "advertencia");
        return null;
    }
    
    // Convertir índice de vista a índice de modelo si hay filtro
    int modeloFila = tblProducto.convertRowIndexToModel(filaSeleccionada);
    
    DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();
    int idProducto = (Integer) modelo.getValueAt(modeloFila, 0);
    
    // Buscar el producto en la lista (necesitas mantener una referencia a la lista)
    List<Productos> listaProductos = control.TraerProducto();
    for (Productos prod : listaProductos) {
        if (prod.getIdProducto() == idProducto) {
            return prod;
        }
    }
    
    return null;
}
}
class ProductoPedido {
    int idProducto;
    int cantidad;
    String nombre;
    
    public ProductoPedido(int idProducto, int cantidad, String nombre) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }
}