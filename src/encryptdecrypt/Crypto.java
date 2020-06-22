package encryptdecrypt;

import static encryptdecrypt.ArgumentsParser.SHIFT;
import static encryptdecrypt.ArgumentsParser.UNICODE;

public class Crypto {

    private CryptoAlgorithm algorithm;

    public void setAlgorithm(String algorithm) {
        switch (algorithm) {
            case SHIFT:
                this.algorithm = new ShiftAlgorithm();
                break;
            case UNICODE:
                this.algorithm = new UnicodeAlgorithm();
                break;
            default:
                throw new UnsupportedOperationException("Algorithm " + algorithm + " not supported!");
        }
    }

    public String encrypt(String toEncrypt, Integer key) {
        return algorithm.doEncryption(toEncrypt, key);
    }

    public String decrypt(String toDecrypt, Integer key) {
        return algorithm.doDecryption(toDecrypt, key);
    }
}
