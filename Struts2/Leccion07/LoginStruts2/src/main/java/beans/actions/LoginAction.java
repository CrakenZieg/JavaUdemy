
package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
//resultados posibles de esta clase en funcion del retorno del metodo execute
@Result(name="success", location="/WEB-INF/content/login.jsp")
public class LoginAction extends ActionSupport {
//accion que ejecuta esta clase cuando la llaman desde ("accion")
    @Action("login")
    public String execute(){
        return SUCCESS;
    }
    
}
