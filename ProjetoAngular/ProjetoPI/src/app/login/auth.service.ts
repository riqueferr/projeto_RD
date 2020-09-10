import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
// import { JwtService } from '@nestjs/jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // public usuarioAutenticado = false;

  mostrarMenuEmitter = new EventEmitter<boolean>();
  constructor(
    private http: HttpClient,
    // private jwtService: JwtService
    ) { }

  // tslint:disable-next-line: typedef
  async fazerLogin(user: any) {
    const result = await this.http.post<any>(`${environment.api}/login`, user).toPromise();
    if (result){
      window.localStorage.setItem('token', 'result.access_token');
      return true;
    }
    return false;
    // return new Promise((resolve) => {
    //   window.localStorage.setItem('token', 'meu-token');
    //   resolve(true);
    // });
    // // tslint:disable-next-line: triple-equals
    // if (usuario.nome == '166534' &&
    //   // tslint:disable-next-line: triple-equals
    //   usuario.senha == '123456') {

    //   this.usuarioAutenticado = true;
    //   this.mostrarMenuEmitter.emit(true);
    //   this.router.navigate(['/abastecimento-dashboard']);

    // } else {
    //   this.usuarioAutenticado = false;
    //   this.mostrarMenuEmitter.emit(false);
    // }
  }
  // async login(user: any) {
  //   const payload = { nrMatricula: user.nrMatricula, sub: user.idOperador };
  //   return {
  //     access_token: this.jwtService.sign(payload),
  //   };
  // }

  // tslint:disable-next-line: typedef
  // usuarioEstaAutenticado() {
  //   return this.usuarioAutenticado;
  // }
}
