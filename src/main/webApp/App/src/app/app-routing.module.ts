import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthentificationComponent} from "./authentification/authentification.component";
import {HomeComponent} from "./home/home.component";
import {RegisterComponent} from "./authentification/register/register.component";

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path: 'login',
    component: AuthentificationComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }