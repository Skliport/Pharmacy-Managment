
package Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venta {
    
    //Campos - Atributos.
    private int id_venta, id_empleado;
    private Date fecha;
    public ArrayList<ProductoPorVenta> lProductosPorVenta;
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
    
    //Constructor.
    public Venta(){ 
        lProductosPorVenta = new ArrayList<>();
        
        //Fecha de registro - Fecha actual.
        Date fechaActual = new Date();
        this.fecha = fechaActual; 
    }
 
    //Métodos de acceso - Set.
    public void setId_venta(int id_venta){
         this.id_venta = (id_venta); 
    }
    
    public void setId_empleado(int id_empleado){
         this.id_empleado = id_empleado; 
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;     
    }
        
    //Métodos de acceso - Get.
    public int getId_venta(){return this.id_venta;} 
    public int getId_empleado(){return this.id_empleado;} 
    public Date getFecha(){return this.fecha;} 
    public String getString_fecha(){return sdf.format(this.fecha);} 
}