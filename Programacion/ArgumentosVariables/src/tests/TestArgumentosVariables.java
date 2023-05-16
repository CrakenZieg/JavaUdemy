
package tests;

public class TestArgumentosVariables {
    
    public static void main(String[] args) {
        
         variosParametros("primera tanda", 1, 2, 3, 7);
         variosParametros("segunda tanda", 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
                
    }
    
    //los ... implican que no sabemos cuantos argumentos vamos a recibir
    //se combierte en un arreglo
    private static void imprimirNumeros(int...numeros){
        for(int i = 0; i < numeros.length; i++){
            System.out.println("Numeros["+i+"] = " + numeros[i]);
        }
    }
    //el argumento variable siempre va al final
    private static void variosParametros(String nombre, int... numeros){
        System.out.println("Nombre = " + nombre);
        imprimirNumeros(numeros);
    }
    
}
