import {Assignement} from './assignement';

export interface Act{
  id : number;
  description :string;
  createdAt : Date;
  draft :Boolean;
  type :string;
  assignment :Assignement;
}
