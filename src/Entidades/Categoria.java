
package Entidades;

public class Categoria {
   
    //Campos - Atributos.
    private int id_categoria;
    private String nombre;
   
    //Constructor.
    public Categoria(){       
    }
    
    //Métodos de acceso - Set.
    public void setId(int id_categoria){
        this.id_categoria = id_categoria; 
    }
     
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    
    //Métodos de acceso - Get.
    public int getId(){return this.id_categoria;}
    public String getNombre(){return this.nombre;}
}