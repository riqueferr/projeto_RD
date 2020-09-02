import { Component } from '@angular/core';
import { AppData } from './AppData';
import { AuthService } from './login/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  data = new AppData('');

  mostrarMenu = false;

  constructor(private authService: AuthService) {

  }
  ngOnInit() {
    this.authService.mostrarMenuEmitter.subscribe(
      mostrar => this.mostrarMenu = mostrar
  );
  }

}

