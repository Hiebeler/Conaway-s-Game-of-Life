public class Grid {
    public Cell[][] cells;
    private static final String ALIVE = "██";
    private static final String DEAD = "  ";

    public Grid(Cell[][] cells) {
        this.cells = cells;
        drawGrid();
    }

    public void updateCells() {
        Cell[][] updatedCells = new Cell[cells.length][cells[0].length];

        for (int row = 0; row < updatedCells.length; row++) {
            for (int col = 0; col < updatedCells[row].length; col++) {
                int neighbours = getNeighbours(row, col);
                boolean isAliveAfterRules = applyRules(neighbours, cells[row][col].isAlive);
                updatedCells[row][col] = new Cell(isAliveAfterRules);
            }
        }
        cells = updatedCells;
        drawGrid();
    }

    private int getNeighbours(int row, int col) {
        int neighbours = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r == row && c == col) continue;

                if (r >= 0 && r < cells.length) {
                    if (c >= 0 && c < cells[r].length){
                        neighbours += boolToInt(cells[r][c].isAlive);
                    }
                }
            }
        }

        return neighbours;
    }

    private int boolToInt(boolean bool) {
        return bool ? 1 : 0;
    }

    private boolean applyRules(int neighbours, boolean isAlive) {
        if (neighbours <= 1) {
            return false;
        } else if (neighbours >= 4) {
            return false;
        } else if (neighbours == 2 && !isAlive) {
            return false;
        }
        return true;
    }

    private void drawGrid() {
        clearScreen();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                System.out.print(cells[row][col].isAlive ? ALIVE : DEAD);
            }
            System.out.println();
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
