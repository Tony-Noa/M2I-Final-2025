import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { createUser, UserType } from '../../models/user/user';
import { AuthService } from '../../utils/services/auth-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-log-in',
  imports: [ReactiveFormsModule],
  templateUrl: './log-in.html',
  styleUrl: './log-in.css'
})
export class LogIn {
  constructor(private authApiService: AuthService, private router: Router) { }

  form = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl(
      '',
      [
        Validators.required,
        //Validators.minLength(8),
        // au moins 1 minuscule, 1 majuscule, 1 chiffre, 1 spécial
        //Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^\w\s]).+$/)
      ]
    )
  });


  onSubmit() {
    if (this.form.invalid) {
      console.log("test");
      this.form.markAllAsTouched();
      return;
    }
    // À remplacer par votre appel API (service Angular -> Spring)
    let user: UserType = createUser({
      email: this.form.value.email!,
      password: this.form.value.password!
    });
    console.log('Soumission', user);
    this.authApiService.login(user).subscribe({
      next: res => {
        if (res) {
          this.router.navigate(["/"])
        }
      }
    });
  }
}
