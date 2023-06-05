import { Component, Input, OnInit } from '@angular/core';
import { Registro } from '../registro.model';
import { PresupuestoService } from '../presupuesto-service.service';

@Component({
  selector: 'app-tablas',
  templateUrl: './tablas.component.html',
  styleUrls: []
})
export class TablasComponent implements OnInit{

  @Input() ingresos:Registro[];
  @Input() egresos:Registro[];
  ingreso:number;

  constructor(private presupuestoService:PresupuestoService){
    this.ingreso=this.presupuestoService.ingreso;
  }

  ngOnInit(): void {
    this.presupuestoService.ingresoSub.subscribe((prep)=>{this.ingreso=prep||0});
    this.ingresos=this.presupuestoService.ingresos;
    this.egresos=this.presupuestoService.egresos;
  }

  eliminar(registro:Registro){
    this.presupuestoService.eliminar(registro);
  }

  porcentaje(registro:Registro):number{
    return (registro.valor / this.ingreso) * 100;
  }
}
