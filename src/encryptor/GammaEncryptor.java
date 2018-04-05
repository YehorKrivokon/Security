package encryptor;

import java.util.Random;

class GammaEncryptor extends CesarEncryptor {

    String encrypt(String text, String gamma) {
        StringBuilder fullGamma = new StringBuilder(gamma);
        StringBuilder res = new StringBuilder();
        while (fullGamma.length() < text.length()) {
            fullGamma.append(gamma);
        }
        for(int i = 0; i < text.length(); ++i) {
            res.append(encryptChar(text.charAt(i),
                    new Random((int) fullGamma.charAt(i))
                            .nextInt(Character.MAX_VALUE)));
        }
        return res.toString();
    }

    String decrypt(String text, String gamma) {
        StringBuilder fullGamma = new StringBuilder(gamma);
        StringBuilder res = new StringBuilder();
        while (fullGamma.length() < text.length()) {
            fullGamma.append(gamma);
        }
        for(int i = 0; i < text.length(); ++i) {
            res.append(decryptChar(text.charAt(i),
                    new Random((int) fullGamma.charAt(i))
                            .nextInt(Character.MAX_VALUE)));
        }
        return res.toString();
    }

}
