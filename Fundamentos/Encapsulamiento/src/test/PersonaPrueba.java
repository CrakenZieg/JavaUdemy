
package test;

import dominio.Persona;
//si quiero importar todas las clases dentro de dominip, 
//hago dominio.* (asterisco)

public class PersonaPrueba {

//static se asocia al centexto estatico, es decir, cuando se cargan las clases,
//en contraposicion al contexto dinamico, cuando creas objetos, en base a esas clases
//que ya cargaste    
    
    public static void main(String[] args) {
        
         Persona persona_1 = new Persona("Carlos", 5000, false);
         //creo objeto con atributo valor = x
         System.out.println("persona_1.nombre = " + persona_1.getNombre());
         //recupero valor del atributo con el get
         persona_1.setNombre("Juan Carlos");
         //modifico el valor del atributo con el set
         System.out.println("persona_1.nombre = " + persona_1.getNombre());
         //recupero el nuevo valor del atributo con el get 
         
         System.out.println(persona_1.toString());
         System.out.println(persona_1);
         //print y println llaman automaticamente al metodo toString()
         //que hay dentro de la clase Persona, o sea que no es necesario
         //hacer persona_1.toString()
         
    }
    
}
