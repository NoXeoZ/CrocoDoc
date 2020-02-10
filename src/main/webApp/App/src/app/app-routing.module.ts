import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthentificationComponent} from "./authentification/authentification.component";
import {HomeComponent} from "./home/home.component";
import {StructureComponent} from "./structure/structure.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {StructureEditComponent} from "./structure/edit/structure-edit.component";
import {UpdateStructureComponent} from "./structure/update-structure/update-structure.component";
import {DmpComponent} from "./dmp/dmp.component";
import {AssignementComponent} from './assignement/assignement.component';
import {EditAssignementComponent} from './assignement/edit-assignement/edit-assignement.component';

const routes: Routes = [
  {
    path: 'login',
    component: AuthentificationComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'structures',
    component: StructureComponent
  },
  {
    path: 'structures/edit',
    component: StructureEditComponent
  },
  {
    path: 'structures/update/:id',
    component: UpdateStructureComponent
  },
  {
    path: 'dmp',
    component: DmpComponent
  },
  {
    path: 'dmp/edit',
    component: StructureEditComponent
  },
  {
    path: 'dmp/update/:id',
    component: UpdateStructureComponent
  },
  {
    path: 'assignement',
    component: AssignementComponent
  },
  {
    path: 'assignement/edit',
    component: EditAssignementComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
