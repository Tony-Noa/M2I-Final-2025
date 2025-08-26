import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-gamecard',
  standalone: true,
  templateUrl: './gamecard.html',
  styleUrls: ['./gamecard.css'],
  imports: [CommonModule, RouterModule],
})

export class Gamecard {
  @Input() game!: {
    slug: string;    
    title: string;
    image: string;
    meta: string;
    icon: string;
    additionalInfo: string[];
  };
}
