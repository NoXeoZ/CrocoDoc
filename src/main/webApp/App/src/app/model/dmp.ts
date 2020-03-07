import {Hospitalization} from './Hospitalization';

export interface Dmp{
  id:number;
  firstname :string;
  lastname : string;
  birth :Date;
  birthCity:string;
  socialSecurityNumber:string;
  phoneNumber:string;
  email:string;
  hospitalizations:Array<Hospitalization>
}
