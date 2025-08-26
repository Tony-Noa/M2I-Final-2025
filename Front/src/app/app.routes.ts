import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { LogIn } from './pages/log-in/log-in';
import { Signup } from './pages/sign-up/sign-up';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'sign-up', component: Signup },
  { path: 'log-in', component: LogIn },
  // other routes...
];
