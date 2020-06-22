package encryptdecrypt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static encryptdecrypt.ArgumentsParser.ARGUMENT_DATA;
import static encryptdecrypt.ArgumentsParser.ARGUMENT_IN;

public class DataReader {

    private final Map<String, String> options;

    public DataReader(Map<String, String> options) {
        this.options = options;
    }

    public String getData() {
        if (!options.containsKey(ARGUMENT_DATA) && !options.containsKey(ARGUMENT_IN)) {
            return "";
        }

        if (options.containsKey(ARGUMENT_DATA) && options.containsKey(ARGUMENT_IN)) {
            return options.get(ARGUMENT_DATA);
        }

        if (options.containsKey(ARGUMENT_DATA)) {
            return options.get(ARGUMENT_DATA);
        }

        if (options.containsKey(ARGUMENT_IN)) {
            return readFile(options.get(ARGUMENT_IN));
        }

        return "";
    }

    private String readFile(String fileName) {
        try (InputStream is = new FileInputStream(fileName);
             BufferedInputStream bis = new BufferedInputStream(is)) {
            return new String(bis.readAllBytes());
        } catch (IOException e) {
            System.out.println("Error: cannot read file " + fileName);
            return "";
        }
    }
}
