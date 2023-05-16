
package test;

import domain.Persona;

public class PersonaPrueba {
    
    public static void main(String[] args) {
        
        Persona persona_1 = new Persona("Carlos");
        System.out.println("persona_1 = " + persona_1);
        
        Persona persona_2 = new Persona("Carlos");
        System.out.println("persona_2 = " + persona_2);
//como contadorPersonas es un atributo estatico, sigue existiendo con la clase        
//no se reinicia con cada objeto que se crea

        imprimir(persona_1);
        imprimir(persona_2);

    }
//Dentro de un metodo estatico solo se pueden llamar metodos estaticos
//tampoco se puede usar this, ya que tambien existen a partir de la creacion
//de obejetos    
    public static void imprimir(Persona persona){
    
        System.out.println("Persona: " + persona);
        
    }
}
