import { Injectable } from '@angular/core';
import { Registro } from './registro.model';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PresupuestoService {


  ingresos:Registro[]=[new Registro("ingreso","particular",2000),new Registro("ingreso","particular",2000),new Registro("ingreso","particular",2000)];
  egresos:Registro[]=[new Registro("egreso","verdura",2500),new Registro("egreso","fruta",1500)];
  ingreso:number=this.ingresos.reduce(function(acc,reg){return acc+reg.valor},0);
  egreso:number=this.egresos.reduce(function(acc,reg){return acc+reg.valor},0);
  ingresoSub:Subject<number> = new Subject<number>();
  egresoSub:Subject<number> = new Subject<number>();
  presupuestoSub:Subject<number> = new Subject<number>();

  constructor() {
  }

  agregarRegistro(registro:Registro){
    if(registro.tipo=="ingreso"){
      this.ingresos.push(registro);
      if(this.ingresos.length!=0){
        this.ingreso=this.ingresos.reduce(function(acc,reg){return acc+reg.valor},0);
        this.ingresoSub.next(this.ingreso);
      }
    } else {
      this.egresos.push(registro);
      if(this.egresos.length!=0){
        this.egreso=this.egresos.reduce(function(acc,reg){return acc+reg.valor},0);
        this.egresoSub.next(this.egreso);
      }
    }
    this.presupuestoSub.next(this.ingreso-this.egreso);
  }

  eliminar(registro:Registro){
    if(registro.tipo=="ingreso"){
      this.ingresos.splice(this.ingresos.findIndex((reg)=>{return registro==reg}),1);
      if(this.ingresos.length!=0){
        this.ingreso=this.ingresos.reduce(function(acc,reg){return acc+reg.valor},0);
      } else {
        this.ingreso=0;
      }
      this.ingresoSub.next(this.ingreso);
    } else {
      this.egresos.splice(this.egresos.findIndex((reg)=>{return registro==reg}),1);
      if(this.egresos.length!=0){
        this.egreso=this.egresos.reduce(function(acc,reg){return acc+reg.valor},0);
      } else {
        this.egreso=0;
      }
      this.egresoSub.next(this.egreso);
    }
    this.presupuestoSub.next(this.ingreso-this.egreso);
  }

}
