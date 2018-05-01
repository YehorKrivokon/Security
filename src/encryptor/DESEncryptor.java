package encryptor;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DESEncryptor {

    String encrypt(String text, String key) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("DES");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = secretKeyFactory.generateSecret(desKeySpec);
        encryptCipher.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] unencryptedByteArray = text.getBytes("UTF8");
        byte[] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);
        byte[] encodedBytes = Base64.encodeBase64(encryptedBytes);
        return new String(encodedBytes);
    }

    String decrypt(String text, String key) throws Exception {
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = secretKeyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] decodedBytes = Base64.decodeBase64(text.getBytes());
        byte[] unencryptedByteArray = cipher.doFinal(decodedBytes);
        return new String(unencryptedByteArray, "UTF8");
    }
}
