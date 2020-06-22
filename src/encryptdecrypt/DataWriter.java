package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static encryptdecrypt.ArgumentsParser.ARGUMENT_OUT;

public class DataWriter {

    private final Map<String, String> options;

    public DataWriter(Map<String, String> options) {
        this.options = options;
    }

    public void writeData(String data) {
        if (options.containsKey(ARGUMENT_OUT)) {
            writeFile(options.get(ARGUMENT_OUT), data);
        } else {
            System.out.println(data);
        }
    }

    private void writeFile(String fileName, String content) {
        try {
            Files.writeString(Paths.get(fileName), content);
        } catch (IOException e) {
            System.out.println("Error: cannot write file " + fileName);
        }
    }
}
