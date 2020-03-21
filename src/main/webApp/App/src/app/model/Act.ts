import {Assignement} from './assignement';
import {User} from "./user";

export enum ActType{
  OBSERVATION='OBSERVATION',
  EXAM='EXAM',
  PRESCRIPTION='PRESCRIPTION',
  CONSTANT_REPORT='CONSTANT_REPORT',
  CR='CR',
  ORDONNANCE='ORDONNANCE',
  RADIO='RADIO'
}
export interface Act{
  id : number;
  description :string;
  createdAt : Date;
  draft :Boolean;
  type :ActType;
  assignment :Assignement;
  user:User;
  image: any;
}
