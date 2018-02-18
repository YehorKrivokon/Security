package sample;

public class CesarEncryptor {

    public static String encrypt(String text, int shiftNumber) {
        if(text.isEmpty()) {
            throw new RuntimeException("Text is empty");
        } else {
            StringBuilder res = new StringBuilder();

            for(int i = 0; i < text.length(); ++i) {
                res.append(encryptChar(text.charAt(i), shiftNumber));
            }

            return res.toString();
        }
    }

    public static String decrypt(String text, int shiftNumber) {
        if(text.isEmpty()) {
            throw new RuntimeException("Text is empty");
        } else {
            StringBuilder res = new StringBuilder();

            for(int i = 0; i < text.length(); ++i) {
                res.append(decryptChar(text.charAt(i), shiftNumber));
            }

            return res.toString();
        }
    }

    private static char encryptChar(char c, int shiftNumber) {
        return (char)(c + shiftNumber);
    }

    private static char decryptChar(char c, int shiftNumber) {
        return (char)(c - shiftNumber);
    }
}
