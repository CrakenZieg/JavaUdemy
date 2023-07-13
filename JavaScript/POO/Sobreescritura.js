class Empleado{
    constructor(nombre, sueldo){
        this._nombre = nombre;
        this._sueldo = sueldo;
    }

    get nombre(){
        return this._nombre;
    }
    get sueldo(){
        return this._sueldo;
    }
    set nombre(nombre){
        this._nombre = nombre;
    }
    set sueldo(sueldo){
        this._sueldo = sueldo;
    }

    obtenerDetalles(){
        return `Empleado: nombre: ${this._nombre}, sueldo: ${this._sueldo}`;
    }
}

class Gerente extends Empleado{
    constructor(nombre,sueldo,departamento){
        super(nombre, sueldo);
        this._departamento = departamento;
    }
    get departamento(){
        return this._departamento;
    }
    set departamento(departamento){
        this._departamento = departamento;
    }

    obtenerDetalles(){
        return `${super.obtenerDetalles()}, gerente del departamento ${this._departamento}`;
    }
}

function imprimir(a){
    console.log(a.obtenerDetalles());
}

let gatito = new Empleado("peludito", 100);
imprimir(gatito);

let gato = new Gerente("peludo", 100, "siesta");
imprimir(gato);

