import { Utilisateur } from "./Utilisateur";

export class Commentaire {
    id!: number;
    utilisateur !: Utilisateur;
    description!: string;  
    date !: Date


}