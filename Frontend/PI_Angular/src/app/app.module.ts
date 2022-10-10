import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { headerSection } from './components/header-section/header-section';
import { BannerContainer } from './components/banner-container/banner-container.component';
import { AcercaDeSectionComponent } from './acerca-de-section/acerca-de-section.component';
import { ExperienceSectionComponent } from './experience-section/experience-section.component';
import { EducationSectionComponent } from './education-section/education-section.component';
import { SkillsSectionComponent } from './skills-section/skills-section.component';
import { ProyectSectionComponent } from './proyect-section/proyect-section.component';
import { FooterSectionComponent } from './components/footer-section/footer-section.component'
import { PortfolioServiceService } from './servicios/portfolio.service';
import { HttpClientModule } from '@angular/common/http';
import { CargarScriptService } from './servicios/cargar-script.service';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { RegistrarComponent } from './auth/registrar/registrar.component';
import { RecuperarComponent } from './components/recuperar/recuperar.component';
import { LoginBarComponent } from './components/login-bar/login-bar.component';
import { interceptorProvider } from './interceptors/persona-interceptor.service';
import { RedesSocialesComponent } from './components/redes-sociales/redes-sociales.component';
import { NuevaExpComponent } from './experience-section/nueva-exp/nueva-exp.component';
import { EditarExpComponent } from './experience-section/editar-exp/editar-experiencia.component';
import { NuevaEduComponent } from './education-section/nueva-edu/nueva-edu.component';
import { EditarEduComponent } from './education-section/editar-edu/editar-edu.component';
import { NuevaSkillComponent } from './skills-section/nueva-skill/nueva-skill.component';
import { EditarSkillComponent } from './skills-section/editar-skill/editar-skill.component';
import { NuevoProyectoComponent } from './proyect-section/nuevo-proyecto/nuevo-proyecto.component';
import { EditarProyectoComponent } from './proyect-section/editar-proyecto/editar-proyecto.component';
import { EditarPersonaComponent } from './acerca-de-section/editar-persona/editar-persona.component';
import { NgCircleProgressModule } from 'ng-circle-progress';

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
    EditarProyectoComponent,
    EditarPersonaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({    })
  ],
  providers: [PortfolioServiceService,CargarScriptService, interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
