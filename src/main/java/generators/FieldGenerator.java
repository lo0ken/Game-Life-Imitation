package generators;

import model.Cell;
import model.Field;
import model.State;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FieldGenerator {
    private static CellHelper cellHelper = new CellHelper();

    public static Field generateRandomField(int m, int n) {
        Random random = new Random();

        Cell[][] cells = new Cell[m][n];
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
        cellHelper.setNeighbors(cells);
        return new Field(m, n, cells);
    }

    public static Field generateFieldFromFile(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<>();
            while (br.ready()) {
                lines.add(br.readLine());
            }
            br.close();

            int m = lines.size();
            int n = lines.get(0).split(" ").length;
            Cell[][] cells = new Cell[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    String[] line = lines.get(i).split(" ");

                    int state = Integer.parseInt(line[j]);
                    if (state == 0) {
                        cells[i][j] = new Cell(State.DEAD);
                    } else if (state == 1) {
                        cells[i][j] = new Cell(State.ALIVE);
                    } else {
                        throw new IOException("Wrong data in file!");
                    }
                }
            }
            cellHelper.setNeighbors(cells);
            return new Field(m, n, cells);
        }
    }
}
