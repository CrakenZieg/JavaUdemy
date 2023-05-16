
package domain;

public class Persona {
//una constante se definiria como final static, se escriben en mayus
    public static final String MAU_MAU = "MAUUU";
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
//final en un metodo implica que no se puede modificar o sobreescribir 
//ese metodo en las clases que lo heredan    
    public final void mau(){
        System.out.println("MAUU");
    }
    
}
