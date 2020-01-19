package model;

public class Field {
    public final int m;
    public final int n;
    private Cell[][] cells;

    public Field(int m, int n, Cell[][] cells) {
        this.m = m;
        this.n = n;
        this.cells = cells;
    }

    public void nextStep() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j].calculateNextState();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j].changeState();
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder field = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                field.append(String.format("%3s", cells[i][j]));
            }
            field.append(System.lineSeparator());
        }

        return field.toString();
    }
}
