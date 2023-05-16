
package test;

import domain.*;

public class TestConversionDeObjetos {
    
    public static void main(String[] args) {
        
        Empleado empleado;
        
        empleado = new Escritor("Roberto", 15, TipoEscritura.CLASICO); 
        //una variable de clase padre puede almacenar objetos de clase hija
        
        System.out.println("empleado = " + empleado);
        
        System.out.println(empleado.obtenerDetalles());
//Aca cuando ejecuta se da cuenta que aunque la variable es de clase Empleado, apunta 
//una clase hija de Empleado, como padre e hija tienen metodos que se llaman igual, 
//llama al de la clase hija, al de la clase a la que hace referencia la variable y no
//al de la clase que ES la variable

//El polimorfismo se resuelve cuando ejecuta

//En este caso, se resuelve satisfactoriamente, ya que el metodo que llamamos tiene 
//el mismo nombre en padre e hija, y JAVA va y mira la referencia y dice "uso el metodo
//de la hija"

//No podría llamar un metodo de la clase hija, si la variable es de clase padre
//y esa clase padre no poseyera un metodo del mismo nombre, por eso la conversion de objetos
//Por ejemplo:
    
//    empleado.getTipoEscritura();
//    no funciona, ya que la variable tipo Empleado no tiene el metodo getTipoEscritura()
//    Por eso hacemos conversion:

    ((Escritor)empleado).getTipoEscritura(); //DOWNCASTING
//Este tipo de conversion se llama downcasting, ya que bajamos de la clase padre a la clase hija
//por ejemplo:

    Escritor escritor = (Escritor)empleado; //empleado era de tipo Empleado y la bajamos a Escritor

//El upcasting es convertir una variable de tipo hija en una variable de tipo padre, por ejemplo:

    Empleado empleado2 = (Empleado) escritor; //empleado2 era escritor tipo Escritor y ahora es de tipo
//Empleado

   

    }
    
}
