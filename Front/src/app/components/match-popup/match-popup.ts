import { Component, EventEmitter, Input, Output } from '@angular/core';
import { endMatch, MatchType } from '../../models/match';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-match-popup',
  imports: [FormsModule],
  templateUrl: './match-popup.html',
  styleUrl: './match-popup.css'
})
export class MatchPopup {

  @Input() visible = false;
  @Input() match!: MatchType;
  @Output() closed = new EventEmitter<boolean>();

  close() {
    this.visible = false;
    this.closed.emit(false);
  }

  register(){
    endMatch(this.match);
    this.closed.emit(true);
  }
}
