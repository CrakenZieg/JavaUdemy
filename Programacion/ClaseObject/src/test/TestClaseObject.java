
package test;

import domain.*;

public class TestClaseObject {
    public static void main(String[] args) {
        
        Empleado empleado1 = new Empleado("Roberto", 15);
        Empleado empleado2 = new Empleado("Roberto", 15);
        
    // '==' compara las referencias en memoria de los objetos
    //como cada empleado tiene "new Empleado(args)" se crea una nueva referencia 
    //en memoria para cada uno, por lo que no son iguales '=='
        
        if (empleado1 == empleado2){
            System.out.println("'==' --> Tienen la misma referencia en memoria");
        } else {
            System.out.println("'==' --> Tienen diferente referencia en memoria");
        }
    
//todos los tipo objeto vienen con dos metodos para comparar, uno equals y otro 
//que compara el codigo hash de cada objeto

//si creamos un nuevo metodo equals() tambén debemos crear un nuevo metodo hashCode()
//que sobreescriba los metodos que tiene la clase Object (es buena practica)

//luego podemos usar: 
//objeto1.equals(objeto2); 

//o comparar: 
//(objeto1.hashCode() == objeto2.hashCode());
        
//ambos metodos devuelven booleanos

        if (empleado1.equals(empleado2)){
            System.out.println("Metodo obj1.equals(obj2) --> Tienen el mismo contenido");
        } else {
            System.out.println("Metodo obj1.equals(obj2) --> Tienen diferente contenido");
        }
        
         if (empleado1.hashCode() == empleado2.hashCode()){
            System.out.println("Metodo obj11.hashCode() == obj2.hashCode() --> Tienen el mismo hashCode");
        } else {
            System.out.println("Metodo obj11.hashCode() == obj2.hashCode() --> Tienen diferente hashCode");
        }

    }
}
