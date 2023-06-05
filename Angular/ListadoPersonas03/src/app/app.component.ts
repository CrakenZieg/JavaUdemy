import { Component, OnInit } from '@angular/core';
import { Persona } from './persona.model';
import { LoggingService } from './LoggingService.service';
import { PersonaService } from './Personas.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'Listado de Personas';

  personas:Persona[];

  constructor(private loggingService:LoggingService,
              private personaService:PersonaService){}
//Este metodo funciona después del constructor, por lo que una vez inyectadas las dependencias
//podemos usarlas
  ngOnInit(): void {
    this.personas=this.personaService.personas;
  }

  personaAgregada(persona:Persona){
    this.loggingService.enviarMensajeAConsola("Persona enviada al servicio: "+ persona.nombre+" "+persona.apellido);
    this.personaService.personaAgregada(persona);
  }

}
