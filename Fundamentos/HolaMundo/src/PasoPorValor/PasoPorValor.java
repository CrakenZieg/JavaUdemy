
package PasoPorValor;

public class PasoPorValor {
    
    public static void main(String[] args) {
        
        int x = 10;
        System.out.println("x = " + x);
        
        cambioValor(x);
        System.out.println("x 'nuevo valor'= " + x);     
        
    }
    
    //Java no pasa la variable, pasa solo su valor
    public static void cambioValor(int arg1){
        
    //arg1 es una variable nueva, de valor x, o sea 10
    
        System.out.println("arg1 = " + arg1);
        arg1 = 15;
        System.out.println("arg1 'nuevo valor'= " + arg1);
        
    }
    
    //se podría si hicieramos x = cambioValor() y a cambioValor le dieramos un return arg1, por ejemplo
    
}
