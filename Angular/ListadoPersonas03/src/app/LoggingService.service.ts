export class LoggingService{

  enviarMensajeAConsola(mensaje:string){
    console.log(mensaje);
  }

}
/*
un servicio no solo debe declararse en el constructor de un componente si no que
tambien debe incluirse entre sus provedores, si queremos tener solo una instancia
de un servicio debemos declararlo solo en los provedores del app.module
*/
