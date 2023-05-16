
package tests;

import domain.Persona;

public class TestForEach {
    public static void main(String[] args) {
        
        int edades[] = {5, 6, 8, 12};
        
        for(int i = 0; i < edades.length; i++){
            System.out.println("sarasa for " + edades[i]);
        }
//for each me permite iterar sin necesidad de un contador, pero este tambien su limitante
        for(int edad: edades){
            System.out.println("sarasa for each " + edad);
        }
        
        Persona personas[] = {new Persona("mau"), new Persona("Mau"), new Persona("MAU")};
        
        for(Persona persona: personas){
            System.out.println("persona = " + persona.getNombre());
        }
        
    }
}
