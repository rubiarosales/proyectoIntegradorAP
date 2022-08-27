import { Component, OnInit } from '@angular/core';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';

@Component({
  selector: 'education-section',
  templateUrl: './education-section.component.html',
  styleUrls: ['./education-section.component.css']
})
export class EducationSectionComponent implements OnInit {

  educationList:any;

  constructor(private datosPortfolio:PortfolioServiceService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
    this.educationList=data.education;
    });
  }
}