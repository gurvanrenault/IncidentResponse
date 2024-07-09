import { Routes } from '@angular/router';
import { ListIncidentsComponent } from './components/list-incidents/list-incidents.component';
import { ManageIncidentsComponent } from './components/manage-incidents/manage-incidents.component';

export const routes: Routes = [
    {path: '', component: ListIncidentsComponent},
    {path: 'incident/create',component: ManageIncidentsComponent},
    {path: 'incident/:id', component: ManageIncidentsComponent}
];
