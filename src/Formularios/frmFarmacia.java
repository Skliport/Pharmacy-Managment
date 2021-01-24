
package Formularios;

import Entidades.Categoria;
import Entidades.Compra;
import Entidades.DBAdmin;
import Entidades.Empleado;
import Entidades.Encriptador;
import Entidades.Producto;
import Entidades.ProductoPorCompra;
import Entidades.ProductoPorVenta;
import Entidades.Proveedor;
import Entidades.Venta;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/*import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;*/

public class frmFarmacia extends javax.swing.JFrame {

    DBAdmin dba; Encriptador encriptador; 
    Empleado empleado; Venta venta; Compra compra;
    
    //Listas.
    ArrayList<Empleado> lEmpleados; ArrayList<Venta> lVentas; 
    ArrayList<Compra> lCompras; ArrayList<Producto> lProductos; 
    ArrayList<Categoria> lCategorias; ArrayList<Proveedor> lProveedores; 
    ArrayList<ProductoPorVenta> lProductoPorVenta; ArrayList<ProductoPorCompra> lProductoPorCompra; 
  
    //Modelos de tabla.
    DefaultTableModel modeloEmpleado; DefaultTableModel modeloPedidoVenta;
    DefaultTableModel modeloPedidoCompra; DefaultTableModel modeloProducto;
    DefaultTableModel modeloCategoria; DefaultTableModel modeloVenta;
    DefaultTableModel modeloDetalleVenta; DefaultTableModel modeloCompra;
    DefaultTableModel modeloDetalleCompra; DefaultTableModel modeloProveedor;
    DefaultTableModel modeloCatalogo; DefaultTableModel modeloProductoProveedor;
    DefaultTableCellRenderer centerRenderer;
    SimpleDateFormat sdf_timestamp = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            
    boolean passwordVisible, modo_edicion;
    int id_cargo;
    
