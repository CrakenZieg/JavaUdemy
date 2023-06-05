import { Component, Input, OnInit } from '@angular/core';
import { PresupuestoService } from '../presupuesto-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: []
})
export class HeaderComponent implements OnInit {

  presupuesto:number;
  ingresos:number;
  egresos:number;

  constructor(private presupuestoService:PresupuestoService){
    this.ingresos = this.presupuestoService.ingreso;
    this.egresos = this.presupuestoService.egreso;
    this.presupuesto=this.ingresos-this.egresos;

  }

  ngOnInit(): void {
    this.presupuestoService.presupuestoSub.subscribe((prep)=>{this.presupuesto=prep||0});
    this.presupuestoService.ingresoSub.subscribe((prep)=>{this.ingresos=prep||0});
    this.presupuestoService.egresoSub.subscribe((prep)=>{this.egresos=prep||0});
  }



}
