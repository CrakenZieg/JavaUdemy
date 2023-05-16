
public class IfElse {
    
    public static void main(String args[]) {
    
        var condicion = true;
    
        if(condicion){
            System.out.println("Condicion verdadera");
        } else {
            System.out.println("Condicion falsa");
        }
        
        var numero = 2;
        var texto = "ponele";
        
        if(numero == 1) {
            texto = "Numero Uno";
        }
        else if (numero == 2) {
            texto = "Numero Dos";
        }
        else if (numero == 3) {
            texto = "Numero Tres";
        }
        else if (numero == 4) { 
            texto = "Numero Cuatro";
        } else {
            texto = "Numero no encontrado";
        }
        
        System.out.println("texto = " + texto);
        
    }
    
}
