/*
Esta clase va a administrar las acciones de struts, y va a redireccionar en funcion
de los resultados que configuremos en el archivo struts xml que debemos crear
*/
package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

@Results({
    @Result(name="bienvenidoResult", location="bienvenidoTile", type="tiles"),
    @Result(name="personasResult", location="personasTile", type="tiles")
})
public class LinkAction extends ActionSupport{
    
    @Action(value="bienvenidoAction")
    public String bienvenido(){
        return "bienvenidoResult";
    }
    
    @Action(value="personasAction")
    public String personas(){
        return "personasResult";
    }
}