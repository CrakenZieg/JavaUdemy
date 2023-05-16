public class CaracteresEspeciales {
    public static void main (String args[]) {
        var nombre = "Mau";
        
        //salto de linea
        System.out.println("Nueva linea: \n" + nombre);
        //tab
        System.out.println("Tabulador: \t" + nombre);
        //vuelve un caracter (por cada \b)
        System.out.println("Retroceso: \b" + nombre);
        //con \' podés usar '' y "" sin problemas (como en expresiones genericas de Js)
        System.out.println("Comilla simple: \'" + nombre + "\'");
        System.out.println("Comilla doble: \"" + nombre + "\"");
        // *igual '' no sirve para rodear strings 
    }
}
