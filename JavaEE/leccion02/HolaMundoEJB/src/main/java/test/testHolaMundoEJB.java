package test;

import beans.HolaMundoEJBRemote;
import javax.naming.*;

public class testHolaMundoEJB {
    public static void main(String[] args){
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try{
            Context jndi = new InitialContext();
            System.out.println("creado jndi");
            HolaMundoEJBRemote holaMundoEJB = (HolaMundoEJBRemote) jndi.lookup("java:global/HolaMundoEJB-1.0/HolaMundoEJBImpl!beans.HolaMundoEJBRemote");
            System.out.println("jndi.lookup()");
            int resultado = holaMundoEJB.sumar(3, 5);
            System.out.println("llamado el metodo .sumar()");
            System.out.println("El resultado de sumar 3 y 5 es: " + resultado);
        }
        catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
