package encryptdecrypt;

public interface CryptoAlgorithm {
    String doEncryption(String toEncrypt, Integer key);
    String doDecryption(String toDecrypt, Integer key);
}
