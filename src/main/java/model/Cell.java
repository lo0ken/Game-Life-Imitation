package model;

class Cell {
    private State state;
    private State nextState;
    private Cell[] neighbors;

    Cell(State state) {
        this.state = state;
    }

    void setNeighbors(Cell[] neighbors) {
        this.neighbors = neighbors;
    }

    void changeState() {
        state = nextState;
    }

    public void calculateNextState() {
        State nextState = state;
        int aliveNeighbors = calculateAliveNeighbors();

        if (aliveNeighbors < 2 || aliveNeighbors > 3) {
            nextState =  State.DEAD;
        }

        if (aliveNeighbors == 2 || aliveNeighbors == 3) {
            nextState =  State.ALIVE;
        }

        this.nextState = nextState;
    }

    private int calculateAliveNeighbors() {
        int alive = 0;
        for (Cell c : neighbors) {
            alive += c.state.ordinal();
        }
        return alive;
    }

    @Override
    public String toString() {
        return Integer.toString(state.ordinal());
    }
}
