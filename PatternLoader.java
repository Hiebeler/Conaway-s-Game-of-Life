import java.io.*;
import java.util.*;

public class PatternLoader {
    public static Cell[][] loadPattern(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] size = reader.readLine().split(" ");
            int height = Integer.parseInt(size[0]);
            int width = Integer.parseInt(size[1]);
            int offset = Integer.parseInt(size[2]);


            Cell[][] cells = new Cell[height + offset * 2][width + offset * 2];
            
            for (int row = 0; row < height + offset * 2; row++) {
                for (int col = 0; col < width + offset * 2; col++) {
                    cells[row][col] = new Cell(false);
                }
            }

            for (int row = 0; row < height; row++) {
                String line = reader.readLine();
                for (int col = 0; col < width; col++) {
                    cells[row + offset][col + offset] = new Cell(line.charAt(col) == 'O'); // 'O' is alive
                }
            }

            return cells;
        }
    }
}