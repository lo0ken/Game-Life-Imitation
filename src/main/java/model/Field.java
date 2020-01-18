package model;

public class Field {
    private final int M;
    private final int N;
    private Cell[][] cells;

    Field(int m, int n, Cell[][] cells) {
        M = m;
        N = n;
        this.cells = cells;
    }

    @Override
    public String toString() {
        StringBuilder field = new StringBuilder();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                field.append(String.format("%3s", cells[i][j]));
            }
            field.append(System.lineSeparator());
        }

        return field.toString();
    }
}