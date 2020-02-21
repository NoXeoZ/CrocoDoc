export enum TypeProfil {
  SECRETARY='SECRETARY',
  NURSE='NURSE',
  DOCTOR='DOCTOR',
  LAB_STAFF='LAB_STAFF',
  ADMIN='ADMIN',
}
export interface Profil{
  id : number;
  name:string;
  role : TypeProfil;

}
