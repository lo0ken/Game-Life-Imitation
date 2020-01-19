import generators.FieldGenerator;
import model.Field;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SimulatorBuilder {
    public static GameLife getSimulatorWithOptions(Map<String, String> options) throws IOException {
        String fieldtype = options.get("-fieldtype");
        int time = Integer.parseInt(options.get("-time"));

        checkFieldtype(fieldtype);
        checkTime(time);

        Field field;

        switch (options.get("-fieldtype")) {
            case "random":
                int m = Integer.parseInt(options.get("-m"));
                int n = Integer.parseInt(options.get("-n"));

                field = FieldGenerator.generateRandomField(m, n);
                break;

            case "file":
                field = FieldGenerator.generateFieldFromFile(new File(options.get("-filepath")));
                break;

            default:
                throw new IllegalArgumentException("Illegal argument -fieldtype! Should be \"random\" or \"file\"");
        }
        return new GameLife(field, time);
    }

    private static void checkFieldtype(String fieldtype) {
        if (!(fieldtype.equals("random") || fieldtype.equals("file"))) {
            throw new IllegalArgumentException("Wrong fieltype!");
        }
    }

    private static void checkTime(int time) {
        if (time < 1) {
            throw new IllegalArgumentException("Wrong time option! Should be not less than 1");
        }
    }
}
