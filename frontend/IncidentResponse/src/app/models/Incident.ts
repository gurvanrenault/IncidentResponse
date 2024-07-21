import { PrioriteEnum } from "../enums/PrioriteEnum";
import { StatutIncidentEnum } from "../enums/StatutIncidentEnum";
import { Commentaire } from "./Commentaire";
import { Utilisateur } from "./Utilisateur";

export class Incident {
    id !: number;
    titre !:string;
    description !: string;
    priorite !: PrioriteEnum;
    statut !: StatutIncidentEnum;
    utilisateur ?: number ;
    commentaires ?:Commentaire[]; 
    date !: Date
}