
package test;

import domain.Persona;

public class TestFinal {
    
    public static void main(String[] args) {
//final en una variable la hace constante (en esa instancia), 
//no se puede modificar su valor        
        final int miVariable = 10;
        System.out.println("miVariable = " + miVariable);
        
    
    
    final Persona persona_1 = new Persona();
//no puedo modificar la referencia del objeto al que apunta la variable el 
//nombre persona_1, porque es final, si puedo modificar sus atributos
    persona_1.setNombre("Roberto");    
    System.out.println("persona_1.nombre = " + persona_1.getNombre());
    } 
}
