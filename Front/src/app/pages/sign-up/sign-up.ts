import { Component } from '@angular/core';
import { createUserDto, UserDto } from '../../models/user/userDto';
import { AuthService } from '../../utils/services/auth-service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  imports: [ReactiveFormsModule],
  templateUrl: './sign-up.html',
  styleUrl: './sign-up.css'
})
export class Signup {
  constructor(private authApiService: AuthService, private router: Router) { }

  form = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    username: new FormControl(
      '',
      [
        Validators.required,
        //Validators.minLength(3),
        //Validators.maxLength(20),
        //Validators.pattern(/^[a-zA-Z0-9_-]+$/)
      ]
    ),
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
    this.form.clearValidators;
    if (this.form.invalid) {

      this.form.markAllAsTouched();
      return;
    }
    // À remplacer par votre appel API (service Angular -> Spring)
    let userCreated: UserDto = createUserDto({
      email: this.form.value.email!,
      username: this.form.value.username!,
      password: this.form.value.password!
    });
    console.log('Soumission', userCreated);
    this.authApiService.register(userCreated).subscribe({
      next: res => {
        if (res) {
          this.router.navigate(["/"])
        }
      }
    });
  }
}
