
package test;

import domain.*;

public class TestClasesAbastractas {
    
    public static void main(String[] args) {
        
        Rectangulo rectangulo1 = new Rectangulo("Rectangulo");
        
        System.out.println("rectangulo1 = " + rectangulo1);
        
        FiguraGeometrica figura = new Rectangulo("Rectangulo"); 
    //automaticamente hace el downcasting, no es necesario anteponer 
    //(FiguraGeometrica) a new Rectangulo("Rectangulo");
        
        System.out.println("figura = " + figura);
        
        rectangulo1.dibujar();
    //ejecuta el metodo de la clase que le corresponde, la clase hija  
        
        figura.dibujar();
    //ejecuta el metodo de la clase hija porque es le mas bajo que hay, ya que es
    //una variable de clase padre pero tiene asignada un objeto de clase hija
    //es una de las caracteristicas del polimorfismo
    //y de hecho la clase padre ni siquiera tiene implementado el metodo
        
    }
    
}
