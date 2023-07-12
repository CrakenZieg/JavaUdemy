class Producto {
    
    _idProducto;
    _nombre;
    _precio;
    static contadorProductos = 0;

    constructor(nombre, precio){
        this._idProducto = ++contadorProductos;
        this._nombre = nombre;
        this._precio = precio;        
    }

    get idProducto(){
        return this._idProducto;
    }
    get nombre(){
        return this._nombre;
    }
    get precio(){
        return this._precio;
    }
    set nombre(nombre){
        this._nombre = nombre;
    }
    set precio(precio){
        this._precio = precio;
    }

    toString(){
        return "Id: "+this._idProducto+", nombre: "+this._nombre+", $"+this._precio;
    }
}
