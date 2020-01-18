package utils;

import model.Field;

public class GameLifeSimulator extends Thread {
    private Field field;

    public GameLifeSimulator(Field field) {
        this.field = field;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(field);
            field.nextStep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
