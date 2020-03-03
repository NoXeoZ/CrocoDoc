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
import { UserComponent } from './user/user.component';
import { UserEditComponent } from './user/edit/user-edit.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import { OneUserComponent } from './user/one-user/one-user.component';
import {DmpComponent} from './dmp/dmp.component';
import {MatSnackBarModule} from "@angular/material";
import {AssignementComponent} from './assignement/assignement.component';
import {EditAssignementComponent} from './assignement/edit-assignement/edit-assignement.component';
import {OneAssignementComponent} from './assignement/one-assignement/one-assignement.component';
import {DmpSecretaryComponent} from './dmp-admin/dmp-secretary.component';
import {DmpSecretaryEditComponent} from './dmp-admin/edit/dmp-secretary-edit.component';
import {OneDmpComponent} from './dmp-admin/one-dmp/one-dmp.component';
import {SpecialityComponent} from './speciality/speciality.component';
import {EditSpecialityComponent} from './speciality/edit-speciality/edit-speciality.component';
import {OneSpecialityComponent} from './speciality/one-speciality/one-speciality.component';
import {UpdateSpecialityComponent} from './speciality/update-speciality/update-speciality.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from '@angular/material/core';

@NgModule({
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
    AssignementComponent,
    EditAssignementComponent,
    OneAssignementComponent,
    DmpSecretaryComponent,
    DmpSecretaryEditComponent,
    OneDmpComponent,
    SpecialityComponent,
    EditSpecialityComponent,
    OneSpecialityComponent,
    UpdateSpecialityComponent,
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
        LayoutModule,
        MatSnackBarModule,
        MatDatepickerModule,
        MatNativeDateModule

    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
