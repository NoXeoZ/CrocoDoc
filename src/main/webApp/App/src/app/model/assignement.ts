import {Structure} from "./structure";
import {Hospitalization} from './Hospitalization';
import {Act} from './Act';
import Instance = WebAssembly.Instance;

export interface Assignement{
  id : number;
  startDate: Instance;
  endDate : Instance;
  service :Structure;
  hospitalization :Hospitalization;
  acts: Array<Act>
}
