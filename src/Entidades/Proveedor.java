
package Entidades;

public class Proveedor {
    
    //Campos - Atributos.
    private int id_proveedor;
    private String nombre;
   
    //Constructor.
    public Proveedor(){       
    }
    
    //Métodos de acceso - Set.
    public void setId(int id_proveedor){
        this.id_proveedor = id_proveedor; 
    }
     
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    
    //Métodos de acceso - Get.
    public int getId(){return this.id_proveedor;}
    public String getNombre(){return this.nombre;}
}