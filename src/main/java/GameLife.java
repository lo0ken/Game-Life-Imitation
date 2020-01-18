import model.Field;
import model.FieldGenerator;
import utils.GameLifeSimulator;

public class GameLife {

    public static void main(String[] args) {
        Field f = new FieldGenerator(10, 10).generate();
        GameLifeSimulator game = new GameLifeSimulator(f);
        game.start();
    }
}
