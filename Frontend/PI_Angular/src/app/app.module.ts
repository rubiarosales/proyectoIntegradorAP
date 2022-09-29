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
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { RegistrarComponent } from './auth/registrar/registrar.component';
import { RecuperarComponent } from './recuperar/recuperar.component';
import { LoginBarComponent } from './login-bar/login-bar.component';
import { interceptorProvider } from './interceptors/persona-interceptor.service';
import { RedesSocialesComponent } from './redes-sociales/redes-sociales.component';
import { NuevaExpComponent } from './nueva-exp/nueva-exp.component';
import { EditarExpComponent } from './editar-exp/editar-experiencia.component';
import { NuevaEduComponent } from './nueva-edu/nueva-edu.component';
import { EditarEduComponent } from './editar-edu/editar-edu.component';
import { NuevaSkillComponent } from './skills-section/nueva-skill/nueva-skill.component';
import { EditarSkillComponent } from './skills-section/editar-skill/editar-skill.component';
import { NuevoProyectoComponent } from './proyect-section/nuevo-proyecto/nuevo-proyecto.component';
import { EditarProyectoComponent } from './proyect-section/editar-proyecto/editar-proyecto.component';


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
    FooterSectionComponent,
    HomeComponent,
    LoginComponent,
    RegistrarComponent,
    RecuperarComponent,
    LoginBarComponent,
    RedesSocialesComponent,
    NuevaExpComponent,
    EditarExpComponent,
    NuevaEduComponent,
    EditarEduComponent,
    NuevaSkillComponent,
    EditarSkillComponent,
    NuevoProyectoComponent,
    EditarProyectoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [PortfolioServiceService,CargarScriptService, interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
