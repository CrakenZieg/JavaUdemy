
package domain;

public class Persona {
//existen bloques de inicializacion estaticos y no estaticos
//ambos se ejecutan antes que el constructor de la clase
    private final int idPersona;
    private static int contadorPersonas;
//este bloque se ejecuta antes que cualquier bloque no static y/o constructor        
//se ejecuta en el momento que la clase se carga en memoria
//sirve para inicializar variables static    
    static{
        System.out.println("Ejecucion en bloque estatico");
        ++Persona.contadorPersonas;
    }
//este es un bloque no estatico, se ejecuta antes del constructor de la clase
//ahora tenemos acceso al operador this. y tambien a las variables no estaticas 
//se ejecuta en cada inicializacion    
    {
        System.out.println("Ejecucion bloque NO estatico");
        this.idPersona = Persona.contadorPersonas++;
        
    }
//para el momento en que se ejecuta el constructor ya se ejecutaron los bloques estaticos    
    public Persona(){
        System.out.println("Ejecucion del constructor");
    }

    public int getIdPersona() {
        return this.idPersona;
    }
    public static int getContadorPersonas() {
        return Persona.contadorPersonas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("idPersona=").append(idPersona);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
