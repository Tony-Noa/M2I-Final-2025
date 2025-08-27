import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-game-tournament',
  templateUrl: './game-tournament.html',
  styleUrls: ['./game-tournament.css'],
  standalone: true,
  imports: [CommonModule]
})
export class GameTournamentComponent implements OnInit {
  slug: string | null = null;
  tournament: any;

  tournaments = [
    { 
      title: 'Ultimate Tournament 1', 
      slug: 'ultimate-tournament-1', 
      date: '2025-09-01', 
      location: 'Roubaix', 
      image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9', 
      host: 'SuperSmashEnjoyer', 
      gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png', 
      attendees: 100,
      maxAttendees: 150,
      description: 'Come join the Ultimate Tournament 1, lots of fun!',
      screenshots: [
        'screenshot1.jpg',
        'screenshot2.jpg',
        'screenshot3.jpg'
      ]
    },
    { 
      title: 'Ultimate Tournament 2', 
      slug: 'ultimate-tournament-2', 
      date: '2025-10-15', 
      location: 'Paris', 
      image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9', 
      host: 'SmashLover', 
      gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png', 
      attendees: 50,
      maxAttendees: 100,
      description: 'The second tournament, get ready!',
      screenshots: [
        'screenshot4.jpg',
        'screenshot5.jpg',
      ]
    },
  ];

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    const navigation = history.state;
  
    if (navigation.tournament) {
      this.tournament = navigation.tournament;
    } else {
      this.slug = this.route.snapshot.paramMap.get('slug');
      if (this.slug) {
        this.tournament = this.tournaments.find(t => t.slug === this.slug);
      }
    }
  }
}
