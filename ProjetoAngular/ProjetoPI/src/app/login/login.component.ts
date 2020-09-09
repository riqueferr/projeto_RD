import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // public usuario: Usuario = new Usuario();
  login = {
    nrMatricula: null,
    pwOperador: ''
  };

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  async onSubmit() {
    try {
      const result = await this.authService.fazerLogin(this.login);
      console.log(`Login efetuado: ${result}`);

      // navego para a rota vazia novamente
      this.router.navigate(['/abastecimento-dashboard']);
    } catch (error) {
      console.error(error);
    }
    // fazerLogin() {
    //   console.log(this.usuario);
    //   this.authService.fazerLogin(this.usuario);
  }

  // setUsuario(usuario: string) {
  //   this.usuario.nome = usuario;
  // }
}
