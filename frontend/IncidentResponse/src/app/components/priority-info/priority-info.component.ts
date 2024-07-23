import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-priority-info',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './priority-info.component.html',
  styleUrl: './priority-info.component.scss'
})
export class PriorityInfoComponent {
  
  @Input() value = 0;
}
