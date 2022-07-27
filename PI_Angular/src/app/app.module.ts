import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { headerSection } from './header-section/header-section';
import { BannerContainer } from './banner-container/banner-container.component';
import { AcercaDeSectionComponent } from './acerca-de-section/acerca-de-section.component';
import { ExperienceSectionComponent } from './experience-section/experience-section.component';
import { EducationSectionComponent } from './education-section/education-section.component';
import { SkillsSectionComponent } from './skills-section/skills-section.component';
import { ProyectSectionComponent } from './proyect-section/proyect-section.component';
import { FooterSectionComponent } from './footer-section/footer-section.component'
import { PortfolioServiceService } from './servicios/portfolio-service.service';
import { HttpClientModule } from '@angular/common/http';
import { CargarScriptService } from './servicios/cargar-script.service';

@NgModule({
  declarations: [
    AppComponent,
    headerSection,
    BannerContainer,
    AcercaDeSectionComponent,
    ExperienceSectionComponent,
    EducationSectionComponent,
    SkillsSectionComponent,
    ProyectSectionComponent,
    FooterSectionComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [PortfolioServiceService, CargarScriptService],
  bootstrap: [AppComponent]
})
export class AppModule { }
