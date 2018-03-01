package encryptor;

public abstract class Encryptor {
    public abstract String encrypt(String text, int shiftNumber);
    public abstract String decrypt(String text, int shiftNumber);
}
