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

    private CesarEncryptor cesarEncryptor = new CesarEncryptor();
    private TrithemiusEncryptor trithemiusEncryptor = new TrithemiusEncryptor();
    private GammaEncryptor gammaEncryptor = new GammaEncryptor();

    @FXML
    private TextArea encryptText;

    @FXML
    private TextField gamma;

    @FXML
    private TextField shiftNumber;

    @FXML
    private TextField linearA;

    @FXML
    private TextField linearB;

    @FXML
    private TextField notLinearA;

    @FXML
    private TextField notLinearB;

    @FXML
    private TextField notLinearC;

    @FXML
    private TextField phrase;

    @FXML
    private void encryptTextWithGamma() {
        String encryptedText = gammaEncryptor.encrypt(encryptText.getText(), gamma.getText());
        encryptText.setText(encryptedText);
    }

    @FXML
    private void decryptTextWithGamma() {
        String encryptedText = gammaEncryptor.decrypt(encryptText.getText(), gamma.getText());
        encryptText.setText(encryptedText);
    }

    @FXML
    private void encryptTextWithTrithemiusPhrase() {
        String encryptedText = trithemiusEncryptor.encrypt(encryptText.getText(), phrase.getText());
        encryptText.setText(encryptedText);
    }

    @FXML
    private void encryptTextWithTrithemiusLinear() {
        String encryptedText = trithemiusEncryptor.encrypt(encryptText.getText(),
                Integer.valueOf(linearA.getText()),
                Integer.valueOf(linearB.getText()));
        encryptText.setText(encryptedText);
    }

    @FXML
    private void encryptTextWithTrithemiusNotLinear() {
        String encryptedText = trithemiusEncryptor.encrypt(encryptText.getText(),
                Integer.valueOf(notLinearA.getText()),
                Integer.valueOf(notLinearB.getText()),
                Integer.valueOf(notLinearC.getText()));
        encryptText.setText(encryptedText);
    }

    @FXML
    private void decryptTextWithTrithemiusPhrase() {
   //     encryptText.focusedProperty().addListener(ar);
        String encryptedText = trithemiusEncryptor.decrypt(encryptText.getText(), shiftNumber.getText());
        encryptText.setText(encryptedText);
    }

    @FXML
    private void encryptTextWithCesar() {
        String encryptedText = cesarEncryptor.encrypt(encryptText.getText(),
                Integer.valueOf(shiftNumber.getText()));
        encryptText.setText(encryptedText);
    }

    @FXML
    private void decryptTextWithTrithemiusLinear() {
        String encryptedText = trithemiusEncryptor.decrypt(encryptText.getText(),
                Integer.valueOf(linearA.getText()),
                Integer.valueOf(linearB.getText()));
        encryptText.setText(encryptedText);
    }

    @FXML
    private void decryptTextWithTrithemiusNotLinear() {
        String encryptedText = trithemiusEncryptor.decrypt(encryptText.getText(),
                Integer.valueOf(notLinearA.getText()),
                Integer.valueOf(notLinearB.getText()),
                Integer.valueOf(notLinearC.getText()));
        encryptText.setText(encryptedText);
    }

    @FXML
    private void decryptTextWithCesar() {
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
