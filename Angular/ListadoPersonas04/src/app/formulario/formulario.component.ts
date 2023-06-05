import { Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';
import { Persona } from '../persona.model';
import { LoggingService } from '../LoggingService.service';
import { PersonaService } from '../Personas.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: [],
  providers: []
})
export class FormularioComponent {

//Clase que va a enviar el mensaje a la clase padre, va a propagar el objeto persona al
//componente padre
  //@Output() personaCreada = new EventEmitter<Persona>(); Vamos directamente al servicio
  //@ViewChild('nombreInput') nombreInput:ElementRef;
  //@ViewChild('apellidoInput') apellidoInput:ElementRef;
  nombreInput:string;
  apellidoInput:string;

  constructor(private loggingService:LoggingService,
              private personaService:PersonaService){
                this.personaService.saludar.subscribe((indice:number)=>alert("El indice es: "+indice));
              }

  agregarPersona(){
//creo la persona con los datos de input del html
    //let persona = new Persona(this.nombreInput.nativeElement.value,this.apellidoInput.nativeElement.value);
    let persona = new Persona(this.nombreInput,this.apellidoInput);
    this.loggingService.enviarMensajeAConsola("Enviando persona: "+ persona.nombre+" "+persona.apellido);
//uso el emiter para propagar la persona creada
    this.personaService.personaAgregada(persona);
  }

}
