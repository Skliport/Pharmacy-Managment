
package Entidades;

public class ProductoPorCompra {
   
    //Campos - Atributos.
    private int id_compra, cantidad, id_producto;
    private double precio_unitario;
    
    //Constructor.
    public ProductoPorCompra(){       
    }
    
    //Métodos de acceso - Set.
    public void setId(int id_compra){
        this.id_compra = id_compra;
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
    public int getId_compra(){return this.id_compra;} 
    public int getId_producto(){return this.id_producto;} 
    public int getCantidad(){return this.cantidad;} 
    public double getPrecio(){return this.precio_unitario;} 
}