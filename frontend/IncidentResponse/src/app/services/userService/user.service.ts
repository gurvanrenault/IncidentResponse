import { Injectable } from '@angular/core';
import { User } from '../../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  
 
  
  private utilisateurs : Array<User>= [
    {id:0, mail: "test@gmail;com", lastname: "Telsa",name: "Nicolas",entreprise:"Tesla"},
    {id:1, mail: "test@gmail;com", lastname: "Edison",name: "Mark",entreprise:"Tesla"}
  ];
  constructor() { }

  public getUtilisateurs(){
    return this.utilisateurs
  }
  public getUtilisateurById(id:number) {
    return this.utilisateurs.find( (util) => util.id === id);
  }
}
