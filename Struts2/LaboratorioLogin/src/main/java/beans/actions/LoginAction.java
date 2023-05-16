
package beans.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    
    private String usuario;
    private String password;

    @Override
    public String execute(){
        return SUCCESS;
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
    
    public String getTitulo() {
        return getText("form.titulo");
    }
    public String getUsuar() {
        return getText("form.usuar");
    }
    public String getContra() {
        return getText("form.contra");
    }
    public String getBoton() {
        return getText("form.boton");
    }
     public String getValor() {
        return getText("form.valor");
    }
   
    
}
