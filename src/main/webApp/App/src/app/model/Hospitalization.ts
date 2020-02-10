import {Structure} from './structure';
import {Dmp} from './dmp';
import {Assignement} from './assignement';


export interface Hospitalization{
  startDate :Date;
  endDate : Date;
  hospital :Structure,
  dmp:Dmp,
  assignments:Array<Assignement>
}
