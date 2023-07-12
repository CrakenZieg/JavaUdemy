/*Los objetos tienen metodos y propiedades*/

//! declaracion clasica
let peludo = {
    nombre: 'peludo',
    tipo: 'gato',
    maullido: 10,
    maullar() {
        console.log('MAUUU');
    },
    get nombreBicho(){
        return this.nombre;
    },
    set setNombre(nombre){
        this.nombre = nombre;
    } 
}
//# podemos acceder a los atributos usando . y [], podemos declarar funciones usando get y set 
console.log(peludo.nombre);
//# cuando usamos un get no necesitamos usar () para aclarar que es una funcion 
console.log(peludo.nombreBicho);
//# cuando usamos un set no necesitamos pasar el parametro, lo asignamos
peludo.setNombre = "nuevoPeludo";
console.log(peludo.nombre);

console.log(peludo['tipo']);
for(atrib in peludo){
    console.log(atrib);
    console.log(peludo[atrib]);
}
peludo.maullar();
peludo.maullar();

//! como nuevo objeto
let peludo2 = new Object();
peludo2.nombre = 'peludo2';
peludo2.tipo = 'gato';
peludo2.maullido = 15;
peludo2.maullar = () => {
    console.log('MAUUU');
};
peludo2.maullar();

//*Igual que arriba, podemos agregar atributos a un objeto simplemente declarandolos ('objeto'.'propiedad' =  'valor')
//*Para borrar una propiedad debemos usar "delete 'objeto'.'propiedad'"
//#Para imprimir un obj en cualquier navegador podemos concatenar sus propiedades, iterar usando for(), 
//#usando Object.values('objeto') (que devuelve un arreglo) o usar JSON.stringify('objeto') (que devuelce un string) 

/* 
? Con las maneras anteriores los objetos se crean 'unicos' y no podemos reutilizarlos sin declarar todo de nuevo
? Para poder reutilizar codigo podemos crear objetos utilizando funciones constructoras
*/
//! Funcion constructora
function Peludo(nombre, tipo, maullido){
    this.nombre = nombre;
    this.tipo = tipo;
    this.maullido = maullido;
    this.maullar = function (){
        console.log('MAUUU');
    }
    this.setNombre = function (nombre){
        this.nombre = nombre;
    }
    this.nombreBicho = function (){
        return this.nombre;
    }
}

let pepeludo = new Peludo("gato", "felino", 50);
pepeludo.maullar(); 
console.log(pepeludo.nombreBicho());

//*Podemos crear objetos usando:
let obj1 = new Object();
let obj2 = {};

let string1 = new String('Pepe');
let string2 = 'Pepe';

let num1 = new Number(7);
let num2 = 7;

let bool1 = new Boolean(true);
let bool2 = true;

let arr1 = new Array();
let arr2 = [];

let func1 = new Function();
let func2 = function(){};

//# Con Prototype podemos agregar propiedades a objetos ya creados utilizando un constructor
//# es decir, creamos 2 instancias de un obj con el constructor, luego agregamos la propiedad a ambos 
Peludo.prototype.peludes = "mucha";
console.log(pepeludo.peludes);

let per1 = {
    nombre: 'pepe',
    apellido: 'sasa',
    nombreCompleto: function(){
        return this.nombre+' '+this.apellido;
    }
}

let per2 = {
    nombre: 'papa',
    apellido: ' sese',
    sarasa: function(algo){
        return this.nombre + ': ' +algo;
    }
}

//! usamos el metodo call para utilizar el metodo de per1 sobre per2
console.log(per1.nombreCompleto());
console.log(per1.nombreCompleto.call(per2));
//! a call podemos pasar los argumentos necesarios dandolos como argumentos despues del obj
console.log(per2.sarasa.call(per1,'argumento'));

//! cons apply podemos lograr lo mismo
console.log(per1.nombreCompleto.apply(per2));
//! pero los parametros se pasan mediante un arreglo
let arreglo = ['argumento2'];
console.log(per2.sarasa.apply(per1,arreglo));