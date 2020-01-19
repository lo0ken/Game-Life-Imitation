import model.Field;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameLife extends Thread {

    private final Field field;
    private final int time;

    public GameLife(Field field, int time) {
        this.field = field;
        this.time = time;
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> params = new HashMap<String, String>() {{
            put("-fieldtype", "file");
            put("-filepath", "field.txt");
            put("-m", "10");
            put("-n", "10");
            put("-time", "10");
        }};

        for (String arg : args) {
            if (arg.contains("-fieldtype=")) {
                params.replace("-fieldtype", arg.substring(arg.indexOf("=") + 1));
            } else if (arg.contains("-filepath=")) {
                params.replace("-filepath", arg.substring(arg.indexOf("=") + 1));
            } else if (arg.contains("-m=")) {
                params.replace("-m", arg.substring(arg.indexOf("=") + 1));
            } else if (arg.contains("-n=")) {
                params.replace("-n", arg.substring(arg.indexOf("=") + 1));
            } else if (arg.contains("-time=")) {
                params.replace("-time", arg.substring(arg.indexOf("=") + 1));
            }
        }

        SimulatorBuilder.getSimulatorWithOptions(params).start();
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
