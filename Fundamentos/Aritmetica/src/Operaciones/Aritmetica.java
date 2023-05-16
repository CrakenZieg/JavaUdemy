
package Operaciones;

public class Aritmetica {
    //atributos
    int a;
    int b;
    
    //constructor
    public Aritmetica(){
    
        System.out.println("Ejecutando constructor");
        //a = 0; Java automaticamente asigna el valor default si creas una variable sin darle valor,
        //b = 0; no es necesario incluir las variables en el constructor (a menos que queramos darle un valor)
    
    }
    //sobrecarga de constructores: darle más de un constructor a una clase, por ejemplo:
    public Aritmetica(int a, int b){
        this.a = a;
        this.b = b;
        System.out.println("Ejecutando constructor con argumentos");
        
    }
    //***** O sea que la clase Aritmetica tiene 2 constructores, uno sin asignar parametros y otro con asignacion.
    //Java asigna constructores automaticamente si no definiste ningun constructor previamente
        
    //metodos
    public void sumar(){
    
        int resultado = this.a + this.b;
        System.out.println("resultado = " + resultado);
            
    }
    
    public int sumarConRetorno(){
        
        return a + b;        
        
    }
    
    public int sumarConArgumentos(int a, int b){
        this.a = a;
        this.b = b;
        return this.sumarConRetorno();
        
    }
}
    

