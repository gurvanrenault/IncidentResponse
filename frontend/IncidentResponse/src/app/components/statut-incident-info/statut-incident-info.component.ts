import { Component, Input } from '@angular/core';
import { StatutIncidentEnum } from '../../enums/StatutIncidentEnum';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-statut-incident-info',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './statut-incident-info.component.html',
  styleUrl: './statut-incident-info.component.scss'
})
export class StatutIncidentInfoComponent {
  @Input() value:string = StatutIncidentEnum.TODO;
}
