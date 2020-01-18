package model;

public class Cell {
    public State state;
    private Cell[] neighbors;

    public Cell(State state) {
        this.state = state;
    }

    public Cell[] getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Cell[] neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return Integer.toString(state.ordinal());
    }
}
