
public class BreakContinue {
    
    public static void main(String args[]){
    //break corta con los ciclos
    //continue salta de iteración, los siguientes son codigos con el mismo retorno:
        //el primero imprime si la variable es par
        for (var i = 0; i <= 5; i++){
            if (i % 2 == 0){
                System.out.println("i = " + i);
            }
        }
        //el segundo saltea la impresion cuando la variable no es par
        for (var i = 0; i <= 5; i++){
            if (i % 2 != 0){
                continue;
            }
            System.out.println("i = " + i);
        }
        
    }
    
}
