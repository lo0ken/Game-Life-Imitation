package generators;

import model.Cell;
import model.Field;
import model.State;

import java.util.Random;

public class RandomFieldGenerator implements FieldGenerator{
    protected final int m;
    protected final int n;
    protected final Cell[][] cells;

    public RandomFieldGenerator(int m, int n) {
        this.m = m;
        this.n = n;

        cells = new Cell[m][n];
    }

    public Field generate() {
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int chance = random.nextInt(10);
                if (chance == State.ALIVE.ordinal()) {
                    cells[i][j] = new Cell(State.ALIVE);
                } else {
                    cells[i][j] = new Cell(State.DEAD);
                }
            }
        }

        return new Field(m, n, cells);
    }
}
