import { Component, Input, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header-hero',
  templateUrl: './header-hero.html',
  styleUrls: ['./header-hero.css'],
  standalone: true,
  imports: [CommonModule]
})
export class HeaderHeroComponent {
  @Input() title: string = '';
  @Input() description: string = '';
  @Input() heroImages: string[] = [];
  currentIndex = 0;
  previousIndex: number | null = null;
  slideDirection: 'left' | 'right' = 'right';
  intervalId: any;

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
  
    // Use 'left' for slideDirection for consistency with left arrow animations
    this.slideDirection = 'left';
  
    setTimeout(() => {
      this.previousIndex = -1; // clear previous after animation ends
    }, 600);
  }
  
  prevImage(): void {
    this.previousIndex = this.currentIndex;
    this.currentIndex =
      (this.currentIndex - 1 + this.heroImages.length) % this.heroImages.length;
  
    // Also use 'left' here for consistency
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
      this.previousIndex = -1; // Clear previous index after animation
    }, 600);
  }

  createTournament(): void {
    console.log('Create tournament clicked!');
  }
}
