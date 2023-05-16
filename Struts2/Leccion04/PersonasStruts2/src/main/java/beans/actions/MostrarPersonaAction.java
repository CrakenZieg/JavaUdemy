
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
    
//Definimos 3 metodos que recuperan los valores del archivo de propiedades mediante 
//el metodo getText definido en la clase actionSupport 
//usando estos metodos es que vamos a poder recuperar los valores para rellenar el 
//JSP 
    public String getTitulo() {
        return getText("persona.titulo");
    }
    public String getValor() {
        return getText("persona.valor");
    }
    public String getBoton() {
        return getText("persona.boton");
    }
    
}
