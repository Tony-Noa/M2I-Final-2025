import { Component, Input, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header-hero-game',
  templateUrl: './header-hero-game.html',
  styleUrls: ['./header-hero-game.css'],
  standalone: true,
  imports: [CommonModule]
})
export class HeaderHeroGameComponent implements OnInit, OnDestroy {
  @Input() title: string = '';
  @Input() description: string = '';
  @Input() heroImages: string[] = [];
  @Input() logo: string = '';
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
