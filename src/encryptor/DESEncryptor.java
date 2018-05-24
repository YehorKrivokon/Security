package encryptor;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DESEncryptor {

    String encrypt(String text, String key) throws Exception {
        Cipher cipher = getCipher(key, Cipher.ENCRYPT_MODE);
        byte[] unencryptedByteArray = text.getBytes("UTF8");
        byte[] encryptedBytes = cipher.doFinal(unencryptedByteArray);
        byte[] encodedBytes = Base64.encodeBase64(encryptedBytes);
        return new String(encodedBytes);
    }

    String decrypt(String text, String key) throws Exception {
        Cipher cipher = getCipher(key, Cipher.DECRYPT_MODE);
        byte[] decodedBytes = Base64.decodeBase64(text.getBytes());
        byte[] unencryptedByteArray = cipher.doFinal(decodedBytes);
        return new String(unencryptedByteArray, "UTF8");
    }

    private Cipher getCipher(String key, int mode) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = secretKeyFactory.generateSecret(desKeySpec);
        cipher.init(mode, desKey);
        return cipher;
    }
}
