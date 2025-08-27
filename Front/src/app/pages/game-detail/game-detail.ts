import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Tournamentcard } from '../../components/tournamentcard/tournamentcard';
import { HeaderHeroGameComponent } from "../../components/header-hero-game/header-hero-game";
import { GameDataService } from '../../services/game-data.service';

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

  constructor(private route: ActivatedRoute, private gameData: GameDataService) {}

  ngOnInit() {
    this.slug = this.route.snapshot.paramMap.get('slug');
    if (this.slug) {
      this.game = this.gameData.getGameBySlug(this.slug);
    }
  }
}
