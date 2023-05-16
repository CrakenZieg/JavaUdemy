
public class Booleanos {
    
    public static void main(String args[]){
    
        boolean varBooleano= true;
        System.out.println("varBooleano = " + varBooleano);
        
        if (varBooleano){ 
            System.out.println("Booleano verdadero");
        } else {
            System.out.println("Booleano falso");
        }
        
        var edadMau = 10;
        //var esViejo = 10 >= edadMau;
        
        if(edadMau>=10) {
            System.out.println("Mau viejito");
        } else {
            System.out.println("Mau es un pibe");
        }
    
    }
    
}
