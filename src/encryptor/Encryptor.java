package encryptor;

abstract class Encryptor {
    abstract String encrypt(String text, int shiftNumber);
    abstract String decrypt(String text, int shiftNumber);

    char encryptChar(char c, int shiftNumber) {
        return (char)(c + shiftNumber);
    }

    char decryptChar(char c, int shiftNumber) {
        return (char)(c - shiftNumber);
    }
}
