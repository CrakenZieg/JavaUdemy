//# las promesas funcionan como funciones asincronas
//? en este caso tenemos una promise 2 parametros que son callbacks, una para 'try' y otra para el catch

let promesa1 = new Promise((resolve, rejected)=>{
    let expresion = true;
    if(expresion){
        resolve('Expresion fue true');
    } else if(!expresion){
        rejected('Error');
    }
});

//* solo con then

promesa1.then(
    valor => console.log(valor),
    error => console.log(error)
);

//* con catch

promesa1
        .then(valor => console.log(valor))
        .catch(error => console.log(error));

let promesa2 = new Promise((resolve)=>{
    console.log("inicio promesa");
    setTimeout(()=>resolve('promesa con timeOut pa'), 4000);
    console.log("final promesa");
})

promesa2.then((valor)=>{console.log(valor)});

//! La palabra reservada async antes de un metodo obliga a este a devolver una promise

async function funcionAsync(){
    return 'retorno con funcion async';
}

funcionAsync().then(valor => console.log(valor));

//! la palabra reservada await obliga a esperar a una promesa
//? solo se puede usar await en una funcion async

//# funcion async con await

async function nuevaFuncion(){
    let promesa = new Promise(resolve =>{
        resolve('promesa con await');
    });

    console.log(await promesa);
}

nuevaFuncion();

//# funcion async con await y setTimeout

async function funcionPromesaAwaitTimeout(){
    console.log('inicio de funcionPromesaAwaitTimeout()');
    let promesa = new Promise(resolve=>{
        setTimeout(()=>resolve('promesa con await y timeout'), 6000);
    });
    console.log('inicio del await');
    console.log(await promesa);
    console.log('fin de funcionPromesaAwaitTimeout()');
}

funcionPromesaAwaitTimeout();