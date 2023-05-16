
package test;

import Aritmetica.Aritmetica;
import excepciones.OperacionExcepcion;

public class TestExcepciones {
//Las excepciones son una clase hija de Throwable (hijo de Object), estas normalmente
//no se usan en el codigo
//Si la excepcion hereda del clase Exception se llama "checked exception":
//necesitan ser declaradas en el metodo o en la clausula "throws" del constructor 
//si pueden ser emitidas por la ejecucion del metodo o constructor y propagarse
//fuera del ambito de ese metodo o constructor 
//Si la excepcion hereda de RuntimeException se llama "uncheked exception":
//"no necesitan" lo anterior ya que el error se da en tiempo de ejecucion, 
//cuando ya esta corriendo el programa
   
    public static void main(String[] args) {
//Dividir por cero claramente genera una excepcion, por lo que, para que no se termine
//de manera abrupta el programa, debemos tratar de que se recupere
        int resultado = 0;
//para ello "envolvemos" el codigo conflictivo en un TryCatch
        try{                                                          //Intenta
            resultado = Aritmetica.division(10,0);                    //codigo conflictivo
        }catch(OperacionExcepcion e){                                 //catchs de menor jerarquia
            System.out.println("Ocurrio un error OperacionExcepcion");//|
            System.out.println(e.getMessage());                       //V
        }catch(Exception e){                                          //catchs mas generales
            System.out.println("Ocurrio un error de tipo Exception: ");
            e.printStackTrace(System.out);//imprimi el pila de excepciones 
            System.out.println(e.getMessage());//imprimi el mensaje solo
        }finally{                                                     //(una excepcion puede desencadenar varias)
            System.out.println("Se reviso la division por cero");
        } //el bloque finally siempre se ejecuta, independientemente de la excepcion
        System.out.println("resultado = " + resultado);
//Entonces intenta correr la /0, encuentra la excepcion, la agrega a la pila y para no
//terminar abruptamente, continua con el catch, imprime la pila de excepcion 
//(porque esta codeado asi) y continua con el codigo, donde imprime "resultado = 0" 
//ya que era el default por que lo que queda dentro del try tiro expecepcion
    }
//ahora que creamos un metodo con su excepcion nosotros, cuando el metodo da excepcion
//nos devuelve nuestro mensaje
}
