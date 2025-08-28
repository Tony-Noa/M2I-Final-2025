import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { GameDataService } from '../../utils/services/game-data.service';
import { CommonModule } from '@angular/common';
import { HeaderHeroGameComponent } from "../../components/header-hero-game/header-hero-game";

interface Game {
  slug: string;
  title: string;
  icon: string;
}

@Component({
  selector: 'app-create-tournament',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, HeaderHeroGameComponent],
  templateUrl: './create-tournament-page.html',
  styleUrls: ['./create-tournament-page.css']
})
export class CreateTournamentComponent implements OnInit {
  tournamentForm!: FormGroup;

  games: Game[] = [];
  tournamentTypes = [
    {
      label: 'Double Elimination',
      value: 'double',
      image: 'https://www.bracketsninja.com/_next/image?url=https%3A%2F%2Fwebsite-assets.commoninja.com%2Fimages%2F1672931239193_double-elimination-hero_1.webp&w=1920&q=75',
      description: 'Each participant has to lose twice before being eliminated, allowing a second chance through the losers bracket.'
    },
    {
      label: 'Single Elimination',
      value: 'single',
      image: 'https://lh4.googleusercontent.com/QYE9UBc58dhXTElPP5Octi4325JJ7DXWQ0bSHxKh8DNeVNhDYyRi5MdPDOH35hPbB1TW1joRx7_dJ8Dw07ZKLjMNLJVx-cXnOpdKTpgZisHXQCzcL9nj3LvcO-SAawCJb_QY9wDGDSZw_Jebl-MM_7I',
      description: 'Participants are eliminated after a single loss, progressing through knockout rounds until a winner is decided.'
    },
    {
      label: 'Round-Robin',
      value: 'roundrobin',
      image: 'https://www.bracketsninja.com/_next/image?url=https%3A%2F%2Fwebsite-assets.commoninja.com%2Fimages%2F1672829922931_round-robin-hero.webp&w=1920&q=75',
      description: 'Every participant plays against all others, with rankings determined by overall wins and points.'
    }
  ];

  constructor(private fb: FormBuilder, private gameDataService: GameDataService) { }

  ngOnInit() {
    this.games = this.gameDataService.getAllGames();

    this.tournamentForm = this.fb.group({
      name: ['', Validators.required],
      type: ['', Validators.required],
      game: ['', Validators.required],
      participants: [2, [Validators.required, Validators.min(2), Validators.max(128)]],
    });
  }

  selectType(typeValue: string) {
    this.tournamentForm.patchValue({ type: typeValue });
  }

  onSubmit() {
    if (this.tournamentForm.valid) {
      console.log('Form data', this.tournamentForm.value);
    }
  }

  dropdownOpen = false;
  selectedGame: Game | null = null;

  toggleDropdown(event?: MouseEvent) {
    if (event) {
      event.stopPropagation();
    }
    this.dropdownOpen = !this.dropdownOpen;
  }


  selectGame(game: Game) {
    this.selectedGame = game;
    this.tournamentForm.patchValue({ game: game.slug });
    this.dropdownOpen = false;
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent) {
    const target = event.target as HTMLElement;
    if (!target.closest('.custom-select')) {
      this.dropdownOpen = false;
    }
  }


}
