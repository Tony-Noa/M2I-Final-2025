import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router'; 

@Component({
  selector: 'app-header-hero',
  templateUrl: './header-hero.html',
  styleUrls: ['./header-hero.css'],
  standalone: true,
  imports: [CommonModule, RouterModule]
})
export class HeaderHeroComponent {
  @Input() title: string = '';
  @Input() description: string = '';
  @Input() heroImages: string[] = [];
  currentIndex = 0;
  previousIndex: number | null = null;
  slideDirection: 'left' | 'right' = 'right';
  intervalId: any;

  constructor(private router: Router) {} 

  createTournament(): void {
    console.log('Button clicked!');
    this.router.navigate(['/createtournament']);
  }
  
  ngOnInit(): void {
    this.intervalId = setInterval(() => {
      this.nextImage(true);
    }, 6000);
  }

  ngOnDestroy(): void {
    clearInterval(this.intervalId);
  }

  nextImage(auto = false): void {
    this.previousIndex = this.currentIndex;
    this.currentIndex = (this.currentIndex + 1) % this.heroImages.length;

    this.slideDirection = 'left';

    setTimeout(() => {
      this.previousIndex = -1;
    }, 600);
  }

  prevImage(): void {
    this.previousIndex = this.currentIndex;
    this.currentIndex =
      (this.currentIndex - 1 + this.heroImages.length) % this.heroImages.length;

    this.slideDirection = 'left';

    setTimeout(() => {
      this.previousIndex = -1;
    }, 600);
  }

  goToImage(index: number): void {
    if (index === this.currentIndex) return;

    this.previousIndex = this.currentIndex;
    this.currentIndex = index;

    setTimeout(() => {
      this.previousIndex = -1;
    }, 600);
  }
}