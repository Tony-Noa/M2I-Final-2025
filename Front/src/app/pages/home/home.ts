import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Gamecard } from '../../components/gamecard/gamecard';
import { HeaderHeroComponent } from "../../components/header-hero/header-hero";
import { Tournamentcard } from '../../components/tournamentcard/tournamentcard';
import { GameDataService } from '../../services/game-data.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, Gamecard, HeaderHeroComponent, Tournamentcard],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class HomeComponent {
  homeHeroImages = [
    'https://medias.lequipe.fr/img-photo-jpg/-/1500000001309483/0-0-0-70/5ab25.jpg',
    'https://weezevent.com/wp-content/uploads/2018/10/15140712/compet_esport.jpg',
    'https://insider-gaming.com/wp-content/uploads/2024/07/best-esports-events-1024x576.jpeg'
  ];

  homeHeroTitle = 'WELCOME TO GAMEZONE';
  homeHeroDescription = 'The place where you can easily make tournament brackets for many games supported, and more to come.';

  games: any[] = [];
  tournaments: any[] = [];

  constructor(private gameData: GameDataService) {}

  ngOnInit(): void {
    this.games = this.gameData.getAllGames();
    this.tournaments = this.gameData.getAllTournaments();
  }
}


