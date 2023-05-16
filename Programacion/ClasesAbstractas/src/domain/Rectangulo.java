
package domain;

//la clase Rectangulo debe ser abstracta o implementar todos los metodos abstractos de la clase padre
public class Rectangulo extends FiguraGeometrica{
    
    public Rectangulo(String tipoFigura){
        super(tipoFigura);
    }
    
    @Override //Por mas que diga 'SobreEscribir', en realidad implementa, como lo indica la pequeña I
    public void dibujar(){
        System.out.println("Se imprime un: " + this.getClass().getSimpleName());
        //el metodo getClass() da la clase y el metodo getSimpleName() da el nombre de esta
    }
}
