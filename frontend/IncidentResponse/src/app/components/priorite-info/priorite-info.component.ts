import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-priorite-info',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './priorite-info.component.html',
  styleUrl: './priorite-info.component.scss'
})
export class PrioriteInfoComponent {
  
  @Input() value = 0;
}
