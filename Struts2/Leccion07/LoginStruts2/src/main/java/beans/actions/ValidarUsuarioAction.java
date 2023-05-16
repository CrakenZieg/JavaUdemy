
package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
        @Result(name="success", location="/WEB-INF/content/bienvenido.jsp"),
        @Result(name="input", location="/WEB-INF/content/login.jsp")
})
public class ValidarUsuarioAction extends ActionSupport{
    
    private String usuario;
    private String password;

    @Override
    @Action("ValidarUsuario")
    public String execute(){
        if("admin".equals(this.usuario)){
//ActionSupport viene con metodos como addActionMessage que nos permite agregar 
//un mensaje a la llamada al jsp
            addActionMessage(getText("usuario.valido"));
            return SUCCESS;
        } else {
            return INPUT;
        }
    }
//Nos permite tambien usar el metodo validate para validar datos y devolver mensajes
    @Override
    public void validate(){
        if(this.usuario==null || "".equals(this.usuario.trim())){
//add field error nos permite devolver el error directamente al field que le especificamos
            addFieldError("usuario", getText("val.usuario"));
        } else if (!usuarioValido()){
            addActionError(getText("usuario.invalido"));
        }
        if(this.password==null || "".equals(this.password.trim())){
            addFieldError("password", getText("val.password"));
        } else if (this.password.length()<3){
            addFieldError("password", getText("val.lentgh.password"));
        }
    }
    
    private boolean usuarioValido(){
        return "admin".equals(this.usuario);
    }
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
