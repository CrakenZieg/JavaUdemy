
package test;

import domain.*;

public class TestSobreEscritura {
    
    public static void main(String[] args) {
        
        Empleado empleado1 = new Empleado("Pepe", 5);
        Gerente gerente1 = new Gerente("Roberto", 15, "balanza");
        
        //System.out.println("empleado= " + empleado1.obtenerDetalles());
        //System.out.println("gerente= " + gerente1.obtenerDetalles());
        
        imprimir(empleado1);
        imprimir(gerente1);
        
//Entonces la clase hija sobreescribre (@Override) el metodo de la clase hija
//es decir, cualquier instancia hija a la que se le pida el metodo va a devolver
//el propio, no el del padre.
//La clase hija si puede usar super(args) para incluir el metodo de la clase padre 
//entre las lineas de su método.
//Es importante que: 
//-Los metodos se llamen igual (padre e hijos)
//-los modificadores de acceso (public, protected, default, private) sean igual 
//o menos restrictivos en las clases hijas, es decir, si es protected en padre 
//no puede ser private en hijos
    
    }
    
//Polimorfismo:
//Es el hecho de que, por ejemplo, el metodo imprimir(args) siguiente funciona tanto 
//para empleados como para gerentes, ya que llama a un metodo del argumento que ambos 
//objetos tienen definido, o sea que es un metodo que "modifica su return" en funcion 
//del argumentos
//Lo central es que podemos usar como argumento para un metodo tipos especificos y los 
//"compatibles" con estos, en este caso, usamos Empleado como argumento, y un tipo hijo
//que es compatible
    
    
    public static void imprimir(Empleado empleado){
        String detalles = empleado.obtenerDetalles();
        System.out.println("empleado = " + detalles);
    }
    
}
