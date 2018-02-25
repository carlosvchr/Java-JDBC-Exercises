/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojava01;

import java.util.List;

/**
 *
 * @author carlos
 */
public class ManejoPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PersonasJDBC personasJDBC = new PersonasJDBC();
        
        //Prueba INSERT
        //personasJDBC.insert("Anibal", "Picazo");
        
        //Prueba UPDATE
        //personasJDBC.update(15, "Angel", "Delfin");
        
        //Prueba DELETE
        //personasJDBC.delete(14);
        
        //Prueba SELECT
        List <Persona> personas = personasJDBC.select();
        personas.stream().forEach((p) -> {
            System.out.println(p);
        });
    }
    
}
