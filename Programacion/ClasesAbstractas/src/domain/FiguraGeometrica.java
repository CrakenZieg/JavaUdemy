
package domain;

//una clase abstracta es tal que no se va a implementar, y sera padre de otras clases
//abstractas o que si se implementen
public abstract class FiguraGeometrica {
    
    protected String tipoFigura;
    
    protected FiguraGeometrica(String tipoFigura){
        this.tipoFigura = tipoFigura;
    }
//si en una clase hay metodos abstractos necesariamente la clase debe ser abstracta    
    public abstract void dibujar();
//las clases que hereden de esta clase deberan implementar necesariamente los metodos 
//abstractos de esta clase
    public String getTipoFigura() {
        return tipoFigura;
    }
    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FiguraGeometrica{");
        sb.append("tipoFigura=").append(tipoFigura);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
