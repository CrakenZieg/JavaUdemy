
package excepciones;
//creamos nuestra propia excepcion, para que la tome como tal, debe ser hija de
//alguna de las clases de exception (Exception o RuntimeExceptop), 
//la hacemos hija de Exception, que no obliga a procesarla en el codigo

public class OperacionExcepcion extends Exception {
    
//normalmente, al surgir una excepcion se emite un mensaje que debemos propagar 
//a la clase padre, por lo que en el constructor de nuestra excepcion llamamos
//al constructor de la clase padre (Exception) usando como argumento ese mensaje
    public OperacionExcepcion(String mensaje){
        super(mensaje);
    }
}
