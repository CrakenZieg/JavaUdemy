import { Injectable } from '@angular/core';
import { LoggingService } from './LoggingService.service';
import { Persona } from './persona.model';

@Injectable()
export class PersonaService{

  personas:Persona[]=[
    new Persona('Carlos','Saul'),
    new Persona('Saul','Goodman'),
    new Persona('Goodman','Perez')
  ];

  constructor(private loggingService:LoggingService){}

  personaAgregada(persona:Persona){
    this.loggingService.enviarMensajeAConsola("Persona agregada al arreglo: "+ persona.nombre+" "+persona.apellido);
    this.personas.push(persona);
  }

}
