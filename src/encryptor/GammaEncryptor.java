package encryptor;

import java.util.Random;

class GammaEncryptor extends TrithemiusEncryptor {
//TODO remove duplicate  code, change intrface

    String encrypt(String text, String gamma) {
        Random random = new Random(Integer.valueOf(gamma));
        StringBuilder fullGamma = new StringBuilder(gamma);
        StringBuilder res = new StringBuilder();
        while (fullGamma.length() < text.length()) {
            fullGamma.append(gamma);
        }
        for(int i = 0; i < text.length(); ++i) {
            res.append(encryptChar(text.charAt(i), random.nextInt(Character.MAX_VALUE)));
        }
        return res.toString();
    }

    String decrypt(String text, String gamma) {
        Random random = new Random(Integer.valueOf(gamma));
        StringBuilder fullGamma = new StringBuilder(gamma);
        StringBuilder res = new StringBuilder();
        while (fullGamma.length() < text.length()) {
            fullGamma.append(gamma);
        }
        for(int i = 0; i < text.length(); ++i) {
            res.append(decryptChar(text.charAt(i), random.nextInt(Character.MAX_VALUE)));
        }
        return res.toString();
    }

}
