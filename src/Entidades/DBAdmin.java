
package Entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBAdmin {
    
    //Atributos / Campos.
    private String usuario, password;
    private String db = "jdbc:mysql://localhost:3306/farmacia";
    Connection conexion = null;
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd"), sdf_timestamp = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    
    //Constructor.
    public DBAdmin(){
    }
    
    //Constructor - Conexión inicial.
    public DBAdmin(String usuario, String password) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException{
        
        this.usuario = usuario; 
        this.password = password;
      
        try
        {
            //Instanciar conexión.
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            this.conexion = DriverManager.getConnection(this.db, this.usuario, this.password);
            
            //JOptionPane.showMessageDialog(null, "Conexión establecida con éxito", "Conexión", JOptionPane.INFORMATION_MESSAGE); 
        }
        catch(SQLException ex){System.out.println(ex);
            //JOptionPane.showMessageDialog(null, "La clave o usuario son incorrectas", "Conexión", JOptionPane.ERROR_MESSAGE); 
        } 
    }
    
    //Conectar.
    public void conectar() {
        try { this.conexion = DriverManager.getConnection(this.db, this.usuario, this.password); }
        catch(SQLException ex){System.out.println(ex);} 
    }
    
    //Ejecución de comandos.
    public void ejecutarComando(String comando) throws SQLException {
        try 
        {
            Statement com = this.conexion.createStatement();
            com.executeUpdate(comando); //Ejecución.
            System.out.println("Efectuado con éxito.");
        }
        catch(SQLException ex) {System.out.println(ex);}
    }
    
    //Ejecución de consultas.
    public ResultSet ejecutarConsulta(String consulta) throws SQLException{
        Statement st = this.conexion.createStatement();  //Objeto tipo statement que maneja la consulta.
        return st.executeQuery(consulta); //Ejecutando la consulta.
    }
    
    //Cerrar conexión db.
    public void cerrarConexion() throws SQLException {
        this.conexion.close();
    }
    
    //1. Recupera lista de empleados. (Empleados activos).
    public ArrayList getListaEmpleados(String campo, String filtro) throws SQLException{
  
        ArrayList<Empleado> lEmpleados = new ArrayList<>();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `empleado` WHERE `id_estado` = 1;";

        //Busqueda por:
        switch (campo) {
            case "id_empleado":  
                consulta = "SELECT * FROM `empleado` WHERE (`id_empleado` = '"+filtro+"') AND `id_estado` = 1;";
                break;
            case "nombre": 
                consulta = "SELECT * FROM `empleado` WHERE (`nombre` LIKE '%"+filtro+"%') AND `id_estado` = 1;";
                break;   
            case "apellido":
                consulta = "SELECT * FROM `empleado` WHERE (`apellido` LIKE '%"+filtro+"%') AND `id_estado` = 1;";
                break;
            case "usuario":
                consulta = "SELECT * FROM `empleado` WHERE (`usuario` LIKE '%"+filtro+"%') AND `id_estado` = 1;";
                break;
            case "fechaContratacion":
                consulta = "SELECT * FROM `empleado` WHERE (`fechaContratacion` LIKE '%"+filtro+"%') AND `id_estado` = 1;";
                break;
            case "id_cargo":
                consulta = "SELECT * FROM `empleado` WHERE (`id_cargo` = '"+filtro+"') AND `id_estado` = 1;";
                break;
        }
           
        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           lEmpleados.add(new Empleado());
           lEmpleados.get(lEmpleados.size()-1).setId(rs.getInt("id_empleado"));
           lEmpleados.get(lEmpleados.size()-1).setUsuario(rs.getString("usuario"));
           lEmpleados.get(lEmpleados.size()-1).setPassword(rs.getString("passw"));
           lEmpleados.get(lEmpleados.size()-1).setNombre(rs.getString("nombre"));
           lEmpleados.get(lEmpleados.size()-1).setApellido(rs.getString("apellido"));
           lEmpleados.get(lEmpleados.size()-1).setFechaNacimiento(rs.getDate("fechaNacimiento"));
           lEmpleados.get(lEmpleados.size()-1).setFechaContratacion(rs.getDate("fechaContratacion"));
           lEmpleados.get(lEmpleados.size()-1).setSalario(rs.getDouble("salario"));
           lEmpleados.get(lEmpleados.size()-1).setCargo(rs.getInt("id_cargo"));
        }
        
        this.cerrarConexion();
        return lEmpleados; 
    }  
    
    
    //2. Recupera lista de productos.
    public ArrayList getListaProductos(String campo, String filtro) throws SQLException{
  
        ArrayList<Producto> lProductos = new ArrayList<>();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `producto`;";

        //Busqueda por:
        switch (campo) {
            case "id_producto":  
                consulta = "SELECT * FROM `producto` WHERE (`id_producto` = '"+filtro+"');";
                break;
            case "nombre": 
                consulta = "SELECT * FROM `producto` WHERE (`nombre` LIKE '%"+filtro+"%');";
                break;   
            case "fabricante":
                consulta = "SELECT * FROM `producto` WHERE (`fabricante` LIKE '%"+filtro+"%');";
                break;
            case "id_proveedor":
                consulta = "SELECT * FROM `producto` WHERE (`id_proveedor` = '"+filtro+"');";
                break;
            case "id_categoria":
                consulta = "SELECT * FROM `producto` WHERE (`id_categoria` = '"+filtro+"');";
                break;
        }
           
        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           lProductos.add(new Producto());
           lProductos.get(lProductos.size()-1).setId_producto(rs.getInt("id_producto"));
           lProductos.get(lProductos.size()-1).setNombre(rs.getString("nombre"));
           lProductos.get(lProductos.size()-1).setFabricante(rs.getString("fabricante"));
           lProductos.get(lProductos.size()-1).setPecio(rs.getDouble("precio_unitario"));
           lProductos.get(lProductos.size()-1).setExistencia(rs.getInt("existencia"));
           lProductos.get(lProductos.size()-1).setId_categoria(rs.getInt("id_categoria"));
           lProductos.get(lProductos.size()-1).setId_proveedor(rs.getInt("id_proveedor"));
        }
        
        this.cerrarConexion();
        return lProductos; 
    }  
    
    //3. Recupera lista de categorias.
    public ArrayList getListaCategorias() throws SQLException{
  
        ArrayList<Categoria> lCategorias = new ArrayList<>();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `categoria`;";
        
        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           lCategorias.add(new Categoria());
           lCategorias.get(lCategorias.size()-1).setId(rs.getInt("id_categoria"));
           lCategorias.get(lCategorias.size()-1).setNombre(rs.getString("nombre"));
        }
        
        this.cerrarConexion();
        return lCategorias; 
    }  
    
    //4. Recupera lista de ventas.
    public ArrayList getListaVentas(String campo, String filtro) throws SQLException{
  
        ArrayList<Venta> lVentas = new ArrayList<>();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `venta`;";

        //Busqueda por:
        switch (campo) {
            case "id_venta":  
                consulta = "SELECT * FROM `venta` WHERE (`id_venta` = '"+filtro+"');";
                break;
            case "id_empleado": 
                consulta = "SELECT * FROM `venta` WHERE (`id_empleado` = '"+filtro+"');";
                break;   
            case "fecha":
                consulta = "SELECT * FROM `venta` WHERE (`fecha` LIKE '%"+filtro+"%');";
                break;
        }
        
        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           lVentas.add(new Venta());
           lVentas.get(lVentas.size()-1).setId_venta(rs.getInt("id_venta"));
           lVentas.get(lVentas.size()-1).setId_empleado(rs.getInt("id_empleado"));
           lVentas.get(lVentas.size()-1).setFecha(rs.getTimestamp("fecha"));
        }
        
        this.cerrarConexion();
        return lVentas; 
    }  
    
    //5. Recupera lista detalle de venta
    public ArrayList getListaDetalleVenta(String id_venta) throws SQLException{
  
        ArrayList<ProductoPorVenta> lProductosPorVenta = new ArrayList<>();
        
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `detalle_venta` WHERE id_venta ='"+ id_venta +"';";
        
        //Obteniendo el ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
       
        //Mostrando el contenido del ResultSet
        while(rs.next())
        {
            lProductosPorVenta.add(new ProductoPorVenta());
            lProductosPorVenta.get(lProductosPorVenta.size()-1).setId(rs.getInt("id_venta"));
            lProductosPorVenta.get(lProductosPorVenta.size()-1).setId_producto(rs.getInt("id_producto"));
            lProductosPorVenta.get(lProductosPorVenta.size()-1).setPrecio(rs.getDouble("precio_unitario"));
            lProductosPorVenta.get(lProductosPorVenta.size()-1).setCantidad(rs.getInt("cantidad"));
        }
        
        this.cerrarConexion();
        return lProductosPorVenta;
    }
    
    //6. Recupera lista de compras.
    public ArrayList getListaCompras(String campo, String filtro) throws SQLException{
  
        ArrayList<Compra> lCompras = new ArrayList<>();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `compra`;";
        
        //Busqueda por:
        switch (campo) {
            case "id_compra":  
                consulta = "SELECT * FROM `compra` WHERE (`id_compra` = '"+filtro+"');";
                break;
            case "id_empleado": 
                consulta = "SELECT * FROM `compra` WHERE (`id_empleado` = '"+filtro+"');";
                break;   
            case "fecha":
                consulta = "SELECT * FROM `compra` WHERE (`fecha` LIKE '%"+filtro+"%');";
                break;
        }
        
        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           lCompras.add(new Compra());
           lCompras.get(lCompras.size()-1).setId_compra(rs.getInt("id_compra"));
           lCompras.get(lCompras.size()-1).setId_empleado(rs.getInt("id_empleado"));
           lCompras.get(lCompras.size()-1).setFecha(rs.getTimestamp("fecha"));
        }
        
        this.cerrarConexion();
        return lCompras; 
    }  
    
    //7. Recupera lista detalle de compra
    public ArrayList getListaDetalleCompra(String id_compra) throws SQLException{
  
        ArrayList<ProductoPorCompra> lProductosPorCompra = new ArrayList<>();

        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `detalle_compra` WHERE id_compra ='"+ id_compra +"';";
        
        //Obteniendo el ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
       
        //Mostrando el contenido del ResultSet
        while(rs.next())
        {
            lProductosPorCompra.add(new ProductoPorCompra());
            lProductosPorCompra.get(lProductosPorCompra.size()-1).setId(rs.getInt("id_compra"));
            lProductosPorCompra.get(lProductosPorCompra.size()-1).setId_producto(rs.getInt("id_producto"));
            lProductosPorCompra.get(lProductosPorCompra.size()-1).setPrecio(rs.getDouble("precio_unitario"));
            lProductosPorCompra.get(lProductosPorCompra.size()-1).setCantidad(rs.getInt("cantidad"));
        }
        
        this.cerrarConexion();
        return lProductosPorCompra;
    }
    
    //8. Recupera lista de proveedores.
    public ArrayList getListaProveedores(String campo, String filtro) throws SQLException{
  
        ArrayList<Proveedor> lProveedores = new ArrayList<>();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `proveedor`;";

        //Busqueda por:
        switch (campo) {
            case "id_proveedor":  
                consulta = "SELECT * FROM `proveedor` WHERE (`id_proveedor` = '"+filtro+"');";
                break;
            case "nombre": 
                consulta = "SELECT * FROM `proveedor` WHERE (`nombre` LIKE '%"+filtro+"%');";
                break;   
        }
        
        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           lProveedores.add(new Proveedor());
           lProveedores.get(lProveedores.size()-1).setId(rs.getInt("id_proveedor"));
           lProveedores.get(lProveedores.size()-1).setNombre(rs.getString("nombre"));
        }
        
        this.cerrarConexion();
        return lProveedores; 
    }  
    
    //1. Recupera empleado especifico por id.
    public Empleado getEmpleado(String id_empleado) throws SQLException{
  
        Empleado empleado = new Empleado();

        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `empleado` WHERE `id_empleado` = '"+ id_empleado +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           empleado.setId(rs.getInt("id_empleado"));
           empleado.setUsuario(rs.getString("usuario"));
           empleado.setPassword(rs.getString("passw"));
           empleado.setNombre(rs.getString("nombre"));
           empleado.setApellido(rs.getString("apellido"));
           empleado.setFechaNacimiento(rs.getDate("fechaNacimiento"));
           empleado.setFechaContratacion(rs.getDate("fechaContratacion"));
           empleado.setSalario(rs.getDouble("salario"));
           empleado.setCargo(rs.getInt("id_cargo"));
        }
        
        this.cerrarConexion();
        return empleado; 
    }  
    
    //2.Recupera producto especifico por nombre.
    public Producto getProducto(String nombre) throws SQLException{
  
        Producto producto = new Producto();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `producto` WHERE `nombre` = '"+ nombre +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
            producto.setId_producto(rs.getInt("id_producto"));
            producto.setNombre(rs.getString("nombre"));
            producto.setFabricante(rs.getString("fabricante"));
            producto.setPecio(rs.getDouble("precio_unitario"));
            producto.setExistencia(rs.getInt("existencia"));
            producto.setId_categoria(rs.getInt("id_categoria"));
            producto.setId_proveedor(rs.getInt("id_proveedor"));
        }
        
        this.cerrarConexion();
        return producto; 
    }  
    
     //3.Recupera producto especifico por id.
    public Producto getProductoPorId(String id_producto) throws SQLException{
  
        Producto producto = new Producto();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `producto` WHERE `id_producto` = '"+ id_producto +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
            producto.setId_producto(rs.getInt("id_producto"));
            producto.setNombre(rs.getString("nombre"));
            producto.setFabricante(rs.getString("fabricante"));
            producto.setPecio(rs.getDouble("precio_unitario"));
            producto.setExistencia(rs.getInt("existencia"));
            producto.setId_categoria(rs.getInt("id_categoria"));
            producto.setId_proveedor(rs.getInt("id_proveedor"));
        }
        
        this.cerrarConexion();
        return producto; 
    }  
    
    //4. Recupera categoria especifica por id.
    public Categoria getCategoria(String id_categoria) throws SQLException{
  
        Categoria categoria = new Categoria();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `categoria` WHERE `id_categoria` = '"+ id_categoria +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           categoria.setId(rs.getInt("id_categoria"));
           categoria.setNombre(rs.getString("nombre"));
        }
        
        this.cerrarConexion();
        return categoria; 
    }  
    
    //5. Recupera proveedor especifico por id.
    public Proveedor getProveedor(String id_proveedor) throws SQLException{
  
        Proveedor proveedor = new Proveedor();
         
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT * FROM `proveedor` WHERE `id_proveedor` = '"+ id_proveedor +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           proveedor.setId(rs.getInt("id_proveedor"));
           proveedor.setNombre(rs.getString("nombre"));
        }
        
        this.cerrarConexion();
        return proveedor; 
    }  
    
    //6. Recupera nombre de cargo especifico por id.
    public String getNombreCargo(String id_cargo) throws SQLException{
         
        String cargo = "";
        
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `nombre` FROM `cargo_empleado` WHERE `id_cargo` = '"+ id_cargo +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           cargo = rs.getString("nombre");
        }
        
        this.cerrarConexion();
        return cargo; 
    }  
    
    //7. Recupera id de cargo especifico por nombre.
    public String getIdCargo(String nombre) throws SQLException{
         
        String cargo = "";
        
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `id_cargo` FROM `cargo_empleado` WHERE `nombre` = '"+ nombre +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           cargo = rs.getString("id_cargo");
        }
        
        this.cerrarConexion();
        return cargo; 
    }  
    
    //8. Recupera id de producto especifico por nombre.
    public String getIdProducto(String nombre) throws SQLException{

        String id_producto = "0"; //Nulo - El producto no se encuentra registrado.
        
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `id_producto` FROM `producto` WHERE `nombre` = '"+ nombre +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           id_producto = rs.getString("id_producto");
        }
        
        this.cerrarConexion();
        return id_producto; 
    }  
         
    //9. Recupera id de categoria especifica por nombre.
    public String getIdCategoria(String nombre) throws SQLException{

        String id_categoria = "";
        
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `id_categoria` FROM `categoria` WHERE `nombre` = '"+ nombre +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           id_categoria = rs.getString("id_categoria");
        }
        
        this.cerrarConexion();
        return id_categoria; 
    }  
    
    //10. Recupera id de proveedor especifico por nombre.
    public String getIdProveedor(String nombre) throws SQLException{

        String id_proveedor = "";
        
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `id_proveedor` FROM `proveedor` WHERE `nombre` = '"+ nombre +"';";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           id_proveedor = rs.getString("id_proveedor");
        }
        
        this.cerrarConexion();
        return id_proveedor; 
    }  
    
    //1 - Registra un empleado.
    public void registrarEmpleado(Empleado empleado) throws SQLException{
 
        this.conectar();
        
        String comando = "INSERT INTO `farmacia`.`empleado` (`id_empleado`, `usuario`,"
                + "`passw`,`nombre`,`apellido`,`fechaNacimiento`,`fechaContratacion`,`salario`,"
                + "`id_cargo`,`id_estado`) VALUES "
                + "(default, "
                + "'"+ empleado.getUsuario() +"', "
                + "'"+ empleado.getPassword() +"', "
                + "'"+ empleado.getNombre() +"', "
                + "'"+ empleado.getApellido() +"', "
                + "'"+ sdf.format(empleado.getFechaNacimiento()) +"', "
                + "'"+ sdf.format(empleado.getFechaContratacion()) + "', "
                + "'"+ empleado.getSalario()+"', "
                + "'"+ empleado.getCargo()+"', "
                + "'"+ empleado.getEstado() +"');";
        
        this.ejecutarComando(comando);
        this.cerrarConexion();
    }  
    
    //2 - Modificar datos de un empleado existente.
    public void modificarEmpleado(Empleado empleado) throws SQLException{
        
        this.conectar();
        
        String comando = "UPDATE `farmacia`.`empleado` SET "
                + "`usuario`='"+ empleado.getUsuario()+"',"
                + "`passw`='"+ empleado.getPassword()+"',"
                + "`nombre`='"+ empleado.getNombre()+"',"
                + "`apellido`='"+ empleado.getApellido()+"',"
                + "`fechaNacimiento`='"+ sdf.format(empleado.getFechaNacimiento())+"',"
                + "`fechaContratacion`='"+ sdf.format(empleado.getFechaContratacion())+"',"
                + "`salario`='"+ empleado.getSalario()+"',"
                + "`id_cargo`='"+ empleado.getCargo()+"'"
                + " WHERE `id_empleado`='"+ empleado.getId()+"';";
        
        this.ejecutarComando(comando);
        this.cerrarConexion();
    }  
    
    //3. Remueve un empleado. (Cambiar su estado a inactivo).
    public void removerEmpleado(String id_empleado) throws SQLException{
  
        this.conectar();
        
        //Sentencia SQL de la consulta
        String comando = "UPDATE `empleado` SET `id_estado` = 2 WHERE `id_empleado` = '"+ id_empleado +"';";
        
        this.ejecutarComando(comando);
        this.cerrarConexion();
    }  

    //1. Registra una venta.
    public void registrarVenta(Venta venta) throws SQLException{
        
        this.conectar();
        
        // A) Ingresar venta. 
        String comandoA = "INSERT INTO `farmacia`.`venta` (`id_venta`, `id_empleado`, `fecha`) VALUES "
            + "(default, '"+ venta.getId_empleado() +"', '"+ sdf_timestamp.format(venta.getFecha()) +"');";

        this.ejecutarComando(comandoA);
        
        // B) Registrar detalles de venta.
        for (int i = 0; i < venta.lProductosPorVenta.size(); i++) {
           
            String comandoB = "INSERT INTO `farmacia`.`detalle_venta` "
                    + "(`id_venta`, `id_producto`, `precio_unitario`, `cantidad`) VALUES "
                + "('"+ venta.lProductosPorVenta.get(i).getId_venta() +"', "
                + "'"+ venta.lProductosPorVenta.get(i).getId_producto() +"', "
                + "'"+ venta.lProductosPorVenta.get(i).getPrecio() +"', "
                + "'"+ venta.lProductosPorVenta.get(i).getCantidad() +"');";
        
            this.ejecutarComando(comandoB);
           
            // C) Remover existencias de inventario.
            String comandoC = "UPDATE `farmacia`.`producto` SET "
                + "`existencia`= `existencia` - '"+ venta.lProductosPorVenta.get(i).getCantidad()+ "'"
                + " WHERE `id_producto` = '"+ venta.lProductosPorVenta.get(i).getId_producto()+ "';";
             
            this.ejecutarComando(comandoC);
        }

        this.cerrarConexion();
    }
    
    //2. Registra una compra.
    public void registrarCompra(Compra compra) throws SQLException{

        this.conectar();
        
        // A) Ingresar compra. 
        String comandoA = "INSERT INTO `farmacia`.`compra` (`id_compra`, `id_empleado`, `fecha`) VALUES "
            + "(default, '"+ compra.getId_empleado() +"', '"+ sdf_timestamp.format(compra.getFecha()) +"');";
        
        this.ejecutarComando(comandoA);
        
        // B) Registrar detalles de compra.
        for (int i = 0; i < compra.lProductosPorCompra.size(); i++) {
           
            String comandoB = "INSERT INTO `farmacia`.`detalle_compra` "
                + "(`id_compra`, `id_producto`, `precio_unitario`, `cantidad`) VALUES "
                + "('"+ compra.lProductosPorCompra.get(i).getId_compra()+"', "
                + "'"+ compra.lProductosPorCompra.get(i).getId_producto() +"', "
                + "'"+ compra.lProductosPorCompra.get(i).getPrecio() +"', "
                + "'"+ compra.lProductosPorCompra.get(i).getCantidad() +"');";
        
            this.ejecutarComando(comandoB);
            
            // C) Agregar existencias a inventario.          
            String comandoC = "UPDATE `farmacia`.`producto` SET "
                + "`existencia`= `existencia` + '"+ compra.lProductosPorCompra.get(i).getCantidad()+ "'"
                + " WHERE `id_producto` = '"+ compra.lProductosPorCompra.get(i).getId_producto()+ "';";
             
            this.ejecutarComando(comandoC);
        }
        
        this.cerrarConexion();
    }
    
    //3. Registra un producto.
    public void registrarProducto(Producto producto) throws SQLException{

        this.conectar();
        
        //Sentencia SQL del comando.
        String comando = "INSERT INTO `farmacia`.`producto` (`id_producto`, `nombre`, `fabricante`,"
                + "`precio_unitario`, `existencia`, `id_categoria`,`id_proveedor`) VALUES "
                + "(default, "
                + "'"+ producto.getNombre() +"', "
                + "'"+ producto.getFabricante()+"', "
                + "'"+ producto.getPrecio() +"', "
                + "'"+ producto.getExistencia()+"', "
                + "'"+ producto.getId_categoria()+"', "
                + "'"+ producto.getId_proveedor() +"');";

        this.ejecutarComando(comando);
        this.cerrarConexion();
    }
    
    //4. Registra un proveedor.
    public void registrarProveedor(String nombre) throws SQLException{

        this.conectar();
        
        //Sentencia SQL del comando.
        String comando = "INSERT INTO `farmacia`.`proveedor` (`id_proveedor`, `nombre`) VALUES "
                + "(default, "
                + "'"+ nombre +"');";

        this.ejecutarComando(comando);
        this.cerrarConexion();
    }
    
    //1. Obtiene proximo id a registrar para un nuevo empleado.
    public String getNuevoId() throws SQLException{
  
        String id_empleado = "";

        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `id_empleado`+1 AS `id` FROM `empleado` ORDER BY `id_empleado` DESC LIMIT 1;";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           id_empleado = rs.getString("id");
        }
        
        this.cerrarConexion();
        return id_empleado; 
    }  
    
    //2. Obtiene proximo id a registrar para un nueva venta.
        public String getNuevoIdVenta() throws SQLException{
  
        String id_venta = "1";
        
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `id_venta`+1 AS `id` FROM `venta` ORDER BY `id_venta` DESC LIMIT 1;";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           id_venta = rs.getString("id");
        }
        
        this.cerrarConexion();
        return id_venta; 
    }  
        
    //3. Obtiene proximo id a registrar para un nueva compra.
        public String getNuevoIdCompra() throws SQLException{
  
        String id_compra = "1";
        
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `id_compra`+1 AS `id` FROM `compra` ORDER BY `id_compra` DESC LIMIT 1;";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet.
        while(rs.next())
        {
           id_compra = rs.getString("id");
        }
        
        this.cerrarConexion();
        return id_compra; 
    }  
        
    //1. Autenticacion de usuario.
    public String autenticar(String usuario, String password) throws SQLException{
  
        String id_empleado = "0"; //Nulo - Este usuario no existe o no se encuentra activo.
        this.conectar();
        
        //Sentencia SQL de la consulta
        String consulta = "SELECT `id_empleado` FROM `empleado` WHERE `usuario` = '"+ usuario +"' "
            + "AND `passw` = '"+ password +"' AND `id_estado` = 1;";

        //Obteniendo ResultSet.
        ResultSet rs = this.ejecutarConsulta(consulta);
        
        //Mostrando contenido del ResultSet. (Si hay lectura, entonces confirma un ingreso correcto).
        while(rs.next())
        {
           id_empleado = rs.getString("id_empleado");
           return id_empleado; 
        }
        
        //Si no hay lectura, entonces el usuario no ha ingresado correctamente.
        
        this.cerrarConexion();
        return id_empleado; 
    }  
    
    //Métodos de acceso - Set.
    public void setUsuario(String usuario){
        this.usuario = usuario;   
    }
    
    public void setPassword(String password){
        this.password = password;   
    }
    
    //Métodos de acceso - Get.
    public Connection getConexion(){return this.conexion;} 
    public String getUsuario(){return this.usuario;} 
}