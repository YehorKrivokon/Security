package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    public void Controller(){}

    @FXML
    private TextArea encryptText;

    @FXML
    private TextArea handledText;

    @FXML
    private TextField shiftNumber;

    @FXML
    private void encryptText() {
        String encryptedText = CesarEncryptor.encrypt(encryptText.getText(),
                Integer.valueOf(shiftNumber.getText()));
        handledText.setText(encryptedText);
    }

    @FXML
    private void decryptText() {
        String decryptedText = CesarEncryptor.decrypt(encryptText.getText(),
                Integer.valueOf(shiftNumber.getText()));
        handledText.setText(decryptedText);
    }

    private void initialize(){}

}
