import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-tournamentcard',
  standalone: true,
  templateUrl: './tournamentcard.html',
  styleUrls: ['./tournamentcard.css'],
  imports: [CommonModule, RouterModule]
})
export class Tournamentcard {
  @Input() tournament!: {
    title: string;
    slug: string;
    host: string;
    date: string;
    location: string;
    attendees: number;
    image: string;
    gameIcon: string;
  };

}