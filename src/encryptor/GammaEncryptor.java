package encryptor;

import java.util.Random;

class GammaEncryptor extends CesarEncryptor {

    private final Random random = new Random();

    String encrypt(String text, String gamma) {
        StringBuilder fullGamma = new StringBuilder(gamma);
        StringBuilder res = new StringBuilder();
        while (fullGamma.length() < text.length()) {
            fullGamma.append(gamma);
        }
        for(int i = 0; i < text.length(); ++i) {
            random.setSeed((int) fullGamma.charAt(i));
            res.append(encryptChar(text.charAt(i), random.nextInt(Character.MAX_VALUE)));
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
            random.setSeed((int) fullGamma.charAt(i));
            res.append(decryptChar(text.charAt(i), random.nextInt(Character.MAX_VALUE)));
        }
        return res.toString();
    }

}
