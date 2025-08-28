import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Tournament } from "../../components/tournament/tournament";
import { AttendeesComponent } from "../../components/attendees/attendees";

@Component({
  selector: 'app-game-tournament',
  templateUrl: './game-tournament.html',
  styleUrls: ['./game-tournament.css'],
  standalone: true,
  imports: [CommonModule, Tournament, AttendeesComponent]
})
export class GameTournamentComponent implements OnInit {
  slug: string | null = null;
  tournament: any;

  activeSection: string = 'overview'; 

  @Input() backgroundImage: string = '';

  tournaments = [
    
    {
      slug: 'smash-bros-tournament-1',
      tournamenttype: 'Single',
      logo: 'https://cdn2.steamgriddb.com/logo_thumb/0498cae30ceca924f76c2b0832c14f34.png',
      gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png',
      maxAttendees: 150,
      description: 'Join us for an exciting Super Smash Bros. Ultimate tournament where players of all skill levels come together to battle it out for glory! Whether you’re a casual fan or a seasoned competitor, this event offers a friendly yet competitive environment to showcase your skills on the iconic Nintendo Switch. Expect fast-paced matches, thrilling upsets, and plenty of opportunities to meet fellow Smash enthusiasts. Come ready to fight, have fun, and maybe take home some sweet prizes!',
      screenshots: [
        'https://sm.ign.com/t/ign_me/screenshot/s/small-batt/small-battlefield-in-super-smash-bros-ultimate_bh6s.1080.jpg',
        'https://i.ticketweb.com/i/00/09/57/08/29_Original.jpg?v=6',
        'https://images.squarespace-cdn.com/content/v1/639a626169e089445c592481/df6002da-6c9b-4282-b857-618ec55f46b3/game-focal-ssb1-1160x664.jpg'
      ]
    },
    {
      slug: 'my-first-tournament',
      tournamenttype: 'Single',
      logo: 'https://cdn2.steamgriddb.com/logo_thumb/0498cae30ceca924f76c2b0832c14f34.png',
      gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png',
      maxAttendees: 100,
      description: 'A Mario-character focused tournament for fun!',
      screenshots: [
        'https://i.ytimg.com/vi/qyt4-Lj8T8o/maxresdefault.jpg',
        'https://static1.thegamerimages.com/wordpress/wp-content/uploads/2022/07/Super-Smash-Bros-Ultimate-Luigi.jpg?q=50&fit=crop&w=825&dpr=1.5',
        'https://www.smashbros.com/assets_v2/img/fighter/mario/ss_4.jpg'
      ]
    },
    {
      slug: 'smash-64-only',
      tournamenttype: 'Single',
      logo: 'https://cdn2.steamgriddb.com/logo_thumb/0498cae30ceca924f76c2b0832c14f34.png',
      gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png',
      maxAttendees: 100,
      description: 'Super Smash Bros. 64 characters only!',
      screenshots: [
        'https://ssb.wiki.gallery/images/thumb/6/6f/UltimateStarters.png/1600px-UltimateStarters.png',
      ]
    },
    {
      slug: 'sf6-tournament-1',
      tournamenttype: 'Single',
      logo: 'https://upload.wikimedia.org/wikipedia/fr/0/0d/Street_Fighter_6_Logo.png',
      maxAttendees: 100,
      description: 'Put your fighting gloves on.',
      screenshots: [
        'https://press-start.com.au/wp-content/uploads/2022/06/Street-Fighter-6.jpg',
        'https://i.pcmag.com/imagery/reviews/04QtV9tYUdB4Hix1hC8ek43-6..v1665211680.jpg',
        'https://cdn.wccftech.com/wp-content/uploads/2022/10/20221009171707_1-scaled.jpg',
      ]
    },

    
  ];

  

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    const navigation = history.state;

    if (navigation.tournament?.slug) {
      const fullTournament = this.tournaments.find(t => t.slug === navigation.tournament.slug);
      this.tournament = { ...fullTournament, ...navigation.tournament };
    } else {
      this.slug = this.route.snapshot.paramMap.get('slug');
      if (this.slug) {
        this.tournament = this.tournaments.find(t => t.slug === this.slug);
      }
    }
  }

  selectSection(section: string) {
    this.activeSection = section;
  }
}
