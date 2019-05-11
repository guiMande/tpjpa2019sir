import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { ApiService } from "./api.service";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from "./material.module";
import { ParticipantsComponent } from './participants/participants.component';
import { AppRouters } from "./app.routes";
import { SondageComponent } from './sondage/sondage.component';
import { SondagesComponent } from './sondages/sondages.component';
import { ParticipantCreateComponent } from './participants/participant-create/participant-create.component';
import { MatButtonModule, MatCardModule, MatFormFieldModule, MatInputModule} from '@angular/material';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    ParticipantsComponent,
    SondageComponent,
    SondagesComponent,
    ParticipantCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRouters,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    FormsModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
