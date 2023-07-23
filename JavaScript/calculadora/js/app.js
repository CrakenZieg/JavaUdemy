let resultado;
function sumar(){
    const formu = document.getElementById('forma');
    let a = formu['numA'];
    let b = formu['numB'];
    resultado = parseInt(a.value) + parseInt(b.value);
    if(isNaN(resultado)){
        resultado = 'Faltan ingresar datos';
    }
    document.getElementById('resultado').innerHTML=`Resultado: ${resultado}`;
}
function restar(){
    const formu = document.getElementById('forma');
    let a = formu['numA'];
    let b = formu['numB'];
    resultado = parseInt(a.value) - parseInt(b.value);
    if(isNaN(resultado)){
        resultado = 'Faltan ingresar datos';
    }
    document.getElementById('resultado').innerHTML=`Resultado: ${resultado}`;
}
function multiplicar(){
    const formu = document.getElementById('forma');
    let a = formu['numA'];
    let b = formu['numB'];
    resultado = parseInt(a.value) * parseInt(b.value);
    if(isNaN(resultado)){
        resultado = 'Faltan ingresar datos';
    }
    document.getElementById('resultado').innerHTML=`Resultado: ${resultado}`;
}
function dividir(){
    const formu = document.getElementById('forma');
    let a = formu['numA'];
    let b = formu['numB'];
    resultado = parseInt(a.value) / parseInt(b.value);
    if(isNaN(resultado)){
        resultado = 'Faltan ingresar datos';
    }
    document.getElementById('resultado').innerHTML=`Resultado: ${resultado}`;
}