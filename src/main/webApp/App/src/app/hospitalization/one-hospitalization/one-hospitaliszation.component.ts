import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HospitalizationService} from "../hospitalization.service";
import {Hospitalization} from "../../model/Hospitalization";

@Component({
  selector: 'tr [hospitalization]',
  templateUrl: './one-hospitalization.component.html',
  styleUrls: ['./one-hospitalization.component.css']
})
export class OneHospitalizationComponent implements OnInit {
  @Input()
  hospitalization: Hospitalization;
  private key: string;
  constructor(private hospitalizationService: HospitalizationService,private route :ActivatedRoute) { }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
  }

}
