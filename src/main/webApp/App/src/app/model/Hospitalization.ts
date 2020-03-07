import {Structure} from './structure';
import {Dmp} from './dmp';
import {Assignement} from './assignement';


export interface Hospitalization{
  id:number;
  startDate :Date;
  endDate : Date;
  hospital :Structure,
  dmp:Dmp,
  assignments:Array<Assignement>
}
