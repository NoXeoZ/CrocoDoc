import {Structure} from "./structure";

export interface Affectation{
  id : number;
  dateDebut: Date;
  dateFin : Date;
  endEffectation :Boolean;
  structure :Structure
}
