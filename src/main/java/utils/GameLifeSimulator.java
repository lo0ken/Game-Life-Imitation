package utils;

import model.Field;

public class GameLifeSimulator extends Thread {
    private final Field field;
    private final int time;

    public GameLifeSimulator(Field field, int time) {
        this.field = field;
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i < time; i++) {
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
