import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { IncidentService } from './services/incidentService/incident.service';
import { UserService } from './services/userService/user.service';
import { CommentaryService } from './services/CommentaryService/commentary.service';

export const appConfig: ApplicationConfig = {
  providers: [IncidentService,UserService,CommentaryService,provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes), provideClientHydration(), provideAnimationsAsync(),provideAnimationsAsync()]
};
