import java.util.Random;

public class Cell {
    public Boolean isAlive;

    public Cell(Boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Cell() {
        Random random = new Random();
        boolean randomIsAlive = random.nextBoolean();
        this.isAlive = randomIsAlive;
    }


    @Override
    public String toString() {
        return isAlive.toString();
    }
}
