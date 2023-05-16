
package beans.model;

public class Provincia {
    private int provinciaId;
    private String nombreProvincia;
    private int codigoPostal;
    
    public Provincia() {
    }

    public Provincia(int provinciaId, String nombreProvincia, int codigoPostal) {
        this.provinciaId = provinciaId;
        this.nombreProvincia = nombreProvincia;
        this.codigoPostal = codigoPostal;
    }

    public int getProvinciaId() {
        return provinciaId;
    }
    public void setProvinciaId(int provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }
    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
    
}
