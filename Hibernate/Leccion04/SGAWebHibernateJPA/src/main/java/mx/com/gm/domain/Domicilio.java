
package mx.com.gm.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Domicilio implements Serializable {
    
    public static final long serialVerionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//aclaramos que la DDBB es la que asigna este campo
    @Column(name="id_domicilio")
    private Integer idDomicilio;//usamos el objeto para comprobar contra null, no contra 0 xej
    
    private String calle;
    
    @Column(name="num_calle")
    private String numCalle;
    
    private String barrio;

    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }
    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumCalle() {
        return numCalle;
    }
    public void setNumCalle(String numCalle) {
        this.numCalle = numCalle;
    }

    public String getBarrio() {
        return barrio;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", numCalle=" + numCalle + ", barrio=" + barrio + '}';
    }

//como estos obj pueden ser parte de colecciones incluimos tambien, como buena pratica,
//estos 2 metodos mas    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.idDomicilio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domicilio other = (Domicilio) obj;
        return Objects.equals(this.idDomicilio, other.idDomicilio);
    }
    
}
