
package enumeracion;

public enum Continentes {
    
    AFRICA(53),
    EUROPA(46),
    ASIA(44),
    AMERICA(34),
    OCEANIA(14);
//declaro atributos de cada elemento de la enumeracion
    private final int paises;
//declaro un constructor para los elementos de la enumeracion
    Continentes(int paises){
        this.paises = paises;
    }
    public int getPaises(){
        return this.paises;
    }
    
}
