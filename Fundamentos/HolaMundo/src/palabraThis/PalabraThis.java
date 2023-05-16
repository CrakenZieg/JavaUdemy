
package palabraThis;

public class PalabraThis {
    
    public static void main(String[] args) {
    //puedo hacer "new String("string1")" y crear un lugar specifico en la memoria
    //normalmente, cuando haces "string1", no le da lugar más que en el poolString,
    //un lugar generico donde Java va mandando los Strings
        Persona persona_1 = new Persona("Juan", "Perez");                
        System.out.println("persona_1 = " + persona_1); 
    //imprime persona_1 = palabraThis.Persona@16b98e56
    //        nombre      paquete donde esta @ lugar en la memoria     
    
    }
    
}

class Persona{

    String nombre; 
    String apellido;
    
    Persona(String nombre, String apellido){
    //super(): hay una llamada implicita al constructor de la clase Object en 
    //las clases, es ese constructor el que reserva espacio de memoria
        this.nombre = nombre;
        this.apellido = apellido;
        System.out.println("Objeto persona usando this: " + this);
        //puedo hacer Imprimir imprimir = new Imprimir, etc; pero me puedo 
        //ahorrar la variable
        new Imprimir().imprimir(this);
        
    }
    
}

class Imprimir{
    public void imprimir(Persona persona){
        System.out.println("persona desde imprimir " + persona);
        System.out.println("impresion del objeto actual (this) " + this);
    }
}
/*
Run file imrpime:
Objeto persona usando this: palabraThis.Persona@16b98e56
persona desde imprimir palabraThis.Persona@16b98e56
impresion del objeto actual (this) palabraThis.Imprimir@27d6c5e0
persona_1 = palabraThis.Persona@16b98e56
La primera linea es del constructor de la clase Persona
la segunda imprime la variable que le pase al objeto de clase imprimir que cree
la tercera imprime el objeto de clase imprimir que cree
la cuarta imprime la persona que cree
*/