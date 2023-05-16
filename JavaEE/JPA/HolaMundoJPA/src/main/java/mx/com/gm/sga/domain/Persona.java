
package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.*;

//Entity lo convierte en entidad, lo que nos permite mediante el API de JPA trabajar
//con la DDBB directamente. 
@Entity
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;

//declaramos esta variable como la primary key de la tabla
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_persona")
    private int idPersona;
    
    private String nombre;
    
    private String apellido;
    
    private String email;
    
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String mail, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = mail;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public String getMail() {
        return email;
    }
    public void setMail(String mail) {
        this.email = mail;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + email + ", telefono=" + telefono + '}';
    }
    
}
