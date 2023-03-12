import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss'],
})
export class GameComponent implements OnInit {
  matrixArray: boolean[][] = [];
  interval: any;
  running: boolean = false;


  ngOnInit(): void {
    this.generateMatrixArray();
  }

  generateMatrixArray() {
    for (let i = 0; i < 50; i++) {
      this.matrixArray[i] = [];
      for (let j = 0; j < 33; j++) {
        this.matrixArray[i][j] = false;
      }
    }
  }

  clickCell(cell: number, row: number) {
    this.matrixArray[cell][row] = !this.matrixArray[cell][row];
  }

  startGame() {
    this.running = true;
    this.interval = setInterval(() => this.gameCycle(), 1000);
  }

  pauseGame() {
    this.running = false;
    clearInterval(this.interval);
  }

  resetBoard() {
    this.generateMatrixArray();
  }

  gameCycle() {
    let newMatrixArray: boolean[][] = [];
    for (let column = 0; column < this.matrixArray.length; column++) {
      newMatrixArray.push([]);
      for (let row = 0; row < this.matrixArray[column].length; row++) {
        let neighbours = this.getNeighboursCount(column, row);
        let status = this.matrixArray[column][row];
        let newStatus = this.ruleBook(status, neighbours);
        newMatrixArray[column].push(newStatus);
      }
    }
    this.matrixArray = newMatrixArray;
  }

  getNeighboursCount(column: number, row: number) {
    let neighbours = 0;
    for (let col = column - 1; col <= column + 1; col++) {
      for (let rowId = row - 1; rowId <= row + 1; rowId++) {
        if (col < 0 || rowId < 0) continue;
        if (
          col >= this.matrixArray.length ||
          rowId >= this.matrixArray[col].length
        )
          continue;
        if (col == column && rowId == row) continue;
        if (this.matrixArray[col][rowId]) neighbours++;
      }
    }
    return neighbours;
  }

  ruleBook(status: boolean, neighbours: number): boolean {
    if (status) return this.aliveRules(neighbours);
    else return this.deadRules(neighbours);
  }

  aliveRules(neighbours: number): boolean {
    if (neighbours <= 1) return false;
    else if (neighbours >= 4) return false;
    else return true;
  }

  deadRules(neighbours: number): boolean {
    if (neighbours === 3) return true;
    else return false;
  }
}
