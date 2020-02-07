import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSelectModule} from "@angular/material/select";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import { NavbarComponent } from './navbar/navbar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { StructureComponent } from './structure/structure.component';
import { StructureEditComponent } from './structure/edit/structure-edit.component';
import { OneStructureComponent } from './structure/one-structure/one-structure.component';
import { UpdateStructureComponent } from './structure/update-structure/update-structure.component';
import {HttpClientModule} from "@angular/common/http";
import { DmpComponent } from './dmp/dmp.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfileEditComponent } from './profile/edit/profile-edit.component';
import { UpdateProfileComponent } from './profile/update-profile/update-profile.component';
import { OneProfileComponent } from './profile/one-profile/one-profile.component';

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
    ProfileComponent,
    ProfileEditComponent,
    UpdateProfileComponent,
    OneProfileComponent,
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

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
