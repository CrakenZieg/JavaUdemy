
public class CiclosWhile {
    
    public static void main(String args[]){
    
        var contadorWhile = 0;
        while (contadorWhile < 3) {
            System.out.println("contadorWhile = " + contadorWhile);
            contadorWhile++;
        }
        
        var contadorDoWhile = 0;
        
        do{ 
            System.out.println("contadorDoWhile = " + contadorDoWhile);
            contadorDoWhile++; 
        }while(contadorDoWhile < 3);
    
    }
    
}
