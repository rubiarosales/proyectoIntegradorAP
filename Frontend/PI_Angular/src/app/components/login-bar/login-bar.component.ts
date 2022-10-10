import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PortfolioServiceService } from '../../servicios/portfolio.service';
import { TokenService } from '../../servicios/token.service';

@Component({
  selector: 'app-login-bar',
  templateUrl: './login-bar.component.html',
  styleUrls: ['./login-bar.component.css']
})
export class LoginBarComponent implements OnInit {

  isLogged=false;

  constructor(private datosPortfolio:PortfolioServiceService, private router:Router, private tokenService: TokenService) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged=true;
    } else{
      this.isLogged=false;
    }
  }

  onLogOut():void{
    this.tokenService.logOut();
    window.location.reload();
  }

  login(){
    this.router.navigate(['/login']);
  }
}
