import {Component, OnInit} from '@angular/core';
import { ApiService} from "./api.service";
import {Participant} from "./Models/participant";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'doodleApp';
  participant: Participant;

  constructor(private api: ApiService) {}

  ngOnInit(){
    this.api.getParticipant().subscribe(res => {
      this.participant = res;
      console.log(res);
    })

  }
}
