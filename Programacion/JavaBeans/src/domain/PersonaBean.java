
package domain;

import java.io.Serializable;
//un JavaBean es una clase que permite trabajar con otras tecnologias Java
//Implementa Serializable, todos sus atributos son privados, constructor vacio
//Es requerido tener los getter y setter de cada atributo privado
//Serializable: permite al servidor Java convertir determinado objeto en bits para
//transferirlo entre diferentes tecnologias, entre diferentes computadoras incluso
public class PersonaBean implements Serializable{
    
    private String nombre;
    private String apellido;
    
    public PersonaBean(){}
//se pueden tener mas contructores, por ejemplo:
    public PersonaBean(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido  = apellido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
//podemos tambien implementar toString, equals y hashCode

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonaBean{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append('}');
        return sb.toString();
    }
    
    
}
