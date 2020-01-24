import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {

  constructor(    private router: Router) { }

  ngOnInit() {
  }
  model: any = {};
  login() {
    console.log('Tentative de connexion');

    // Vérifier que login/mdp sont correctes, par exemple par une requête à un service REST
    localStorage.setItem('user', JSON.stringify({login : this.model.username}));
   // this.router.navigate(['/home']);
  }
}
