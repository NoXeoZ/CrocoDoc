import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AuthentificationComponent} from './authentification/authentification.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HomeComponent} from './home/home.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSelectModule} from "@angular/material/select";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {NavbarComponent} from './navbar/navbar.component';
import {LayoutModule} from '@angular/cdk/layout';
import {StructureComponent} from './structure/structure.component';
import {StructureEditComponent} from './structure/edit/structure-edit.component';
import {OneStructureComponent} from './structure/one-structure/one-structure.component';
import {UpdateStructureComponent} from './structure/update-structure/update-structure.component';
import {HttpClientModule} from "@angular/common/http";
import {DmpComponent} from './dmp/dmp.component';
import { MatSnackBarModule} from "@angular/material";
import {DmpSecretaryComponent} from './dmp-admin/dmp-secretary.component';
import {DmpSecretaryEditComponent} from './dmp-admin/edit/dmp-secretary-edit.component';
import {OneDmpComponent} from './dmp-admin/one-dmp/one-dmp.component';
import {SpecialityComponent} from './speciality/speciality.component';
import {EditSpecialityComponent} from './speciality/edit-speciality/edit-speciality.component';
import {OneSpecialityComponent} from './speciality/one-speciality/one-speciality.component';
import {UpdateSpecialityComponent} from './speciality/update-speciality/update-speciality.component';
import {HospitalizationComponent} from "./hospitalization/hospitalization.component";
import {UpdateHospitalizationComponent} from "./hospitalization/update-hospitalization/update-hospitalization.component";
import {HospitalizationEditComponent} from "./hospitalization/edit/hospitalization-edit.component";
import {OneHospitalizationComponent} from "./hospitalization/one-hospitalization/one-hospitaliszation.component";
import {DialogOverviewAssignementComponent} from './hospitalization/dialog-overview-assignement/dialog-overview-assignement.component';
import {AssignementHospitalizationComponent} from './hospitalization/update-hospitalization/one-assignement/assignement-of-Hospitalization.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from '@angular/material/core';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { AngularFontAwesomeModule} from "angular-font-awesome";
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {UserComponent} from "./user/user.component";
import {UserEditComponent} from "./user/edit/user-edit.component";
import {UpdateUserComponent} from "./user/update-user/update-user.component";
import {OneUserComponent} from "./user/one-user/one-user.component";
import {MatDialogModule} from "@angular/material/dialog";
import { UpdateUserRegularComponent } from './user-regular/update-user-regular/update-user-regular.component';
import {UserRegularComponent} from "./user-regular/user-regular.component";

import {OneDmpSearchComponent} from "./dmp/one-dmp/one-dmp-search.component";
import {SejourComponent} from "./dmp/one-hospitalization/sejour.component";
import {AssignementComponent} from "./dmp/one-assignement/assignement.component";
import { EditActComponent } from './dmp/edit-act/edit-act.component';
import {OneActComponent} from "./dmp/one-act/one-act.component";
import {DialogChefComponent} from "./structure/dialog-overview/dialog-chef.component";
import {StructureChefComponent} from "./structure/update-structure/one-chef/one-chef.component";
import {OneActToDisplayComponent} from "./dmp/one-actToDisplay/one-act-to-display.component";
import { InputFileConfig, InputFileModule} from 'ngx-input-file';

const config: InputFileConfig = {};

@NgModule({
  exports: [DialogOverviewAssignementComponent,DialogChefComponent],
  entryComponents: [DialogOverviewAssignementComponent,DialogChefComponent],
  declarations: [
    AppComponent,
    AuthentificationComponent,
    HomeComponent,
    NavbarComponent,
    StructureComponent,
    StructureEditComponent,
    OneStructureComponent,
    UpdateStructureComponent,
    DmpComponent,
    UserComponent,
    UserEditComponent,
    UpdateUserComponent,
    OneUserComponent,
    DmpSecretaryComponent,
    DmpSecretaryEditComponent,
    OneDmpComponent,
    SpecialityComponent,
    EditSpecialityComponent,
    OneSpecialityComponent,
    UpdateSpecialityComponent,
    HospitalizationComponent,
    UpdateHospitalizationComponent,
    HospitalizationEditComponent,
    OneHospitalizationComponent,
    DialogOverviewAssignementComponent,
    AssignementHospitalizationComponent,
    UpdateUserRegularComponent,
    UserRegularComponent,
    AssignementHospitalizationComponent,
    OneDmpSearchComponent,
    SejourComponent,
    AssignementComponent,
    EditActComponent,
    OneActComponent,
    DialogChefComponent,
    StructureChefComponent,
    OneActToDisplayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatSelectModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatSidenavModule,
    MatListModule,
    MatDialogModule,
    LayoutModule,
    MatSnackBarModule,
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        BrowserAnimationsModule,
        MatCardModule,
        MatFormFieldModule,
        FormsModule,
        ReactiveFormsModule,
        MatToolbarModule,
        MatSelectModule,
        MatIconModule,
        MatButtonModule,
        MatInputModule,
        MatSidenavModule,
        MatListModule,
        LayoutModule,
        MatSnackBarModule,
        MatDatepickerModule,
        MatNativeDateModule,
      FontAwesomeModule,
    InputFileModule.forRoot(config)

  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
