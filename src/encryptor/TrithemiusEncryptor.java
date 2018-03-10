package encryptor;

class TrithemiusEncryptor extends CesarEncryptor {

    String encrypt(String text, String phrase) {
        StringBuilder textPhrase = new StringBuilder(phrase);
        StringBuilder res = new StringBuilder();
        while (textPhrase.length() < text.length()) {
            textPhrase.append(phrase);
        }
        for(int i = 0; i < text.length(); ++i) {
            res.append(encryptChar(text.charAt(i), textPhrase.charAt(i)));
        }
        return res.toString();
    }

    String encrypt(String text, int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < text.length(); ++i) {
            res.append(encryptChar(text.charAt(i), a * i * i + b * i + c));
        }
        return res.toString();
    }

    String encrypt(String text, int a, int b) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < text.length(); ++i) {
            res.append(encryptChar(text.charAt(i), a * i + b));
        }
        return res.toString();
    }

    String decrypt(String text, String phrase) {
        StringBuilder textPhrase = new StringBuilder(phrase);
        StringBuilder res = new StringBuilder();
        while (textPhrase.length() < text.length()) {
            textPhrase.append(phrase);
        }
        for(int i = 0; i < text.length(); ++i) {
            res.append(decryptChar(text.charAt(i),textPhrase.charAt(i)));
        }
        return res.toString();
    }

    String decrypt(String text, int a, int b) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < text.length(); ++i) {
            res.append(decryptChar(text.charAt(i), a * i + b));
        }
        return res.toString();
    }

    String decrypt(String text, int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < text.length(); ++i) {
            res.append(decryptChar(text.charAt(i), a * i * i + b * i + c));
        }
        return res.toString();
    }


}
