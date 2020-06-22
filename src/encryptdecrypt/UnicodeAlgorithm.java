package encryptdecrypt;

import java.util.stream.Collectors;

public class UnicodeAlgorithm implements CryptoAlgorithm {

    @Override
    public String doEncryption(String toEncrypt, Integer key) {
        return toEncrypt.chars()
                .mapToObj(c -> (char) c)
                .map(c -> encryptChar(c, key))
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    @Override
    public String doDecryption(String toDecrypt, Integer key) {
        return toDecrypt.chars()
                .mapToObj(c -> (char) c)
                .map(c -> decryptChar(c, key))
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    private Character encryptChar(Character c, Integer key) {
        return (char) (c + key);
    }

    private Character decryptChar(Character c, int key) {
        return (char) (c - key);
    }
}
