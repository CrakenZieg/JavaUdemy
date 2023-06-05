import { Injectable, EventEmitter } from '@angular/core';
import { LoggingService } from './LoggingService.service';
import { Persona } from './persona.model';

//el decorador Injectable se asegura que el compilador genere la metadata necesaria para poder crear las
//dependencias necesarias para que esta clase sea inyectada
@Injectable()
export class PersonaService{

  personas:Persona[]=[
    new Persona('Carlos','Saul'),
    new Persona('Saul','Goodman'),
    new Persona('Goodman','Perez')
  ];

  saludar = new EventEmitter<number>();

  constructor(private loggingService:LoggingService){}

  personaAgregada(persona:Persona){
    this.loggingService.enviarMensajeAConsola("Persona agregada al arreglo: "+ persona.nombre+" "+persona.apellido);
    this.personas.push(persona);
  }

}
