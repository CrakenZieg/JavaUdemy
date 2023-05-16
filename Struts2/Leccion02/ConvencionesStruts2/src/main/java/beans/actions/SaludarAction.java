
package beans.actions;

//Una clase de tipo action de struts no necesariamente extiende o implementa de una clase java

import org.apache.logging.log4j.*;

//Lo unico que la caracteriza es tener un metodo execute
public class SaludarAction {
    
    //Nombre de la clase que estamos usando 
    Logger log = LogManager.getLogger(SaludarAction.class);
    
    private String saludosAtr;

    //metodo que ejecuta el framework de Struts cuando ejecuta la clase
    public String execute(){
        log.info("Ejecutando metodo execute() de Struts2");
        this.saludosAtr = "Hola desde Struts2 con convenciones";
        //siempre retorna un String que indica el nombre del JSP que se va a ejecutar
        return "exito";
        
    }
    
    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
    
    
    
}
