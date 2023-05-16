
package test;

import domain.*;

public class TestInstanceOf {
    
    public static void main(String[] args) {
        
        Empleado empleado1 = new Empleado("Pepe", 5);
        
        determinarTipo(empleado1);
        
        empleado1 = new Gerente("Roberto", 15, "balanza");
        
        determinarTipo(empleado1);
            
    }
    
//El tipo de la variable y el tipo del espacio en memoria no necesariamente son iguales,
//yo podría hacer, por ejemplo:
    
//  Empleado empleado1 = new Empleado("Pepe", 5);
    
//Hasta acá la variable empleado1 es de tipo Empleado y hace referencia a un espacio de
//memoria de tipo Empleado tambien, pero puedo hacer lo siguiente:
    
//  empleado1 = new Gerente("Roberto", 15, "balanza");
    
//Y le asigno, a la misma variable, la referencia a otro espacio de memoria diferente, que 
//en este caso es de tipo Gerente, al final, la variable es de tipo Empleado, y es una 
//instancia de tipo Gerente
    
//InstanceOf nos va a permitir determinar el tipo de una variable en tiempo de ejecucion 
//es decir, nos va a permitir preguntar de que tipo es la referencia a la cual apunta
//cierta variable
    
//instanceof nos va a decir si un objeto es de determinado tipo, vale recordar que cada
//hijo tambien es de las clases padres, es decir, gerente1 es tipo Gerente, es tipo Empleado
//y tambien es tipo Object
    
//Usando instanceof podemos conocer el tipo de la referencia a la que alude la variable y luego 
//convertir el tipo de la variable para poder acceder a los metodos/atributos de esa referencia,  
//a los que no podiamos accerder porque el tipo de la variable no los tiene. En el ejemplo,  
//por mas que empleado1 haga referencia a un objeto de tipo Gerente, no vamos a poder acceder 
//metodos/atributos propios del tipo Gerente, solo a los que tenga el tipo Empleado, 
//sobreescritos o no por metodos/atributos del tipo Gerente
    
//La conversion de tipo es similar a las de tipos primitivos, por ejemplo:
    
//empleado1.getDepartamento(); 
//no va a funcionar ya que empleado1 es de tipo Empleado y este no tiene definido el atributo
//departamento ni el metodo getDepartamento(), pero si convertimos el tipo:

//((Gerente)empleado1).getDepartamento();
//va a funcionar ya que cambiamos el tipo de variable a Gerente
    
    public static void determinarTipo(Empleado empleado){
        if(empleado instanceof Gerente){
            System.out.println(empleado + "es de tipo Gerente");
            System.out.println("Es gerente en el departamento de " + ((Gerente)empleado).getDepartamento());
        } else if (empleado instanceof Empleado){
            System.out.println(empleado + "es de tipo Empleado");
        } else if (empleado instanceof Object){
            System.out.println(empleado + "es de tipo Object");
        }
    }
    

    
}
