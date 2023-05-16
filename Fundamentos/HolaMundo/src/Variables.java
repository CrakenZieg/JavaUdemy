public class Variables {
    public static void main(String args[]) {
        
        int miVariableEntera = 10;
        System.out.println("miVariableEntera = " + miVariableEntera);
        
        //modificamos miVariableEntera
        miVariableEntera = 5;
        System.out.println("miVariableEntera nueva = " + miVariableEntera);
        
        String miVariableString = "Saludos";
        System.out.println("miVariableString = " + miVariableString);
        
        miVariableString = "Adios";
        System.out.println("miVariableString nueva = " + miVariableString);
        
        //inferencia de datos: java ve el literal de la variable y se da cuenta del tipo
        var miVariableEntera2 = 15;
        System.out.println("miVariableEntera2 = " + miVariableEntera2);
        
        var miVariableString2 = "Trompeta";
        System.out.println("miVariableString2 = " + miVariableString2);   
        
        //nombre posibles, no se recomienda poner acentos, siempre en camello y comenzando en minúscula 
        var miVariable = 1;
        var _miVariable = 2;
        var $miVariable = 3;
        
        System.out.println("miVariable = " + miVariable);
        System.out.println("_miVariable = " + _miVariable);
        System.out.println("$miVariable = " + $miVariable);
    }
}
