import { Component, OnInit } from '@angular/core';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';


@Component({
  selector: 'banner-container',
  templateUrl: './banner-container.component.html',
  styleUrls: ['./banner-container.component.css']
})
export class BannerContainer implements OnInit {

 bannerList:any;

  constructor(private datosPortfolio:PortfolioServiceService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
    this.bannerList=data.imgBanner;
    });
  }
}
