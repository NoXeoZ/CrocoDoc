export interface Profile{
  id : number;
  lastName:string;
  firstName : string;
  birthDate : Date;
  address : string;
  phoneNumber : string;
  mail : string;
  specialities: Array<string>;
}
