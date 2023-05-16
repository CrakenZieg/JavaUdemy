
package Operaciones;

public class PruebaAritmetica {
    
    public static void main(String[] args) {
        
        Aritmetica aritmetica1 = new Aritmetica();
        
        aritmetica1.a = 3;
        aritmetica1.b = 4;
        aritmetica1.sumar();
        
        int resultado = aritmetica1.sumarConRetorno();
        System.out.println("resultado desde prueba = " + resultado);
        
        resultado = aritmetica1.sumarConArgumentos(5, 3);
        System.out.println("resultado = " + resultado);
        
    }
    
}
