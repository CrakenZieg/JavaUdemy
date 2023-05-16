
package beans.actions;

//Una clase de tipo action de struts no necesariamente extiende o implementa de una clase java

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;

//Lo unico que la caracteriza es tener un metodo execute

//extender esta clase tiene varias ventajas, incluyendo el hecho de que implementa
//varias interfaces que incluyen validacion de datos, recuperacion de textos para
//internacionalizacion, etc
//esta clase contiene varias constantes que podemos devolver, incluyendo error, success,
//none, etc
public class MostrarPersonaAction extends ActionSupport{
    
     
    Logger log = LogManager.getLogger(MostrarPersonaAction.class);
    
    private String nombre;

    //metodo que ejecuta el framework de Struts cuando ejecuta la clase
    @Override
    public String execute(){
        log.info("El nombre es: "+this.nombre);
        return SUCCESS;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
