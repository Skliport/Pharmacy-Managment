
package Entidades;

public class Producto {
    
    //Campos - Atributos.
    private int id_producto, existencia, id_categoria, id_proveedor;
    private String nombre, fabricante;
    private double precio_unitario;
    
    //Constructor.
    public Producto(){       
    }
    
    //Métodos de acceso - Set.
    public void setId_producto(int id_producto){
        this.id_producto = id_producto;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    
    public void setId_categoria(int id_categoria){
        this.id_categoria = id_categoria;
    }
    
    public void setId_proveedor(int id_proveedor){
        this.id_proveedor = id_proveedor;
    }
    
    public void setExistencia(int existencia){
        this.existencia = existencia;
    }
    
    public void setPecio(double precio_unitario){
        this.precio_unitario = precio_unitario;
    }
    
    //Métodos de acceso - Get.
    public int getId_producto(){return this.id_producto;} 
    public int getId_categoria(){return this.id_categoria;} 
    public int getId_proveedor(){return this.id_proveedor;}
    public String getNombre(){return this.nombre;}
    public String getFabricante(){return this.fabricante;}
    public int getExistencia(){return this.existencia;} 
    public double getPrecio(){return this.precio_unitario;} 
}