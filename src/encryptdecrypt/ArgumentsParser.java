package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsParser {

    public static final String ARGUMENT_MODE = "-mode";
    public static final String ARGUMENT_KEY = "-key";
    public static final String ARGUMENT_DATA = "-data";
    public static final String ARGUMENT_IN = "-in";
    public static final String ARGUMENT_OUT = "-out";
    public static final String ARGUMENT_ALG = "-alg";

    public static final String MODE_ENC = "enc";
    public static final String MODE_DEC = "dec";
    public static final String SHIFT = "shift";
    public static final String UNICODE = "unicode";

    private final String[] arguments;

    public ArgumentsParser(String[] arguments) {
        this.arguments = arguments;
    }

    public Map<String, String> parse() {
        Map<String, String> argumentsMap = new HashMap<>();
        for (int i = 0; i < arguments.length - 1; i++) {
            switch (arguments[i]) {
                case ARGUMENT_MODE:
                    argumentsMap.put(ARGUMENT_MODE, arguments[i + 1]);
                    break;
                case ARGUMENT_KEY:
                    argumentsMap.put(ARGUMENT_KEY, arguments[i + 1]);
                    break;
                case ARGUMENT_DATA:
                    argumentsMap.put(ARGUMENT_DATA, arguments[i + 1]);
                    break;
                case ARGUMENT_IN:
                    argumentsMap.put(ARGUMENT_IN, arguments[i + 1]);
                    break;
                case ARGUMENT_OUT:
                    argumentsMap.put(ARGUMENT_OUT, arguments[i + 1]);
                    break;
                case ARGUMENT_ALG:
                    argumentsMap.put(ARGUMENT_ALG, arguments[i + 1]);
                    break;
            }
        }
        argumentsMap.putIfAbsent(ARGUMENT_MODE, MODE_ENC);
        argumentsMap.putIfAbsent(ARGUMENT_KEY, "0");
        argumentsMap.putIfAbsent(ARGUMENT_ALG, SHIFT);

        return argumentsMap;
    }
}
