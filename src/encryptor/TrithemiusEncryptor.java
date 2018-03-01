package encryptor;

public class TrithemiusEncryptor extends Encryptor {

    public String encryptPhrase(String text, String phrase) {
        StringBuilder textPhrase = new StringBuilder(phrase);
        while (textPhrase.length() < text.length()) {
            textPhrase.append(phrase);
        }
        int shiftNumber = 0;
        for(int i = 0; i < text.length(); ++i) {
            shiftNumber = (text.charAt(i) + textPhrase.charAt(i)) % Character.MAX_VALUE;
        }
        System.out.println(shiftNumber);
        return encrypt(text, shiftNumber);
    }

    public String decryptPhrase(String text, String phrase) {
        StringBuilder textPhrase = new StringBuilder(phrase);
        while (textPhrase.length() < text.length()) {
            textPhrase.append(phrase);
        }
        int shiftNumber = 0;
        for(int i = 0; i < text.length(); ++i) {
            shiftNumber = (text.charAt(i) + Character.MAX_VALUE - (textPhrase.charAt(i) % Character.MAX_VALUE)) % Character.MAX_VALUE;
        }
        System.out.println(shiftNumber);
        return decrypt(text, shiftNumber);
    }

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
