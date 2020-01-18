import utils.SimulatorBuilder;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class GameLife {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> params = new HashMap<String, String>() {{
            put("fieldtype", "random");
            put("filepath", "field.txt");
            put("m", "10");
            put("n", "10");
            put("time", "10");
        }};

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-fieldtype")) {
                params.put("fieldtype", args[i].substring(args[i].indexOf("=") + 1));
            }
            else if (args[i].equals("-m")) {
                params.put("m", args[i].substring(args[i].indexOf("=") + 1));
            }
            else if (args[i].equals("-n")) {
                params.put("n", args[i].substring(args[i].indexOf("=") + 1));
            }
            else if (args[i].equals("-time")) {
                params.put("time", args[i].substring(args[i].indexOf("=") + 1));
            }
        }

        SimulatorBuilder.getSimulatorWithOptions(params).start();
    }
}
