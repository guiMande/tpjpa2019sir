import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListParticipantComponent } from './Participant/list-participant/list-participant.component';
import {HttpClientModule} from "@angular/common/http";
import {ApiService} from "./api.service";

@NgModule({
  declarations: [
    AppComponent,
    ListParticipantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
