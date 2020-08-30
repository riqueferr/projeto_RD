import { Component } from '@angular/core';
import { AppData } from './AppData';

@Component({
  selector: 'app-root',
  templateUrl:'./app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  data = new AppData('');

}

