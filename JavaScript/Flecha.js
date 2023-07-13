//! Funcion flecha

function funcion(){
    console.log("corre funcion");
}

funcion();

let f1 = () => {
    console.log("corre funcion flecha1");
}

f1();

//# cuando usamos let o const no se aplica el hoisting

let f2 = () => console.log("corre funcion flecha2");

f2();

const devolverObj = () => ({nombre:'Gato', mau:'Mau'});

console.log(devolverObj());

const conParamClasico = function(data){console.log(data)};
const conParamFlecha = (data) => console.log(data);

conParamClasico('data');
conParamFlecha('data');

const sumaGrande = (a1,a2)=>{
    let resultado = `Resultado: ${a1+a2}`;
    return resultado;
}
const sumaChica = (a1,a2)=> `Resultado: ${a1+a2}`;

console.log(sumaGrande(1,2));
console.log(sumaChica(1,2));

