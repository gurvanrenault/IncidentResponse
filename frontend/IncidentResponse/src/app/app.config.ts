import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { IncidentService } from './shared/services/incidentService/incident.service';
import { UserService } from './shared/services/userService/user.service';
import { CommentaryService } from './shared/services/CommentaryService/commentary.service';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [IncidentService,UserService,CommentaryService,provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes),provideHttpClient(), provideClientHydration(), provideAnimationsAsync(),provideAnimationsAsync()]
};
