import { Component, Input } from '@angular/core';
import { StatusIncidentEnum } from '../../enums/StatutsIncidentEnum';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-status-incident-info',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './status-incident-info.component.html',
  styleUrl: './status-incident-info.component.scss'
})
export class StatusIncidentInfoComponent {
  @Input() value:string = StatusIncidentEnum.TODO;
}
