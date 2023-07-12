import {Producto} from './Producto.js';

class Orden {

    _idOrden;
    _productos = [Producto];
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
            console.log("Orden con productos maximos");
        }
    }

    calcularTotal(){
        return this._productos.reduce((a,b)=>{a+this._productos[b].precio},0);
    }

    toString(){
        let retorno = "Id: "+this._idOrden+", productos: "+this._contadorProductosAgregados+
        (this._contadorProductosAgregados!=0)?" -> ":"";
        for(producto in _productos){
            retorno = retorno + producto.toString();
        }
        return retorno;
    }
}