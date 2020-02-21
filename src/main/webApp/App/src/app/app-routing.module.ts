import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthentificationComponent} from "./authentification/authentification.component";
import {HomeComponent} from "./home/home.component";
import {StructureComponent} from "./structure/structure.component";
import {StructureEditComponent} from "./structure/edit/structure-edit.component";
import {UpdateStructureComponent} from "./structure/update-structure/update-structure.component";
import {DmpComponent} from "./dmp/dmp.component";
import {ProfileComponent} from "./profile/profile.component";
import {ProfileEditComponent} from "./profile/edit/profile-edit.component";
import {AssignementComponent} from './assignement/assignement.component';
import {EditAssignementComponent} from './assignement/edit-assignement/edit-assignement.component';
import {DmpSecretaryComponent} from './dmp-admin/dmp-secretary.component';
import {DmpSecretaryEditComponent} from './dmp-admin/edit/dmp-secretary-edit.component';
import {SpecialityComponent} from './speciality/speciality.component';
import {EditSpecialityComponent} from './speciality/edit-speciality/edit-speciality.component';
import {UpdateSpecialityComponent} from './speciality/update-speciality/update-speciality.component';
import {UpdateProfileComponent} from "./profile/update-profile/update-profile.component";
import {OneProfileLargeComponent} from "./profile/one-profile-large/one-profile-large.component";

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
    path: 'assignement/:key',
    component: AssignementComponent
  },
  {
    path: 'assignement/edit',
    component: EditAssignementComponent
  },
  {
    path: 'profiles',
    component: ProfileComponent
  },
  {
    path: 'profiles/edit',
    component: ProfileEditComponent
  },
  {
    path: 'profiles/update/:id',
    component: UpdateProfileComponent
  },
  {
    path: 'profile',
    component: OneProfileLargeComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
