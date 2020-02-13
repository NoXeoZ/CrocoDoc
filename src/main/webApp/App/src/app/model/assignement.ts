import {Structure} from "./structure";
import {Hospitalization} from './Hospitalization';
import {Act} from './Act';

export interface Assignement{
  id : number;
  startDate: Date;
  endDate : Date;
  service :Structure;
  hospitalization :Hospitalization;
  acts: Array<Act>
}
