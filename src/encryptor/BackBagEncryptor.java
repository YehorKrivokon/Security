package encryptor;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackBagEncryptor {

    String encrypt(String text, String key, int m, int n) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        String arr[] = key.split(" ");
        for (String anArr : arr) {
            sum += Integer.valueOf(anArr);
        }
        int b[] = new int[arr.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = (Integer.valueOf(arr[i]) * n) % m;
        }

        char[] chars = text.toCharArray();
        for (char ch : chars ) {
            int secretSum = 0;
            char[] c = new char[8];
            for (int i = 0; i < (c.length - Integer.toBinaryString(ch).toCharArray().length); i ++ ){
                c[i] = '0';
            }
            for (int i = c.length - Integer.toBinaryString(ch).toCharArray().length; i < c.length; i ++) {
                c[i] = Integer.toBinaryString(ch).toCharArray()[i - (c.length - Integer.toBinaryString(ch).toCharArray().length)];
            }
            for (int i = 0; i < c.length; i++) {
                secretSum += Integer.valueOf("" + c[i]) * b[i];
            }
            result.append(secretSum + " ");
        }
        return new String(result);
    }

    String decrypt(String encryptedKey, String key, int m, int n) {
        StringBuilder result = new StringBuilder();
        BigInteger nBI = new BigInteger(String.valueOf(n));
        BigInteger mBI = new BigInteger(String.valueOf(m));
        Integer mult = nBI.modInverse(mBI).intValue();
        String keyArr[] = key.split(" ");
        String encryptedKeyArr[] = encryptedKey.split(" ");

        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < encryptedKeyArr.length; i ++) {
            int mMult = Integer.valueOf(encryptedKeyArr[i]) * mult % m;
            while (mMult > 0) {
                int max = getMaxLessThan(keyArr, mMult);
                positions.add(Arrays.asList(keyArr).indexOf(max + ""));
                mMult -= max;
            }

            int[] binary = new int[keyArr.length];
            for (int q = 0; q < positions.size(); q++) {
                binary[positions.get(q)] = 1;
            }

            char[] chars = new char[binary.length/8];
            for (int q = 0; q < chars.length; ++q) {
                int c = 0;
                for (int j = q * 8; j < (q + 1) * 8; ++j) {
                    c = c << 1;
                    c += binary[j];
                }
                chars[q] = (char)c;
            }

            result.append(new String(chars));
            positions.clear();
        }

        return new String(result);
    }

    int getMaxLessThan(String[] arr, int a) {
        int result = 0;
        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            arrInt[i] = Integer.valueOf(arr[i]);
        }
        Arrays.sort(arrInt);
        for (int i = arrInt.length - 1; i >= 0; i --) {
            if (arrInt[i] <= a) {
               result = arrInt[i];
               break;
            }
        }
        return result;
    }

}
