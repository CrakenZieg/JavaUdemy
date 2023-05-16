
public class Operadores {
    
    public static void main(String args[]){
        
        int a = 2, b = 3;
        var resultado = a + b;
        System.out.println("Suma = " + resultado);
        
        resultado = a - b;
        System.out.println("Resta = " + resultado);
        
        resultado = a * b;
        System.out.println("Multiplicacion = " + resultado);
        
        resultado = b / a;
        System.out.println("division = " + resultado + " (porque a y b son enteros, resultado es entero)");
        
        var c = 3.0;
        System.out.println("division = c / a = " + (c/a) + " (c = 3.0)");
        
        resultado = b % a;
        System.out.println("Resto o modulo = " + resultado);
        
        if ( a % 2 == 0){
            System.out.println("a es Par");
        } else {
            System.out.println("a es Impar");
        }
        
    }
    
}
