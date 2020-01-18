package generators;

import generators.FieldGenerator;
import model.Cell;
import model.Field;
import model.State;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileFieldGenerator implements FieldGenerator {

    private FileReader file;

    public FileFieldGenerator(String fileName) throws FileNotFoundException {
        file = new FileReader(fileName);
    }

    public Field generate() {
        try (BufferedReader fileReader = new BufferedReader(file)) {
            List<String> lines = new ArrayList<>();

            while (fileReader.ready()) {
                lines.add(fileReader.readLine());
            }
            int m = lines.get(0).split(" ").length;
            int n = lines.size();

            Cell[][] cells = new Cell[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    String[] line = lines.get(i).split(" ");
                    int state = Integer.parseInt(line[j]);
                    cells[i][j] = new Cell(state == 1 ? State.ALIVE : State.DEAD);
                }
            }

            return new Field(m, n, cells);
        } catch (IOException e) {
            throw new IllegalArgumentException("Data in files is wrong!");
        }
    }
}
