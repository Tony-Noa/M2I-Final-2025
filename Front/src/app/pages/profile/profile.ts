import { Component } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Tournamentcard } from "../../components/tournamentcard/tournamentcard";
import { GameDataService } from '../../utils/services/game-data.service';
import { CommonModule } from '@angular/common';
type Tournament = {
  title: string;
  slug: string;
  date: string;
  location: string;
  image: string;
  host: string;
  gameIcon: string;
  attendees: number;
};

@Component({
  selector: 'app-profile',
  templateUrl: './profile.html',
  styleUrls: ['./profile.css'],
  imports: [DatePipe, Tournamentcard, CommonModule]
})
export class ProfileComponent {
  user: {
    coverImage: string;
    avatar: string;
    username: string;
    location: string;
    joinDate: Date;
    createdTournaments: Tournament[];
  } = {
    coverImage: 'path_or_url_to_cover_image',
    avatar: 'path_or_url_to_avatar',
    username: 'Goku',
    location: 'Lille',
    joinDate: new Date(2020, 11, 1),
    createdTournaments: []
  };

  constructor(private gameData: GameDataService) {
    this.user.createdTournaments = this.gameData.getAllTournaments().slice(0, 3);
  }
}
