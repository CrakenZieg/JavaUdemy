
package PasoPorReferencia;
import Clases.Persona;

public class PasoPorReferencia {
    
    public static void main(String[] args) {
        
//a diferencia de los tipos primitivos, que pasan el valor, en objetos se pasa la referencia
//cuando pasamos un objeto, no se "copia", lo que hace es pasar la referencia del mismo
        Persona persona_1 = new Persona();
        
        persona_1.nombre = "Roberto";
        System.out.println("persona_1 nombre = " + persona_1.nombre);
        
        persona_1 = cambiaValor(persona_1);
        
        System.out.println("cambiaValor(persona_1) nombre= " + persona_1.nombre);
        //si paso un valor de persona_1 = null; voy a tener un error en tiempo de ejecucion en
        //todas las referencias al objeto persona_1 ya que apuntan a un objeto "vacio", un objeto
        //que no tiene referencia en la memoria
    }
    
    public static Persona cambiaValor(Persona persona){
    //para agregar varios return a un metodo, debemos ponerlos dentro de condicionales 
        if (persona == null) {
            System.out.println("Valor de Persona invalido: null");
            return null;
        }
        
        persona.nombre = "Carlos";
        //si un metodo tiene un retorno "void", java directamente agrega al fondo del metodo return;
        //por eso, auqnue no este visible, todos los metodos tienen return
        return persona;
        
    }
    
}
