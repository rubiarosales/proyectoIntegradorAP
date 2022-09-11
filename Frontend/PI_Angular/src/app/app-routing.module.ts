import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { RecuperarComponent } from "./recuperar/recuperar.component";
import { RegistrarComponent } from "./registrar/registrar.component";

const routes: Routes=[
    {path:'', component:HomeComponent},
    {path:'login', component:LoginComponent},
    {path:'registrar', component:RegistrarComponent},
    {path:'recuperar', component:RecuperarComponent}
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}