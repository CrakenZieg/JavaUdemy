public class Concatenacion {
    public static void main(String args[]) {
        var usuario = "Roberto";
        var titulo = "Boludo";
        
        var union = usuario + " es " + titulo;
        
        System.out.println("union = " + union);
        
        var int1 = 3;
        var int2 = 4;
        //suma
        System.out.println(int1 + int2);
        //suma y encadena
        System.out.println(int1 + int2 + usuario);
        //encadena
        System.out.println(int1 + usuario + int2);
        //encadena y sigue encadenando
        System.out.println(usuario + int1 + int2);
        //primero resuelve parentesis
        System.out.println(usuario + (int1 + int2));
        
    }
}
