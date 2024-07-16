import { PrioriteEnum } from "../enums/PrioriteEnum";
import { Commentaire } from "./Commentaire";
import { Utilisateur } from "./Utilisateur";

export class Incident {
    id !: number;
    description !: string;
    priorite !: PrioriteEnum
    utilisateur ?: Utilisateur ;
    commentaires ?:Commentaire 
    date !: Date
}