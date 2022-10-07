import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/servicios/auth-service.service';
import { TokenService } from 'src/app/servicios/token.service';
import { LoginUsuario } from '../../model/login-usuario';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLogged=false;
  isLogginFail=false;
  loginUsuario!:LoginUsuario;
  nombreUsuario!: string;
  password!:string;
  roles:string[]=[];
  errMsj!:string;


  constructor(private router: Router, private tokenService: TokenService, private authService: AuthServiceService) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()){
      this.isLogged = true;
      this.isLogginFail = false;
      
    }
  }



  onLogin(): void{
    this.loginUsuario = new LoginUsuario(this.nombreUsuario,this.password);
    this.authService.login(this.loginUsuario).subscribe({
      next: (data) => {
      this.isLogged=true;
      this.isLogginFail=false;
      this.tokenService.setToken(data.token);
    
      this.roles=data.authorities;
      this.router.navigate(['']);
    },
    
    error: (err) => {
    this.isLogged=false;
    this.isLogginFail= true;
    this.errMsj=err.error.mensaje;
    console.log(this.errMsj);
  }
});


  }



}
