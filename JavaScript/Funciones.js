/! TODOS LOS ARCHIVOS CREADOS ANTES SE PERDIERON POR RESTAURAR EL SISTEMA /

function sumaConcat(a,b){
//podemos llamar a la propiedad 'arguments' porque las funciones son objetos (solo podemos desde dentro de ellas)
    console.log(arguments.length);
    console.log(arguments[0]);
    console.log(arguments[1]);
    return a+b;
}

/* podemos definir argumentos por default asignandolos cuando indicamos los argumentos miFuncion(a=1, b="r"..),
   cuando pasemos parametros a la funcion estos se sobreescribiran, podemos pasar mas o menos que los que tiene
   la funcion definida, y ello puede o no afectar el comportamiento de la funcion. La cantidad de argumentos no
   necesariamente debe coincidir con la cantidad de parametros.
*/

console.log(typeof sumaConcat);

function cons(a){
    console.log(a);
}

cons(sumaConcat(2,5));
cons(sumaConcat("2","5"));

/*Funcion tipo expresion*/
let x = function (a,b){return a+b};
console.log(x(2,3));

/*Funcion flecha*/
const xFlecha = (a,b)=>a+b;
console.log(xFlecha(2,3));

/*Funcion tipo Self Invoking */
(function(){
    console.log("Ejecutando la funcion");
})();//se ejecuta sola una sola vez

(function(a,b){
    console.log(a+b);
})(1,2);//se le pueden pasar argumentos

//Como son objetos podemos llamar sobre funciones .toString()
let nombre = sumaConcat.toString();
console.log(nombre);

function sumaDeSucesion(){
    let suma = 0;
    for(let i = 0; i<arguments.length; i++){
        suma+=arguments[i];
    }
    return suma;
}

console.log(sumaDeSucesion(1,3,5,7,9));

/*Los tipos primitivos pasan por valor, los obj pasan por referencia*/

const gato = {
    nombre: 'peludo',
    tipo: 'gato',
    maullido: 10
}

function modNombre(a){
    a.nombre = a.nombre+"Mau";
}

console.log(gato);
modNombre(gato);
modNombre(gato);
console.log(gato);