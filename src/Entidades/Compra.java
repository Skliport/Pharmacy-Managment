
package Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Compra {
  
    //Campos - Atributos.
    private int id_compra, id_empleado;
    private Date fecha;
    public ArrayList<ProductoPorCompra> lProductosPorCompra;
    public ArrayList<Producto> lProductos;
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
    
    //Constructor.
    public Compra(){  
        
        lProductosPorCompra = new ArrayList<>();
        lProductos = new ArrayList<>();
        
        //Fecha de registro - Fecha actual.
        Date fechaActual = new Date();
        this.fecha = fechaActual; 
    }
       
    //Métodos de acceso - Set.
    public void setId_compra(int id_compra){
        this.id_compra = id_compra;
    }
    
    public void setId_empleado(int id_empleado){
         this.id_empleado = id_empleado; 
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha; 
    }
    
    //Métodos de acceso - Get.
    public int getId_compra(){return this.id_compra;} 
    public int getId_empleado(){return this.id_empleado;} 
    public Date getFecha(){return this.fecha;} 
    public String getString_fecha(){return sdf.format(this.fecha);} 
}