import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthentificationComponent} from "./authentification/authentification.component";
import {HomeComponent} from "./home/home.component";
import {StructureComponent} from "./structure/structure.component";
import {StructureEditComponent} from "./structure/edit/structure-edit.component";
import {UpdateStructureComponent} from "./structure/update-structure/update-structure.component";
import {DmpComponent} from "./dmp/dmp.component";
import {UserComponent} from "./user/user.component";
import {UserEditComponent} from "./user/edit/user-edit.component";
import {UpdateUserComponent} from "./user/update-user/update-user.component";
import {DmpSecretaryComponent} from './dmp-admin/dmp-secretary.component';
import {DmpSecretaryEditComponent} from './dmp-admin/edit/dmp-secretary-edit.component';
import {SpecialityComponent} from './speciality/speciality.component';
import {EditSpecialityComponent} from './speciality/edit-speciality/edit-speciality.component';
import {UpdateSpecialityComponent} from './speciality/update-speciality/update-speciality.component';
import {HospitalizationComponent} from "./hospitalization/hospitalization.component";
import {HospitalizationEditComponent} from "./hospitalization/edit/hospitalization-edit.component";
import {UpdateHospitalizationComponent} from "./hospitalization/update-hospitalization/update-hospitalization.component";

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
    path: 'hospitalization/:key',
    component: HospitalizationComponent
  },
  {
    path: 'hospitalization/:key/edit',
    component: HospitalizationEditComponent
  },
  {
    path: 'hospitalization/:key/update/:id',
    component: UpdateHospitalizationComponent
  },
  {
    path: 'speciality/:key',
    component: SpecialityComponent
  },
  {
    path: 'speciality/:key/edit',
    component: EditSpecialityComponent
  },
  {
    path: 'speciality/:key/update/:id',
    component: UpdateSpecialityComponent
  },
  {
    path: 'dmp',
    component: DmpComponent
  },
  {
    path: 'dmp/edit/:key',
    component: StructureEditComponent
  },
  {
    path: 'dmpSecretary/:key',
    component: DmpSecretaryComponent
  },
  {
    path: 'dmpSecretary/edit/:key',
    component: DmpSecretaryEditComponent
  },
  {
    path: 'dmp/update/:id',
    component: UpdateStructureComponent
  },
  {
    path: 'user/:key',
    component: UserComponent
  },
  {
    path: 'user/:key/edit',
    component: UserEditComponent
  },
  {
      path: 'user/:key/update/:id',
      component: UpdateUserComponent
  },
  {
    path: 'users/:key',
    component: UserComponent
  },
  {
    path: 'users/:key/edit',
    component: UserEditComponent
  },
  {
    path: 'users/:key/update/:id',
    component: UpdateUserComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
