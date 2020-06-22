package encryptdecrypt;

import java.util.Map;

import static encryptdecrypt.ArgumentsParser.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String> options = new ArgumentsParser(args).parse();
        DataReader dataReader = new DataReader(options);
        DataWriter dataWriter = new DataWriter(options);
        Crypto crypto = new Crypto();
        crypto.setAlgorithm(options.get(ARGUMENT_ALG));

        switch (options.get(ARGUMENT_MODE)) {
            case MODE_ENC:
                String encrypted = crypto.encrypt(dataReader.getData(), Integer.parseInt(options.get(ARGUMENT_KEY)));
                dataWriter.writeData(encrypted);
                break;
            case MODE_DEC:
                String decrypted = crypto.decrypt(dataReader.getData(), Integer.parseInt(options.get(ARGUMENT_KEY)));
                dataWriter.writeData(decrypted);
                break;
            default:
                System.out.println("Error: encryption mode not supported! Supported values are: [enc|dec]");
        }
    }
}
