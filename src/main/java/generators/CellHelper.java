package generators;

import model.Cell;

class CellHelper {
    private static final int FIRST_ROW = 0;
    private static final int FIRST_COL = 0;

    private int LAST_ROW;
    private int LAST_COL;
    private int m;
    private int n;

    private Cell[][] cells;

    void setNeighbors(Cell[][] cells) {
        calculateCellsParams(cells);

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == FIRST_ROW && col == FIRST_COL) {
                    setNeighborsToLeftTopCell(cells[row][col]);
                } else if (row == FIRST_ROW && col == LAST_COL) {
                    setNeighborsToRightTopCell(cells[row][col]);
                } else if (row == LAST_ROW && col == FIRST_COL) {
                    setNeighborsToLeftBotCell(cells[row][col]);
                } else if (row == LAST_ROW && col == LAST_COL) {
                    setNeighborsToRightBotCell(cells[row][col]);
                } else if (row == FIRST_ROW) {
                    setNeighborsToFirstRowCell(cells[row][col], col);
                } else if (row == LAST_ROW) {
                    setNeighborsToLastRowCell(cells[row][col], col);
                } else if (col == FIRST_COL) {
                    setNeighbborsToFirstColCell(cells[row][col], row);
                } else if (col == LAST_COL) {
                    setNeighborsToLastColCell(cells[row][col], row);
                } else {
                    setNeighborsToCentralCell(cells[row][col], row, col);
                }
            }
        }
    }

    private void calculateCellsParams(Cell[][] cells) {
        this.m = cells.length;
        this.n = cells[0].length;

        if (m < 3 || n < 3) {
            throw new IllegalArgumentException("Size of field should be not less than 3!");
        }

        this.cells = cells;
        LAST_ROW = m - 1;
        LAST_COL = n - 1;
    }

    private void setNeighborsToLeftTopCell(Cell cell) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[LAST_ROW][LAST_COL];
        neighbors[1] = cells[LAST_ROW][FIRST_COL];
        neighbors[2] = cells[LAST_ROW][1];

        neighbors[3] = cells[FIRST_ROW][LAST_COL];
        neighbors[4] = cells[FIRST_ROW][1];

        neighbors[5] = cells[1][LAST_COL];
        neighbors[6] = cells[1][FIRST_COL];
        neighbors[7] = cells[1][1];

        cell.setNeighbors(neighbors);
    }

    private void setNeighborsToRightTopCell(Cell cell) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[LAST_ROW][LAST_COL - 1];
        neighbors[1] = cells[LAST_ROW][LAST_COL];
        neighbors[2] = cells[LAST_ROW][FIRST_COL];

        neighbors[3] = cells[FIRST_ROW][LAST_COL - 1];
        neighbors[4] = cells[FIRST_ROW][FIRST_COL];

        neighbors[5] = cells[1][LAST_COL - 1];
        neighbors[6] = cells[1][LAST_COL];
        neighbors[7] = cells[1][FIRST_ROW];

        cell.setNeighbors(neighbors);
    }

    private void setNeighborsToLeftBotCell(Cell cell) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[LAST_ROW - 1][LAST_COL];
        neighbors[1] = cells[LAST_ROW - 1][FIRST_COL];
        neighbors[2] = cells[LAST_ROW - 1][1];

        neighbors[3] = cells[LAST_ROW][LAST_COL];
        neighbors[4] = cells[LAST_ROW][1];

        neighbors[5] = cells[FIRST_ROW][LAST_COL];
        neighbors[6] = cells[FIRST_ROW][FIRST_COL];
        neighbors[7] = cells[FIRST_ROW][1];

        cell.setNeighbors(neighbors);
    }

    private void setNeighborsToRightBotCell(Cell cell) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[LAST_ROW - 1][LAST_COL - 1];
        neighbors[1] = cells[LAST_ROW - 1][LAST_COL];
        neighbors[2] = cells[LAST_ROW - 1][FIRST_COL];

        neighbors[3] = cells[LAST_ROW][LAST_COL - 1];
        neighbors[4] = cells[LAST_ROW][FIRST_COL];

        neighbors[5] = cells[FIRST_ROW][LAST_COL - 1];
        neighbors[6] = cells[FIRST_ROW][LAST_COL];
        neighbors[7] = cells[FIRST_ROW][FIRST_COL];

        cell.setNeighbors(neighbors);
    }

    private void setNeighborsToFirstRowCell(Cell cell, int col) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[LAST_ROW][col - 1];
        neighbors[1] = cells[LAST_ROW][col];
        neighbors[2] = cells[LAST_ROW][col + 1];

        neighbors[3] = cells[FIRST_ROW][col - 1];
        neighbors[4] = cells[FIRST_ROW][col + 1];

        neighbors[5] = cells[1][col - 1];
        neighbors[6] = cells[1][col];
        neighbors[7] = cells[1][col + 1];

        cell.setNeighbors(neighbors);
    }

    private void setNeighborsToLastRowCell(Cell cell, int col) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[LAST_ROW - 1][col - 1];
        neighbors[1] = cells[LAST_ROW - 1][col];
        neighbors[2] = cells[LAST_ROW - 1][col + 1];

        neighbors[3] = cells[LAST_ROW][col - 1];
        neighbors[4] = cells[LAST_ROW][col + 1];

        neighbors[5] = cells[FIRST_ROW][col - 1];
        neighbors[6] = cells[FIRST_ROW][col];
        neighbors[7] = cells[FIRST_ROW][col + 1];

        cell.setNeighbors(neighbors);
    }

    private void setNeighbborsToFirstColCell(Cell cell, int row) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[row - 1][LAST_COL];
        neighbors[1] = cells[row - 1][FIRST_COL];
        neighbors[2] = cells[row - 1][1];

        neighbors[3] = cells[row][LAST_COL];
        neighbors[4] = cells[row][1];

        neighbors[5] = cells[row + 1][LAST_COL];
        neighbors[6] = cells[row + 1][FIRST_COL];
        neighbors[7] = cells[row + 1][1];

        cell.setNeighbors(neighbors);
    }

    private void setNeighborsToLastColCell(Cell cell, int row) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[row - 1][LAST_COL - 1];
        neighbors[1] = cells[row - 1][LAST_COL];
        neighbors[2] = cells[row - 1][FIRST_COL];

        neighbors[3] = cells[row][LAST_COL - 1];
        neighbors[4] = cells[row][FIRST_COL];

        neighbors[5] = cells[row + 1][LAST_COL - 1];
        neighbors[6] = cells[row + 1][LAST_COL];
        neighbors[7] = cells[row + 1][FIRST_COL];

        cell.setNeighbors(neighbors);
    }

    private void setNeighborsToCentralCell(Cell cell, int row, int col) {
        Cell[] neighbors = new Cell[8];

        neighbors[0] = cells[row - 1][col - 1];
        neighbors[1] = cells[row - 1][col];
        neighbors[2] = cells[row - 1][col + 1];

        neighbors[3] = cells[row][col - 1];
        neighbors[4] = cells[row][col + 1];

        neighbors[5] = cells[row + 1][col - 1];
        neighbors[6] = cells[row + 1][col];
        neighbors[7] = cells[row + 1][col + 1];

        cell.setNeighbors(neighbors);
    }
}

