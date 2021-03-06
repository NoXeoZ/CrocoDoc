import {Speciality} from "./speciality";
import {Hospitalization} from "./Hospitalization";
import {User} from "./user";


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
  speciality:Speciality,
  hospitalizations : Array<Hospitalization>

}
