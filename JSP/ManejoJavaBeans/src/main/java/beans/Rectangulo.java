
package beans;

//Un JavaBean es una clase que tiene atributos privados, getter o setter (o ambos) por 
//cada atributo y un constructor vacio (puede tener más)
public class Rectangulo {
    private int base;
    private int altura;
    
//Como no agregamos constructor, el compilador agrega el constructor vacio 
//automaticamente, si agregamos un constructor con param debemos agregar el vacio
    
    public int getAltura(){
        return this.altura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    
    public int getBase(){
        return this.base;
    }
    public void setBase(int base){
        this.base = base;
    }
    
    public int getArea(){
        return this.base*this.altura;
    }
    
}
