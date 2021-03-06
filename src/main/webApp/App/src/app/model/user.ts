import {Structure} from "./structure";

export enum TypeUser{
  SECRETARY='SECRETARY',
  NURSE='NURSE',
  DOCTOR='DOCTOR',
  LAB_STAFF='LAB_STAFF',
  ADMIN='ADMIN',
}
export interface User{
  id   : number;
  type : TypeUser;
  firstname : string;
  lastname : string;
  birthDate : Date;
  address : string;
  phoneNumber : string;
  email : string;
  password : string;
  rib : string;
  structure : Structure;
}

