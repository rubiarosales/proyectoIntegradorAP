import { Component, OnInit } from '@angular/core';
import { PortfolioServiceService } from '../../servicios/portfolio.service';
import { TokenService } from '../../servicios/token.service';


@Component({
  selector: 'banner-container',
  templateUrl: './banner-container.component.html',
  styleUrls: ['./banner-container.component.css']
})
export class BannerContainer implements OnInit {
  isLogged= false;
  
 bannerList:any;

  constructor(private datosPortfolio:PortfolioServiceService, private tokenService:TokenService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
    this.bannerList=data.imgBanner;
    });

    if (this.tokenService.getToken()){
     
      this.isLogged=true;
    }else{
      this.isLogged=false;
    }
  }
}
