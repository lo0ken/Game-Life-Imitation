package utils;

import generators.FileFieldGenerator;
import generators.RandomFieldGenerator;
import model.Field;

import java.io.FileNotFoundException;
import java.util.Map;

public class SimulatorBuilder {
    public static GameLifeSimulator getSimulatorWithOptions(Map<String, String> options) throws FileNotFoundException {
        String fieldtype = options.get("fieldtype");
        int time = Integer.parseInt(options.get("time"));

        checkFieldtype(fieldtype);
        checkTime(time);

        FieldFactory fieldFactory;

        switch (options.get("fieldtype")) {
            case "random" :
                int m = Integer.parseInt(options.get("m"));
                int n = Integer.parseInt(options.get("n"));
                checkSize(m);
                checkSize(n);
                fieldFactory = new FieldFactory(new RandomFieldGenerator(m, n));
                break;

            case "file" :
                fieldFactory = new FieldFactory(new FileFieldGenerator(options.get("filename")));
                break;

            default :
                throw new IllegalArgumentException("Illegal argument fieldtype! Should be \"random\" or \"file\"");
        }
        return new GameLifeSimulator(fieldFactory.getInstance(), time);
    }

    private static void checkFieldtype(String fieldtype) {
        if (!(fieldtype.equals("random") || fieldtype.equals("file"))) {
            throw new IllegalArgumentException("Wrong fieltype!");
        }
    }

    private static void checkSize(int size) {
        if (size < 3) {
            throw  new IllegalArgumentException("Wrong size!");
        }
    }

    private static void checkTime(int time) {
        if (time < 1) {
            throw new IllegalArgumentException("Wrong time option! Should be not less than 1");
        }
    }
}
