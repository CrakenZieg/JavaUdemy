
package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="persona")//si no reconociera el nombre de la tabla porque la clase está con P y la tabla con p
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L; 
    
//anotamos la notacion column porque es diferente el nombre del atributo y el de la columna
    @Column(name="id_persona")
    @Id
    private int idPersona;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Persona() {
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
}
