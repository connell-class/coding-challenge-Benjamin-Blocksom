import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// Import Listview component Module
import { ListviewModule } from '@syncfusion/ej2-angular-lists';
import { AppComponent }  from './app.component';
import { AppRoutingModule } from './app-routing.module';



@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ListviewModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
