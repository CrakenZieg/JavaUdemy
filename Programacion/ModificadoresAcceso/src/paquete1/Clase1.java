
package paquete1;

public class Clase1 {

//public: accede cualquiera 
//vale para clases, constructores, variables y metodos
    public String atributoPublico = "Valor atributo publico";
    protected String atributoProtected = "Valor atributo protected";
    String atributoDefault = "valor atributo Default";
    private String atributoPrivado = "atributo Privado";
    
    public Clase1() {
        System.out.println("Constructor Publico");
    }
        
    protected Clase1(String protect) {
        System.out.println("Constructor Protected");
    }
    
    Clase1(int num){
        System.out.println("Constructor default");
    }
    
    public void metodoPublico(){
        System.out.println("Metodo publico");
    }
    
    protected void metodoProtected(){
        System.out.println("Metodo pretected");
    }
    
//protected: acceden les hijes y las clases del mismo paquete de la clase
//no vale para clases (no hay clases "protected")
//a los constructores se accede con super(), no se heredan
    
    public void metodoDefault(){
        System.out.println("Metodo Default");
    }
    
}
