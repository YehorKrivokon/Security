package encryptor;

public class CesarEncryptor extends Encryptor {

    @Override
    public String encrypt(String text, int shiftNumber) {
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

    @Override
    public String decrypt(String text, int shiftNumber) {
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

    private char encryptChar(char c, int shiftNumber) {
        return (char)(c + shiftNumber);
    }

    private char decryptChar(char c, int shiftNumber) {
        return (char)(c - shiftNumber);
    }
}
