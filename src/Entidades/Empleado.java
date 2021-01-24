
package Entidades;

import java.util.Date;

public class Empleado {
   
    //Campos - Atributos.
    private int id_empleado, id_cargo, estado;
    private String usuario, password, nombre, apellido;
    private Date fechaNacimiento, fechaContratacion;
    private double salario;
    
    //Constructor.
    public Empleado(){       
    }
    
    //Métodos de acceso - Set.
    public void setId(int id_empleado){
        this.id_empleado = id_empleado; 
    }
     
    public void setUsuario(String usuario){
        this.usuario = usuario; 
    }
    
    public void setPassword(String password){
        this.password = password; 
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido; 
    }
    
    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento; 
    }
    
    public void setFechaContratacion(Date fechaContratacion){
        this.fechaContratacion = fechaContratacion; 
    }
    
    public void setSalario(double salario){
        this.salario = salario; 
    }
    public void setCargo(int id_cargo){
        this.id_cargo = id_cargo; 
    }
    public void setEstado(int estado){
        this.estado = estado; 
    }
    
    //Métodos de acceso - Get.
    public int getId(){return this.id_empleado;}
    public String getUsuario(){return this.usuario;}
    public String getPassword(){return this.password;}
    public String getApellido(){return this.apellido;}
    public String getNombre(){return this.nombre;}
    public Date getFechaNacimiento(){return this.fechaNacimiento;}
    public Date getFechaContratacion(){return this.fechaContratacion;}
    public double getSalario(){return this.salario;}
    public int getCargo(){return this.id_cargo;} 
    public int getEstado(){return this.estado;}
}