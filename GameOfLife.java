import java.io.IOException;

public class GameOfLife {
    private static int SPEED = 50;
    public static void main(String[] args) {
      //  try {
           // Cell[][] cells = PatternLoader.loadPattern("patterns/glider.txt");
           Cell[][] cells = initializeCells(40, 40);
            Grid grid = new Grid(cells);
            try {
                gameRunner(grid);
            } catch (InterruptedException exception) {
                System.out.println("exited");
            }
       // } catch (IOException e) {
         //   System.out.println("Error loading pattern: " + e.getMessage());
       // }
    }

    private static Cell[][] initializeCells(int width, int height) {
        Cell[][] cellsArray = new Cell[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                cellsArray[h][w] = new Cell();
            }
        }
        return cellsArray;
    }

    private static void gameRunner(Grid grid) throws InterruptedException {
        Thread.sleep(SPEED);
        while (true) {
            grid.updateCells();
            Thread.sleep(SPEED);
        }
    }
}
