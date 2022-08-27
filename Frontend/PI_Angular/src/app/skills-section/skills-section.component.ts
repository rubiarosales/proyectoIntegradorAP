import { Component, OnInit } from '@angular/core';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';


@Component({
  selector: 'skills-section',
  templateUrl: './skills-section.component.html',
  styleUrls: ['./skills-section.component.css']
})
export class SkillsSectionComponent implements OnInit {
  skillList:any;

  constructor(private datosPortfolio:PortfolioServiceService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
    this.skillList=data.skills;
    });
  }
}
