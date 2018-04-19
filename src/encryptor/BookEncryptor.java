package encryptor;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BookEncryptor {

    public String encrypt(String text, String poesy) {
        StringBuilder result = new StringBuilder();
        String[] lines = poesy.split("\\r?\\n");
        for (int i = 0; i < text.length(); i ++) {
            int startLine = new Random().nextInt(lines.length);
            int currentLine = startLine;
            String currentSymbol = String.valueOf(text.charAt(i));
            boolean finded = false;
            int missed = 1;
            while (!finded && missed < lines.length) {
                String line = lines[currentLine];
                if (line.contains(currentSymbol)) {
                    finded = true;
                    result.append((currentLine + 1) + "|" + (line.indexOf(currentSymbol) + 1) + ", ");
                } else {
                    missed++;
                    if (currentLine + 1 == lines.length) {
                        currentLine = 0;
                    } else {
                        currentLine++;
                    }
                }
            }
        }
        return result.toString();
    }

    public String decrypt(String text, String poesy) {
        StringBuilder result = new StringBuilder();
        String[] lines = poesy.split("\\r?\\n");
        for (int i = 0; i < text.length(); i ++) {
            int startLine = new Random().nextInt(lines.length);
            int currentLine = startLine;
            String currentSymbol = String.valueOf(text.charAt(i));
            boolean finded = false;
            int missed = 1;
            while (!finded && missed < lines.length) {
                String line = lines[currentLine];
                if (line.contains(currentSymbol)) {
                    finded = true;
                    result.append((currentLine + 1) + "|" + (line.indexOf(currentSymbol) + 1) + ", ");
                } else {
                    missed++;
                    if (currentLine + 1 == lines.length) {
                        currentLine = 0;
                    } else {
                        currentLine++;
                    }
                }
            }
        }
        return result.toString();
    }
}
