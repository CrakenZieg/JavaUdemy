
package test;

import domain.*;

public class TestJavaBeans {
    public static void main(String[] args) {
//Usamos el constructor vacio porque al crearla no sabemos cuales son los parametros 
//del constructor
        PersonaBean persona = new PersonaBean();
//Usamos los setters
        persona.setNombre("Carlo");
        persona.setApellido("SinNombre");
        
        System.out.println(persona.toString());
        
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Apellido: " + persona.getApellido());
        
    }
}
