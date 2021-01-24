
package Entidades;

public class ProductoPorVenta {
   
    //Campos - Atributos.
    private int id_venta, cantidad, id_producto;
    private double precio_unitario;
    
    //Constructor.
    public ProductoPorVenta(){       
    }
    
    //Métodos de acceso - Set.
    public void setId(int id_venta){
        this.id_venta = id_venta;
    }
    
    public void setId_producto(int id_producto){
        this.id_producto = id_producto;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public void setPrecio(double precio_unitario){
        this.precio_unitario = precio_unitario;
    }
    
    //Métodos de acceso - Get.
    public int getId_venta(){return this.id_venta;} 
    public int getId_producto(){return this.id_producto;} 
    public int getCantidad(){return this.cantidad;} 
    public double getPrecio(){return this.precio_unitario;} 
}