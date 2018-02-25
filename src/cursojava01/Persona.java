/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojava01;

/**
 *
 * @author carlos
 */
public class Persona {
    
    private int idpersona;
    private String nombre, apellido;
    
    public int getId(){
        return idpersona;
    }
    
    public void setId(int id){
        idpersona = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    @Override
    public String toString(){
        return "Persona{ Id: "+idpersona+"; Nombre: "+nombre+"; Apellido: "+apellido+" }";
    }
    
}
