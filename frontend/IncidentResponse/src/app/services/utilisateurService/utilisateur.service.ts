import { Injectable } from '@angular/core';
import { Utilisateur } from '../../models/Utilisateur';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  
  
 
  
  private utilisateurs : Array<Utilisateur>= [
    {id:0, mail: "test@gmail;com", nom: "Telsa",prenom: "Nicolas",entreprise:"Tesla"},
    {id:1, mail: "test@gmail;com", nom: "Edison",prenom: "Mark",entreprise:"Tesla"}
  ];
  constructor() { }

  public getUtilisateurs(){
    return this.utilisateurs
  }
  public getUtilisateurById(id:number) {
    return this.utilisateurs.find( (util) => util.id === id);
  }
}
