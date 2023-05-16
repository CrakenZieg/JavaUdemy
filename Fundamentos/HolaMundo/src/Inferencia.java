public class Inferencia {
    
    public static void main(String args[]){
        //cliqueando a la izquierda de los numeros de linea ponemos puntos de ruptura, pada debugear
        var numeroEntero = 10;
        System.out.println("numeroEntero = " + numeroEntero);
        
        var numeroDouble = 10.11111111111111111111111111111;
        System.out.println("numeroDouble = " + numeroDouble);
        
        var numeroFloat = (float)numeroDouble;
        System.out.println("numeroFloat = " + numeroFloat + " (que es \"igual\" a (float)numeroDouble)");
        
    }
    
}
