// import { Gato } from './Clases.js';
//! Quokka free no banca imports

class Gato {
    _nombre = '';
    _tipo = '';
    _maullido = '';
    _grito = '';
    static _gusta = 'pescadito';
    constructor(nombre, tipo, maullido, grito) {
        this._nombre = nombre;
        this._tipo = tipo;
        this._maullido = maullido;
        this._grito = grito;
    }
    maullar() {
        console.log(this._maullido);
    }
    gritar() {
        console.log(this._grito);
    }
    get nombre(){
        return this._nombre;
    }
    set nombre(nombre){
        this._nombre = nombre;
    }
    get tipo(){
        return this._tipo;
    }
    set tipo(tipo){
        this._tipo = tipo;
    }
    get maullido(){
        return this._maullido;
    }
    set maullido(maullido){
        this._maullido = maullido;
    }
    get grito(){
        return this._grito;
    }
    set grito(grito){
        this._grito = grito;
    }
    static gusta(){
        return Gato._gusta;
    }
}

class Gatito extends Gato{

    constructor(nombre, tipo, maullido, grito, pequenies){
        super(nombre, tipo, maullido, grito);
        this._pequenies = pequenies;
    }
    get pequenies(){
        return this._pequenies;
    }
    set pequenies(peque){
        this._pequenies = peque;
    }

}

/*
? Podemos sobreescribir un metodo simplemente debemos declararlo de nuevo en la clase hija
# El concepto de polimorfismo tambien aplica conjugado con la herencia
* Static tambien se puede usar para atributos y metodos de las clases, se los llama desde las clases
* Podemos agregar atributos a objetos con 'obj'.'nuevoAtributo'
* o a clases con 'Class'.'nuevoAtributo'
! no podemos declarar un atributo static final como en Java, pero podemos simularlo usando un metodo
! "get 'nombreAtributo'(){retorno 'atributo';}" y no declarar un set, con lo que solo podemos leer el atributo
*/

let peludito = new Gatito('Peludito','gatito','mii','miiaa','extrema');

console.log(peludito.nombre);
console.log(peludito.pequenies);
console.log(peludito);

console.log(Gatito.gusta());
