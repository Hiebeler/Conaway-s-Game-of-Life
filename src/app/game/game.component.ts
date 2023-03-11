import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})

export class GameComponent implements OnInit {

  matrixArray:number[][] = [];

  ngOnInit(): void {
    this.generateMatrixArray();
  }

  generateMatrixArray() {
    for (let i = 0; i < 10; i++) {
      this.matrixArray[i] = [];
      for (let j = 0; j < 20; j++) {
        this.matrixArray[i][j] = 0;
      }
    }
    console.log(this.matrixArray)
  }

}
