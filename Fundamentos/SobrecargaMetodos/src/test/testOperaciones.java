
package test;

import operaciones.Operaciones;

public class testOperaciones {
    
    public static void main(String[] args) {
        
        var resultado = Operaciones.sumar(5, 3);
        System.out.println("resultado = " + resultado);
        
        var resultado2 = Operaciones.sumar(2.0, 4.0);
        System.out.println("resultado2 = " + resultado2);
        
        var resultado3 = Operaciones.sumar(3, 4L);
        System.out.println("resultado3 = " + resultado3);
//puede resolver esta ultima haciendo 4L (long) como double        
    }
    
}
