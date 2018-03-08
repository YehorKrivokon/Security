package encryptor;

public class TrithemiusEncryptor extends Encryptor {

    public String encryptPhrase(String text, String phrase) {
        StringBuilder textPhrase = new StringBuilder(phrase);
        StringBuilder res = new StringBuilder();
        while (textPhrase.length() < text.length()) {
            textPhrase.append(phrase);
        }
        int shiftNumber = 0;
        for(int i = 0; i < text.length(); ++i) {
            res.append(encryptChar(text.charAt(i),(text.charAt(i) + textPhrase.charAt(i)) % Character.MAX_VALUE));
        }
        System.out.println(5 % 1000);
        System.out.println(shiftNumber);
        System.out.println(textPhrase);
        return res.toString();
    }

    public String decryptPhrase(String text, String phrase) {
        StringBuilder textPhrase = new StringBuilder(phrase);
        StringBuilder res = new StringBuilder();
        while (textPhrase.length() < text.length()) {
            textPhrase.append(phrase);
        }
        int shiftNumber = 0;
        for(int i = 0; i < text.length(); ++i) {
            res.append(decryptChar(text.charAt(i),(text.charAt(i) - textPhrase.charAt(i)) % Character.MAX_VALUE));
        }
        System.out.println(5 % 1000);
        System.out.println(shiftNumber);
        System.out.println(textPhrase);
        return res.toString();
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
