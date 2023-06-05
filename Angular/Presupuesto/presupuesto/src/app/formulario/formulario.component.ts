import { Component, EventEmitter } from '@angular/core';
import { PresupuestoService } from '../presupuesto-service.service';
import { Registro } from '../registro.model';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: []
})
export class FormularioComponent {

  tipo:string;
  descripcion:string;
  valor:number;

  constructor(private presupuestoService:PresupuestoService){}

  agregarRegistro(){
    console.log(this.tipo,this.descripcion,this.valor)
    this.presupuestoService.agregarRegistro(new Registro(this.tipo,this.descripcion,this.valor))
  }

}
