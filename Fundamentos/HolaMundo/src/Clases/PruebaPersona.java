
package Clases;

public class PruebaPersona {
    
    public static void main(String[] args) {
        //Puedo hacer Persona persona1 = new Persona(); pero lo hago de esta manera para mostrar que se puede
        Persona persona1; 
        persona1 = new Persona();
        
        //con Objeto. me muestra atributos y metodos asociados al objeto
        persona1.nombre = "Roberto";
        persona1.apellido = "Carlos";
        persona1.desplegarInformacion();
        
        //creo nuevo objeto Persona
        Persona persona2 = new Persona();
        //el metodo retornara null porque no hay valores        
        persona2.desplegarInformacion();
        persona2.nombre = "Roberta";
        persona2.apellido = "Carla";
        //ahora ya va a mostrar datos
        persona2.desplegarInformacion();
                
    }
    
}
