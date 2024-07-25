import { Routes } from '@angular/router';
import { ListIncidentsComponent } from './components/list-incidents/list-incidents.component';
import { ManageIncidentsComponent } from './components/manage-incidents/manage-incidents.component';
import { ViewIncidentComponent } from './components/view-incident/view-incident.component';

export const routes: Routes = [
    {path: '', component: ListIncidentsComponent},
    {path: 'incident/:id', component: ViewIncidentComponent}
];
