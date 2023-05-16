
package test;

public class TestAutoBoxingUnBoxing {
    
    public static void main(String[] args) {
/*todas las primitivas tienen clases envolventes 

int -- Integer        
long -- Long
float -- Float
double -- Double
boolean -- Boolean
byte -- Byte
char -- Character
short -- Short

La ventaja sobre los tipos primitivos es 
que las clases tienen atributos y metodos
Se recomienda si queres usar solo objetos
(mas facil hacer conversiones por ejemplo)
no recomendado si usanmos esos tipos para 
hacer muchos calculos        
*/

    int enteroInt = 10;
    Integer enteroEnv = 10;//Autoboxing (meter la variable en un objeto)
    System.out.println("enteroInt = " + enteroInt);
    System.out.println("enteroEnv = " + enteroEnv);
    System.out.println("enteroEnv.toString(): " + enteroEnv.toString());
//por la clase envolvente puedo acceder a metodos de esa clase    
    System.out.println("enteroEnv.doubleValue() = " + enteroEnv.doubleValue());

//tambien puedo hacer Unboxing para recuperar el tipo primitivo del objeto
    int enteroEnvUnboxed = enteroEnv;
    
    System.out.println("enteroEnvUnboxed = " + enteroEnvUnboxed);

    }
    
}
