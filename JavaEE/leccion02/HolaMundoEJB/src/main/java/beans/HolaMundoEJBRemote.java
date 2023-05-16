
package beans;

import javax.ejb.Remote;

@Remote
public interface HolaMundoEJBRemote {
    
    public int sumar(int a, int b);
    
}
