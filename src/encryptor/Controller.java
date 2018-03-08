package encryptor;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class Controller {
    public void Controller(){}

    private Encryptor cesarEncryptor = new CesarEncryptor();
    private TrithemiusEncryptor trithemiusEncryptor = new TrithemiusEncryptor();

    @FXML
    private TextArea encryptText;

    @FXML
    private TextField shiftNumber;

    @FXML
    private void encryptTextWithPhrase() {
        String encryptedText = trithemiusEncryptor.encryptPhrase(encryptText.getText(),
                shiftNumber.getText());
        encryptText.setText(encryptedText);
    }

    @FXML
    private void decryptTextWithPhrase() {
        String encryptedText = trithemiusEncryptor.decryptPhrase(encryptText.getText(),
                shiftNumber.getText());
        encryptText.setText(encryptedText);
    }

    @FXML
    private void encryptText() {
        String encryptedText = cesarEncryptor.encrypt(encryptText.getText(),
                Integer.valueOf(shiftNumber.getText()));
        encryptText.setText(encryptedText);
    }

    @FXML
    private void decryptText() {
        String encryptedText = cesarEncryptor.decrypt(encryptText.getText(),
                Integer.valueOf(shiftNumber.getText()));
        encryptText.setText(encryptedText);
    }

    @FXML
    private void choseFile() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Get Text");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File phil = fc.showOpenDialog(new Stage());
        if (phil != null) {
            encryptText.clear();
            try {
                String content =
                        new Scanner(phil)
                                .useDelimiter("\\Z")
                                .next();
                encryptText.appendText(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void saveFile() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Get Text");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File phil = fc.showOpenDialog(new Stage());

        ObservableList<CharSequence> paragraph = encryptText.getParagraphs();
        Iterator<CharSequence> iter = paragraph.iterator();
        try
        {
            BufferedWriter bf = new BufferedWriter(new FileWriter(new File(phil.getPath())));
            while(iter.hasNext())
            {
                CharSequence seq = iter.next();
                bf.append(seq);
                bf.newLine();
            }
            bf.flush();
            bf.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void initialize(){}

}
