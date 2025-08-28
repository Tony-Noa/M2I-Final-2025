import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MatchType } from '../../models/match';
import { MatchPopup } from '../match-popup/match-popup';

@Component({
  selector: 'app-match',
  imports: [MatchPopup],
  templateUrl: './match.html',
  styleUrl: './match.css'
})
export class Match {
  @Input() match!: MatchType;
  @Output() haveAWinner = new EventEmitter<MatchType>();

  showPopup: boolean = false;

  openPopup() {
    this.showPopup = true;  
  }

  changeBracket(haveAWinner:boolean){
    if(haveAWinner)
      this.haveAWinner.emit(this.match);
  }
}
