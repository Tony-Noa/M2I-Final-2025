import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Gamecard } from '../../components/gamecard/gamecard';
import { Navbar } from "../../components/navbar/navbar";

@Component({
  selector: 'app-home',
  standalone: true,           
  imports: [CommonModule, Gamecard],   
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class HomeComponent {

  heroImages = [
    'https://medias.lequipe.fr/img-photo-jpg/-/1500000001309483/0-0-0-70/5ab25.jpg',
    'https://weezevent.com/wp-content/uploads/2018/10/15140712/compet_esport.jpg',
    'https://insider-gaming.com/wp-content/uploads/2024/07/best-esports-events-1024x576.jpeg'
  ];

  currentIndex = 0;
  previousIndex = 0;
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
    this.slideDirection = 'right';
  }

  prevImage(): void {
    this.previousIndex = this.currentIndex;
    this.currentIndex =
      (this.currentIndex - 1 + this.heroImages.length) % this.heroImages.length;
    this.slideDirection = 'left';
  }

  goToImage(index: number): void {
    if (index === this.currentIndex) return;
  
    this.previousIndex = this.currentIndex;
    this.currentIndex = index;
  
    setTimeout(() => {
      this.previousIndex = -1; 
    }, 600); 
  }

    games = [
      {
        title: 'Super Smash Bros. Ultimate',
        image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9',
        meta: 'Some meta about the game',
        icon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png',
        additionalInfo: ['Text', 'Text', 'Text']
      },
      {
        title: 'Street Fighter 6',
        image: 'https://images.ctfassets.net/pc3i4f5nnp8d/57LSR6A8Yj0uxaH4jVAWGU/9fe9500d843fc5182b19a4b9121159b4/biborg-work-capcom-street-fighter-6-header.jpg',
        meta: 'Some meta about the game',
        icon: 'https://cdn2.steamgriddb.com/icon/6622392eb0d8dfdacc44c7f7397ce4ab.png',
        additionalInfo: ['Text', 'Text', 'Text']
      },

      {
        title: 'Super Smash Bros. Melee',
        image: 'https://assets-prd.ignimgs.com/2022/01/08/super-smash-bros-melee-button-crop-1641601540515.jpg',
        meta: 'Some meta about the game',
        icon: 'https://cdn2.steamgriddb.com/icon/e0688d13958a19e087e123148555e4b4.png',
        additionalInfo: ['Text', 'Text', 'Text']
      },

      {
        title: 'Dragon Ball Fighterz',
        image: 'https://cdn11.bigcommerce.com/s-k0hjo2yyrq/images/stencil/1280x1280/products/1020/388/Dragon_Ball_Fighterz_Pass_1_Season_Pass_Product_Banner__19643.1726748293.jpg?c=1',
        meta: 'Some meta about the game',
        icon: 'https://cdn2.steamgriddb.com/icon/33ebd5b07dc7e407752fe773eed20635/32/256x256.png',
        additionalInfo: ['Text', 'Text', 'Text']
      },
     
    ];
}
  

