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
import {DmpAdminComponent} from './dmp-admin/dmp-admin.component';
import {DmpAdminEditComponent} from './dmp-admin/edit/dmp-admin-edit.component';
import {SpecialityComponent} from './speciality/speciality.component';
import {EditSpecialityComponent} from './speciality/edit-speciality/edit-speciality.component';
import {UpdateSpecialityComponent} from './speciality/update-speciality/update-speciality.component';

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
    path: 'structures/:key',
    component: StructureComponent
  },
  {
    path: 'structures/:key/edit',
    component: StructureEditComponent
  },
  {
    path: 'structures/:key/update/:id',
    component: UpdateStructureComponent
  },
  {
    path: 'speciality',
    component: SpecialityComponent
  },
  {
    path: 'speciality/edit',
    component: EditSpecialityComponent
  },
  {
    path: 'speciality/update/:id',
    component: UpdateSpecialityComponent
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
    path: 'dmpAdmin',
    component: DmpAdminComponent
  },
  {
    path: 'dmpAdmin/edit',
    component: DmpAdminEditComponent
  },
  {
    path: 'dmp/update/:id',
    component: UpdateStructureComponent
  },
  {
    path: 'assignement/:key',
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