    public frmFarmacia() {
        initComponents(); 
        this.setIcon(); this.centrarCeldas();
        
        dba = new DBAdmin(); encriptador = new Encriptador();
        empleado = new Empleado(); venta = new Venta(); compra = new Compra();
        
        //Inicializando listas.
        lEmpleados = new ArrayList<>(); lVentas = new ArrayList<>();
        lCompras = new ArrayList<>(); lProductos = new ArrayList<>();
        lCategorias = new ArrayList<>(); lProveedores = new ArrayList<>();
        lProductoPorVenta = new ArrayList<>(); lProductoPorCompra  = new ArrayList<>();
        
        //Modelos de tabla.
        modeloEmpleado = (DefaultTableModel) this.jtEmpleado.getModel();
        modeloPedidoVenta = (DefaultTableModel) this.jtPedidoVenta.getModel();
        modeloPedidoCompra = (DefaultTableModel) this.jtPedidoCompra.getModel();
        modeloProducto = (DefaultTableModel) this.jtProducto.getModel();
        modeloCategoria = (DefaultTableModel) this.jtCategoria.getModel();
        modeloVenta = (DefaultTableModel) this.jtVenta.getModel();
        modeloDetalleVenta = (DefaultTableModel) this.jtDetalleVenta.getModel();
        modeloCompra = (DefaultTableModel) this.jtCompra.getModel();
        modeloDetalleCompra = (DefaultTableModel) this.jtDetalleCompra.getModel();
        modeloProveedor = (DefaultTableModel) this.jtProveedor.getModel();
        modeloCatalogo = (DefaultTableModel) this.jtCatalogo.getModel();
        modeloProductoProveedor = (DefaultTableModel) this.jtProductoProveedor.getModel();
        
        //SetEditable Jspinner.
        ((JSpinner.DefaultEditor) jsDiaNac.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) jsDiaContratacion.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) jsCantidadCompra.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) jsCantidadVenta.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) jsAñoNac.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) jsAñoContratacion.getEditor()).getTextField().setEditable(false);
        passwordVisible = false; modo_edicion = false; id_cargo = 0;
        jpHome.setVisible(false); jpSalir.setVisible(false); jpUsuario.setVisible(false);  
        
        //Modificando Width - Tablas.
        jtCatalogo.getColumnModel().getColumn(0).setPreferredWidth(90);  
        jtCatalogo.getColumnModel().getColumn(4).setPreferredWidth(50);  
        jtCatalogo.getColumnModel().getColumn(2).setPreferredWidth(60);   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpInicio = new javax.swing.JPanel();
        jpLogIn = new javax.swing.JPanel();
        jpIniciar = new javax.swing.JPanel();
        lnlUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        lblIniciar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblAvisoInicio = new javax.swing.JLabel();
        jpEmpleado = new javax.swing.JPanel();
        jpEmpleadotabla = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtEmpleado = new javax.swing.JTable();
        lblUsuario1 = new javax.swing.JLabel();
        txtBusquedaEmpleado = new javax.swing.JTextField();
        chkId_empleado = new javax.swing.JCheckBox();
        chkNombreEmpleado = new javax.swing.JCheckBox();
        chkApellidoEmpleado = new javax.swing.JCheckBox();
        chkUsuarioEmpleado = new javax.swing.JCheckBox();
        btnBuscarEmpleado = new javax.swing.JButton();
        btnReiniciarBusquedaEmpleado = new javax.swing.JButton();
        chkCargo = new javax.swing.JCheckBox();
        chkContratacion = new javax.swing.JCheckBox();
        btnGenerarReporteEmpleados = new javax.swing.JButton();
        jpOpciones2 = new javax.swing.JPanel();
        txtNombreEmpleado = new javax.swing.JTextField();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtApellidoEmpleado = new javax.swing.JTextField();
        lblApellidoEmpleado = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        lblIdEmpleado = new javax.swing.JLabel();
        lblcuenta1 = new javax.swing.JLabel();
        lblAviso1 = new javax.swing.JLabel();
        jpOpciones1 = new javax.swing.JPanel();
        btnNuevoEmpleado = new javax.swing.JButton();
        btnModificarEmpleado = new javax.swing.JButton();
        btnGuardarEmpleado = new javax.swing.JButton();
        btnRemoverEmpleado = new javax.swing.JButton();
        btnLimpiarEmpleado = new javax.swing.JButton();
        jpOpciones4 = new javax.swing.JPanel();
        txtPasswordEmpleado = new javax.swing.JPasswordField();
        lblPassword1 = new javax.swing.JLabel();
        btnVerPassword = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtUsuarioEmpleado = new javax.swing.JTextField();
        lblAviso3 = new javax.swing.JLabel();
        lblAviso4 = new javax.swing.JLabel();
        lblcuenta = new javax.swing.JLabel();
        btnGenerarPassword = new javax.swing.JButton();
        btnModificarPassword = new javax.swing.JButton();
        jpOpciones3 = new javax.swing.JPanel();
        lblAño1 = new javax.swing.JLabel();
        jsDiaContratacion = new javax.swing.JSpinner();
        lbldia1 = new javax.swing.JLabel();
        lblFechaNac1 = new javax.swing.JLabel();
        lblMes1 = new javax.swing.JLabel();
        cboMesContratacion = new javax.swing.JComboBox<>();
        jsAñoContratacion = new javax.swing.JSpinner();
        lblMes = new javax.swing.JLabel();
        cboMesNac = new javax.swing.JComboBox<>();
        jsAñoNac = new javax.swing.JSpinner();
        lblAño = new javax.swing.JLabel();
        jsDiaNac = new javax.swing.JSpinner();
        lbldia = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        cboCargo = new javax.swing.JComboBox<>();
        lblCargo = new javax.swing.JLabel();
        lblFechaNac2 = new javax.swing.JLabel();
        jpPrincipalAdmin = new javax.swing.JPanel();
        btnIrAVentas = new javax.swing.JButton();
        btnIrACompras = new javax.swing.JButton();
        btnIrAInventario = new javax.swing.JButton();
        btnIrAOrdenes = new javax.swing.JButton();
        btnIrAProveedores = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jpGestionEmpleados = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        jpVenta = new javax.swing.JPanel();
        jpVentaA = new javax.swing.JPanel();
        lblVenta1 = new javax.swing.JLabel();
        lblPecioVenta1 = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        txtIdEmpleadoVenta = new javax.swing.JTextField();
        lblPecioVenta2 = new javax.swing.JLabel();
        jpVentaB = new javax.swing.JPanel();
        lblPedidoVenta = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtPedidoVenta = new javax.swing.JTable();
        lblTotalVenta = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarProductoVenta = new javax.swing.JButton();
        btnRemoverProductoVenta = new javax.swing.JButton();
        btnConfirmarVenta = new javax.swing.JButton();
        jpGestionEmpleados1 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblCantidadVenta = new javax.swing.JLabel();
        jsCantidadVenta = new javax.swing.JSpinner();
        txtPrecioVenta = new javax.swing.JTextField();
        lblPecioVenta = new javax.swing.JLabel();
        lblVenta = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox<>();
        lblProductoVenta = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblVenta2 = new javax.swing.JLabel();
        txtIdProductoVenta = new javax.swing.JTextField();
        btnIngresarProductoVenta = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jpCompra = new javax.swing.JPanel();
        jpComprasA = new javax.swing.JPanel();
        lblSeleccion = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtCatalogo = new javax.swing.JTable();
        jpComprasB = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        txtNombreProductoCompra = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblCat = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        cboCategoriaCompra = new javax.swing.JComboBox<>();
        cboProveedorCompra = new javax.swing.JComboBox<>();
        txtFabricante = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        jsCantidadCompra = new javax.swing.JSpinner();
        jpComprasC = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtPedidoCompra = new javax.swing.JTable();
        lblPedido = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        lblTotalCompra = new javax.swing.JLabel();
        jpOpciones = new javax.swing.JPanel();
        btnRemoverProductoCompra = new javax.swing.JButton();
        btnConfirmarOrden = new javax.swing.JButton();
        btnAgregarProductoCompra = new javax.swing.JButton();
        jpGestionEmpleados6 = new javax.swing.JPanel();
        lblTitulo7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnIrACompras1 = new javax.swing.JButton();
        btnCompraIrAInventario = new javax.swing.JButton();
        btnCompraIrAProveedores = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblProducto1 = new javax.swing.JLabel();
        chkNuevoProd = new javax.swing.JCheckBox();
        chkCatalogo = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        lblProducto2 = new javax.swing.JLabel();
        lblPecioVenta3 = new javax.swing.JLabel();
        txtIdCompra = new javax.swing.JTextField();
        lblPecioVenta4 = new javax.swing.JLabel();
        txtIdEmpleadoCompra = new javax.swing.JTextField();
        jpInventario = new javax.swing.JPanel();
        jpInventarioA = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();
        lblUsuario3 = new javax.swing.JLabel();
        jpGestionEmpleados7 = new javax.swing.JPanel();
        lblTitulo8 = new javax.swing.JLabel();
        jpGestionEmpleados9 = new javax.swing.JPanel();
        chkNombreProductos = new javax.swing.JCheckBox();
        chkCategoriaProductos = new javax.swing.JCheckBox();
        chkProveedorProductos = new javax.swing.JCheckBox();
        btnBuscarProducto = new javax.swing.JButton();
        btnReiniciarBusqProducto = new javax.swing.JButton();
        lblUsuario2 = new javax.swing.JLabel();
        txtBusquedaProductos = new javax.swing.JTextField();
        chkIdProducto = new javax.swing.JCheckBox();
        chkFabricante = new javax.swing.JCheckBox();
        btnGenerarReporteProductos = new javax.swing.JButton();
        jpInventarioA1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtCategoria = new javax.swing.JTable();
        lblUsuario4 = new javax.swing.JLabel();
        jpOrden = new javax.swing.JPanel();
        jpGestionEmpleados8 = new javax.swing.JPanel();
        lblTitulo9 = new javax.swing.JLabel();
        jpGestionEmpleados12 = new javax.swing.JPanel();
        chkIdEmpleadoVenta = new javax.swing.JCheckBox();
        btnBuscarVenta = new javax.swing.JButton();
        btnReiniciarBusqVenta = new javax.swing.JButton();
        lblUsuario8 = new javax.swing.JLabel();
        txtBusquedaVenta = new javax.swing.JTextField();
        chkIdVenta = new javax.swing.JCheckBox();
        chkFechaVenta = new javax.swing.JCheckBox();
        btnGenerarReporteVentas = new javax.swing.JButton();
        jpInventarioA3 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtVenta = new javax.swing.JTable();
        lblUsuario9 = new javax.swing.JLabel();
        jpInventarioA4 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jtCompra = new javax.swing.JTable();
        lblUsuario10 = new javax.swing.JLabel();
        jpGestionEmpleados13 = new javax.swing.JPanel();
        chkIdEmpleado = new javax.swing.JCheckBox();
        btnBuscarCompra = new javax.swing.JButton();
        btnReiniciarBusqCompra = new javax.swing.JButton();
        lblUsuario11 = new javax.swing.JLabel();
        txtBusquedaCompra = new javax.swing.JTextField();
        chkIdCompra = new javax.swing.JCheckBox();
        chkFechaCompra = new javax.swing.JCheckBox();
        btnGenerarReporteCompras = new javax.swing.JButton();
        jpInventarioA5 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jtDetalleCompra = new javax.swing.JTable();
        lblUsuario12 = new javax.swing.JLabel();
        jpInventarioA6 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jtDetalleVenta = new javax.swing.JTable();
        lblUsuario13 = new javax.swing.JLabel();
        jpProveedores = new javax.swing.JPanel();
        jpGestionEmpleados10 = new javax.swing.JPanel();
        lblTitulo10 = new javax.swing.JLabel();
        jpInventarioA2 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtProveedor = new javax.swing.JTable();
        lblUsuario5 = new javax.swing.JLabel();
        jpGestionEmpleados11 = new javax.swing.JPanel();
        chkNombreProveedor = new javax.swing.JCheckBox();
        btnBuscarProveedor = new javax.swing.JButton();
        btnReiniciarBusqProveedor = new javax.swing.JButton();
        lblUsuario6 = new javax.swing.JLabel();
        txtBusquedaProveedor = new javax.swing.JTextField();
        chkIdProveedor = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        lblUsuario7 = new javax.swing.JLabel();
        lblNombreEmpleado1 = new javax.swing.JLabel();
        txtNuevoProveedor = new javax.swing.JTextField();
        btnRegistrarProveedor = new javax.swing.JButton();
        jpInventarioA7 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jtProductoProveedor = new javax.swing.JTable();
        lblUsuario15 = new javax.swing.JLabel();
        jpHeader = new javax.swing.JPanel();
        lblUsuario14 = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        jpHome = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lnlUsuario1 = new javax.swing.JLabel();
        jpSalir = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jpUsuario = new javax.swing.JPanel();
        lnlUsuario2 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Farmacia");
        setUndecorated(true);
        setResizable(false);

        jtpPrincipal.setBackground(new java.awt.Color(251, 251, 251));
        jtpPrincipal.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jpInicio.setBackground(new java.awt.Color(251, 251, 251));

        jpLogIn.setBackground(new java.awt.Color(226, 226, 226));

        jpIniciar.setBackground(new java.awt.Color(252, 252, 252));

        lnlUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lnlUsuario.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setPreferredSize(new java.awt.Dimension(6, 28));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPassword.setText("Contraseña:");

        txtPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setEchoChar('•');
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(0, 102, 102));
        btnIngresar.setText("Ingresar");
        btnIngresar.setToolTipText("");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar.setFocusPainted(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        lblIniciar.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblIniciar.setText("Inicio de sesión");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img.jpeg"))); // NOI18N

        lblAvisoInicio.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblAvisoInicio.setForeground(new java.awt.Color(204, 0, 51));
        lblAvisoInicio.setText("        ");

        javax.swing.GroupLayout jpIniciarLayout = new javax.swing.GroupLayout(jpIniciar);
        jpIniciar.setLayout(jpIniciarLayout);
        jpIniciarLayout.setHorizontalGroup(
            jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIniciarLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIniciarLayout.createSequentialGroup()
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIniciarLayout.createSequentialGroup()
                        .addGroup(jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAvisoInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIniciarLayout.createSequentialGroup()
                                .addGroup(jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpIniciarLayout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(lblPassword))
                                            .addGroup(jpIniciarLayout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(lnlUsuario))
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(26, 26, 26)))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIniciarLayout.createSequentialGroup()
                        .addComponent(lblIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
        );
        jpIniciarLayout.setVerticalGroup(
            jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIniciarLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(lblIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAvisoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jpIniciarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtPassword, txtUsuario});

        javax.swing.GroupLayout jpLogInLayout = new javax.swing.GroupLayout(jpLogIn);
        jpLogIn.setLayout(jpLogInLayout);
        jpLogInLayout.setHorizontalGroup(
            jpLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogInLayout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jpIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(417, Short.MAX_VALUE))
        );
        jpLogInLayout.setVerticalGroup(
            jpLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLogInLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jpIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout jpInicioLayout = new javax.swing.GroupLayout(jpInicio);
        jpInicio.setLayout(jpInicioLayout);
        jpInicioLayout.setHorizontalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpInicioLayout.setVerticalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpPrincipal.addTab("Inicio", jpInicio);

        jpEmpleado.setBackground(new java.awt.Color(251, 251, 251));

        jpEmpleadotabla.setBackground(new java.awt.Color(226, 226, 226));

        jtEmpleado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID empleado", "Usuario", "Nombre", "Apellido", "Fec. nacimiento", "Fec. contratación", "Salario", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtEmpleado.setFocusable(false);
        jtEmpleado.setName(""); // NOI18N
        jtEmpleado.setRowHeight(30);
        jtEmpleado.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jtEmpleado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtEmpleado.getTableHeader().setReorderingAllowed(false);
        jtEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtEmpleado);
        if (jtEmpleado.getColumnModel().getColumnCount() > 0) {
            jtEmpleado.getColumnModel().getColumn(0).setResizable(false);
            jtEmpleado.getColumnModel().getColumn(1).setResizable(false);
            jtEmpleado.getColumnModel().getColumn(2).setResizable(false);
            jtEmpleado.getColumnModel().getColumn(3).setResizable(false);
            jtEmpleado.getColumnModel().getColumn(4).setResizable(false);
            jtEmpleado.getColumnModel().getColumn(5).setResizable(false);
            jtEmpleado.getColumnModel().getColumn(6).setResizable(false);
            jtEmpleado.getColumnModel().getColumn(7).setResizable(false);
        }

        lblUsuario1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario1.setText("Búsqueda por:");

        txtBusquedaEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBusquedaEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusquedaEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaEmpleadoKeyReleased(evt);
            }
        });

        chkId_empleado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(chkId_empleado);
        chkId_empleado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkId_empleado.setSelected(true);
        chkId_empleado.setText("ID");
        chkId_empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkId_empleado.setFocusable(false);

        chkNombreEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(chkNombreEmpleado);
        chkNombreEmpleado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkNombreEmpleado.setText("Nombre");
        chkNombreEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkNombreEmpleado.setFocusable(false);

        chkApellidoEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(chkApellidoEmpleado);
        chkApellidoEmpleado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkApellidoEmpleado.setText("Apellido");
        chkApellidoEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkApellidoEmpleado.setFocusable(false);

        chkUsuarioEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(chkUsuarioEmpleado);
        chkUsuarioEmpleado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkUsuarioEmpleado.setText("Usuario");
        chkUsuarioEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkUsuarioEmpleado.setFocusable(false);

        btnBuscarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBuscarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        btnBuscarEmpleado.setToolTipText("Buscar");
        btnBuscarEmpleado.setBorderPainted(false);
        btnBuscarEmpleado.setContentAreaFilled(false);
        btnBuscarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarEmpleado.setFocusable(false);
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        btnReiniciarBusquedaEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        btnReiniciarBusquedaEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnReiniciarBusquedaEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/reset.png"))); // NOI18N
        btnReiniciarBusquedaEmpleado.setToolTipText("Reiniciar búsqueda");
        btnReiniciarBusquedaEmpleado.setBorderPainted(false);
        btnReiniciarBusquedaEmpleado.setContentAreaFilled(false);
        btnReiniciarBusquedaEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReiniciarBusquedaEmpleado.setFocusable(false);
        btnReiniciarBusquedaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarBusquedaEmpleadoActionPerformed(evt);
            }
        });

        chkCargo.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(chkCargo);
        chkCargo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkCargo.setText("ID Cargo");
        chkCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkCargo.setFocusable(false);

        chkContratacion.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(chkContratacion);
        chkContratacion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkContratacion.setText("Contratación (YYYY-MM-dd)");
        chkContratacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkContratacion.setFocusable(false);

        btnGenerarReporteEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteEmpleados.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btnGenerarReporteEmpleados.setForeground(new java.awt.Color(204, 0, 51));
        btnGenerarReporteEmpleados.setText("Generar reporte");
        btnGenerarReporteEmpleados.setToolTipText("");
        btnGenerarReporteEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporteEmpleados.setFocusPainted(false);
        btnGenerarReporteEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteEmpleadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEmpleadotablaLayout = new javax.swing.GroupLayout(jpEmpleadotabla);
        jpEmpleadotabla.setLayout(jpEmpleadotablaLayout);
        jpEmpleadotablaLayout.setHorizontalGroup(
            jpEmpleadotablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpleadotablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEmpleadotablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(jpEmpleadotablaLayout.createSequentialGroup()
                        .addComponent(lblUsuario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkId_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(chkNombreEmpleado)
                        .addGap(6, 6, 6)
                        .addComponent(chkApellidoEmpleado)
                        .addGap(6, 6, 6)
                        .addComponent(chkUsuarioEmpleado)
                        .addGap(6, 6, 6)
                        .addComponent(chkCargo)
                        .addGap(10, 10, 10)
                        .addComponent(chkContratacion)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusquedaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReiniciarBusquedaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnGenerarReporteEmpleados)))
                .addContainerGap())
        );
        jpEmpleadotablaLayout.setVerticalGroup(
            jpEmpleadotablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpleadotablaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jpEmpleadotablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEmpleadotablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkId_empleado)
                        .addComponent(chkNombreEmpleado)
                        .addComponent(chkApellidoEmpleado)
                        .addComponent(chkUsuarioEmpleado)
                        .addComponent(chkCargo)
                        .addComponent(chkContratacion)
                        .addComponent(txtBusquedaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReiniciarBusquedaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarReporteEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpOpciones2.setBackground(new java.awt.Color(226, 226, 226));

        txtNombreEmpleado.setEditable(false);
        txtNombreEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreEmpleadoKeyReleased(evt);
            }
        });

        lblNombreEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNombreEmpleado.setText("Nombre:");

        txtApellidoEmpleado.setEditable(false);
        txtApellidoEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtApellidoEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoEmpleadoKeyReleased(evt);
            }
        });

        lblApellidoEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblApellidoEmpleado.setText("Apellido:");

        lblAviso.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(0, 51, 102));
        lblAviso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAviso.setText("Ingresar entre 4 y 20 caracteres");
        lblAviso.setToolTipText("");
        lblAviso.setPreferredSize(new java.awt.Dimension(24, 18));

        txtIdEmpleado.setEditable(false);
        txtIdEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIdEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblIdEmpleado.setForeground(new java.awt.Color(0, 102, 51));
        lblIdEmpleado.setText("Identificación:");
        lblIdEmpleado.setToolTipText("");

        lblcuenta1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblcuenta1.setForeground(new java.awt.Color(0, 102, 51));
        lblcuenta1.setText("Nombre completo:");

        lblAviso1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblAviso1.setForeground(new java.awt.Color(0, 51, 102));
        lblAviso1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAviso1.setText("Ingresar entre 4 y 20 caracteres");
        lblAviso1.setToolTipText("");
        lblAviso1.setPreferredSize(new java.awt.Dimension(24, 18));

        javax.swing.GroupLayout jpOpciones2Layout = new javax.swing.GroupLayout(jpOpciones2);
        jpOpciones2.setLayout(jpOpciones2Layout);
        jpOpciones2Layout.setHorizontalGroup(
            jpOpciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpciones2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jpOpciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAviso1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcuenta1)
                    .addGroup(jpOpciones2Layout.createSequentialGroup()
                        .addComponent(lblIdEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpOpciones2Layout.createSequentialGroup()
                        .addComponent(lblNombreEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpOpciones2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jpOpciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpOpciones2Layout.createSequentialGroup()
                                .addComponent(lblApellidoEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jpOpciones2Layout.setVerticalGroup(
            jpOpciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpciones2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpOpciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblcuenta1)
                .addGap(18, 18, 18)
                .addGroup(jpOpciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAviso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOpciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidoEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jpOpciones1.setBackground(new java.awt.Color(226, 226, 226));

        btnNuevoEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnNuevoEmpleado.setText("Nuevo registro");
        btnNuevoEmpleado.setToolTipText("");
        btnNuevoEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevoEmpleado.setFocusPainted(false);
        btnNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpleadoActionPerformed(evt);
            }
        });

        btnModificarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnModificarEmpleado.setText("Modificar registro");
        btnModificarEmpleado.setToolTipText("");
        btnModificarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificarEmpleado.setEnabled(false);
        btnModificarEmpleado.setFocusPainted(false);
        btnModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpleadoActionPerformed(evt);
            }
        });

        btnGuardarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnGuardarEmpleado.setForeground(new java.awt.Color(0, 102, 102));
        btnGuardarEmpleado.setText("Guardar registro");
        btnGuardarEmpleado.setToolTipText("");
        btnGuardarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarEmpleado.setEnabled(false);
        btnGuardarEmpleado.setFocusPainted(false);
        btnGuardarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEmpleadoActionPerformed(evt);
            }
        });

        btnRemoverEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoverEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnRemoverEmpleado.setForeground(new java.awt.Color(204, 0, 51));
        btnRemoverEmpleado.setText("Remover registro");
        btnRemoverEmpleado.setToolTipText("");
        btnRemoverEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRemoverEmpleado.setEnabled(false);
        btnRemoverEmpleado.setFocusPainted(false);
        btnRemoverEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverEmpleadoActionPerformed(evt);
            }
        });

        btnLimpiarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnLimpiarEmpleado.setForeground(new java.awt.Color(51, 51, 51));
        btnLimpiarEmpleado.setText("Limpiar campos");
        btnLimpiarEmpleado.setToolTipText("");
        btnLimpiarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarEmpleado.setFocusPainted(false);
        btnLimpiarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOpciones1Layout = new javax.swing.GroupLayout(jpOpciones1);
        jpOpciones1.setLayout(jpOpciones1Layout);
        jpOpciones1Layout.setHorizontalGroup(
            jpOpciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpciones1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemoverEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpOpciones1Layout.setVerticalGroup(
            jpOpciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpciones1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOpciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpOpciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnModificarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(btnNuevoEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpOpciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRemoverEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(btnLimpiarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpOpciones4.setBackground(new java.awt.Color(226, 226, 226));

        txtPasswordEmpleado.setEditable(false);
        txtPasswordEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPasswordEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPasswordEmpleado.setEchoChar('•');
        txtPasswordEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordEmpleadoKeyReleased(evt);
            }
        });

        lblPassword1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPassword1.setText("Password:");

        btnVerPassword.setBackground(new java.awt.Color(255, 255, 255));
        btnVerPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnVerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/password.png"))); // NOI18N
        btnVerPassword.setToolTipText("Mostrar/ocultar contraseña actual");
        btnVerPassword.setBorderPainted(false);
        btnVerPassword.setContentAreaFilled(false);
        btnVerPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVerPassword.setEnabled(false);
        btnVerPassword.setFocusable(false);
        btnVerPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPasswordActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario:");

        txtUsuarioEmpleado.setEditable(false);
        txtUsuarioEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtUsuarioEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuarioEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioEmpleadoKeyReleased(evt);
            }
        });

        lblAviso3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblAviso3.setForeground(new java.awt.Color(0, 51, 102));
        lblAviso3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAviso3.setText("Ingresar 10 caracteres");
        lblAviso3.setToolTipText("");
        lblAviso3.setPreferredSize(new java.awt.Dimension(24, 18));

        lblAviso4.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblAviso4.setForeground(new java.awt.Color(0, 51, 102));
        lblAviso4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAviso4.setText("Ingrese entre 8 y 16 caracteres");
        lblAviso4.setToolTipText("");
        lblAviso4.setPreferredSize(new java.awt.Dimension(24, 18));

        lblcuenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblcuenta.setForeground(new java.awt.Color(0, 102, 51));
        lblcuenta.setText("Cuenta de empleado:");

        btnGenerarPassword.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnGenerarPassword.setForeground(new java.awt.Color(51, 51, 51));
        btnGenerarPassword.setText("Nueva password");
        btnGenerarPassword.setToolTipText("");
        btnGenerarPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarPassword.setEnabled(false);
        btnGenerarPassword.setFocusPainted(false);
        btnGenerarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPasswordActionPerformed(evt);
            }
        });

        btnModificarPassword.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarPassword.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btnModificarPassword.setForeground(new java.awt.Color(204, 0, 51));
        btnModificarPassword.setText("Modificar y crear nueva password");
        btnModificarPassword.setToolTipText("Elimina la password actual y asigna una nueva");
        btnModificarPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificarPassword.setEnabled(false);
        btnModificarPassword.setFocusPainted(false);
        btnModificarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOpciones4Layout = new javax.swing.GroupLayout(jpOpciones4);
        jpOpciones4.setLayout(jpOpciones4Layout);
        jpOpciones4Layout.setHorizontalGroup(
            jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpciones4Layout.createSequentialGroup()
                .addGroup(jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOpciones4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblcuenta))
                    .addGroup(jpOpciones4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpOpciones4Layout.createSequentialGroup()
                                .addComponent(lblPassword1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAviso4, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(btnModificarPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGenerarPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtPasswordEmpleado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOpciones4Layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAviso3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jpOpciones4Layout.setVerticalGroup(
            jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOpciones4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblcuenta)
                .addGap(18, 18, 18)
                .addGroup(jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAviso3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnGenerarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOpciones4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPasswordEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAviso4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpOpciones3.setBackground(new java.awt.Color(226, 226, 226));

        lblAño1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblAño1.setText("Año:");

        jsDiaContratacion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jsDiaContratacion.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        jsDiaContratacion.setEnabled(false);

        lbldia1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbldia1.setText("Día:");

        lblFechaNac1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblFechaNac1.setForeground(new java.awt.Color(0, 102, 51));
        lblFechaNac1.setText("Fecha de contratación:");

        lblMes1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMes1.setText("Mes:");

        cboMesContratacion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cboMesContratacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cboMesContratacion.setEnabled(false);
        cboMesContratacion.setFocusable(false);

        jsAñoContratacion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jsAñoContratacion.setModel(new javax.swing.SpinnerNumberModel(1980, 1950, 2050, 1));
        jsAñoContratacion.setEnabled(false);

        lblMes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMes.setText("Mes:");

        cboMesNac.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cboMesNac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cboMesNac.setEnabled(false);
        cboMesNac.setFocusable(false);

        jsAñoNac.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jsAñoNac.setModel(new javax.swing.SpinnerNumberModel(1980, 1950, 2050, 1));
        jsAñoNac.setEnabled(false);

        lblAño.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblAño.setText("Año:");

        jsDiaNac.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jsDiaNac.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        jsDiaNac.setEnabled(false);

        lbldia.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbldia.setText("Día:");

        lblFechaNac.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblFechaNac.setForeground(new java.awt.Color(0, 102, 51));
        lblFechaNac.setText("Fecha de nacimiento:");

        lblSalario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSalario.setText("Salario (USD):");

        txtSalario.setEditable(false);
        txtSalario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSalario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalarioKeyReleased(evt);
            }
        });

        cboCargo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administracion", "Ventas", "Compras" }));
        cboCargo.setEnabled(false);
        cboCargo.setFocusable(false);

        lblCargo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblCargo.setText("Cargo:");

        lblFechaNac2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblFechaNac2.setForeground(new java.awt.Color(0, 102, 51));
        lblFechaNac2.setText("Posición:");

        javax.swing.GroupLayout jpOpciones3Layout = new javax.swing.GroupLayout(jpOpciones3);
        jpOpciones3.setLayout(jpOpciones3Layout);
        jpOpciones3Layout.setHorizontalGroup(
            jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpciones3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOpciones3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalario))
                    .addGroup(jpOpciones3Layout.createSequentialGroup()
                        .addComponent(lblFechaNac1)
                        .addGap(271, 271, 271))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOpciones3Layout.createSequentialGroup()
                        .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpOpciones3Layout.createSequentialGroup()
                                .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFechaNac, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaNac2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpOpciones3Layout.createSequentialGroup()
                                .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jpOpciones3Layout.createSequentialGroup()
                                        .addComponent(lbldia1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jsDiaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblMes1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboMesContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpOpciones3Layout.createSequentialGroup()
                                        .addComponent(lbldia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jsDiaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(lblMes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboMesNac, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpOpciones3Layout.createSequentialGroup()
                                        .addComponent(lblAño)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jsAñoNac, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpOpciones3Layout.createSequentialGroup()
                                        .addComponent(lblAño1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jsAñoContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                        .addGap(41, 41, 41))))
        );
        jpOpciones3Layout.setVerticalGroup(
            jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpciones3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblFechaNac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsDiaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldia)
                    .addComponent(cboMesNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMes)
                    .addComponent(lblAño)
                    .addComponent(jsAñoNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lblFechaNac1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsDiaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldia1)
                    .addComponent(cboMesContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMes1)
                    .addComponent(lblAño1)
                    .addComponent(jsAñoContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblFechaNac2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSalario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpOpciones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCargo)))
                .addGap(19, 19, 19))
        );

        jpPrincipalAdmin.setBackground(new java.awt.Color(226, 226, 226));

        btnIrAVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnIrAVentas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnIrAVentas.setForeground(new java.awt.Color(0, 102, 102));
        btnIrAVentas.setText("Nueva venta");
        btnIrAVentas.setToolTipText("");
        btnIrAVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIrAVentas.setFocusPainted(false);
        btnIrAVentas.setFocusable(false);
        btnIrAVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAVentasActionPerformed(evt);
            }
        });

        btnIrACompras.setBackground(new java.awt.Color(255, 255, 255));
        btnIrACompras.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnIrACompras.setForeground(new java.awt.Color(0, 102, 102));
        btnIrACompras.setText("Nueva compra");
        btnIrACompras.setToolTipText("");
        btnIrACompras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIrACompras.setFocusPainted(false);
        btnIrACompras.setFocusable(false);
        btnIrACompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAComprasActionPerformed(evt);
            }
        });

        btnIrAInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnIrAInventario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnIrAInventario.setForeground(new java.awt.Color(0, 102, 102));
        btnIrAInventario.setText("Inventario");
        btnIrAInventario.setToolTipText("");
        btnIrAInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIrAInventario.setFocusPainted(false);
        btnIrAInventario.setFocusable(false);
        btnIrAInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAInventarioActionPerformed(evt);
            }
        });

        btnIrAOrdenes.setBackground(new java.awt.Color(255, 255, 255));
        btnIrAOrdenes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnIrAOrdenes.setForeground(new java.awt.Color(0, 102, 102));
        btnIrAOrdenes.setText("Ordenes");
        btnIrAOrdenes.setToolTipText("");
        btnIrAOrdenes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIrAOrdenes.setFocusPainted(false);
        btnIrAOrdenes.setFocusable(false);
        btnIrAOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAOrdenesActionPerformed(evt);
            }
        });

        btnIrAProveedores.setBackground(new java.awt.Color(255, 255, 255));
        btnIrAProveedores.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnIrAProveedores.setForeground(new java.awt.Color(0, 102, 102));
        btnIrAProveedores.setText("Proveedores");
        btnIrAProveedores.setToolTipText("");
        btnIrAProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIrAProveedores.setFocusPainted(false);
        btnIrAProveedores.setFocusable(false);
        btnIrAProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalAdminLayout = new javax.swing.GroupLayout(jpPrincipalAdmin);
        jpPrincipalAdmin.setLayout(jpPrincipalAdminLayout);
        jpPrincipalAdminLayout.setHorizontalGroup(
            jpPrincipalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIrACompras, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(btnIrAVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIrAProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIrAInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIrAOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPrincipalAdminLayout.setVerticalGroup(
            jpPrincipalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIrAVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIrACompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIrAInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIrAOrdenes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIrAProveedores)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jpPrincipalAdminLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnIrACompras, btnIrAInventario, btnIrAOrdenes, btnIrAProveedores, btnIrAVentas});

        jPanel1.setBackground(new java.awt.Color(226, 226, 226));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        lblTitulo1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Panel de administración: Gestión de empleados");

        javax.swing.GroupLayout jpGestionEmpleadosLayout = new javax.swing.GroupLayout(jpGestionEmpleados);
        jpGestionEmpleados.setLayout(jpGestionEmpleadosLayout);
        jpGestionEmpleadosLayout.setHorizontalGroup(
            jpGestionEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpGestionEmpleadosLayout.setVerticalGroup(
            jpGestionEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jpEmpleadoLayout = new javax.swing.GroupLayout(jpEmpleado);
        jpEmpleado.setLayout(jpEmpleadoLayout);
        jpEmpleadoLayout.setHorizontalGroup(
            jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEmpleadoLayout.createSequentialGroup()
                        .addComponent(jpGestionEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEmpleadoLayout.createSequentialGroup()
                        .addComponent(jpOpciones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpOpciones3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpOpciones4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEmpleadoLayout.createSequentialGroup()
                        .addGroup(jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEmpleadoLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jpOpciones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpEmpleadoLayout.createSequentialGroup()
                                .addComponent(jpPrincipalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpEmpleadotabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
        );
        jpEmpleadoLayout.setVerticalGroup(
            jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpGestionEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpEmpleadotabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPrincipalAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpOpciones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpOpciones2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpOpciones3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpOpciones4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtpPrincipal.addTab("Adm Empleados", jpEmpleado);

        jpVenta.setBackground(new java.awt.Color(251, 251, 251));

        jpVentaA.setBackground(new java.awt.Color(226, 226, 226));

        lblVenta1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblVenta1.setForeground(new java.awt.Color(0, 102, 102));
        lblVenta1.setText("Nueva venta:");

        lblPecioVenta1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPecioVenta1.setText("ID Venta:");

        txtIdVenta.setEditable(false);
        txtIdVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIdVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdVenta.setDisabledTextColor(new java.awt.Color(0, 102, 0));

        txtIdEmpleadoVenta.setEditable(false);
        txtIdEmpleadoVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIdEmpleadoVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdEmpleadoVenta.setDisabledTextColor(new java.awt.Color(0, 102, 0));

        lblPecioVenta2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPecioVenta2.setText("ID Empleado:");

        javax.swing.GroupLayout jpVentaALayout = new javax.swing.GroupLayout(jpVentaA);
        jpVentaA.setLayout(jpVentaALayout);
        jpVentaALayout.setHorizontalGroup(
            jpVentaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaALayout.createSequentialGroup()
                .addGroup(jpVentaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVentaALayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVenta1))
                    .addGroup(jpVentaALayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpVentaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpVentaALayout.createSequentialGroup()
                                .addComponent(lblPecioVenta2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdEmpleadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpVentaALayout.createSequentialGroup()
                                .addComponent(lblPecioVenta1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jpVentaALayout.setVerticalGroup(
            jpVentaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVentaALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVenta1)
                .addGap(18, 18, 18)
                .addGroup(jpVentaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPecioVenta1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jpVentaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdEmpleadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPecioVenta2))
                .addGap(20, 20, 20))
        );

        jpVentaB.setBackground(new java.awt.Color(226, 226, 226));

        lblPedidoVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPedidoVenta.setForeground(new java.awt.Color(0, 102, 102));
        lblPedidoVenta.setText("Orden actual:");

        jtPedidoVenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtPedidoVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Precio unitario", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPedidoVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtPedidoVenta.setFocusable(false);
        jtPedidoVenta.setName(""); // NOI18N
        jtPedidoVenta.setRowHeight(30);
        jtPedidoVenta.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jtPedidoVenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtPedidoVenta.getTableHeader().setReorderingAllowed(false);
        jtPedidoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPedidoVentaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtPedidoVenta);
        if (jtPedidoVenta.getColumnModel().getColumnCount() > 0) {
            jtPedidoVenta.getColumnModel().getColumn(0).setResizable(false);
            jtPedidoVenta.getColumnModel().getColumn(1).setResizable(false);
            jtPedidoVenta.getColumnModel().getColumn(2).setResizable(false);
            jtPedidoVenta.getColumnModel().getColumn(3).setResizable(false);
            jtPedidoVenta.getColumnModel().getColumn(4).setResizable(false);
        }

        lblTotalVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTotalVenta.setText("Total final:");

        txtTotalVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTotalVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalVenta.setText("$ 0.00");
        txtTotalVenta.setDisabledTextColor(new java.awt.Color(204, 0, 51));
        txtTotalVenta.setEnabled(false);

        javax.swing.GroupLayout jpVentaBLayout = new javax.swing.GroupLayout(jpVentaB);
        jpVentaB.setLayout(jpVentaBLayout);
        jpVentaBLayout.setHorizontalGroup(
            jpVentaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVentaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jpVentaBLayout.createSequentialGroup()
                        .addComponent(lblPedidoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpVentaBLayout.createSequentialGroup()
                        .addComponent(lblTotalVenta)
                        .addGap(4, 4, 4)
                        .addComponent(txtTotalVenta)))
                .addContainerGap())
        );
        jpVentaBLayout.setVerticalGroup(
            jpVentaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPedidoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpVentaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalVenta))
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(226, 226, 226));

        btnAgregarProductoVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarProductoVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAgregarProductoVenta.setForeground(new java.awt.Color(0, 102, 102));
        btnAgregarProductoVenta.setText("Agregar producto");
        btnAgregarProductoVenta.setToolTipText("");
        btnAgregarProductoVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarProductoVenta.setFocusable(false);
        btnAgregarProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoVentaActionPerformed(evt);
            }
        });

        btnRemoverProductoVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoverProductoVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnRemoverProductoVenta.setForeground(new java.awt.Color(204, 0, 51));
        btnRemoverProductoVenta.setText("Remover producto");
        btnRemoverProductoVenta.setToolTipText("");
        btnRemoverProductoVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRemoverProductoVenta.setEnabled(false);
        btnRemoverProductoVenta.setFocusable(false);
        btnRemoverProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverProductoVentaActionPerformed(evt);
            }
        });

        btnConfirmarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnConfirmarVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnConfirmarVenta.setText("Confirmar venta");
        btnConfirmarVenta.setToolTipText("");
        btnConfirmarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConfirmarVenta.setEnabled(false);
        btnConfirmarVenta.setFocusable(false);
        btnConfirmarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarProductoVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAgregarProductoVenta, btnConfirmarVenta, btnRemoverProductoVenta});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemoverProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmarVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAgregarProductoVenta, btnConfirmarVenta, btnRemoverProductoVenta});

        lblTitulo2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Registro de ventas: Nueva venta");

        javax.swing.GroupLayout jpGestionEmpleados1Layout = new javax.swing.GroupLayout(jpGestionEmpleados1);
        jpGestionEmpleados1.setLayout(jpGestionEmpleados1Layout);
        jpGestionEmpleados1Layout.setHorizontalGroup(
            jpGestionEmpleados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpGestionEmpleados1Layout.setVerticalGroup(
            jpGestionEmpleados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(226, 226, 226));

        lblCantidadVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblCantidadVenta.setText("Cantidad:");
        lblCantidadVenta.setToolTipText("");

        jsCantidadVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jsCantidadVenta.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVenta.setDisabledTextColor(new java.awt.Color(0, 102, 0));

        lblPecioVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPecioVenta.setText("Precio:");

        lblVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblVenta.setForeground(new java.awt.Color(0, 102, 102));
        lblVenta.setText("Ingreso de productos:");

        cboProducto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cboProducto.setFocusable(false);
        cboProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProductoItemStateChanged(evt);
            }
        });

        lblProductoVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProductoVenta.setText("Producto:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVenta))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblProductoVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblPecioVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCantidadVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVenta)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductoVenta))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadVenta)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPecioVenta))
                .addGap(34, 34, 34))
        );

        lblVenta2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblVenta2.setForeground(new java.awt.Color(0, 102, 102));
        lblVenta2.setText("Ingreso por ID:");

        txtIdProductoVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIdProductoVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdProductoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdProductoVentaKeyReleased(evt);
            }
        });

        btnIngresarProductoVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresarProductoVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnIngresarProductoVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        btnIngresarProductoVenta.setToolTipText("Buscar");
        btnIngresarProductoVenta.setBorderPainted(false);
        btnIngresarProductoVenta.setContentAreaFilled(false);
        btnIngresarProductoVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresarProductoVenta.setFocusable(false);
        btnIngresarProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarProductoVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVenta2)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtIdProductoVenta)
                .addGap(10, 10, 10)
                .addComponent(btnIngresarProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVenta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIngresarProductoVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpVentaLayout = new javax.swing.GroupLayout(jpVenta);
        jpVenta.setLayout(jpVentaLayout);
        jpVentaLayout.setHorizontalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpVentaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpVentaLayout.createSequentialGroup()
                        .addComponent(jpVentaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpGestionEmpleados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpVentaLayout.setVerticalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpGestionEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVentaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jpVentaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpVentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpVentaLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpVentaB, javax.swing.GroupLayout.PREFERRED_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpPrincipal.addTab("Venta", jpVenta);

        jpCompra.setBackground(new java.awt.Color(251, 251, 251));

        jpComprasA.setBackground(new java.awt.Color(226, 226, 226));

        lblSeleccion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSeleccion.setForeground(new java.awt.Color(0, 102, 51));
        lblSeleccion.setText("Catálogo de productos:");

        jtCatalogo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Fabricante", "Proveedor", "Categoria", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCatalogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCatalogo.setFocusable(false);
        jtCatalogo.setName(""); // NOI18N
        jtCatalogo.setRowHeight(30);
        jtCatalogo.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jtCatalogo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtCatalogo.getTableHeader().setReorderingAllowed(false);
        jtCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCatalogoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtCatalogo);
        if (jtCatalogo.getColumnModel().getColumnCount() > 0) {
            jtCatalogo.getColumnModel().getColumn(0).setResizable(false);
            jtCatalogo.getColumnModel().getColumn(1).setResizable(false);
            jtCatalogo.getColumnModel().getColumn(2).setResizable(false);
            jtCatalogo.getColumnModel().getColumn(3).setResizable(false);
            jtCatalogo.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jpComprasALayout = new javax.swing.GroupLayout(jpComprasA);
        jpComprasA.setLayout(jpComprasALayout);
        jpComprasALayout.setHorizontalGroup(
            jpComprasALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComprasALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComprasALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpComprasALayout.createSequentialGroup()
                        .addComponent(lblSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpComprasALayout.setVerticalGroup(
            jpComprasALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpComprasALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpComprasB.setBackground(new java.awt.Color(226, 226, 226));

        lblProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProducto.setForeground(new java.awt.Color(0, 102, 102));
        lblProducto.setText("Producto:");

        txtNombreProductoCompra.setEditable(false);
        txtNombreProductoCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreProductoCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreProductoCompra.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtNombreProductoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProductoCompraKeyReleased(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        lblCat.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblCat.setText("Categoria:");

        lblNombre1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNombre1.setText("Proveedor:");

        cboCategoriaCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cboCategoriaCompra.setEnabled(false);
        cboCategoriaCompra.setFocusable(false);

        cboProveedorCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cboProveedorCompra.setEnabled(false);
        cboProveedorCompra.setFocusable(false);

        txtFabricante.setEditable(false);
        txtFabricante.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtFabricante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFabricante.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFabricanteKeyReleased(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNombre2.setText("Fabricante:");

        txtPrecioCompra.setEditable(false);
        txtPrecioCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioCompra.setDisabledTextColor(new java.awt.Color(0, 102, 51));
        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyReleased(evt);
            }
        });

        lblPrecio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPrecio.setText("Precio (USD):");

        lblCantidad.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblCantidad.setText("Cantidad:");
        lblCantidad.setToolTipText("");

        jsCantidadCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jsCantidadCompra.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        javax.swing.GroupLayout jpComprasBLayout = new javax.swing.GroupLayout(jpComprasB);
        jpComprasB.setLayout(jpComprasBLayout);
        jpComprasBLayout.setHorizontalGroup(
            jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComprasBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpComprasBLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpComprasBLayout.createSequentialGroup()
                        .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre2)
                            .addComponent(lblNombre1)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpComprasBLayout.createSequentialGroup()
                                .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCantidad)
                                    .addGroup(jpComprasBLayout.createSequentialGroup()
                                        .addComponent(cboProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblPrecio)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jsCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioCompra)))
                            .addComponent(txtNombreProductoCompra)
                            .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpComprasBLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCategoriaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jpComprasBLayout.setVerticalGroup(
            jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComprasBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre2)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre1)
                    .addComponent(cboProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jpComprasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoriaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCat)
                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpComprasC.setBackground(new java.awt.Color(226, 226, 226));

        jtPedidoCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtPedidoCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Fabricante", "Proveedor", "Categoría", "Precio unitario", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPedidoCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtPedidoCompra.setFocusable(false);
        jtPedidoCompra.setName(""); // NOI18N
        jtPedidoCompra.setRowHeight(30);
        jtPedidoCompra.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jtPedidoCompra.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtPedidoCompra.getTableHeader().setReorderingAllowed(false);
        jtPedidoCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPedidoCompraMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtPedidoCompra);
        if (jtPedidoCompra.getColumnModel().getColumnCount() > 0) {
            jtPedidoCompra.getColumnModel().getColumn(0).setResizable(false);
            jtPedidoCompra.getColumnModel().getColumn(1).setResizable(false);
            jtPedidoCompra.getColumnModel().getColumn(2).setResizable(false);
            jtPedidoCompra.getColumnModel().getColumn(3).setResizable(false);
            jtPedidoCompra.getColumnModel().getColumn(4).setResizable(false);
            jtPedidoCompra.getColumnModel().getColumn(5).setResizable(false);
            jtPedidoCompra.getColumnModel().getColumn(6).setResizable(false);
        }

        lblPedido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPedido.setForeground(new java.awt.Color(0, 102, 102));
        lblPedido.setText("Orden actual:");

        txtTotalCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompra.setText("$ 0.00");
        txtTotalCompra.setDisabledTextColor(new java.awt.Color(204, 0, 51));
        txtTotalCompra.setEnabled(false);

        lblTotalCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTotalCompra.setText("Total:");

        javax.swing.GroupLayout jpComprasCLayout = new javax.swing.GroupLayout(jpComprasC);
        jpComprasC.setLayout(jpComprasCLayout);
        jpComprasCLayout.setHorizontalGroup(
            jpComprasCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpComprasCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComprasCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpComprasCLayout.createSequentialGroup()
                        .addComponent(lblPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpComprasCLayout.createSequentialGroup()
                        .addComponent(lblTotalCompra)
                        .addGap(4, 4, 4)
                        .addComponent(txtTotalCompra)))
                .addContainerGap())
        );
        jpComprasCLayout.setVerticalGroup(
            jpComprasCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComprasCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpComprasCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalCompra))
                .addContainerGap())
        );

        jpOpciones.setBackground(new java.awt.Color(226, 226, 226));

        btnRemoverProductoCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoverProductoCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnRemoverProductoCompra.setForeground(new java.awt.Color(204, 0, 51));
        btnRemoverProductoCompra.setText("Remover producto");
        btnRemoverProductoCompra.setToolTipText("");
        btnRemoverProductoCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRemoverProductoCompra.setEnabled(false);
        btnRemoverProductoCompra.setFocusable(false);
        btnRemoverProductoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverProductoCompraActionPerformed(evt);
            }
        });

        btnConfirmarOrden.setBackground(new java.awt.Color(255, 255, 255));
        btnConfirmarOrden.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnConfirmarOrden.setText("Confirmar compra");
        btnConfirmarOrden.setToolTipText("");
        btnConfirmarOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConfirmarOrden.setEnabled(false);
        btnConfirmarOrden.setFocusable(false);
        btnConfirmarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarOrdenActionPerformed(evt);
            }
        });

        btnAgregarProductoCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarProductoCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAgregarProductoCompra.setForeground(new java.awt.Color(0, 102, 102));
        btnAgregarProductoCompra.setText("Agregar producto");
        btnAgregarProductoCompra.setToolTipText("");
        btnAgregarProductoCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarProductoCompra.setEnabled(false);
        btnAgregarProductoCompra.setFocusable(false);
        btnAgregarProductoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOpcionesLayout = new javax.swing.GroupLayout(jpOpciones);
        jpOpciones.setLayout(jpOpcionesLayout);
        jpOpcionesLayout.setHorizontalGroup(
            jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRemoverProductoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarProductoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jpOpcionesLayout.setVerticalGroup(
            jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemoverProductoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jpOpcionesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAgregarProductoCompra, btnConfirmarOrden});

        lblTitulo7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTitulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo7.setText("Registro de compras: Nueva compra");

        javax.swing.GroupLayout jpGestionEmpleados6Layout = new javax.swing.GroupLayout(jpGestionEmpleados6);
        jpGestionEmpleados6.setLayout(jpGestionEmpleados6Layout);
        jpGestionEmpleados6Layout.setHorizontalGroup(
            jpGestionEmpleados6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpGestionEmpleados6Layout.setVerticalGroup(
            jpGestionEmpleados6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(226, 226, 226));

        btnIrACompras1.setBackground(new java.awt.Color(255, 255, 255));
        btnIrACompras1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnIrACompras1.setForeground(new java.awt.Color(0, 102, 102));
        btnIrACompras1.setText("Nueva compra");
        btnIrACompras1.setToolTipText("");
        btnIrACompras1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIrACompras1.setEnabled(false);
        btnIrACompras1.setFocusPainted(false);

        btnCompraIrAInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnCompraIrAInventario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCompraIrAInventario.setForeground(new java.awt.Color(0, 102, 102));
        btnCompraIrAInventario.setText("Inventario");
        btnCompraIrAInventario.setToolTipText("");
        btnCompraIrAInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCompraIrAInventario.setFocusPainted(false);
        btnCompraIrAInventario.setFocusable(false);
        btnCompraIrAInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraIrAInventarioActionPerformed(evt);
            }
        });

        btnCompraIrAProveedores.setBackground(new java.awt.Color(255, 255, 255));
        btnCompraIrAProveedores.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCompraIrAProveedores.setForeground(new java.awt.Color(0, 102, 102));
        btnCompraIrAProveedores.setText("Proveedores");
        btnCompraIrAProveedores.setToolTipText("");
        btnCompraIrAProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCompraIrAProveedores.setFocusPainted(false);
        btnCompraIrAProveedores.setFocusable(false);
        btnCompraIrAProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraIrAProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCompraIrAInventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCompraIrAProveedores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIrACompras1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnIrACompras1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCompraIrAInventario)
                .addGap(18, 18, 18)
                .addComponent(btnCompraIrAProveedores)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCompraIrAInventario, btnCompraIrAProveedores, btnIrACompras1});

        lblProducto1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProducto1.setForeground(new java.awt.Color(0, 102, 102));
        lblProducto1.setText("Ingreso de producto:");

        chkNuevoProd.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup6.add(chkNuevoProd);
        chkNuevoProd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkNuevoProd.setText("Nuevo producto");
        chkNuevoProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkNuevoProd.setFocusable(false);
        chkNuevoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNuevoProdActionPerformed(evt);
            }
        });

        chkCatalogo.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup6.add(chkCatalogo);
        chkCatalogo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkCatalogo.setSelected(true);
        chkCatalogo.setText("Por catálogo");
        chkCatalogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkCatalogo.setFocusable(false);
        chkCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCatalogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkNuevoProd, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(chkCatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(chkCatalogo)
                .addGap(18, 18, 18)
                .addComponent(chkNuevoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblProducto2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProducto2.setForeground(new java.awt.Color(0, 102, 102));
        lblProducto2.setText("Nueva compra:");

        lblPecioVenta3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPecioVenta3.setText("ID Compra:");

        txtIdCompra.setEditable(false);
        txtIdCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIdCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdCompra.setDisabledTextColor(new java.awt.Color(0, 102, 0));

        lblPecioVenta4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPecioVenta4.setText("ID Empleado:");

        txtIdEmpleadoCompra.setEditable(false);
        txtIdEmpleadoCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIdEmpleadoCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdEmpleadoCompra.setDisabledTextColor(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPecioVenta3)
                            .addComponent(lblPecioVenta4)
                            .addComponent(txtIdCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtIdEmpleadoCompra))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPecioVenta3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPecioVenta4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdEmpleadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jpCompraLayout = new javax.swing.GroupLayout(jpCompra);
        jpCompra.setLayout(jpCompraLayout);
        jpCompraLayout.setHorizontalGroup(
            jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpGestionEmpleados6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCompraLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpComprasB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCompraLayout.createSequentialGroup()
                        .addComponent(jpComprasA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpComprasC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCompraLayout.setVerticalGroup(
            jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpGestionEmpleados6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpComprasB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpComprasA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpComprasC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtpPrincipal.addTab("Compra", jpCompra);

        jpInventario.setBackground(new java.awt.Color(251, 251, 251));

        jpInventarioA.setBackground(new java.awt.Color(226, 226, 226));

        jtProducto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID producto", "Nombre", "Fabricante", "Precio unitario", "Existencia", "ID categoría", "ID proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtProducto.setFocusable(false);
        jtProducto.setName(""); // NOI18N
        jtProducto.setRowHeight(30);
        jtProducto.setRowSelectionAllowed(false);
        jtProducto.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jtProducto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtProducto.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtProducto);
        if (jtProducto.getColumnModel().getColumnCount() > 0) {
            jtProducto.getColumnModel().getColumn(0).setResizable(false);
            jtProducto.getColumnModel().getColumn(1).setResizable(false);
            jtProducto.getColumnModel().getColumn(2).setResizable(false);
            jtProducto.getColumnModel().getColumn(3).setResizable(false);
            jtProducto.getColumnModel().getColumn(4).setResizable(false);
            jtProducto.getColumnModel().getColumn(5).setResizable(false);
            jtProducto.getColumnModel().getColumn(6).setResizable(false);
        }

        lblUsuario3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario3.setText("Productos:");

        javax.swing.GroupLayout jpInventarioALayout = new javax.swing.GroupLayout(jpInventarioA);
        jpInventarioA.setLayout(jpInventarioALayout);
        jpInventarioALayout.setHorizontalGroup(
            jpInventarioALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInventarioALayout.createSequentialGroup()
                        .addComponent(lblUsuario3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jpInventarioALayout.setVerticalGroup(
            jpInventarioALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        lblTitulo8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo8.setText("Inventario");

        javax.swing.GroupLayout jpGestionEmpleados7Layout = new javax.swing.GroupLayout(jpGestionEmpleados7);
        jpGestionEmpleados7.setLayout(jpGestionEmpleados7Layout);
        jpGestionEmpleados7Layout.setHorizontalGroup(
            jpGestionEmpleados7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpGestionEmpleados7Layout.setVerticalGroup(
            jpGestionEmpleados7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpGestionEmpleados9.setBackground(new java.awt.Color(226, 226, 226));

        chkNombreProductos.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(chkNombreProductos);
        chkNombreProductos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkNombreProductos.setText("Nombre");
        chkNombreProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkNombreProductos.setFocusable(false);

        chkCategoriaProductos.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(chkCategoriaProductos);
        chkCategoriaProductos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkCategoriaProductos.setText("ID Categoria");
        chkCategoriaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkCategoriaProductos.setFocusable(false);

        chkProveedorProductos.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(chkProveedorProductos);
        chkProveedorProductos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkProveedorProductos.setText("ID Proveedor");
        chkProveedorProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkProveedorProductos.setFocusable(false);

        btnBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        btnBuscarProducto.setToolTipText("Mostrar/ocultar contraseña actual");
        btnBuscarProducto.setBorderPainted(false);
        btnBuscarProducto.setContentAreaFilled(false);
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarProducto.setFocusable(false);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnReiniciarBusqProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnReiniciarBusqProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnReiniciarBusqProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/reset.png"))); // NOI18N
        btnReiniciarBusqProducto.setToolTipText("Mostrar/ocultar contraseña actual");
        btnReiniciarBusqProducto.setBorderPainted(false);
        btnReiniciarBusqProducto.setContentAreaFilled(false);
        btnReiniciarBusqProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReiniciarBusqProducto.setFocusable(false);
        btnReiniciarBusqProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarBusqProductoActionPerformed(evt);
            }
        });

        lblUsuario2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario2.setText("Búsqueda por:");

        txtBusquedaProductos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBusquedaProductos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusquedaProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaProductosKeyReleased(evt);
            }
        });

        chkIdProducto.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(chkIdProducto);
        chkIdProducto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkIdProducto.setSelected(true);
        chkIdProducto.setText("ID Producto");
        chkIdProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkIdProducto.setFocusable(false);

        chkFabricante.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(chkFabricante);
        chkFabricante.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkFabricante.setText("Fabricante");
        chkFabricante.setToolTipText("");
        chkFabricante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkFabricante.setFocusable(false);

        btnGenerarReporteProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteProductos.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btnGenerarReporteProductos.setForeground(new java.awt.Color(204, 0, 51));
        btnGenerarReporteProductos.setText("Generar reporte");
        btnGenerarReporteProductos.setToolTipText("");
        btnGenerarReporteProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporteProductos.setFocusPainted(false);
        btnGenerarReporteProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpGestionEmpleados9Layout = new javax.swing.GroupLayout(jpGestionEmpleados9);
        jpGestionEmpleados9.setLayout(jpGestionEmpleados9Layout);
        jpGestionEmpleados9Layout.setHorizontalGroup(
            jpGestionEmpleados9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkIdProducto)
                .addGap(13, 13, 13)
                .addComponent(chkNombreProductos)
                .addGap(12, 12, 12)
                .addComponent(chkFabricante)
                .addGap(18, 18, 18)
                .addComponent(chkCategoriaProductos)
                .addGap(18, 18, 18)
                .addComponent(chkProveedorProductos)
                .addGap(73, 73, 73)
                .addComponent(txtBusquedaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReiniciarBusqProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnGenerarReporteProductos)
                .addContainerGap())
        );
        jpGestionEmpleados9Layout.setVerticalGroup(
            jpGestionEmpleados9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGestionEmpleados9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerarReporteProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpGestionEmpleados9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpGestionEmpleados9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkIdProducto)
                            .addComponent(chkNombreProductos)
                            .addComponent(chkCategoriaProductos)
                            .addComponent(chkProveedorProductos)
                            .addComponent(chkFabricante))
                        .addComponent(btnReiniciarBusqProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBusquedaProductos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpInventarioA1.setBackground(new java.awt.Color(226, 226, 226));

        jtCategoria.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID categoría", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCategoria.setFocusable(false);
        jtCategoria.setName(""); // NOI18N
        jtCategoria.setRowHeight(30);
        jtCategoria.setRowSelectionAllowed(false);
        jtCategoria.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jtCategoria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtCategoria.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jtCategoria);
        if (jtCategoria.getColumnModel().getColumnCount() > 0) {
            jtCategoria.getColumnModel().getColumn(0).setResizable(false);
            jtCategoria.getColumnModel().getColumn(1).setResizable(false);
        }

        lblUsuario4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario4.setText("Categorias:");

        javax.swing.GroupLayout jpInventarioA1Layout = new javax.swing.GroupLayout(jpInventarioA1);
        jpInventarioA1.setLayout(jpInventarioA1Layout);
        jpInventarioA1Layout.setHorizontalGroup(
            jpInventarioA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jpInventarioA1Layout.createSequentialGroup()
                        .addComponent(lblUsuario4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpInventarioA1Layout.setVerticalGroup(
            jpInventarioA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpInventarioLayout = new javax.swing.GroupLayout(jpInventario);
        jpInventario.setLayout(jpInventarioLayout);
        jpInventarioLayout.setHorizontalGroup(
            jpInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpInventarioA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpGestionEmpleados7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpGestionEmpleados9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpInventarioA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpInventarioLayout.setVerticalGroup(
            jpInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpGestionEmpleados7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpGestionEmpleados9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpInventarioA, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpInventarioA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpPrincipal.addTab("Inventario", jpInventario);

        jpOrden.setBackground(new java.awt.Color(251, 251, 251));

        lblTitulo9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo9.setText("Ordenes");

        javax.swing.GroupLayout jpGestionEmpleados8Layout = new javax.swing.GroupLayout(jpGestionEmpleados8);
        jpGestionEmpleados8.setLayout(jpGestionEmpleados8Layout);
        jpGestionEmpleados8Layout.setHorizontalGroup(
            jpGestionEmpleados8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo9)
                .addContainerGap(1189, Short.MAX_VALUE))
        );
        jpGestionEmpleados8Layout.setVerticalGroup(
            jpGestionEmpleados8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jpGestionEmpleados12.setBackground(new java.awt.Color(226, 226, 226));

        chkIdEmpleadoVenta.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup4.add(chkIdEmpleadoVenta);
        chkIdEmpleadoVenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkIdEmpleadoVenta.setText("ID Empleado");
        chkIdEmpleadoVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkIdEmpleadoVenta.setFocusable(false);

        btnBuscarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBuscarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        btnBuscarVenta.setToolTipText("Buscar");
        btnBuscarVenta.setBorderPainted(false);
        btnBuscarVenta.setContentAreaFilled(false);
        btnBuscarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarVenta.setFocusable(false);
        btnBuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaActionPerformed(evt);
            }
        });

        btnReiniciarBusqVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnReiniciarBusqVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnReiniciarBusqVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/reset.png"))); // NOI18N
        btnReiniciarBusqVenta.setToolTipText("Reiniciar búsqueda");
        btnReiniciarBusqVenta.setBorderPainted(false);
        btnReiniciarBusqVenta.setContentAreaFilled(false);
        btnReiniciarBusqVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReiniciarBusqVenta.setFocusable(false);
        btnReiniciarBusqVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarBusqVentaActionPerformed(evt);
            }
        });

        lblUsuario8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario8.setText("Búsqueda por:");

        txtBusquedaVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBusquedaVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusquedaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaVentaKeyReleased(evt);
            }
        });

        chkIdVenta.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup4.add(chkIdVenta);
        chkIdVenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkIdVenta.setSelected(true);
        chkIdVenta.setText("ID Venta");
        chkIdVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkIdVenta.setFocusable(false);

        chkFechaVenta.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup4.add(chkFechaVenta);
        chkFechaVenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkFechaVenta.setText("Fecha (YYYY-MM-dd)");
        chkFechaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkFechaVenta.setFocusable(false);

        btnGenerarReporteVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteVentas.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btnGenerarReporteVentas.setForeground(new java.awt.Color(204, 0, 51));
        btnGenerarReporteVentas.setText("Generar reporte");
        btnGenerarReporteVentas.setToolTipText("");
        btnGenerarReporteVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporteVentas.setFocusPainted(false);
        btnGenerarReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpGestionEmpleados12Layout = new javax.swing.GroupLayout(jpGestionEmpleados12);
        jpGestionEmpleados12.setLayout(jpGestionEmpleados12Layout);
        jpGestionEmpleados12Layout.setHorizontalGroup(
            jpGestionEmpleados12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkIdVenta)
                .addGap(13, 13, 13)
                .addComponent(chkIdEmpleadoVenta)
                .addGap(18, 18, 18)
                .addComponent(chkFechaVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBusquedaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReiniciarBusqVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReporteVentas)
                .addContainerGap())
        );
        jpGestionEmpleados12Layout.setVerticalGroup(
            jpGestionEmpleados12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpGestionEmpleados12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkIdVenta)
                    .addComponent(chkIdEmpleadoVenta)
                    .addComponent(chkFechaVenta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGestionEmpleados12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGestionEmpleados12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarReporteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusquedaVenta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReiniciarBusqVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpInventarioA3.setBackground(new java.awt.Color(226, 226, 226));

        jtVenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID venta", "ID empleado", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtVenta.setFocusable(false);
        jtVenta.setName(""); // NOI18N
        jtVenta.setRowHeight(30);
        jtVenta.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jtVenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtVenta.getTableHeader().setReorderingAllowed(false);
        jtVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVentaMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jtVenta);
        if (jtVenta.getColumnModel().getColumnCount() > 0) {
            jtVenta.getColumnModel().getColumn(0).setResizable(false);
            jtVenta.getColumnModel().getColumn(1).setResizable(false);
            jtVenta.getColumnModel().getColumn(2).setResizable(false);
        }

        lblUsuario9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario9.setText("Ventas:");

        javax.swing.GroupLayout jpInventarioA3Layout = new javax.swing.GroupLayout(jpInventarioA3);
        jpInventarioA3.setLayout(jpInventarioA3Layout);
        jpInventarioA3Layout.setHorizontalGroup(
            jpInventarioA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInventarioA3Layout.createSequentialGroup()
                        .addComponent(lblUsuario9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpInventarioA3Layout.setVerticalGroup(
            jpInventarioA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpInventarioA4.setBackground(new java.awt.Color(226, 226, 226));

        jtCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID compra", "ID empleado", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCompra.setFocusable(false);
        jtCompra.setName(""); // NOI18N
        jtCompra.setRowHeight(30);
        jtCompra.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jtCompra.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtCompra.getTableHeader().setReorderingAllowed(false);
        jtCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCompraMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jtCompra);
        if (jtCompra.getColumnModel().getColumnCount() > 0) {
            jtCompra.getColumnModel().getColumn(0).setResizable(false);
            jtCompra.getColumnModel().getColumn(1).setResizable(false);
            jtCompra.getColumnModel().getColumn(2).setResizable(false);
        }

        lblUsuario10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario10.setText("Compras:");

        javax.swing.GroupLayout jpInventarioA4Layout = new javax.swing.GroupLayout(jpInventarioA4);
        jpInventarioA4.setLayout(jpInventarioA4Layout);
        jpInventarioA4Layout.setHorizontalGroup(
            jpInventarioA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpInventarioA4Layout.setVerticalGroup(
            jpInventarioA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpGestionEmpleados13.setBackground(new java.awt.Color(226, 226, 226));

        chkIdEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup5.add(chkIdEmpleado);
        chkIdEmpleado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkIdEmpleado.setText("ID Empleado");
        chkIdEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkIdEmpleado.setFocusable(false);

        btnBuscarCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBuscarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        btnBuscarCompra.setToolTipText("Buscar");
        btnBuscarCompra.setBorderPainted(false);
        btnBuscarCompra.setContentAreaFilled(false);
        btnBuscarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarCompra.setFocusable(false);
        btnBuscarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCompraActionPerformed(evt);
            }
        });

        btnReiniciarBusqCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnReiniciarBusqCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnReiniciarBusqCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/reset.png"))); // NOI18N
        btnReiniciarBusqCompra.setToolTipText("Reiniciar búsqueda");
        btnReiniciarBusqCompra.setBorderPainted(false);
        btnReiniciarBusqCompra.setContentAreaFilled(false);
        btnReiniciarBusqCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReiniciarBusqCompra.setFocusable(false);
        btnReiniciarBusqCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarBusqCompraActionPerformed(evt);
            }
        });

        lblUsuario11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario11.setText("Búsqueda por:");

        txtBusquedaCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBusquedaCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusquedaCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaCompraKeyReleased(evt);
            }
        });

        chkIdCompra.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup5.add(chkIdCompra);
        chkIdCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkIdCompra.setSelected(true);
        chkIdCompra.setText("ID Compra");
        chkIdCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkIdCompra.setFocusable(false);

        chkFechaCompra.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup5.add(chkFechaCompra);
        chkFechaCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkFechaCompra.setText("Fecha (YYYY-MM-dd)");
        chkFechaCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkFechaCompra.setFocusable(false);

        btnGenerarReporteCompras.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteCompras.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btnGenerarReporteCompras.setForeground(new java.awt.Color(204, 0, 51));
        btnGenerarReporteCompras.setText("Generar reporte");
        btnGenerarReporteCompras.setToolTipText("");
        btnGenerarReporteCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporteCompras.setFocusPainted(false);
        btnGenerarReporteCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteComprasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpGestionEmpleados13Layout = new javax.swing.GroupLayout(jpGestionEmpleados13);
        jpGestionEmpleados13.setLayout(jpGestionEmpleados13Layout);
        jpGestionEmpleados13Layout.setHorizontalGroup(
            jpGestionEmpleados13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkIdCompra)
                .addGap(13, 13, 13)
                .addComponent(chkIdEmpleado)
                .addGap(18, 18, 18)
                .addComponent(chkFechaCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBusquedaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReiniciarBusqCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReporteCompras)
                .addContainerGap())
        );
        jpGestionEmpleados13Layout.setVerticalGroup(
            jpGestionEmpleados13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados13Layout.createSequentialGroup()
                .addGroup(jpGestionEmpleados13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpGestionEmpleados13Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jpGestionEmpleados13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkIdCompra)
                            .addComponent(chkIdEmpleado)
                            .addComponent(chkFechaCompra)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpGestionEmpleados13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpGestionEmpleados13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusquedaCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpGestionEmpleados13Layout.createSequentialGroup()
                                .addGroup(jpGestionEmpleados13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGenerarReporteCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReiniciarBusqCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpInventarioA5.setBackground(new java.awt.Color(226, 226, 226));

        jtDetalleCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID compra", "ID producto", "Precio unitario", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDetalleCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtDetalleCompra.setFocusable(false);
        jtDetalleCompra.setName(""); // NOI18N
        jtDetalleCompra.setRowHeight(30);
        jtDetalleCompra.setRowSelectionAllowed(false);
        jtDetalleCompra.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jtDetalleCompra.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtDetalleCompra.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(jtDetalleCompra);
        if (jtDetalleCompra.getColumnModel().getColumnCount() > 0) {
            jtDetalleCompra.getColumnModel().getColumn(0).setResizable(false);
            jtDetalleCompra.getColumnModel().getColumn(1).setResizable(false);
            jtDetalleCompra.getColumnModel().getColumn(2).setResizable(false);
            jtDetalleCompra.getColumnModel().getColumn(3).setResizable(false);
        }

        lblUsuario12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario12.setText("Detalle de compra:");

        javax.swing.GroupLayout jpInventarioA5Layout = new javax.swing.GroupLayout(jpInventarioA5);
        jpInventarioA5.setLayout(jpInventarioA5Layout);
        jpInventarioA5Layout.setHorizontalGroup(
            jpInventarioA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInventarioA5Layout.createSequentialGroup()
                        .addComponent(lblUsuario12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12))
                .addContainerGap())
        );
        jpInventarioA5Layout.setVerticalGroup(
            jpInventarioA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpInventarioA6.setBackground(new java.awt.Color(226, 226, 226));

        jtDetalleVenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID venta", "ID producto", "Precio unitario", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDetalleVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtDetalleVenta.setFocusable(false);
        jtDetalleVenta.setName(""); // NOI18N
        jtDetalleVenta.setRowHeight(30);
        jtDetalleVenta.setRowSelectionAllowed(false);
        jtDetalleVenta.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jtDetalleVenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtDetalleVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(jtDetalleVenta);
        if (jtDetalleVenta.getColumnModel().getColumnCount() > 0) {
            jtDetalleVenta.getColumnModel().getColumn(0).setResizable(false);
            jtDetalleVenta.getColumnModel().getColumn(1).setResizable(false);
            jtDetalleVenta.getColumnModel().getColumn(2).setResizable(false);
            jtDetalleVenta.getColumnModel().getColumn(3).setResizable(false);
        }

        lblUsuario13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario13.setText("Detalle de venta:");

        javax.swing.GroupLayout jpInventarioA6Layout = new javax.swing.GroupLayout(jpInventarioA6);
        jpInventarioA6.setLayout(jpInventarioA6Layout);
        jpInventarioA6Layout.setHorizontalGroup(
            jpInventarioA6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioA6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInventarioA6Layout.createSequentialGroup()
                        .addComponent(lblUsuario13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane13))
                .addContainerGap())
        );
        jpInventarioA6Layout.setVerticalGroup(
            jpInventarioA6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpOrdenLayout = new javax.swing.GroupLayout(jpOrden);
        jpOrden.setLayout(jpOrdenLayout);
        jpOrdenLayout.setHorizontalGroup(
            jpOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpGestionEmpleados8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpGestionEmpleados13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpGestionEmpleados12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpOrdenLayout.createSequentialGroup()
                        .addComponent(jpInventarioA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpInventarioA6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpOrdenLayout.createSequentialGroup()
                        .addComponent(jpInventarioA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpInventarioA5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpOrdenLayout.setVerticalGroup(
            jpOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpGestionEmpleados8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpGestionEmpleados12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpInventarioA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpInventarioA6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOrdenLayout.createSequentialGroup()
                        .addComponent(jpGestionEmpleados13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpInventarioA4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpOrdenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jpInventarioA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jtpPrincipal.addTab("Ordenes", jpOrden);

        jpProveedores.setBackground(new java.awt.Color(251, 251, 251));

        lblTitulo10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTitulo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo10.setText("Proveedores");

        javax.swing.GroupLayout jpGestionEmpleados10Layout = new javax.swing.GroupLayout(jpGestionEmpleados10);
        jpGestionEmpleados10.setLayout(jpGestionEmpleados10Layout);
        jpGestionEmpleados10Layout.setHorizontalGroup(
            jpGestionEmpleados10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpGestionEmpleados10Layout.setVerticalGroup(
            jpGestionEmpleados10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo10, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jpInventarioA2.setBackground(new java.awt.Color(226, 226, 226));

        jtProveedor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID proveedor", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtProveedor.setFocusable(false);
        jtProveedor.setName(""); // NOI18N
        jtProveedor.setRowHeight(30);
        jtProveedor.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jtProveedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtProveedor.getTableHeader().setReorderingAllowed(false);
        jtProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProveedorMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jtProveedor);
        if (jtProveedor.getColumnModel().getColumnCount() > 0) {
            jtProveedor.getColumnModel().getColumn(0).setResizable(false);
            jtProveedor.getColumnModel().getColumn(1).setResizable(false);
        }

        lblUsuario5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario5.setText("Proveedores:");

        javax.swing.GroupLayout jpInventarioA2Layout = new javax.swing.GroupLayout(jpInventarioA2);
        jpInventarioA2.setLayout(jpInventarioA2Layout);
        jpInventarioA2Layout.setHorizontalGroup(
            jpInventarioA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario5)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpInventarioA2Layout.setVerticalGroup(
            jpInventarioA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpGestionEmpleados11.setBackground(new java.awt.Color(226, 226, 226));

        chkNombreProveedor.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup3.add(chkNombreProveedor);
        chkNombreProveedor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkNombreProveedor.setText("Nombre");
        chkNombreProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkNombreProveedor.setFocusable(false);

        btnBuscarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        btnBuscarProveedor.setToolTipText("Buscar");
        btnBuscarProveedor.setBorderPainted(false);
        btnBuscarProveedor.setContentAreaFilled(false);
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarProveedor.setFocusable(false);
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        btnReiniciarBusqProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnReiniciarBusqProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnReiniciarBusqProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/reset.png"))); // NOI18N
        btnReiniciarBusqProveedor.setToolTipText("Reiniciar búsqueda");
        btnReiniciarBusqProveedor.setBorderPainted(false);
        btnReiniciarBusqProveedor.setContentAreaFilled(false);
        btnReiniciarBusqProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReiniciarBusqProveedor.setFocusable(false);
        btnReiniciarBusqProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarBusqProveedorActionPerformed(evt);
            }
        });

        lblUsuario6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario6.setText("Búsqueda por:");

        txtBusquedaProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBusquedaProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusquedaProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaProveedorKeyReleased(evt);
            }
        });

        chkIdProveedor.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup3.add(chkIdProveedor);
        chkIdProveedor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chkIdProveedor.setSelected(true);
        chkIdProveedor.setText("ID Proveedor");
        chkIdProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkIdProveedor.setFocusable(false);

        javax.swing.GroupLayout jpGestionEmpleados11Layout = new javax.swing.GroupLayout(jpGestionEmpleados11);
        jpGestionEmpleados11.setLayout(jpGestionEmpleados11Layout);
        jpGestionEmpleados11Layout.setHorizontalGroup(
            jpGestionEmpleados11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkIdProveedor)
                .addGap(13, 13, 13)
                .addComponent(chkNombreProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBusquedaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReiniciarBusqProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpGestionEmpleados11Layout.setVerticalGroup(
            jpGestionEmpleados11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGestionEmpleados11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGestionEmpleados11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusquedaProveedor)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpGestionEmpleados11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jpGestionEmpleados11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkIdProveedor)
                            .addComponent(chkNombreProveedor))
                        .addComponent(btnReiniciarBusqProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(226, 226, 226));

        lblUsuario7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario7.setForeground(new java.awt.Color(0, 102, 102));
        lblUsuario7.setText("Registrar nuevo proveedor:");

        lblNombreEmpleado1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNombreEmpleado1.setText("Nombre:");

        txtNuevoProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNuevoProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNuevoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNuevoProveedorKeyReleased(evt);
            }
        });

        btnRegistrarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnRegistrarProveedor.setForeground(new java.awt.Color(0, 102, 102));
        btnRegistrarProveedor.setText("Registrar");
        btnRegistrarProveedor.setToolTipText("");
        btnRegistrarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarProveedor.setFocusPainted(false);
        btnRegistrarProveedor.setFocusable(false);
        btnRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsuario7)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRegistrarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblNombreEmpleado1)
                        .addGap(61, 61, 61)))
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombreEmpleado1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarProveedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpInventarioA7.setBackground(new java.awt.Color(226, 226, 226));

        jtProductoProveedor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtProductoProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID producto", "Nombre", "Fabricante", "Precio unitario", "Existencia", "ID categoría", "ID proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProductoProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtProductoProveedor.setFocusable(false);
        jtProductoProveedor.setName(""); // NOI18N
        jtProductoProveedor.setRowHeight(30);
        jtProductoProveedor.setRowSelectionAllowed(false);
        jtProductoProveedor.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jtProductoProveedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtProductoProveedor.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(jtProductoProveedor);
        if (jtProductoProveedor.getColumnModel().getColumnCount() > 0) {
            jtProductoProveedor.getColumnModel().getColumn(0).setResizable(false);
            jtProductoProveedor.getColumnModel().getColumn(1).setResizable(false);
            jtProductoProveedor.getColumnModel().getColumn(2).setResizable(false);
            jtProductoProveedor.getColumnModel().getColumn(3).setResizable(false);
            jtProductoProveedor.getColumnModel().getColumn(4).setResizable(false);
            jtProductoProveedor.getColumnModel().getColumn(5).setResizable(false);
            jtProductoProveedor.getColumnModel().getColumn(6).setResizable(false);
        }

        lblUsuario15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario15.setText("Productos por proveedor:");

        javax.swing.GroupLayout jpInventarioA7Layout = new javax.swing.GroupLayout(jpInventarioA7);
        jpInventarioA7.setLayout(jpInventarioA7Layout);
        jpInventarioA7Layout.setHorizontalGroup(
            jpInventarioA7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInventarioA7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addGroup(jpInventarioA7Layout.createSequentialGroup()
                        .addComponent(lblUsuario15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpInventarioA7Layout.setVerticalGroup(
            jpInventarioA7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioA7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpProveedoresLayout = new javax.swing.GroupLayout(jpProveedores);
        jpProveedores.setLayout(jpProveedoresLayout);
        jpProveedoresLayout.setHorizontalGroup(
            jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpGestionEmpleados10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpGestionEmpleados11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                        .addComponent(jpInventarioA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpInventarioA7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpProveedoresLayout.setVerticalGroup(
            jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpGestionEmpleados10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpGestionEmpleados11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpInventarioA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpInventarioA7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtpPrincipal.addTab("Proveedores", jpProveedores);

        jpHeader.setBackground(new java.awt.Color(227, 227, 227));

        lblUsuario14.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        lblUsuario14.setText("Control de Farmacia");

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize.png"))); // NOI18N
        btnMinimizar.setToolTipText("Minimizar formulario");
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.setFocusable(false);
        btnMinimizar.setPreferredSize(new java.awt.Dimension(24, 24));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        jpHome.setBackground(new java.awt.Color(217, 217, 217));

        btnInicio.setBackground(new java.awt.Color(255, 255, 255));
        btnInicio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png"))); // NOI18N
        btnInicio.setToolTipText("Regresar a inicio");
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInicio.setFocusable(false);
        btnInicio.setPreferredSize(new java.awt.Dimension(24, 24));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpHomeLayout = new javax.swing.GroupLayout(jpHome);
        jpHome.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/close.png"))); // NOI18N
        btnCerrar.setToolTipText("Cerrar formulario");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setFocusable(false);
        btnCerrar.setPreferredSize(new java.awt.Dimension(24, 24));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lnlUsuario1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lnlUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icon.png"))); // NOI18N

        jpSalir.setBackground(new java.awt.Color(217, 217, 217));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logout.png"))); // NOI18N
        btnSalir.setToolTipText("Cerrar sesión");
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setFocusable(false);
        btnSalir.setPreferredSize(new java.awt.Dimension(24, 24));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpSalirLayout = new javax.swing.GroupLayout(jpSalir);
        jpSalir.setLayout(jpSalirLayout);
        jpSalirLayout.setHorizontalGroup(
            jpSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSalirLayout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpSalirLayout.setVerticalGroup(
            jpSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpUsuario.setBackground(new java.awt.Color(217, 217, 217));

        lnlUsuario2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lnlUsuario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user.png"))); // NOI18N

        lblUser.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        lblUser.setText("Usuario");

        javax.swing.GroupLayout jpUsuarioLayout = new javax.swing.GroupLayout(jpUsuario);
        jpUsuario.setLayout(jpUsuarioLayout);
        jpUsuarioLayout.setHorizontalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lnlUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jpUsuarioLayout.setVerticalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lnlUsuario2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpHeaderLayout = new javax.swing.GroupLayout(jpHeader);
        jpHeader.setLayout(jpHeaderLayout);
        jpHeaderLayout.setHorizontalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHeaderLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lnlUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jpHeaderLayout.setVerticalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lnlUsuario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(jpHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpPrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1319, 705));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //0. Ventana principal: Inicio de sesión.
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            dba = new DBAdmin("root", "2019mu601");
            
            //Autenticando usuario.
            String id = dba.autenticar(this.txtUsuario.getText(), encriptador.Encriptar(this.txtPassword.getText()));
           
            //Verificando si el usuario es nulo.
            if (Integer.parseInt(id) == 0) { // Nulo. Este usuario no existe o no se encuentra activo.
                lblAvisoInicio.setText("Nombre de usuario o contraseña incorrectos");
                return; 
            }
            
            //Si el usuario puede ingresar entonces se redirecciona a su panel correspondiente.
            this.id_cargo = this.dba.getEmpleado(id).getCargo(); //Obteniendo.
            switch(id_cargo) {
            case 1: //Ir a panel de gestion de empleados.
                this.jtpPrincipal.setSelectedIndex(1);
                break;
            case 2: //Ir a panel de ventas.
                this.jtpPrincipal.setSelectedIndex(2);
                break;
            case 3: //Ir a panel de compas.
                this.jtpPrincipal.setSelectedIndex(3);
                break; 
            }   

            //Habilitando/ Deshabilitando controles.
            lblAvisoInicio.setText(""); jpHome.setVisible(true); jpSalir.setVisible(true); jpUsuario.setVisible(true);
            this.lblUser.setText(this.dba.getEmpleado(id).getNombre() + " " + this.dba.getEmpleado(id).getApellido());
            this.txtIdEmpleadoCompra.setText(id); this.txtIdEmpleadoVenta.setText(id);
            this.txtUsuario.setText(""); this.txtPassword.setText("");
           
            //Cargando listas de datos.
            this.mostrarEmpleados("",""); this.mostrarProductos("",""); this.mostrarCategorias(); this.mostrarVentas("","");
            this.mostrarCompras("",""); this.mostrarProveedores("",""); this.mostrarCatalogo();
            this.poblarProductosVenta(); this.poblarCategoriasCompra(); this.poblarProveedoresCompra();
            this.txtIdVenta.setText(dba.getNuevoIdVenta()); this.txtIdCompra.setText(dba.getNuevoIdCompra());
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    //1. Ventana empleados: Ir a registro de ventas desde panel de administracion.
    private void btnIrAVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAVentasActionPerformed
        this.jtpPrincipal.setSelectedIndex(2);
    }//GEN-LAST:event_btnIrAVentasActionPerformed

    //1. Ventana empleados: Ir a registro de compras desde panel de administracion.
    private void btnIrAComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAComprasActionPerformed
        this.jtpPrincipal.setSelectedIndex(3);
    }//GEN-LAST:event_btnIrAComprasActionPerformed

    //1. Ventana empleados:Ir a inventario desde panel de administracion.
    private void btnIrAInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAInventarioActionPerformed
        this.jtpPrincipal.setSelectedIndex(4);
    }//GEN-LAST:event_btnIrAInventarioActionPerformed

    //1. Ventana empleados:Ir a ordenes desde panel de administracion.
    private void btnIrAOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAOrdenesActionPerformed
        this.jtpPrincipal.setSelectedIndex(5);
    }//GEN-LAST:event_btnIrAOrdenesActionPerformed

    //1. Ventana empleados: Ir a proveedores desde panel de administracion.
    private void btnIrAProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAProveedoresActionPerformed
        this.jtpPrincipal.setSelectedIndex(6);
    }//GEN-LAST:event_btnIrAProveedoresActionPerformed

    //1. Ventana empleados: Habilita/Deshabilita campos para registrar un nuevo empleado.
    private void btnNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpleadoActionPerformed
        try {
            this.btnLimpiarEmpleado.doClick(); modo_edicion = false; this.jtEmpleado.clearSelection();
            this.txtNombreEmpleado.setEditable(true); this.txtApellidoEmpleado.setEditable(true);
            this.txtSalario.setEditable(true); this.txtUsuarioEmpleado.setEditable(true);
            this.txtPasswordEmpleado.setEditable(true); this.jsDiaNac.setEnabled(true); 
            this.jsDiaContratacion.setEnabled(true); this.jsAñoNac.setEnabled(true); 
            this.jsAñoContratacion.setEnabled(true); this.cboMesNac.setEnabled(true); 
            this.cboMesContratacion.setEnabled(true); this.cboCargo.setEnabled(true); 
            this.btnGuardarEmpleado.setEnabled(true); this.btnModificarEmpleado.setEnabled(false); 
            this.btnRemoverEmpleado.setEnabled(false); this.btnGenerarPassword.setEnabled(true); 
            this.txtIdEmpleado.setText(dba.getNuevoId()); btnVerPassword.setEnabled(true);
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_btnNuevoEmpleadoActionPerformed

    //1. Ventana empleados: Habilita/Deshabilita controles para modificar un empleado existente.
    private void btnModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoActionPerformed
        modo_edicion = true;
        this.txtNombreEmpleado.setEditable(true); this.txtApellidoEmpleado.setEditable(true);
        this.txtSalario.setEditable(true); this.txtUsuarioEmpleado.setEditable(true);
        this.txtPasswordEmpleado.setEditable(false); this.btnGenerarPassword.setEnabled(false);
        this.btnVerPassword.setEnabled(false); this.btnModificarPassword.setEnabled(true);
        this.jsDiaNac.setEnabled(true); this.jsDiaContratacion.setEnabled(true);
        this.jsAñoNac.setEnabled(true); this.jsAñoContratacion.setEnabled(true);
        this.cboMesNac.setEnabled(true); this.cboMesContratacion.setEnabled(true);
        this.cboCargo.setEnabled(true); this.btnGuardarEmpleado.setEnabled(true);
        this.btnModificarEmpleado.setEnabled(false); this.btnRemoverEmpleado.setEnabled(true);
    }//GEN-LAST:event_btnModificarEmpleadoActionPerformed

    //1. Ventana empleados: Guarda el registro de empleado modificado/creado.
    private void btnGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEmpleadoActionPerformed
        try {
            // - - - - - - - - - - /validaciones. - - - - - - - - -
            //Nombre - No permitir espacios en blanco o un length inferior al establecido. 
            if (txtNombreEmpleado.getText().trim().isEmpty() 
                || txtNombreEmpleado.getText().length()<4
                || txtNombreEmpleado.getText().length()>20) { 
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido; entre 4 y 20 caracteres",
                    "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Nombre - Permitir solamente el ingreso de letras.
            if (!(Pattern.matches("^([A-z]\\s?)+$", txtNombreEmpleado.getText()))) {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre con letras únicamente",
                    "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            //Apellido - No permitir espacios en blanco o un length inferior al establecido. 
            if (txtApellidoEmpleado.getText().trim().isEmpty() 
                || txtApellidoEmpleado.getText().length()<4
                || txtApellidoEmpleado.getText().length()>20) { 
                JOptionPane.showMessageDialog(null, "Ingrese un apellido válido; entre 4 y 20 caracteres",
                    "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Apellido - Permitir solamente el ingreso de letras.
            if (!(Pattern.matches("^([A-z]\\s?)+$", txtApellidoEmpleado.getText()))) {
                JOptionPane.showMessageDialog(null, "Ingrese un apellido con letras únicamente",
                    "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            //Usuario - No permitir espacios en blanco o un length inferior al establecido. 
            if (txtUsuarioEmpleado.getText().trim().isEmpty() || txtUsuarioEmpleado.getText().trim().length()<10) { 
                JOptionPane.showMessageDialog(null, "Ingrese un usuario válido; ingrese 10 caracteres",
                    "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            //Password - No permitir espacios en blanco o un length inferior al establecido. 
            if (txtPasswordEmpleado.isEditable()) {
                if (txtPasswordEmpleado.getText().trim().isEmpty() 
                    || txtPasswordEmpleado.getText().length()<8
                    || txtPasswordEmpleado.getText().length()>16) { 
                    JOptionPane.showMessageDialog(null, "Ingrese una contraseña válida; entre 8 y 16 caracteres",
                        "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            
            //Salario - No permitir espacios en blanco o un length inferior al establecido. 
            if (txtSalario.getText().trim().isEmpty() || !(Pattern.matches("^(0*[1-9][0-9]*(\\.[0-9]*)?|0*\\.[0-9]*[1-9][0-9]*)$", txtSalario.getText()))) { 
                JOptionPane.showMessageDialog(null, "Ingrese un salario válido",
                    "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                return;
            }
 
            //No permitir repeticion de nombres de usuario.
            this.lEmpleados = dba.getListaEmpleados("","");
           
            for (int i = 0; i < lEmpleados.size(); i++) {
                if (lEmpleados.get(i).getUsuario().equals(this.txtUsuarioEmpleado.getText()) &&
                    !(lEmpleados.get(i).getId() == Integer.parseInt(this.txtIdEmpleado.getText()))) {
                    JOptionPane.showMessageDialog(null, "Este nombre de usuario de encuentra en uso.",
                    "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // - - - - - - - - - - Fin/validaciones. - - - - - - - - -
            //Nuevo empleado.
            empleado = new Empleado();
            empleado.setId(Integer.parseInt(this.txtIdEmpleado.getText()));
            empleado.setNombre(txtNombreEmpleado.getText());
            empleado.setApellido(txtApellidoEmpleado.getText());
           
            //Obteniendo fecha de nacimiento.
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(jsDiaNac.getValue().toString()));
            calendar.set(Calendar.MONTH, cboMesNac.getSelectedIndex());
            calendar.set(Calendar.YEAR, Integer.parseInt(jsAñoNac.getValue().toString()));
            empleado.setFechaNacimiento(calendar.getTime()); 
                 
            //Obteniendo fecha de contratacion.
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(jsDiaContratacion.getValue().toString()));
            calendar.set(Calendar.MONTH, cboMesContratacion.getSelectedIndex());
            calendar.set(Calendar.YEAR, Integer.parseInt(jsAñoContratacion.getValue().toString()));
            empleado.setFechaContratacion(calendar.getTime());
            
            //Asignando datos de empleado.
            empleado.setCargo(Integer.parseInt(this.dba.getIdCargo(cboCargo.getSelectedItem().toString())));
            empleado.setSalario(Double.parseDouble(txtSalario.getText()));
            empleado.setUsuario(this.txtUsuarioEmpleado.getText());
            empleado.setPassword(this.encriptador.Encriptar(this.txtPasswordEmpleado.getText()));
            empleado.setEstado(1);
     
            //1. Si es un nuevo registro, se agrega el nuevo empleado.
            if (this.modo_edicion == false) {
                 dba.registrarEmpleado(empleado);
                 JOptionPane.showMessageDialog(null, "El empleado con id: " + empleado.getId()+"  ha sido registrado con éxito.",
                    "Registro de empleados", JOptionPane.INFORMATION_MESSAGE);
            }

            //2. Si es un registro existente, se modifican los datos.
            else if (this.modo_edicion == true) {
                
                //Si la password no se modificara. //Reasignar password actual.
                if (!(this.txtPasswordEmpleado.isEditable())) {
                    empleado.setPassword(this.dba.getEmpleado(Integer.toString(empleado.getId())).getPassword());
                }
                 
                dba.modificarEmpleado(empleado);
                JOptionPane.showMessageDialog(null, "El empleado con id: " + empleado.getId()+"  ha sido modificado con éxito.",
                    "Registro de empleados", JOptionPane.INFORMATION_MESSAGE);
            }
              
           this.btnLimpiarEmpleado.doClick(); //Limpiar formulario.
           this.mostrarEmpleados("","");//Actualiza lista de empleados.
           
        } catch(NumberFormatException | SQLException | HeadlessException ex){}
    }//GEN-LAST:event_btnGuardarEmpleadoActionPerformed

    //1. Ventana empleados: Remueve el registro de empleado seleccionado. (Desactiva al empleado).
    private void btnRemoverEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEmpleadoActionPerformed
        try {
            int selectedRow = jtEmpleado.getSelectedRow(); this.btnLimpiarEmpleado.doClick();
            String id_empleado = jtEmpleado.getValueAt(selectedRow,0).toString();
            this.dba.removerEmpleado(id_empleado); //Cambia su estado a inactivo.
            this.mostrarEmpleados("",""); //Actualiza lista de empleados.
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnRemoverEmpleadoActionPerformed

    //1. Ventana empleados: Limpia el formulario de empleados. Habilita/Deshabilita campos.
    private void btnLimpiarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEmpleadoActionPerformed
        this.jtEmpleado.clearSelection(); this.txtIdEmpleado.setText("");
        this.txtNombreEmpleado.setText(""); modo_edicion = false; this.jsDiaNac.setValue(1);
        this.txtSalario.setText(""); this.txtUsuarioEmpleado.setText(""); 
        this.txtPasswordEmpleado.setText(""); this.txtApellidoEmpleado.setText("");
        this.jsAñoNac.setValue(1980); this.jsAñoContratacion.setValue(1980); 
        this.cboMesContratacion.setSelectedIndex(0); this.cboCargo.setSelectedIndex(0); 
        this.txtNombreEmpleado.setEditable(false); this.txtApellidoEmpleado.setEditable(false);
        this.txtSalario.setEditable(false); this.txtUsuarioEmpleado.setEditable(false);
        this.txtPasswordEmpleado.setEditable(false); this.jsDiaNac.setEnabled(false); 
        this.jsDiaContratacion.setEnabled(false); this.cboMesNac.setSelectedIndex(0);
        this.jsAñoNac.setEnabled(false); this.jsAñoContratacion.setEnabled(false);
        this.cboMesNac.setEnabled(false); this.cboMesContratacion.setEnabled(false);
        this.cboCargo.setEnabled(false); this.btnGuardarEmpleado.setEnabled(false);
        this.btnModificarEmpleado.setEnabled(false); this.btnRemoverEmpleado.setEnabled(false);
        this.btnGenerarPassword.setEnabled(false); this.jsDiaContratacion.setValue(1);
        this.txtIdEmpleado.requestFocus(); btnVerPassword.setEnabled(false);
        this.btnModificarPassword.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarEmpleadoActionPerformed

    //1. Ventana empleados: Muestra/oculta password en ventana de empleados.
    private void btnVerPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPasswordActionPerformed
        try { //Muestra password.
        if (passwordVisible == false) {
            txtPasswordEmpleado.setEchoChar((char)0); passwordVisible = true;
            btnVerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/showpassword.png")));
        }
        else { //Oculta password.
            txtPasswordEmpleado.setEchoChar('•'); passwordVisible = false;
            btnVerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/password.png")));
        }        
        } catch(Exception ex){}
    }//GEN-LAST:event_btnVerPasswordActionPerformed

    //2. Ventana ventas: Permite buscar e ingresar un producto por su ID.
    private void btnIngresarProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarProductoVentaActionPerformed
        try {
            //No permitir espacios en blanco.
            if (this.txtIdProductoVenta.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese una id válida.",
                    "Registro de ventas", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            //Valida int.
            if (txtIdProductoVenta.getText().trim().isEmpty() || 
                  !(Pattern.matches("^\\d+$", txtIdProductoVenta.getText()))) { 
                JOptionPane.showMessageDialog(null, "Ingrese un id válido.",
                    "Registro de ventas", JOptionPane.WARNING_MESSAGE);
                return;
            }
               
            int id = Integer.parseInt(this.txtIdProductoVenta.getText());
            this.txtIdProductoVenta.setText(""); btnRemoverProductoVenta.setEnabled(false);
            this.lProductos = this.dba.getListaProductos("","");
            for (int i = 0; i < lProductos.size(); i++) {
                if (lProductos.get(i).getId_producto() == id) {
                    this.cboProducto.setSelectedItem(lProductos.get(i).getNombre());
                return;
                }    
            }      
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_btnIngresarProductoVentaActionPerformed

    //2. Ventana ventas: Agrega un producto seleccionado a la orden de venta.
    private void btnAgregarProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoVentaActionPerformed
        try {  
            // - - - - - - - - - - /validaciones. - - - - - - - - -
            //Validando existencias disponibles.
            int cantidad = Integer.parseInt(jsCantidadVenta.getValue().toString());
            int existencia = dba.getProducto(cboProducto.getSelectedItem().toString()).getExistencia();
            
            if (existencia - cantidad < 0) {
                JOptionPane.showMessageDialog(null, "Este producto no dispone de suficientes existencias; Disponible: "+
                        existencia +"",
                    "Registro de ventas", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // - - - - - - - - - - Fin/validaciones. - - - - - - - - -
            
            this.btnConfirmarVenta.setEnabled(true); this.jtPedidoVenta.clearSelection();
            btnRemoverProductoVenta.setEnabled(false);
            
            //1. Si el producto ha sido agregado antes, aumentara su cantidad a ordenar.
            for (int i = 0; i < this.modeloPedidoVenta.getRowCount(); i++) {
                if (this.modeloPedidoVenta.getValueAt(i, 1).equals(this.cboProducto.getSelectedItem().toString())) {
                    
                    int cantidad_actual = Integer.parseInt(this.modeloPedidoVenta.getValueAt(i, 3).toString());
                    
                    //Validando existencias disponibles.
                    if (existencia - (cantidad + cantidad_actual) < 0) {
                        JOptionPane.showMessageDialog(null, "Este producto no dispone de suficientes existencias; Disponible: "+
                        existencia +"",
                        "Registro de ventas", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    //Sumando cantidad a ordenar.
                    this.modeloPedidoVenta.setValueAt(cantidad_actual + 
                        Integer.parseInt(jsCantidadVenta.getValue().toString()), i, 3);
                    
                    //Actualizando total.
                    this.modeloPedidoVenta.setValueAt(
                        String.format("$ %.2f", (Double.parseDouble(this.modeloPedidoVenta.getValueAt(i, 2).toString().substring(2)) *
                        Double.parseDouble(this.modeloPedidoVenta.getValueAt(i, 3).toString()))), i, 4);
                    
                    //Actualizando total de venta.
                    this.obtenerTotalVenta();
                    return;
                }
            }
            
            //2. Si el producto no ha sido agregado antes, se agregara a la orden.
            String[] registroV = {
                Integer.toString(this.dba.getProducto(this.cboProducto.getSelectedItem().toString()).getId_producto()),
                this.cboProducto.getSelectedItem().toString(), 
                this.txtPrecioVenta.getText(),
                this.jsCantidadVenta.getValue().toString(),
                String.format("$ %.2f", 
                Double.parseDouble(this.jsCantidadVenta.getValue().toString()) *
                Double.parseDouble(this.txtPrecioVenta.getText().substring(2)) )
            };
            
            //Agregando productos a pedido. (Compra).
            modeloPedidoVenta.addRow(registroV);
            
            //Actualizando total de venta.
            this.obtenerTotalVenta();
            jsCantidadVenta.setValue(1);
                    
        } catch (SQLException ex) {Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}        
    }//GEN-LAST:event_btnAgregarProductoVentaActionPerformed
    //2. Ventana ventas: Obtiene el total de la orden de venta y lo muestra.
    public void obtenerTotalVenta() {  
        try {
            double total = 0;
            for (int i = 0; i < this.modeloPedidoVenta.getRowCount(); i++) {
                total = total + (Double.parseDouble(modeloPedidoVenta.getValueAt(i, 4).toString().substring(2)));
            }
            this.txtTotalVenta.setText(String.format("$ %.2f",total)); //Mostrando total.
        } catch(Exception ex){}
    }
    
    //2. Ventana ventas: Remueve un producto seleccionado de la orden de venta.
    private void btnRemoverProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverProductoVentaActionPerformed
         try {
            //Removiendo producto seleccionado.
            modeloPedidoVenta.removeRow(this.jtPedidoVenta.getSelectedRow());
            this.obtenerTotalVenta(); //Actualizando total de venta.
            this.btnRemoverProductoVenta.setEnabled(false);
        } 
        catch(Exception ex) { } 
    }//GEN-LAST:event_btnRemoverProductoVentaActionPerformed

    //2. Ventana ventas: Completa y registra la orden de venta.
    private void btnConfirmarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarVentaActionPerformed
        try {
            // - - - - - - - - - - /validaciones. - - - - - - - - -
            //Existencia de productos en orden.
            if (this.modeloPedidoVenta.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese productos para completar esta orden.",
                    "Registro de ventas.", JOptionPane.WARNING_MESSAGE);
                return;
            }
 
            // - - - - - - - - - - Fin/validaciones. - - - - - - - - -

            this.btnRemoverProductoVenta.setEnabled(false); this.btnConfirmarVenta.setEnabled(false);
            this.jtPedidoVenta.clearSelection(); this.txtTotalVenta.setText("$ 0.00");
            
            //Nueva venta.
            venta = new Venta();
            venta.setId_empleado(Integer.parseInt(this.txtIdEmpleadoVenta.getText()));
            venta.setId_venta(Integer.parseInt(this.txtIdVenta.getText()));
            
            String id_venta = this.txtIdVenta.getText();
            //Obteniendo detalles de venta.
            for (int i = 0; i < this.modeloPedidoVenta.getRowCount(); i++) {
                
                venta.lProductosPorVenta.add(new ProductoPorVenta());
                venta.lProductosPorVenta.get(i).setId(Integer.parseInt(this.txtIdVenta.getText()));             
                venta.lProductosPorVenta.get(i).setId_producto(
                    Integer.parseInt(this.modeloPedidoVenta.getValueAt(i, 0).toString()));
                venta.lProductosPorVenta.get(i).setPrecio(
                    Double.parseDouble(this.modeloPedidoVenta.getValueAt(i, 2).toString().substring(2)));
                venta.lProductosPorVenta.get(i).setCantidad(
                    Integer.parseInt(this.modeloPedidoVenta.getValueAt(i, 3).toString()));
            }
 
            this.dba.registrarVenta(venta); //Registrando venta.
            
            //Limpiando tabla de orden.
            this.modeloPedidoVenta.getDataVector().removeAllElements();
            this.modeloPedidoVenta.fireTableDataChanged(); 
            
            this.txtIdVenta.setText(dba.getNuevoIdVenta()); //Calculando nuevo id de prox. venta.
            this.mostrarVentas("","");//Actualizar tabla de ventas.
            this.mostrarProductos("", ""); //Actualizar productos.
            jsCantidadVenta.setValue(1);
             
            JOptionPane.showMessageDialog(null, "La venta con id: " + venta.getId_venta()+"  ha sido registrada con éxito.",
               "Registro de ventas", JOptionPane.INFORMATION_MESSAGE);
            
            //Generando y mostrando reporte de venta.
          //  this.generarReporteVenta(id_venta);
            
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnConfirmarVentaActionPerformed

    //3. Ventana compras: Ir a inventario desde panel de compras.
    private void btnCompraIrAInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraIrAInventarioActionPerformed
        this.jtpPrincipal.setSelectedIndex(4);
    }//GEN-LAST:event_btnCompraIrAInventarioActionPerformed

    //3. Ventana compras: Ir a registro de proveedores desde panel de compras.
    private void btnCompraIrAProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraIrAProveedoresActionPerformed
        this.jtpPrincipal.setSelectedIndex(6);
    }//GEN-LAST:event_btnCompraIrAProveedoresActionPerformed

    //3. Ventana compras: Agrega un producto seleccionado a la orden de compra.
    private void btnAgregarProductoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoCompraActionPerformed
        try {
            // - - - - - - - - - - /validaciones. - - - - - - - - -
            //Nombre - No permitir espacios en blanco.
            if (txtNombreProductoCompra.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese un nombre de producto válido.",
                    "Registro de compras", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Nombre - Permitir solamente el ingreso de letras.
            if (!(Pattern.matches("^([A-z]\\s?)+$", txtNombreProductoCompra.getText()))) {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre de producto con letras únicamente.",
                    "Registro de compras", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            //Fabricante - No permitir espacios en blanco.
            if (txtFabricante.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese un nombre de fabricante válido.",
                    "Registro de compras", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Fabricante - Permitir solamente el ingreso de letras.
            if (!(Pattern.matches("^([A-z]\\s?)+$", txtFabricante.getText()))) {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre de fabricante con letras únicamente.",
                    "Registro de compras", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            //Precio - No permitir espacios en blanco o un length inferior al establecido. 
            if (txtPrecioCompra.getText().trim().isEmpty() || 
                    !(Pattern.matches("^(0*[1-9][0-9]*(\\.[0-9]*)?|0*\\.[0-9]*[1-9][0-9]*)$", txtPrecioCompra.getText()))) { 
                JOptionPane.showMessageDialog(null, "Ingrese un precio válido.",
                    "Registro de compras", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // - - - - - - - - - - Fin/validaciones. - - - - - - - - -
            
            this.btnConfirmarOrden.setEnabled(true); btnRemoverProductoCompra.setEnabled(false);
            this.jtCatalogo.clearSelection(); this.jtPedidoCompra.clearSelection();
         
            //1. Si el producto ha sido agregado antes, aumentar cantidad a ordenar.
            for (int i = 0; i < this.modeloPedidoCompra.getRowCount(); i++) {
                if (this.modeloPedidoCompra.getValueAt(i, 0).equals(this.txtNombreProductoCompra.getText())) {

                    //Sumando cantidad seleccionada.
                    this.modeloPedidoCompra.setValueAt(
                        Integer.parseInt(this.modeloPedidoCompra.getValueAt(i, 5).toString()) + 
                        Integer.parseInt(jsCantidadCompra.getValue().toString()), i, 5);

                    //Actualizando total.
                    this.modeloPedidoCompra.setValueAt(
                        String.format("$ %.2f", (Double.parseDouble(this.modeloPedidoCompra.getValueAt(i, 4).toString().substring(2)) * 
                        Double.parseDouble(this.modeloPedidoCompra.getValueAt(i, 5).toString()))), i, 6);

                    this.obtenerTotalCompra(); //Actualizando total de compra.
                    return;
                }
            }

            //2. Si el producto no ha sido agregado antes, sera agregado.
            String[] registroC = {
                this.txtNombreProductoCompra.getText(), 
                this.txtFabricante.getText(),
                this.cboProveedorCompra.getSelectedItem().toString(),
                this.cboCategoriaCompra.getSelectedItem().toString(),
                String.format("$ %.2f", Double.parseDouble(this.txtPrecioCompra.getText())),
                this.jsCantidadCompra.getValue().toString(),
                String.format("$ %.2f", 
                Double.parseDouble(this.jsCantidadCompra.getValue().toString()) *
                Double.parseDouble(this.txtPrecioCompra.getText()) )
            };

            //Agregando productos a pedido.
            modeloPedidoCompra.addRow(registroC);

            this.obtenerTotalCompra(); //Actualizando total de compra.
            jsCantidadCompra.setValue(1);
        } catch(HeadlessException | NumberFormatException ex){}
    }//GEN-LAST:event_btnAgregarProductoCompraActionPerformed

    //3. Ventana compras: Obtiene y muestra el total de la orden de compra.
    public void obtenerTotalCompra() {  
        try {
            double total = 0;
            for (int i = 0; i < this.modeloPedidoCompra.getRowCount(); i++) {
                total = total + (Double.parseDouble(modeloPedidoCompra.getValueAt(i, 6).toString().substring(2)));
            }
            this.txtTotalCompra.setText(String.format("$ %.2f",total)); //Muestra el total de compra.
        } catch(Exception ex){}
    }
     
    //3. Ventana compras: Remueve un producto seleccionado de la orden de compra.
    private void btnRemoverProductoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverProductoCompraActionPerformed
        try {
            //Removiendo producto seleccionado.
            modeloPedidoCompra.removeRow(this.jtPedidoCompra.getSelectedRow());
            this.obtenerTotalCompra();  //Actualizando total de compra.
            btnRemoverProductoCompra.setEnabled(false);
        } catch(Exception ex) {} 
    }//GEN-LAST:event_btnRemoverProductoCompraActionPerformed

    //3. Ventana compras: Completa y registra la orden de compra.
    private void btnConfirmarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarOrdenActionPerformed
         try {
            // - - - - - - - - - - /validaciones. - - - - - - - - -
            //Existencia de productos en orden.
            if (this.modeloPedidoCompra.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese productos para completar esta orden.",
                    "Registro de compras.", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // - - - - - - - - - - Fin/validaciones. - - - - - - - - -

            this.btnRemoverProductoCompra.setEnabled(false);  this.btnConfirmarOrden.setEnabled(false);
            this.jtCatalogo.clearSelection(); this.jtPedidoCompra.clearSelection();
            
            //Nueva compra.
            compra = new Compra();
            compra.lProductos.clear();
            compra.lProductosPorCompra.clear();
            compra.setId_empleado(Integer.parseInt(this.txtIdEmpleadoCompra.getText()));
            compra.setId_compra(Integer.parseInt(this.txtIdCompra.getText()));
            
            //1. Registrando aquellos productos que no se encuentran ingresados.
            for (int i = 0; i < this.modeloPedidoCompra.getRowCount(); i++) {
                String nombre = this.modeloPedidoCompra.getValueAt(i, 0).toString();
                if (this.dba.getIdProducto(nombre).equals("0")) {  //si es nulo == 0, no existe entonces agregarlo
                   
                    //Lista de productos a ingresar.
                    compra.lProductos.add(new Producto());
                
                    //0 = Representa un id nula, estos productos no disponen de una id existente.
                    compra.lProductos.get( compra.lProductos.size()-1).setNombre(
                        this.modeloPedidoCompra.getValueAt(i, 0).toString());
                    compra.lProductos.get( compra.lProductos.size()-1).setFabricante(
                        this.modeloPedidoCompra.getValueAt(i, 1).toString());
                    compra.lProductos.get( compra.lProductos.size()-1).setPecio(
                        Double.parseDouble(this.modeloPedidoCompra.getValueAt(i, 4).toString().substring(2)));
                    compra.lProductos.get( compra.lProductos.size()-1).setExistencia(0);
                    compra.lProductos.get( compra.lProductos.size()-1).setId_categoria(
                        Integer.parseInt(this.dba.getIdCategoria(modeloPedidoCompra.getValueAt(i, 3).toString())));
                    compra.lProductos.get( compra.lProductos.size()-1).setId_proveedor(
                        Integer.parseInt(this.dba.getIdProveedor(this.modeloPedidoCompra.getValueAt(i, 2).toString())));   
                    
                    //Registrando productos.
                    dba.registrarProducto(compra.lProductos.get(compra.lProductos.size()-1));
                }
            }
            
            //2. Obteniendo detalles de compra.
            for (int i = 0; i < this.modeloPedidoCompra.getRowCount(); i++) {
                
                compra.lProductosPorCompra.add(new ProductoPorCompra());
                
                compra.lProductosPorCompra.get(i).setId(Integer.parseInt(this.txtIdCompra.getText()));             
                compra.lProductosPorCompra.get(i).setId_producto( 
                    Integer.parseInt(dba.getIdProducto(this.modeloPedidoCompra.getValueAt(i, 0).toString())));
                compra.lProductosPorCompra.get(i).setPrecio(
                    Double.parseDouble(this.modeloPedidoCompra.getValueAt(i, 4).toString().substring(2)));
                compra.lProductosPorCompra.get(i).setCantidad(
                    Integer.parseInt(this.modeloPedidoCompra.getValueAt(i, 5).toString()));       
            }
            
            //Registrar compra.
            this.dba.registrarCompra(compra);
            
            this.txtIdCompra.setText(dba.getNuevoIdCompra()); //Calculando id de prox. compra.
            
            //Limpiando tabla de orden. Habilitando/Deshabilitando controles.
            this.modeloPedidoCompra.getDataVector().removeAllElements();
            this.modeloPedidoCompra.fireTableDataChanged();
            jsCantidadCompra.setValue(1); txtFabricante.setText(""); txtNombreProductoCompra.setText("");
            txtPrecioCompra.setText(""); this.chkNuevoProd.setSelected(false); this.chkCatalogo.doClick();
            this.txtTotalCompra.setText("$ 0.00"); btnAgregarProductoCompra.setEnabled(false);
            
            this.mostrarCompras("", "");//Actualizando tabla de compras.
            this.mostrarCatalogo(); //Actualizar catalogo.
            this.poblarProductosVenta(); //Actualizar lista de productos para venta.
            this.mostrarProductos("", ""); //Actualizar productos.
            JOptionPane.showMessageDialog(null, "La compra con id: " + compra.getId_compra()+"  ha sido registrada con éxito.",
                    "Registro de compras", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_btnConfirmarOrdenActionPerformed

    //4. Ventana inventario: Realiza una busqueda en el registro de productos.
    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        try {
            
            //No permitir espacios en blanco.
            if (this.txtBusquedaProductos.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese un filtro válido.",
                    "Inventario", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String campo = "";
            
            if (this.chkIdProducto.isSelected()) campo = "id_producto";
            else if (this.chkNombreProductos.isSelected()) campo = "nombre";
            else if (this.chkFabricante.isSelected()) campo = "fabricante";
            else if (this.chkProveedorProductos.isSelected()) campo = "id_proveedor";
            else if (this.chkCategoriaProductos.isSelected()) campo = "id_categoria";
            
            String filtro = this.txtBusquedaProductos.getText();
            this.mostrarProductos(campo,filtro); //Muestra el resultado de busqueda.
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    //4. Ventana inventario: Reinicia la busqueda en el registro de productos.
    private void btnReiniciarBusqProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarBusqProductoActionPerformed
       try {
            this.mostrarProductos("",""); //Muestra el registro original.
            this.txtBusquedaProductos.setText("");
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnReiniciarBusqProductoActionPerformed

    //1. Ventana empleados: Reinicia la busqueda en el registro de ventas.
    private void btnReiniciarBusquedaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarBusquedaEmpleadoActionPerformed
        try {
            this.mostrarEmpleados("",""); //Muestra el registro original.
            this.btnLimpiarEmpleado.doClick();
            this.txtBusquedaEmpleado.setText("");
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnReiniciarBusquedaEmpleadoActionPerformed

    //1. Ventana empleados: Realiza una busqueda en el registro de empleados.
    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        try {
            
            //No permitir espacios en blanco.
            if (this.txtBusquedaEmpleado.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese un filtro válido.",
                    "Gestión de empleados", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String campo = "";
            
            if (this.chkId_empleado.isSelected()) campo = "id_empleado";
            else if (this.chkNombreEmpleado.isSelected()) campo = "nombre";
            else if (this.chkApellidoEmpleado.isSelected()) campo = "apellido";
            else if (this.chkUsuarioEmpleado.isSelected()) campo = "usuario";
            else if (this.chkCargo.isSelected()) campo = "id_cargo";
            else if (this.chkContratacion.isSelected()) campo = "fechaContratacion";
            
            String filtro = this.txtBusquedaEmpleado.getText();
            this.btnLimpiarEmpleado.doClick();
            this.mostrarEmpleados(campo,filtro); //Muestra el resultado de busqueda.
        } catch (SQLException ex) {  Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    //5. Ventana ordenes: Realiza una busqueda en el registro de ventas.
    private void btnBuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaActionPerformed
        try {
            //No permitir espacios en blanco.
            if (this.txtBusquedaVenta.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese un filtro válido.",
                    "Ordenes", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String campo = "";
            
            if (this.chkIdVenta.isSelected()) campo = "id_venta";
            else if (this.chkIdEmpleadoVenta.isSelected()) campo = "id_empleado";
            else if (this.chkFechaVenta.isSelected()) campo = "fecha";
  
            String filtro = this.txtBusquedaVenta.getText();
            this.mostrarVentas(campo,filtro); //Muestra el resultado de busqueda.
            
            //Limpiando tabla detalle.
            this.modeloDetalleVenta.getDataVector().removeAllElements();
            this.modeloDetalleVenta.fireTableDataChanged();
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnBuscarVentaActionPerformed

    //5. Ventana ordenes: Reinicia la busqueda en el registro de ventas.
    private void btnReiniciarBusqVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarBusqVentaActionPerformed
        try {
            this.mostrarVentas("",""); //Muestra el registro original.
            this.txtBusquedaVenta.setText("");
            //Limpiando tabla detalle.
            this.modeloDetalleVenta.getDataVector().removeAllElements();
            this.modeloDetalleVenta.fireTableDataChanged();
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnReiniciarBusqVentaActionPerformed

    //5. Ventana ordenes: Realiza una busqueda en el registro de compras.
    private void btnBuscarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCompraActionPerformed
        try {
            
            //No permitir espacios en blanco.
            if (this.txtBusquedaCompra.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese un filtro válido.",
                    "Ordenes", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String campo = "";
            
            if (this.chkIdCompra.isSelected()) campo = "id_compra";
            else if (this.chkIdEmpleado.isSelected()) campo = "id_empleado";
            else if (this.chkFechaCompra.isSelected()) campo = "fecha";
  
            String filtro = this.txtBusquedaCompra.getText();
            this.mostrarCompras(campo,filtro); //Muestra el resultado de busqueda.
           //Limpiando tabla detalle.
            this.modeloDetalleCompra.getDataVector().removeAllElements();
            this.modeloDetalleCompra.fireTableDataChanged();
        } catch (SQLException ex) {  Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnBuscarCompraActionPerformed

    //5. Ventana ordenes: Reinicia la busqueda en el registro de compras.
    private void btnReiniciarBusqCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarBusqCompraActionPerformed
        try {
            this.mostrarCompras("",""); //Muestra el registro original.
            this.txtBusquedaCompra.setText("");
            //Limpiando tabla detalle.
            this.modeloDetalleCompra.getDataVector().removeAllElements();
            this.modeloDetalleCompra.fireTableDataChanged();
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_btnReiniciarBusqCompraActionPerformed

    //6. Ventana proveedores: Realiza una busqueda en el registro de proveedores.
    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        try {
           
            //No permitir espacios en blanco.
            if (this.txtBusquedaProveedor.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese un filtro válido.",
                    "Proveedores", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String campo = "";
            
            if (this.chkIdProveedor.isSelected()) campo = "id_proveedor";
            else if (this.chkNombreProveedor.isSelected()) campo = "nombre";
  
            String filtro = this.txtBusquedaProveedor.getText();
            this.mostrarProveedores(campo,filtro); //Muestra el resultado de busqueda.
            jtProveedor.clearSelection();
            modeloProductoProveedor.getDataVector().removeAllElements();
            modeloProductoProveedor.fireTableDataChanged();
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    //6. Ventana proveedores: Reinicia la busqueda en el registro de proveedores.
    private void btnReiniciarBusqProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarBusqProveedorActionPerformed
        try {
            this.mostrarProveedores("",""); //Muestra el registro original.
            this.txtBusquedaProveedor.setText("");
            jtProveedor.clearSelection();
            modeloProductoProveedor.getDataVector().removeAllElements();
            modeloProductoProveedor.fireTableDataChanged();
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnReiniciarBusqProveedorActionPerformed

    //6. Ventana proveedores: Registra al proveedor ingresado.
    private void btnRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProveedorActionPerformed
        try {
            //Nombre - No permitir espacios en blanco. 
            if (this.txtNuevoProveedor.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido.",
                    "Proveedores", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Nombre - Permitir solamente el ingreso de letras.
            if (!(Pattern.matches("^([A-z]\\s?)+$", txtNuevoProveedor.getText()))) {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre con letras únicamente.",
                    "Proveedores", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            this.dba.registrarProveedor(this.txtNuevoProveedor.getText()); //Registra un proveedor.
            this.txtNuevoProveedor.setText(""); 
            this.mostrarProveedores("",""); //Actualiza la tabla de proveedores.
            this.poblarProveedoresCompra(); //Actualizar lista de proveedores.
            jtProveedor.clearSelection();
            modeloProductoProveedor.getDataVector().removeAllElements();
            modeloProductoProveedor.fireTableDataChanged();
        } catch (SQLException ex) {Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnRegistrarProveedorActionPerformed

    //0. Ventana principal: Permite regresar al inicio (Panel principal del empleado correspondiente).
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        switch(id_cargo) {
            case 1: //Ir a panel de gestion de empleados.
                this.jtpPrincipal.setSelectedIndex(1);
                break;
            case 2: //Ir a panel de ventas.
                this.jtpPrincipal.setSelectedIndex(2);
                break;
            case 3: //Ir a panel de compas.
                this.jtpPrincipal.setSelectedIndex(3);
                break; 
            }   
    }//GEN-LAST:event_btnInicioActionPerformed

    //0. Ventana principal: Cierra la sesion actual del empleado.
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try {
            jpHome.setVisible(false); jpSalir.setVisible(false); jpUsuario.setVisible(false);
            this.jtpPrincipal.setSelectedIndex(0); this.lblUser.setText(""); id_cargo = 0;
            this.dba.cerrarConexion(); this.btnIngresar.requestFocus();
        } catch (SQLException ex) {Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btnSalirActionPerformed

    //Minimiza la ventana.
    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    //Cierra la ventana.
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

   //1. Ventana empleados: Metodo generador de password para empleados.
    public static String generarPassword(int length, String diccionario) {
	String result = "";
	for (int i = 0; i < length; i++) {
            Random randomChar  = new Random(); 
	    int index = randomChar.nextInt(diccionario.length());
	    result += diccionario.charAt(index);
	}
	return result;
    }
    
    //1. Ventana empleados: Genera password de empleado.
    private void btnGenerarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPasswordActionPerformed
        
        //Caracteres disponibles.
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = mayusculas.toLowerCase();
        String numeros = "0123456789";
        String char_especiales = "$?@#%&_-!";
        
        //Generando y Mostrando password hasta cumplir los requisitos: 1 Mayus, 1 minus, 1 num.
        String password = "";
       
        do { password = generarPassword(8, mayusculas+minusculas+numeros+char_especiales); } 
        while (!(Pattern.matches("^(?=.{8})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{8}$", password)));
        
        this.txtPasswordEmpleado.setText(password);
    }//GEN-LAST:event_btnGenerarPasswordActionPerformed

    //3. Ventana compras: Modo de ingreso de productos para compra - Manual.
    private void chkNuevoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNuevoProdActionPerformed
        txtNombreProductoCompra.setEditable(true); cboCategoriaCompra.setEnabled(true);
        txtPrecioCompra.setEditable(true); cboProveedorCompra.setEnabled(true);
        txtFabricante.setEditable(true); this.jtCatalogo.clearSelection();
        btnAgregarProductoCompra.setEnabled(true);
    }//GEN-LAST:event_chkNuevoProdActionPerformed

    //3. Ventana compras: Modo de ingreso de productos para compra - Mediante catalogo.
    private void chkCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCatalogoActionPerformed
        txtNombreProductoCompra.setEditable(false); cboCategoriaCompra.setEnabled(false);
        txtPrecioCompra.setEditable(false); cboProveedorCompra.setEnabled(false);
        txtFabricante.setEditable(false); this.jtPedidoCompra.clearSelection();
        this.txtIdCompra.requestFocus(); btnAgregarProductoCompra.setEnabled(true);
    }//GEN-LAST:event_chkCatalogoActionPerformed

    //1. Ventana empleados: Seleccion de registro en la tabla empleados.
    private void jtEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpleadoMouseClicked
        try {
            this.txtNombreEmpleado.setEditable(false);
            this.txtApellidoEmpleado.setEditable(false);
            this.txtSalario.setEditable(false); this.txtIdEmpleado.requestFocus();
            this.txtUsuarioEmpleado.setEditable(false);
            this.txtPasswordEmpleado.setEditable(false);
            this.jsDiaNac.setEnabled(false); this.jsDiaContratacion.setEnabled(false);
            this.jsAñoNac.setEnabled(false); this.jsAñoContratacion.setEnabled(false);
            this.cboMesNac.setEnabled(false); this.cboMesContratacion.setEnabled(false);
            this.cboCargo.setEnabled(false); this.btnGuardarEmpleado.setEnabled(false);
            this.btnModificarEmpleado.setEnabled(true); this.btnRemoverEmpleado.setEnabled(false);
            this.btnGenerarPassword.setEnabled(false);
            
            //Mostrando datos de empleado seleccionado.
            int selectedRow = jtEmpleado.getSelectedRow();
            String id_empleado = jtEmpleado.getValueAt(selectedRow,0).toString();
            
            empleado = this.dba.getEmpleado(id_empleado);
            
            this.txtIdEmpleado.setText(Integer.toString(empleado.getId()));
            this.txtNombreEmpleado.setText(empleado.getNombre());
            this.txtApellidoEmpleado.setText(empleado.getApellido());
            this.txtUsuarioEmpleado.setText(empleado.getUsuario());
            this.txtSalario.setText(  String.format("%.2f",empleado.getSalario()));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(empleado.getFechaNacimiento());
            
            jsDiaNac.setValue(calendar.get(Calendar.DAY_OF_MONTH));
            cboMesNac.setSelectedIndex(calendar.get(Calendar.MONTH));
            jsAñoNac.setValue(calendar.get(Calendar.YEAR));
            
            calendar.setTime(empleado.getFechaContratacion());
            jsDiaContratacion.setValue(calendar.get(Calendar.DAY_OF_MONTH));
            cboMesContratacion.setSelectedIndex(calendar.get(Calendar.MONTH));
            jsAñoContratacion.setValue(calendar.get(Calendar.YEAR));
            
            cboCargo.setSelectedItem(dba.getNombreCargo(Integer.toString(empleado.getCargo())));
            
            this.txtPasswordEmpleado.setText("");
        } catch (SQLException ex) {Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_jtEmpleadoMouseClicked

    //3. Ventana compras: Seleccion de producto en la tabla catalogo.
    private void jtCatalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCatalogoMouseClicked
        try {
            this.chkCatalogo.doClick();
            this.jtPedidoCompra.clearSelection(); btnRemoverProductoCompra.setEnabled(false);
            
            //Obteniendo índice de producto seleccionado.
            int index = jtCatalogo.getSelectedRow();
                     
            //Mostrando descripción de producto seleccionado.
            this.txtNombreProductoCompra.setText(this.modeloCatalogo.getValueAt(index, 0).toString());
            this.txtFabricante.setText(this.modeloCatalogo.getValueAt(index, 1).toString());
            this.cboProveedorCompra.setSelectedItem(this.modeloCatalogo.getValueAt(index, 2).toString());
            this.cboCategoriaCompra.setSelectedItem(this.modeloCatalogo.getValueAt(index, 3).toString());
            this.txtPrecioCompra.setText(this.modeloCatalogo.getValueAt(index, 4).toString().substring(2));                        
        } 
        catch(Exception ex) { } 
    }//GEN-LAST:event_jtCatalogoMouseClicked

    //3. Ventana compras: Seleccion de registro en la tabla pedido de compra.
    private void jtPedidoCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPedidoCompraMouseClicked
          try {
            //Obteniendo índice de producto seleccionado.
            int index = this.jtPedidoCompra.getSelectedRow();
                     
            //Mostrando descripción de producto seleccionado.
            this.txtNombreProductoCompra.setText(this.modeloPedidoCompra.getValueAt(index, 0).toString());
            this.txtFabricante.setText(this.modeloPedidoCompra.getValueAt(index, 1).toString());
            this.cboProveedorCompra.setSelectedItem(this.modeloPedidoCompra.getValueAt(index, 2).toString());
            this.cboCategoriaCompra.setSelectedItem(this.modeloPedidoCompra.getValueAt(index, 3).toString());
            this.txtPrecioCompra.setText(this.modeloPedidoCompra.getValueAt(index, 4).toString().substring(2));   
            this.jsCantidadCompra.setValue(Integer.parseInt(this.modeloPedidoCompra.getValueAt(index, 5).toString()));
            
            //Deshabilitando controles.
            btnRemoverProductoCompra.setEnabled(true);
            this.jtCatalogo.clearSelection();
            
        } 
        catch(Exception ex) {
        } 
    }//GEN-LAST:event_jtPedidoCompraMouseClicked

    //2. Ventana ventas: Muestra los datos del producto seleccionado.
    private void cboProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProductoItemStateChanged
         try {
            //Mostrando precio de producto seleccionado.
            this.txtPrecioVenta.setText(String.format("$ %.2f",
            this.dba.getProducto(this.cboProducto.getSelectedItem().toString()).getPrecio()));
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_cboProductoItemStateChanged

    //5. Ventana ordenes: Selecciona una venta y muestra sus detalles.
    private void jtVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVentaMouseClicked
        try {
            this.mostrarDetalleVenta();
        } catch (SQLException ex) { Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_jtVentaMouseClicked

    //5. Ventana ordenes: Selecciona una compra y muestra sus detalles.
    private void jtCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCompraMouseClicked
        try {
            this.mostrarDetalleCompra();
        } catch (SQLException ex) {Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_jtCompraMouseClicked

    //1. Ventana empleados: Permite modificar la password de un empleado existente.
    private void btnModificarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPasswordActionPerformed
        this.txtPasswordEmpleado.setEditable(true); this.btnGenerarPassword.setEnabled(true);
        this.btnVerPassword.setEnabled(true); this.btnGenerarPassword.doClick();
        this.btnModificarPassword.setEnabled(false);
    }//GEN-LAST:event_btnModificarPasswordActionPerformed

     //2. Ventana ventas: Selecciona un producto en la orden de venta.
    private void jtPedidoVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPedidoVentaMouseClicked
        this.btnRemoverProductoVenta.setEnabled(true);
    }//GEN-LAST:event_jtPedidoVentaMouseClicked

    //1. Ventana empleados: Validacion Length - nombre.
    private void txtNombreEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEmpleadoKeyReleased
        //Max length.
        if (txtNombreEmpleado.getText().length() > 20) {
            int res = txtNombreEmpleado.getText().length() - 20;
            txtNombreEmpleado.setText(txtNombreEmpleado.getText().substring(0, txtNombreEmpleado.getText().length()-res));
        }
    }//GEN-LAST:event_txtNombreEmpleadoKeyReleased

    //1. Ventana empleados: Validacion Length - apellido.
    private void txtApellidoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoEmpleadoKeyReleased
        //Max length.
        if (txtApellidoEmpleado.getText().length() > 20) {
            int res = txtApellidoEmpleado.getText().length() - 20;
            txtApellidoEmpleado.setText(txtApellidoEmpleado.getText().substring(0, txtApellidoEmpleado.getText().length()-res));
        }
    }//GEN-LAST:event_txtApellidoEmpleadoKeyReleased

    //1. Ventana empleados: Validacion Length - salario.
    private void txtSalarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyReleased
        //Max length.
        if (txtSalario.getText().length() > 8) {
            int res = txtSalario.getText().length() - 8;
            txtSalario.setText(txtSalario.getText().substring(0, txtSalario.getText().length()-res));
        }
    }//GEN-LAST:event_txtSalarioKeyReleased

    //1. Ventana empleados: Validacion Length - usuario.
    private void txtUsuarioEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioEmpleadoKeyReleased
        //Max length.
        if (txtUsuarioEmpleado.getText().length() > 10) {
            int res = txtUsuarioEmpleado.getText().length() - 10;
            txtUsuarioEmpleado.setText(txtUsuarioEmpleado.getText().substring(0, txtUsuarioEmpleado.getText().length()-res));
        }
    }//GEN-LAST:event_txtUsuarioEmpleadoKeyReleased

    //1. Ventana empleados: Validacion Length - password.
    private void txtPasswordEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordEmpleadoKeyReleased
        //Max length.
        if (txtPasswordEmpleado.getText().length() > 16) {
            int res = txtPasswordEmpleado.getText().length() - 16;
            txtPasswordEmpleado.setText(txtPasswordEmpleado.getText().substring(0, txtPasswordEmpleado.getText().length()-res));
        }
    }//GEN-LAST:event_txtPasswordEmpleadoKeyReleased

    //1. Ventana empleados: Validacion Length - busqueda.
    private void txtBusquedaEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaEmpleadoKeyReleased
        //Max length.
        if (txtBusquedaEmpleado.getText().length() > 20) {
            int res = txtBusquedaEmpleado.getText().length() - 20;
            txtBusquedaEmpleado.setText(txtBusquedaEmpleado.getText().substring(0, txtBusquedaEmpleado.getText().length()-res));
        }
    }//GEN-LAST:event_txtBusquedaEmpleadoKeyReleased

    //3. Ventana compras: Validacion Length - nombre de producto.
    private void txtNombreProductoCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoCompraKeyReleased
        //Max length.
        if (txtNombreProductoCompra.getText().length() > 20) {
            int res = txtNombreProductoCompra.getText().length() - 20;
            txtNombreProductoCompra.setText(txtNombreProductoCompra.getText().substring(0, txtNombreProductoCompra.getText().length()-res));
        }
    }//GEN-LAST:event_txtNombreProductoCompraKeyReleased
   
    //3. Ventana compras: Validacion Length - fabricante.
    private void txtFabricanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFabricanteKeyReleased
        //Max length.
        if (txtFabricante.getText().length() > 20) {
            int res = txtFabricante.getText().length() - 20;
            txtFabricante.setText(txtFabricante.getText().substring(0, txtFabricante.getText().length()-res));
        }
    }//GEN-LAST:event_txtFabricanteKeyReleased

    //3. Ventana compras: Validacion Length - precio.
    private void txtPrecioCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyReleased
        //Max length.
        if (txtPrecioCompra.getText().length() > 6) {
            int res = txtPrecioCompra.getText().length() - 6;
            txtPrecioCompra.setText(txtPrecioCompra.getText().substring(0, txtPrecioCompra.getText().length()-res));
        }
    }//GEN-LAST:event_txtPrecioCompraKeyReleased

    //4. Ventana inventario: Validacion Length - busqueda de productos.
    private void txtBusquedaProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaProductosKeyReleased
        //Max length.
        if (txtBusquedaProductos.getText().length() > 20) {
            int res = txtBusquedaProductos.getText().length() - 20;
            txtBusquedaProductos.setText(txtBusquedaProductos.getText().substring(0, txtBusquedaProductos.getText().length()-res));
        }
    }//GEN-LAST:event_txtBusquedaProductosKeyReleased

    //5. Ventana ordenes:  Validacion Length - busqueda venta.
    private void txtBusquedaVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaVentaKeyReleased
        //Max length.
        if (txtBusquedaVenta.getText().length() > 20) {
            int res = txtBusquedaVenta.getText().length() - 20;
            txtBusquedaVenta.setText(txtBusquedaVenta.getText().substring(0, txtBusquedaVenta.getText().length()-res));
        }
    }//GEN-LAST:event_txtBusquedaVentaKeyReleased
   
    //5. Ventana ordenes:  Validacion Length - busqueda compra.
    private void txtBusquedaCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaCompraKeyReleased
        //Max length.
        if (txtBusquedaCompra.getText().length() > 20) {
            int res = txtBusquedaCompra.getText().length() - 20;
            txtBusquedaCompra.setText(txtBusquedaCompra.getText().substring(0, txtBusquedaCompra.getText().length()-res));
        }
    }//GEN-LAST:event_txtBusquedaCompraKeyReleased

    //6. Ventana proveedores:  Validacion Length - busqueda.
    private void txtBusquedaProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaProveedorKeyReleased
        //Max length.
        if (txtBusquedaProveedor.getText().length() > 20) {
            int res = txtBusquedaProveedor.getText().length() - 20;
            txtBusquedaProveedor.setText(txtBusquedaProveedor.getText().substring(0, txtBusquedaProveedor.getText().length()-res));
        }
    }//GEN-LAST:event_txtBusquedaProveedorKeyReleased
    
    //6. Ventana proveedores:  Validacion Length - nombre de proveedor.
    private void txtNuevoProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoProveedorKeyReleased
        //Max length.
        if (txtNuevoProveedor.getText().length() > 16) {
            int res = txtNuevoProveedor.getText().length() - 16;
            txtNuevoProveedor.setText(txtNuevoProveedor.getText().substring(0, txtNuevoProveedor.getText().length()-res));
        }
    }//GEN-LAST:event_txtNuevoProveedorKeyReleased

    //2. Ventana ventas: Validacion Length - busqueda de id.
    private void txtIdProductoVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoVentaKeyReleased
         //Max length.
        if (txtIdProductoVenta.getText().length() > 6) {
            int res = txtIdProductoVenta.getText().length() - 6;
            txtIdProductoVenta.setText(txtIdProductoVenta.getText().substring(0, txtIdProductoVenta.getText().length()-res));
        }
    }//GEN-LAST:event_txtIdProductoVentaKeyReleased

    //6. Ventana proveedores: muestra productos por proveedor.
    private void jtProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProveedorMouseClicked
        try {
            int selectedRow = jtProveedor.getSelectedRow();
            String id_proveedor = jtProveedor.getValueAt(selectedRow,0).toString();
            
            //Recuperando lista.
            this.lProductos = dba.getListaProductos("id_proveedor", id_proveedor);

            //Limpiando tabla.
            modeloProductoProveedor.getDataVector().removeAllElements();
            modeloProductoProveedor.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lProductos.size(); i++)
            {
                String[] registroP = {
                    Integer.toString(this.lProductos.get(i).getId_producto()),
                    this.lProductos.get(i).getNombre(),
                    this.lProductos.get(i).getFabricante(),
                    String.format("$ %.2f", this.lProductos.get(i).getPrecio()),
                    Integer.toString(this.lProductos.get(i).getExistencia()),
                    this.dba.getCategoria(Integer.toString(this.lProductos.get(i).getId_categoria())).getNombre(),
                    Integer.toString(this.lProductos.get(i).getId_proveedor())};

                //Agregando a tabla.
                modeloProductoProveedor.addRow(registroP);
            }
        } catch(Exception ex){}
    }//GEN-LAST:event_jtProveedorMouseClicked

    //Validacione password inicio.
    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        //Max length.
        if (txtPassword.getText().length() > 16) {
            int res = txtPassword.getText().length() - 16;
            txtPassword.setText(txtPassword.getText().substring(0, txtPassword.getText().length()-res));
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    //Validacion usuario inicio.
    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        //Max length.
        if (txtUsuario.getText().length() > 20) {
            int res = txtUsuario.getText().length() - 20;
            txtUsuario.setText(txtUsuario.getText().substring(0, txtUsuario.getText().length()-res));
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

   /*//Generar reporte para empleados generales.
    private void btnGenerarReporteEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteEmpleadosActionPerformed
        this.mostrarReporte(Paths.get(System.getProperty("user.home")+
            "\\JaspersoftWorkspace\\MyReports\\ReportesFarmacia\\reporte_empleados.jasper"));       
    }//GEN-LAST:event_btnGenerarReporteEmpleadosActionPerformed

    //Generar reporte para ventas generales.
    private void btnGenerarReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteVentasActionPerformed
        this.mostrarReporte(Paths.get(System.getProperty("user.home")+
            "\\JaspersoftWorkspace\\MyReports\\ReportesFarmacia\\reporte_ordenes_de_venta.jasper"));     
    }//GEN-LAST:event_btnGenerarReporteVentasActionPerformed

    //Generar reporte para compras generales.
    private void btnGenerarReporteComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteComprasActionPerformed
        this.mostrarReporte(Paths.get(System.getProperty("user.home")+
            "\\JaspersoftWorkspace\\MyReports\\ReportesFarmacia\\reporte_ordenes_de_compra.jasper"));     
    }//GEN-LAST:event_btnGenerarReporteComprasActionPerformed

    //Generar reporte para productos.
    private void btnGenerarReporteProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteProductosActionPerformed
        this.mostrarReporte(Paths.get(System.getProperty("user.home")+
            "\\JaspersoftWorkspace\\MyReports\\ReportesFarmacia\\reporte_productos.jasper"));     
    }//GEN-LAST:event_btnGenerarReporteProductosActionPerformed
    
    //General y muestra un reporte
  /*  public void mostrarReporte(Path path){ 
        try {
            dba = new DBAdmin("root", "2019mu601");
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(path.toString(),null,dba.getConexion());
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reporte.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf); exp.exportReport();

            JasperPrint jasperPrintWindow = JasperFillManager.fillReport(path.toString(), null,dba.getConexion());
            JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow, false);
            jasperViewer.setVisible(true); jasperViewer.setTitle("Reporte");
        } catch (JRException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }   
    
    // Generar reporte de venta realizada.
 /*   public void generarReporteVenta(String id_venta) throws SQLException{
        try {

            dba = new DBAdmin("root", "2019mu601");
            
            String path = System.getProperty("user.home") 
                 + "\\JaspersoftWorkspace\\MyReports\\ReportesFarmacia\\reporte_venta.jasper";
            
            //Parameter map.
            Map parametersMap = new HashMap();  
            parametersMap.put("id_orden_venta", id_venta); 

            JasperPrint jasperPrint = JasperFillManager.fillReport(path, parametersMap, dba.getConexion());
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reporte de venta.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf); exp.exportReport();

            JasperPrint jasperPrintWindow = JasperFillManager.fillReport(path, parametersMap, dba.getConexion());
            JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow, false);
            jasperViewer.setVisible(true); jasperViewer.setTitle("Reporte de venta");
        } catch (JRException ex) {} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(frmFarmacia.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }*/
    
    //5. Ventana ordenes: Muestra los detalles de compra.
    public void mostrarDetalleCompra() throws SQLException {
        try {
            int selectedRow = jtCompra.getSelectedRow();
            String id_compra = jtCompra.getValueAt(selectedRow,0).toString();
            
            //Recuperando lista.
            this.lProductoPorCompra = dba.getListaDetalleCompra(id_compra);

            //Limpiando tabla.
            modeloDetalleCompra.getDataVector().removeAllElements();
            modeloDetalleCompra.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lProductoPorCompra.size(); i++)
            {
                String[] registroDc = {
                    Integer.toString(this.lProductoPorCompra.get(i).getId_compra()),
                    Integer.toString(this.lProductoPorCompra.get(i).getId_producto()),
                    String.format("$ %.2f",this.lProductoPorCompra.get(i).getPrecio()),
                    Integer.toString(this.lProductoPorCompra.get(i).getCantidad())};

                //Agregando a tabla.
                modeloDetalleCompra.addRow(registroDc);
            }
        } catch(Exception ex){}
    }
    
    //5. Ventana ordenes: Muestra los detalles de venta.
    public void mostrarDetalleVenta() throws SQLException {
        try {
            int selectedRow = jtVenta.getSelectedRow();
            String id_venta = jtVenta.getValueAt(selectedRow,0).toString();
            
            //Recuperando lista.
            this.lProductoPorVenta = dba.getListaDetalleVenta(id_venta);

            //Limpiando tabla.
            modeloDetalleVenta.getDataVector().removeAllElements();
            modeloDetalleVenta.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lProductoPorVenta.size(); i++)
            {
                String[] registroDv = {
                    Integer.toString(this.lProductoPorVenta.get(i).getId_venta()),
                    Integer.toString(this.lProductoPorVenta.get(i).getId_producto()),
                    String.format("$ %.2f",this.lProductoPorVenta.get(i).getPrecio()),
                    Integer.toString(this.lProductoPorVenta.get(i).getCantidad())};

                //Agregando a tabla.
                modeloDetalleVenta.addRow(registroDv);
            }
        } catch(Exception ex){}
    }
    
    //1. Ventana empleados: Muestra el registro de empleados en una tabla.
    public void mostrarEmpleados(String campo, String filtro) throws SQLException {
        try {
            //Recuperando lista.
            this.lEmpleados = dba.getListaEmpleados(campo,filtro);

            //Limpiando tabla.
            modeloEmpleado.getDataVector().removeAllElements();
            modeloEmpleado.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lEmpleados.size(); i++)
            {
                String[] registroE = {
                    Integer.toString(this.lEmpleados.get(i).getId()),
                    this.lEmpleados.get(i).getUsuario(),
                    this.lEmpleados.get(i).getNombre(),
                    this.lEmpleados.get(i).getApellido(),
                    this.lEmpleados.get(i).getFechaNacimiento().toString(),
                    this.lEmpleados.get(i).getFechaContratacion().toString(),
                    String.format("$ %.2f", this.lEmpleados.get(i).getSalario()),
                    this.dba.getNombreCargo(Integer.toString(this.lEmpleados.get(i).getCargo()))};

                //Agregando a tabla.
                modeloEmpleado.addRow(registroE);
            }
        } catch(Exception ex){}
    }
    
    // //4. Ventana inventario: Muestra el registro de productos en una tabla.
    public void mostrarProductos(String campo, String filtro) throws SQLException {
        try {
            //Recuperando lista.
            this.lProductos = dba.getListaProductos(campo, filtro);

            //Limpiando tabla.
            modeloProducto.getDataVector().removeAllElements();
            modeloProducto.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lProductos.size(); i++)
            {
                String[] registroP = {
                    Integer.toString(this.lProductos.get(i).getId_producto()),
                    this.lProductos.get(i).getNombre(),
                    this.lProductos.get(i).getFabricante(),
                    String.format("$ %.2f", this.lProductos.get(i).getPrecio()),
                    Integer.toString(this.lProductos.get(i).getExistencia()),
                    Integer.toString(this.lProductos.get(i).getId_categoria()),
                    Integer.toString(this.lProductos.get(i).getId_proveedor())};

                //Agregando a tabla.
                modeloProducto.addRow(registroP);
            }
        } catch(Exception ex){}
    }
    
    // //3. Ventana compras: Muestra el catalogo de productos en una tabla.
    public void mostrarCatalogo() throws SQLException {
        try {
            //Recuperando lista.
            this.lProductos = dba.getListaProductos("","");

            //Limpiando tabla.
            this.modeloCatalogo.getDataVector().removeAllElements();
            this.modeloCatalogo.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lProductos.size(); i++)
            {
                String[] registroP = {
                    this.lProductos.get(i).getNombre(),
                    this.lProductos.get(i).getFabricante(),
                    this.dba.getProveedor(Integer.toString(this.lProductos.get(i).getId_proveedor())).getNombre(),
                    this.dba.getCategoria(Integer.toString(this.lProductos.get(i).getId_categoria())).getNombre(),
                    String.format("$ %.2f", (this.lProductos.get(i).getPrecio() - this.lProductos.get(i).getPrecio()*0.15)),
                    };

                //Agregando a tabla.
                modeloCatalogo.addRow(registroP);
            }
        } catch(Exception ex){}
    }
    
    // // //4. Ventana inventario: Mostrar categorias en tabla.
    public void mostrarCategorias() throws SQLException {
        try {
            //Recuperando lista.
            this.lCategorias = dba.getListaCategorias();

            //Limpiando tabla.
            modeloCategoria.getDataVector().removeAllElements();
            modeloCategoria.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lCategorias.size(); i++)
            {
                String[] registroC = {
                    Integer.toString(this.lCategorias.get(i).getId()),
                    this.lCategorias.get(i).getNombre()};

                //Agregando a tabla.
                modeloCategoria.addRow(registroC);
            }
        } catch(Exception ex){}
    }
    
    //5. Ventana ordenes: Muestra el registro de ventas en una tabla.
    public void mostrarVentas(String campo, String filtro) throws SQLException {
        try {
            //Recuperando lista.
            this.lVentas = dba.getListaVentas(campo, filtro);

            //Limpiando tabla.
            modeloVenta.getDataVector().removeAllElements();
            modeloVenta.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lVentas.size(); i++)
            {
                String[] registroV = {
                    Integer.toString(this.lVentas.get(i).getId_venta()),
                    Integer.toString(this.lVentas.get(i).getId_empleado()),
                     sdf_timestamp.format(this.lVentas.get(i).getFecha())};

                //Agregando a tabla.
                modeloVenta.addRow(registroV);
            }
        } catch(Exception ex){}
    }
    
    //5. Ventana ordenes: Muestra el registro de compras en una tabla.
    public void mostrarCompras(String campo, String filtro) throws SQLException {
        try {
            //Recuperando lista.
            this.lCompras = dba.getListaCompras(campo, filtro);

            //Limpiando tabla.
            modeloCompra.getDataVector().removeAllElements();
            modeloCompra.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lCompras.size(); i++)
            {
                String[] registroV = {
                    Integer.toString(this.lCompras.get(i).getId_compra()),
                    Integer.toString(this.lCompras.get(i).getId_empleado()),
                    sdf_timestamp.format(this.lCompras.get(i).getFecha())};

                //Agregando a tabla.
                modeloCompra.addRow(registroV);
            }
        } catch(Exception ex){}
    }
    
    //6. Ventana proveedores: Muestra el registro de proveedores en una tabla.
    public void mostrarProveedores(String campo, String filtro) throws SQLException {
        try {
            //Recuperando lista.
            this.lProveedores = dba.getListaProveedores(campo, filtro);

            //Limpiando tabla.
            modeloProveedor.getDataVector().removeAllElements();
            modeloProveedor.fireTableDataChanged();

            //Mostrando en tabla.
            for(int i = 0; i < this.lProveedores.size(); i++)
            {
                String[] registroP = {
                    Integer.toString(this.lProveedores.get(i).getId()),
                    this.lProveedores.get(i).getNombre()};

                //Agregando a tabla.
                modeloProveedor.addRow(registroP);
            }
        }  catch(Exception ex){}
    }
    
    //2. Ventana ventas: Muestra los productos disponibles.
    public void poblarProductosVenta() throws SQLException {
        try {
            this.lProductos = dba.getListaProductos("","");
            for(int i = 0; i < this.lProductos.size(); i++)
            {
               this.cboProducto.addItem(this.lProductos.get(i).getNombre());
            }
        } catch(Exception ex){}
    }
    
    //3. Ventana compras: Muestra las categorias disponibles.
    public void poblarCategoriasCompra() throws SQLException {
        try {
            this.lCategorias = dba.getListaCategorias();
            for(int i = 0; i < this.lCategorias.size(); i++)
            {
               this.cboCategoriaCompra.addItem(this.lCategorias.get(i).getNombre());
            }
        } catch(Exception ex){}
    }
    
    //3. Ventana compras: Muestra los proveedores disponibles.
    public void poblarProveedoresCompra() throws SQLException {
        try {
            this.lProveedores = dba.getListaProveedores("","");
            for(int i = 0; i < this.lProveedores.size(); i++)
            {
               this.cboProveedorCompra.addItem( this.lProveedores.get(i).getNombre());
            }
        } catch(Exception ex){}
    }
    
    //Centra valores en celdas.
    public final void centrarCeldas() {
        centerRenderer = new DefaultTableCellRenderer(); centerRenderer.setHorizontalAlignment(JLabel.CENTER);
       
        jtEmpleado.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtEmpleado.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtEmpleado.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jtEmpleado.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jtEmpleado.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jtEmpleado.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        jtEmpleado.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        jtEmpleado.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        
        jtPedidoVenta.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtPedidoVenta.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtPedidoVenta.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jtPedidoVenta.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jtPedidoVenta.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        
        jtPedidoCompra.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtPedidoCompra.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtPedidoCompra.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jtPedidoCompra.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jtPedidoCompra.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jtPedidoCompra.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        jtPedidoCompra.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        
        jtProducto.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtProducto.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtProducto.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jtProducto.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jtProducto.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jtProducto.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        jtProducto.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        
        jtCategoria.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtCategoria.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        
        jtVenta.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtVenta.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtVenta.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        
        jtDetalleVenta.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtDetalleVenta.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtDetalleVenta.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jtDetalleVenta.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
       
        jtCompra.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtCompra.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtCompra.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        
        jtDetalleCompra.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtDetalleCompra.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtDetalleCompra.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jtDetalleCompra.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
        jtProveedor.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtProveedor.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        
        jtProductoProveedor.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtProductoProveedor.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtProductoProveedor.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jtProductoProveedor.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jtProductoProveedor.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jtProductoProveedor.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        jtProductoProveedor.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
    }
    
    //Establece un icono de formulario.
    public final void setIcon() {
        try {
            URL iconURL = getClass().getResource("/resources/icon.png"); 
            ImageIcon icon = new ImageIcon(iconURL);
            this.setIconImage(icon.getImage());
        } catch(Exception ex){}
    }
       
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFarmacia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProductoCompra;
    private javax.swing.JButton btnAgregarProductoVenta;
    private javax.swing.JButton btnBuscarCompra;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnBuscarVenta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCompraIrAInventario;
    private javax.swing.JButton btnCompraIrAProveedores;
    private javax.swing.JButton btnConfirmarOrden;
    private javax.swing.JButton btnConfirmarVenta;
    private javax.swing.JButton btnGenerarPassword;
    private javax.swing.JButton btnGenerarReporteCompras;
    private javax.swing.JButton btnGenerarReporteEmpleados;
    private javax.swing.JButton btnGenerarReporteProductos;
    private javax.swing.JButton btnGenerarReporteVentas;
    private javax.swing.JButton btnGuardarEmpleado;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIngresarProductoVenta;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnIrACompras;
    private javax.swing.JButton btnIrACompras1;
    private javax.swing.JButton btnIrAInventario;
    private javax.swing.JButton btnIrAOrdenes;
    private javax.swing.JButton btnIrAProveedores;
    private javax.swing.JButton btnIrAVentas;
    private javax.swing.JButton btnLimpiarEmpleado;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnModificarEmpleado;
    private javax.swing.JButton btnModificarPassword;
    private javax.swing.JButton btnNuevoEmpleado;
    private javax.swing.JButton btnRegistrarProveedor;
    private javax.swing.JButton btnReiniciarBusqCompra;
    private javax.swing.JButton btnReiniciarBusqProducto;
    private javax.swing.JButton btnReiniciarBusqProveedor;
    private javax.swing.JButton btnReiniciarBusqVenta;
    private javax.swing.JButton btnReiniciarBusquedaEmpleado;
    private javax.swing.JButton btnRemoverEmpleado;
    private javax.swing.JButton btnRemoverProductoCompra;
    private javax.swing.JButton btnRemoverProductoVenta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerPassword;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JComboBox<String> cboCategoriaCompra;
    private javax.swing.JComboBox<String> cboMesContratacion;
    private javax.swing.JComboBox<String> cboMesNac;
    private javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JComboBox<String> cboProveedorCompra;
    private javax.swing.JCheckBox chkApellidoEmpleado;
    private javax.swing.JCheckBox chkCargo;
    private javax.swing.JCheckBox chkCatalogo;
    private javax.swing.JCheckBox chkCategoriaProductos;
    private javax.swing.JCheckBox chkContratacion;
    private javax.swing.JCheckBox chkFabricante;
    private javax.swing.JCheckBox chkFechaCompra;
    private javax.swing.JCheckBox chkFechaVenta;
    private javax.swing.JCheckBox chkIdCompra;
    private javax.swing.JCheckBox chkIdEmpleado;
    private javax.swing.JCheckBox chkIdEmpleadoVenta;
    private javax.swing.JCheckBox chkIdProducto;
    private javax.swing.JCheckBox chkIdProveedor;
    private javax.swing.JCheckBox chkIdVenta;
    private javax.swing.JCheckBox chkId_empleado;
    private javax.swing.JCheckBox chkNombreEmpleado;
    private javax.swing.JCheckBox chkNombreProductos;
    private javax.swing.JCheckBox chkNombreProveedor;
    private javax.swing.JCheckBox chkNuevoProd;
    private javax.swing.JCheckBox chkProveedorProductos;
    private javax.swing.JCheckBox chkUsuarioEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpCompra;
    private javax.swing.JPanel jpComprasA;
    private javax.swing.JPanel jpComprasB;
    private javax.swing.JPanel jpComprasC;
    private javax.swing.JPanel jpEmpleado;
    private javax.swing.JPanel jpEmpleadotabla;
    private javax.swing.JPanel jpGestionEmpleados;
    private javax.swing.JPanel jpGestionEmpleados1;
    private javax.swing.JPanel jpGestionEmpleados10;
    private javax.swing.JPanel jpGestionEmpleados11;
    private javax.swing.JPanel jpGestionEmpleados12;
    private javax.swing.JPanel jpGestionEmpleados13;
    private javax.swing.JPanel jpGestionEmpleados6;
    private javax.swing.JPanel jpGestionEmpleados7;
    private javax.swing.JPanel jpGestionEmpleados8;
    private javax.swing.JPanel jpGestionEmpleados9;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JPanel jpHome;
    private javax.swing.JPanel jpIniciar;
    private javax.swing.JPanel jpInicio;
    private javax.swing.JPanel jpInventario;
    private javax.swing.JPanel jpInventarioA;
    private javax.swing.JPanel jpInventarioA1;
    private javax.swing.JPanel jpInventarioA2;
    private javax.swing.JPanel jpInventarioA3;
    private javax.swing.JPanel jpInventarioA4;
    private javax.swing.JPanel jpInventarioA5;
    private javax.swing.JPanel jpInventarioA6;
    private javax.swing.JPanel jpInventarioA7;
    private javax.swing.JPanel jpLogIn;
    private javax.swing.JPanel jpOpciones;
    private javax.swing.JPanel jpOpciones1;
    private javax.swing.JPanel jpOpciones2;
    private javax.swing.JPanel jpOpciones3;
    private javax.swing.JPanel jpOpciones4;
    private javax.swing.JPanel jpOrden;
    private javax.swing.JPanel jpPrincipalAdmin;
    private javax.swing.JPanel jpProveedores;
    private javax.swing.JPanel jpSalir;
    private javax.swing.JPanel jpUsuario;
    private javax.swing.JPanel jpVenta;
    private javax.swing.JPanel jpVentaA;
    private javax.swing.JPanel jpVentaB;
    private javax.swing.JSpinner jsAñoContratacion;
    private javax.swing.JSpinner jsAñoNac;
    private javax.swing.JSpinner jsCantidadCompra;
    private javax.swing.JSpinner jsCantidadVenta;
    private javax.swing.JSpinner jsDiaContratacion;
    private javax.swing.JSpinner jsDiaNac;
    private javax.swing.JTable jtCatalogo;
    private javax.swing.JTable jtCategoria;
    private javax.swing.JTable jtCompra;
    private javax.swing.JTable jtDetalleCompra;
    private javax.swing.JTable jtDetalleVenta;
    private javax.swing.JTable jtEmpleado;
    private javax.swing.JTable jtPedidoCompra;
    private javax.swing.JTable jtPedidoVenta;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTable jtProductoProveedor;
    private javax.swing.JTable jtProveedor;
    private javax.swing.JTable jtVenta;
    private javax.swing.JTabbedPane jtpPrincipal;
    private javax.swing.JLabel lblApellidoEmpleado;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblAviso1;
    private javax.swing.JLabel lblAviso3;
    private javax.swing.JLabel lblAviso4;
    private javax.swing.JLabel lblAvisoInicio;
    private javax.swing.JLabel lblAño;
    private javax.swing.JLabel lblAño1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidadVenta;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCat;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblFechaNac1;
    private javax.swing.JLabel lblFechaNac2;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JLabel lblIniciar;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMes1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblNombreEmpleado1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPecioVenta;
    private javax.swing.JLabel lblPecioVenta1;
    private javax.swing.JLabel lblPecioVenta2;
    private javax.swing.JLabel lblPecioVenta3;
    private javax.swing.JLabel lblPecioVenta4;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JLabel lblPedidoVenta;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblProducto1;
    private javax.swing.JLabel lblProducto2;
    private javax.swing.JLabel lblProductoVenta;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo10;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JLabel lblTotalCompra;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario10;
    private javax.swing.JLabel lblUsuario11;
    private javax.swing.JLabel lblUsuario12;
    private javax.swing.JLabel lblUsuario13;
    private javax.swing.JLabel lblUsuario14;
    private javax.swing.JLabel lblUsuario15;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JLabel lblUsuario5;
    private javax.swing.JLabel lblUsuario6;
    private javax.swing.JLabel lblUsuario7;
    private javax.swing.JLabel lblUsuario8;
    private javax.swing.JLabel lblUsuario9;
    private javax.swing.JLabel lblVenta;
    private javax.swing.JLabel lblVenta1;
    private javax.swing.JLabel lblVenta2;
    private javax.swing.JLabel lblcuenta;
    private javax.swing.JLabel lblcuenta1;
    private javax.swing.JLabel lbldia;
    private javax.swing.JLabel lbldia1;
    private javax.swing.JLabel lnlUsuario;
    private javax.swing.JLabel lnlUsuario1;
    private javax.swing.JLabel lnlUsuario2;
    private javax.swing.JTextField txtApellidoEmpleado;
    private javax.swing.JTextField txtBusquedaCompra;
    private javax.swing.JTextField txtBusquedaEmpleado;
    private javax.swing.JTextField txtBusquedaProductos;
    private javax.swing.JTextField txtBusquedaProveedor;
    private javax.swing.JTextField txtBusquedaVenta;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtIdCompra;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdEmpleadoCompra;
    private javax.swing.JTextField txtIdEmpleadoVenta;
    private javax.swing.JTextField txtIdProductoVenta;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtNombreProductoCompra;
    private javax.swing.JTextField txtNuevoProveedor;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordEmpleado;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTotalCompra;
    private javax.swing.JTextField txtTotalVenta;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuarioEmpleado;
    // End of variables declaration//GEN-END:variables
}