//import java.util.scanner;

public class Enteros {
    
    public static void main(String args[]){
        /*
            tipos primitivos enteros: 
            byte(8 bits), short (16 bits), char (16 bits), int (32 bits), long(64 bits),
            -128 a 127  , -32768 a 32767 , 0 a 65535     ,-2^31 a 2^31-1, -2^63 a 2^63-1
        
            tipos primitivos flotantes:
            float (32 bits), double (64 bits)
            1.4*e^(-0.45) a 3.4*e^(038), 4.9e^(-324) a 1.8e^(308)
        */
        
        byte numberoByte = 10;
        //podemos forzar el tipo, pero se equivoca, 
        //byte b = (byte)150; -->cuando lo mandemos a imprimir va a retornar un número de su rango
        
        System.out.println("Rango del byte: " + Byte.MIN_VALUE + " a " + Byte.MAX_VALUE);
        
        short numeroShort = 10;
        
        System.out.println("Rango del short: " + Short.MIN_VALUE + " a " + Short.MAX_VALUE);
        
        int numeroInt = 10;
        
        System.out.println("Rango del Int: " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);

        long numeroLong = 10;
        
        System.out.println("Rango del long: " + Long.MIN_VALUE + " a " + Long.MAX_VALUE);
        
        
    }
}
