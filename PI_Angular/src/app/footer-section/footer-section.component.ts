import { Component, OnInit } from '@angular/core';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';


@Component({
  selector: 'footer-section',
  templateUrl: './footer-section.component.html',
  styleUrls: ['./footer-section.component.css']
})
export class FooterSectionComponent implements OnInit {
  miPortfolio:any;

  constructor(private datosPortfolio:PortfolioServiceService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
    this.miPortfolio=data;
    });
  }
}
