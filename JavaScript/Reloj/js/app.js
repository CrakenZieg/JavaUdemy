const mostrarReloj = ()=>{
    let fecha = new Date();
    let hora = formatoHora(fecha.getHours());
    let minutos = formatoHora(fecha.getMinutes());
    let segundos = formatoHora(fecha.getSeconds());
    document.getElementById('hora').innerHTML = `${hora}:${minutos}:${segundos}`;

    const meses = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
    const dias = ['Lunes','Martes','Miércoles','Jueves','Viernes','Sábado','Domingo'];
    let diaS = dias[fecha.getDay()];
    let dia = fecha.getDate();
    let mes = meses[fecha.getMonth()];
    let fechaTexto = `${diaS}, ${dia} de ${mes}`;
    document.getElementById('fecha').innerHTML = fechaTexto;

//recuperamos los elementos de id contenedor y le asignamos la clase animar con un toggle intermedio
//el toggle evalua, si la clase esta la saca, si no esta la pone
    document.getElementById('contenedor').classList.toggle('animar');
}
setInterval(mostrarReloj, 1000);//llama cada segundo la funcion mostrarReloj()
const formatoHora = (tiempo) => {
    if(tiempo<10){
        tiempo = '0' + tiempo;        
    }
    return tiempo;
}