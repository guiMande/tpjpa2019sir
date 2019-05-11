import {Component, OnInit} from '@angular/core';
import { ApiService} from "./api.service";
import {Participant} from "./Models/participant";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'doodleApp'

  constructor(private api: ApiService) {}

  ngOnInit(){
  }
}
