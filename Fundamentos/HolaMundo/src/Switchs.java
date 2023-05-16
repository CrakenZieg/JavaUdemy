
public class Switchs {
    
    public static void main(String args[]){
    
        var numero = 2;
        var numeroTexto = "Valor desconocido";
        
        switch(numero){
            case 1:
                numeroTexto = "Numero Uno";
                break;
            case 2:
                numeroTexto = "Numero Dos";
                break;
            case 3:
                numeroTexto = "Numero Tres";
                break;
            case 4:
                numeroTexto = "Numero Cuatro";
                break;
            default:
                numeroTexto = "Caso no encontrado";
        }
        
        System.out.println("numeroTexto = " + numeroTexto);
        
    }
    
}
