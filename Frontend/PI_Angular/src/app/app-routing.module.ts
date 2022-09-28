import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./auth/login/login.component";
import { RecuperarComponent } from "./recuperar/recuperar.component";
import { RegistrarComponent } from "./auth/registrar/registrar.component";
import { NuevaExpComponent } from "./nueva-exp/nueva-exp.component";
import { EditarExpComponent } from "./editar-exp/editar-experiencia.component";


const routes: Routes=[
    {path:'', component:HomeComponent},
    {path:'login', component:LoginComponent},
    {path:'registrar', component:RegistrarComponent},
    {path:'recuperar', component:RecuperarComponent},
    {path:'agregarExp', component:NuevaExpComponent},
    {path:'editarExp/:id', component:EditarExpComponent}

    //debo agregar esto a las rutas que solo quiera que entren los loqueados y el rol 
    //,CanActivate: [guard],data:{expectedRol:['admin','user']}
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}