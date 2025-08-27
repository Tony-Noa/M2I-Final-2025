import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { LogIn } from './pages/log-in/log-in';
import { Signup } from './pages/sign-up/sign-up';
import { GameDetailComponent } from './pages/game-detail/game-detail';
import { GameTournamentComponent } from './pages/game-tournament/game-tournament';

export const routes: Routes = [
  { path: 'sign-up', component: Signup },
  { path: 'log-in', component: LogIn },
  { path: 'games/:slug', component: GameDetailComponent },
  { path: '', component: HomeComponent },
  {path: 'tournament/:slug',
    component: GameTournamentComponent,
    }
    
];
