import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideAnimations } from '@angular/platform-browser/animations';
import { IncidentService } from './services/incidentService/incident.service';
import { UtilisateurService } from './services/utilisateurService/utilisateur.service';

export const appConfig: ApplicationConfig = {
  providers: [IncidentService,UtilisateurService,provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes), provideClientHydration(), provideAnimationsAsync(),provideAnimationsAsync()]
};
