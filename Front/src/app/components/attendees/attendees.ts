import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-attendees',
  standalone: true, 
  imports: [CommonModule], 
  templateUrl: './attendees.html',
  styleUrls: ['./attendees.css']
})
export class AttendeesComponent {
  topFilter = 'Top 3';

  attendees = [
    {
      name: 'Goku',
      avatar: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQ5teDCD10FpS85zGyU38SSpBFu7jkx40kiA&s',
      socials: ['twitter', 'twitch', 'youtube']
    },
    {
      name: 'Vegeta',
      avatar: 'https://i.pinimg.com/736x/3b/20/d7/3b20d778f3707e5b8026ddb707b133d6.jpg',
      socials: ['twitter', 'twitch', 'youtube']
    },
    {
      name: 'Gohan',
      avatar: 'https://i.pinimg.com/736x/f2/6b/cb/f26bcba1f316f7373351051c9e99b3d2.jpg',
      socials: ['twitter', 'twitch', 'youtube']
    },

    {
      name: 'Piccolo',
      avatar: 'https://i.pinimg.com/736x/dc/54/1a/dc541a84004d77aca766f4dba4556b7a.jpg',
      socials: ['twitter', 'twitch', 'youtube']
    }
  ];
  

  getSocialIcon(platform: string): string {
    const icons: Record<string, string> = {
      twitter: 'https://www.iconpacks.net/icons/1/free-twitter-icon-117-thumb.png',
      twitch: 'https://cdn-icons-png.flaticon.com/512/733/733646.png',
      youtube: 'https://static.vecteezy.com/system/resources/previews/023/987/000/non_2x/twitch-logo-twitch-logo-transparent-twitch-icon-transparent-free-free-png.png'
    };
    return icons[platform] || '';
  }
  
  

  constructor() {
    console.log('✅ AttendeesComponent is running');
  }
}
