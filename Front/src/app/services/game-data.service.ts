import { Injectable, OnInit } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class GameDataService {
  games = [
    {
      slug: 'super-smash-bros-ultimate',
      title: 'Super Smash Bros. Ultimate',
      logo: 'https://cdn2.steamgriddb.com/logo_thumb/0498cae30ceca924f76c2b0832c14f34.png',
      heroImages: [
        'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9',
      ],
      image: 'https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000012332/ac4d1fc9824876ce756406f0525d50c57ded4b2a666f6dfe40a6ac5c3563fad9',
      meta: 'Simple, Double',
      icon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png',
      additionalInfo: ['Number of tournaments :', 'Text', 'Text'],
      tournaments: [
        {
          title: 'Super Smash Bros. Tournament',
          slug: 'smash-bros-tournament-1',
          date: '2025-09-01',
          location: 'Roubaix',
          image: 'https://i.ticketweb.com/i/00/09/57/08/29_Original.jpg?v=6',
          host: 'SuperSmashEnjoyer',
          gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png',
          attendees: 100
        },
        {
          title: 'My First Tournament',
          slug: 'my-first-tournament',
          date: '2025-12-21',
          location: 'Paris',
          image: 'https://nintendoeverything.com/wp-content/uploads/smash-ultimate-tournament-sept-20.jpg',
          host: 'SuperMarioFan',
          gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png',
          attendees: 60
        },
        {   title: 'Smash 64 Only',
            slug: 'smash-64-only',
            date: '2025-09-01',
            location: 'Online',
            image: 'https://www.nintendo.com/eu/media/images/10_share_images/games_15/virtual_console_wii_8/SI_WiiVC_SuperSmashBros_image1600w.jpg',
            host: 'SmashFan64',
            gameIcon: 'https://upload.wikimedia.org/wikipedia/commons/4/49/Smash_Ball.png',
            attendees: 12}
      ]
    },
    {
      slug: 'street-fighter-6',
      title: 'Street Fighter 6',
      logo: 'https://upload.wikimedia.org/wikipedia/fr/0/0d/Street_Fighter_6_Logo.png',
      heroImages: [
        'https://images.ctfassets.net/pc3i4f5nnp8d/57LSR6A8Yj0uxaH4jVAWGU/9fe9500d843fc5182b19a4b9121159b4/biborg-work-capcom-street-fighter-6-header.jpg',
      ],
      image: 'https://images.ctfassets.net/pc3i4f5nnp8d/57LSR6A8Yj0uxaH4jVAWGU/9fe9500d843fc5182b19a4b9121159b4/biborg-work-capcom-street-fighter-6-header.jpg',
      meta: 'Simple',
      icon: 'https://i.namu.wiki/i/CfsnouckJelqkPyvdgXgggneRTemrvPhfX35P1nQHFkAJkgVLx4NoXBQDXvU3W2DH9DRy-J6hbwHD_Xc7ivzlg.webp',
      additionalInfo: ['Number of tournaments :', 'Text', 'Text'],
      tournaments: [
        {
          title: 'SF6 Regional',
          slug: 'sf6-tournament-1',
          date: '2025-09-01',
          location: 'Roubaix',
          image: 'https://img.redbull.com/images/c_limit,w_1500,h_1000/f_auto,q_auto/redbullcom/2023/5/12/ygwolv4feczcbkfkkgoz/red-bull-kumite-2023',
          host: 'SFFan',
          gameIcon: 'https://i.namu.wiki/i/CfsnouckJelqkPyvdgXgggneRTemrvPhfX35P1nQHFkAJkgVLx4NoXBQDXvU3W2DH9DRy-J6hbwHD_Xc7ivzlg.webp',
          attendees: 20
        }
      ]
    },
    {
      slug: 'super-smash-bros-melee',
      title: 'Super Smash Bros. Melee',
      image: 'https://assets-prd.ignimgs.com/2022/01/08/super-smash-bros-melee-button-crop-1641601540515.jpg',
      meta: 'Some meta about the game',
      icon: 'https://cdn2.steamgriddb.com/icon/e0688d13958a19e087e123148555e4b4.png',
      additionalInfo: ['Number of tournaments :', 'Text', 'Text'],
      tournaments: [] 
    },
    {
      slug: 'dragon-ball-fighterz',
      title: 'Dragon Ball Fighterz',
      image: 'https://cdn11.bigcommerce.com/s-k0hjo2yyrq/images/stencil/1280x1280/products/1020/388/Dragon_Ball_Fighterz_Pass_1_Season_Pass_Product_Banner__19643.1726748293.jpg?c=1',
      meta: 'Some meta about the game',
      icon: 'https://cdn2.steamgriddb.com/icon/33ebd5b07dc7e407752fe773eed20635/32/256x256.png',
      additionalInfo: ['Number of tournaments :', 'Text', 'Text'],
      tournaments: [] 
    },
  ];

  constructor() {
    this.games.forEach(game => {
      const tournamentCount = game.tournaments?.length ?? 0;
      game.additionalInfo = game.additionalInfo.map(info =>
        info === 'Number of tournaments :' ? `Number of tournaments: ${tournamentCount}` : info
      );
    });
  }

  getAllGames() {
    return this.games;
  }

  getAllTournaments() {
    return this.games.flatMap(game => game.tournaments || []);
  }

  getGameBySlug(slug: string) {
    return this.games.find(g => g.slug === slug);
  }
}
