//!import { Orden } from "./Orden.js";
//!import { Producto } from "./Producto.js";

class Producto {
    
    _idProducto;
    _nombre;
    _precio;
    static contadorProductos = 0;

    constructor(nombre, precio){
        this._idProducto = ++Producto.contadorProductos;
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

class Orden {

    _idOrden;
    _productos = [];
    _contadorProductosAgregados = 0;
    static contadorOrdenes = 0

    constructor(){
        this._idOrden = ++Orden.contadorOrdenes;
    }

    get MAX_PRODUCTOS(){
        return 5;
    }

    agregarProducto(producto){
        if(this._contadorProductosAgregados<this.MAX_PRODUCTOS){
            this._contadorProductosAgregados++;
            this._productos.push(producto);
        } else {
            console.log("Orden con productos maximos, no se puede ingresar "+producto.toString());
        }
    }

    calcularTotal(){
        return this._productos.reduce((a,b)=>a+b._precio,0);
    }

    toString(){
        let retorno = "Orden id: "+this._idOrden+", productos: "+this._contadorProductosAgregados+
        ((this._contadorProductosAgregados!=0)?", total: $"+this.calcularTotal()+" -> ":"");
        this._productos.forEach((producto)=>retorno = retorno +"\n"+ producto.toString()+"; ");         
        return retorno;
    }
}

let producto1 = new Producto("Papa",100);
console.log(producto1.toString());
let producto2 = new Producto("Zapallo",150);
console.log(producto2.toString());
let producto3 = new Producto("Zapallito",200);
console.log(producto3.toString());
let producto4 = new Producto("Zanahoria",250);
console.log(producto4.toString());
let producto5 = new Producto("Cebolla",300);
console.log(producto5.toString());
let producto6 = new Producto("Tomate",350);
console.log(producto6.toString());

let orden1 = new Orden();

orden1.agregarProducto(producto1);
orden1.agregarProducto(producto2);
orden1.agregarProducto(producto3);
orden1.agregarProducto(producto4);
orden1.agregarProducto(producto5);

console.log(orden1._contadorProductosAgregados);

orden1.agregarProducto(producto6);

console.log(orden1._contadorProductosAgregados);

console.log(orden1.calcularTotal());

console.log(orden1.toString());