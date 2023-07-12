//! declaracion de clase
//# se acostumbra usar _atributo par nombrar atributos 
//# y el nombre del atributo para el get y set
class Gato {
    _nombre = '';
    _tipo = '';
    _maullido = '';
    _grito = '';
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
}

let mau = new Gato('Mau', 'gato', 'mauu', 'MAUU');

mau.maullar();
mau.gritar();
console.log(mau.nombre);

let peludo = new Gato('gato', 'gato', 'miii');
peludo.maullar();
peludo.gritar();

//* El hoisting no funciona con la definicion de clases, no se pueden instanciar
//* objetos y despues declara la clase como con los metodos y variables.