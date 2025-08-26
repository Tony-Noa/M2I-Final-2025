import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Tournamentcard } from '../../components/tournamentcard/tournamentcard';
import { HeaderHeroGameComponent } from "../../components/header-hero-game/header-hero-game";

@Component({
  selector: 'app-game-detail',
  templateUrl: './game-detail.html',
  styleUrls: ['./game-detail.css'],
  standalone: true,
  imports: [CommonModule, Tournamentcard, HeaderHeroGameComponent],
})
export class GameDetailComponent implements OnInit {
  slug: string | null = null;
  game: any;

  games = [
    {
      slug: 'super-smash-bros-ultimate',
      title: 'Super Smash Bros. Ultimate',
      description: 'Description for Smash Bros Ultimate...',
      logo: 'https://cdn2.steamgriddb.com/logo_thumb/0498cae30ceca924f76c2b0832c14f34.png',
      heroImages: [
        'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9',
      ],
      tournaments: [
        { title: 'Ultimate Tournament 1', slug: 'ultimate-tournament-1', date: '2025-09-01', location: 'Roubaix', image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9', host:'SuperSmashEnjoyer', gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png', attendees: '100' },
        { title: 'Ultimate Tournament 2', slug: 'ultimate-tournament-2', date: '2025-09-01', location: 'Paris', image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9', host:'SuperSmashEnjoyer', gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png', attendees: '60' },
        { title: 'Ultimate Tournament 3', slug: 'ultimate-tournament-3', date: '2025-09-01', location: 'Roubaix', image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9', host:'SuperSmashEnjoyer', gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png', attendees: '100' },
        { title: 'Ultimate Tournament 4', slug: 'ultimate-tournament-4', date: '2025-09-01', location: 'Roubaix', image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9', host:'SuperSmashEnjoyer', gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png', attendees: '100' },
        { title: 'Ultimate Tournament 5', slug: 'ultimate-tournament-5', date: '2025-09-01', location: 'Roubaix', image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9', host:'SuperSmashEnjoyer', gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png', attendees: '100' },

      ]
    },
    {
      slug: 'street-fighter-6',
      title: 'Street Fighter 6',
      description: 'Description for Street Fighter 6...',
      heroImages: [
        'https://images.ctfassets.net/pc3i4f5nnp8d/57LSR6A8Yj0uxaH4jVAWGU/9fe9500d843fc5182b19a4b9121159b4/biborg-work-capcom-street-fighter-6-header.jpg',
      ],
      tournaments: [
        { name: 'SF6 Regional', date: '2025-09-15' },
      ]
    },
    // more games
  ];
  

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.slug = this.route.snapshot.paramMap.get('slug');
    this.game = this.games.find(g => g.slug === this.slug);
  }
}
