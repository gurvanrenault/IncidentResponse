import { PriorityEnum } from "../enums/PriorityEnum";
import { StatusIncidentEnum } from "../enums/StatutsIncidentEnum";
import { Commentary } from "./Commentary";

export class Incident {
    id !: number;
    title !:string;
    description !: string;
    priority !: PriorityEnum;
    status !: StatusIncidentEnum;
    user ?: number ;
    commentary ?:Commentary[]; 
    date !: Date
}