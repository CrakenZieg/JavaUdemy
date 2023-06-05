import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FormularioComponent } from './formulario/formulario.component';
import { TablasComponent } from './tablas/tablas.component';
import { PresupuestoService } from './presupuesto-service.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FormularioComponent,
    TablasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [PresupuestoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
