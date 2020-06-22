package encryptdecrypt;

import java.util.stream.Collectors;

public class ShiftAlgorithm implements CryptoAlgorithm {
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
        int shifted = c;
        if (c >= 97 && c <= 122) {
            shifted += key;
            if (shifted > 122) {
                shifted = 97 + shifted % 122 - 1;
            }
        } else if (c >= 65 && c <= 90) {
            shifted += key;
            if (shifted > 90) {
                shifted = 65 + shifted % 90 - 1;
            }
        }
        return (char) shifted;
    }

    private Character decryptChar(Character c, int key) {
        int shifted = c;
        if (c >= 97 && c <= 122) {
            shifted -= key;
            if (shifted < 97) {
                shifted = 122 - 97 % shifted + 1;
            }
        } else if (c >= 65 && c <= 90) {
            shifted -= key;
            if (shifted < 65) {
                shifted = 90 - 65 % shifted + 1;
            }
        }
        return (char) shifted;
    }
}
