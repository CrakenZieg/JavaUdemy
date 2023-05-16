
package test;

import paquete1.Clase1;
import paquete1.ClaseMismoPaq;
import paquete2.ClaseHija;

public class TestModificadoresAcceso {
    
    public static void main(String[] args) {
        
        Clase1 clase1 = new Clase1();
        System.out.println ("clase1 = " + clase1.atributoPublico);
        clase1.metodoPublico();
        
//clase1. no me muestra los atributos o metodos protected porque 
//ni es clase heredera ni está en el mismo paquete

        ClaseHija claseHija = new ClaseHija();
        System.out.println("claseHija = " + claseHija);
//protected es para caracteristicas que queremos que sean privadas,
//pero accesibles para las clases hijas

//default permite el acceso solo a clases hijas del mismo paquete
//default puede usarse en clases
        
        ClaseMismoPaq claseMismoPaq = new ClaseMismoPaq();

/*private no permite a otras clases, hijas o no, dentro o no del mismo paquete
acceder a un atributo, constructor o metodo,
si se puede mediante metodos publicos, protected o default como intermedios
por ejemplo ejemplo en una clase podría tener 

    private constructor(){}

y "acceder indirectamente"   
      
    public constructor(String mau){
       this(); --> aca llama al constructor privado
       algoCon(mau);
    }
    
    Por eso los getters y setters son importantes, te permiten acceder a 
variables a las que no tenes que tener acceso

        
*/        
    }
    
}
