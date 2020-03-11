import {User} from "./user";
import {Speciality} from "./speciality";

export enum StructureType{
  HOSPITAL='HOSPITAL',
  POLE='POLE',
  SERVICE='SERVICE',
  FUNCTIONAL_UNIT='FUNCTIONAL_UNIT',
  HOSPITAL_UNIT='HOSPITAL_UNIT',
}
export interface Structure{
  id : number;
  name:string;
  description : string;
  type:StructureType,
  parent:Structure,
  chief:User,
  specialities:Array<Speciality>
}
