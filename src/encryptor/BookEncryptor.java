package encryptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class BookEncryptor {

    String encrypt(String text, String poesy) {
        StringBuilder result = new StringBuilder();
        String[] lines = poesy.split("\\r?\\n");
        ArrayList<String> missedSymbols = new ArrayList<>();
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
                    result.append((currentLine + 1) + "/" + (line.indexOf(currentSymbol) + 1) + ", ");
                } else {
                    missed++;
                    if (currentLine + 1 == lines.length) {
                        currentLine = 0;
                    } else {
                        currentLine++;
                    }
                }
            }
            if (missed == lines.length) {
                missedSymbols.add(currentSymbol);
            }
        }
        if (!missedSymbols.isEmpty()) {
            result = new StringBuilder("ERROR: this symbols are absent in the alphabet: " + missedSymbols.toString());
        }
        return result.toString();
    }

    String decrypt(String text, String poesy) {
        StringBuilder result = new StringBuilder();
        String[] lines = poesy.split("\\r?\\n");
        String clearCipher = text.replaceAll(",", "");
        String[] letters = clearCipher.split(" ");
        Arrays.stream(letters).forEach(a -> {
            String[] arr = a.split("/");
            int lineNumber = Integer.valueOf(arr[0]) - 1;
            int posNumber = Integer.valueOf(arr[1]) - 1;
            result.append(lines[lineNumber].charAt(posNumber));
        });
        return result.toString();
    }
}
