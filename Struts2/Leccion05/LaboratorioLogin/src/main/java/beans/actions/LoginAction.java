
package beans.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    
    private String usuario;
    private String password;

    @Override
    public String execute(){
        if("admin".equals(this.usuario)){
            return SUCCESS;
        } else {
            return INPUT;
        }
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
