
public class Etiquetas {
    
    public static void main(String args[]){
   
        inicio:
        for (var i = 0; i <= 5; i++){
            if (i % 2 != 0){
                continue inicio;// va a la etiqueta (no se recomienda, no es buena practica)
                //break tambien puede tener etiqueta
            }
            System.out.println("i = " + i);
        }
        
    }
    
}
