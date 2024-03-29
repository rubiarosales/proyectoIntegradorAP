import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from "./auth/login/login.component";
import { RecuperarComponent } from "./components/recuperar/recuperar.component";
import { RegistrarComponent } from "./auth/registrar/registrar.component";
import { NuevaExpComponent } from "./experience-section/nueva-exp/nueva-exp.component";
import { EditarExpComponent } from "./experience-section/editar-exp/editar-experiencia.component";
import { NuevaEduComponent } from "./education-section/nueva-edu/nueva-edu.component";
import { EditarEduComponent } from "./education-section/editar-edu/editar-edu.component";
import { NuevaSkillComponent } from "./skills-section/nueva-skill/nueva-skill.component";
import { EditarSkillComponent } from "./skills-section/editar-skill/editar-skill.component";
import { NuevoProyectoComponent } from "./proyect-section/nuevo-proyecto/nuevo-proyecto.component";
import { EditarProyectoComponent } from "./proyect-section/editar-proyecto/editar-proyecto.component";
import { EditarPersonaComponent } from "./acerca-de-section/editar-persona/editar-persona.component";


const routes: Routes=[
    {path:'', component:HomeComponent},
    {path:'login', component:LoginComponent},
    {path:'nuevo', component:RegistrarComponent},
    {path:'recuperar', component:RecuperarComponent},
    {path:'agregarExp', component:NuevaExpComponent},
    {path:'editarExp/:id', component:EditarExpComponent},
    {path:'agregarEdu', component:NuevaEduComponent},
    {path:'editarEdu/:id', component:EditarEduComponent},
    {path:'agregarSkill', component:NuevaSkillComponent},
    {path:'editarSkill/:id', component:EditarSkillComponent},
    {path:'agregarProyecto', component:NuevoProyectoComponent},
    {path:'editarProyecto/:id', component:EditarProyectoComponent},
    {path:'editarPersona/:id', component:EditarPersonaComponent}


    //debo agregar esto a las rutas que solo quiera que entren los loqueados y el rol 
    //,CanActivate: [guard],data:{expectedRol:['admin','user']}
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}