import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsuario } from '../model/login-usuario';

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
  password!: string;
  roles!:string[];
  errMsj!:string;


  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  entrar(){
    this.router.navigate(['']);
  }

}
