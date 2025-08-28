import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { LogIn } from './pages/log-in/log-in';
import { Signup } from './pages/sign-up/sign-up';
import { GameDetailComponent } from './pages/game-detail/game-detail';
import { GameTournamentComponent } from './pages/game-tournament/game-tournament';
import { CreateTournamentComponent } from './pages/create-tournament-page/create-tournament-page';
import { Tournament } from './components/tournament/tournament';
import { ProfileComponent } from './pages/profile/profile';

export const routes: Routes = [
  { path: 'sign-up', component: Signup },
  { path: 'log-in', component: LogIn },
  { path: 'games/:slug', component: GameDetailComponent },
  { path: '', component: HomeComponent },
  { path: 'createtournament', component: CreateTournamentComponent },
  { path: 'tournament/:slug', component: GameTournamentComponent },
  { path: "bracket-view", component: Tournament },
  { path: 'profile', component: ProfileComponent },



];
