//!Llamadas asincronas con el uso de setTimeout

function imprimir2(){
    console.log("imprimiendo!");
}

setTimeout(imprimir2, 3000); //# se imprime 3 segundos despues

setTimeout(function(){console.log("5segundos")},5000);

setTimeout(()=>{console.log("4segundos")},4000);

let reloj = () => {
    let fecha = new Date();
    console.log(`${fecha.getHours()}:${fecha.getMinutes()}:${fecha.getSeconds()}hs`);
}

//? setInterval(reloj,1000);