package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Profile {


    @FXML
    private Button buttonLogOut;

    @FXML
    private Label username;

    @FXML
    private Button close;

    @FXML
    private TextField password;

    @FXML
    private Button network;

    @FXML
    private Button refreshButton;

    @FXML
    private Button userButton;

    @FXML
    void LogOut(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logIn.fxml")));

        Stage windowLogIn = (Stage)  buttonLogOut.getScene().getWindow();
        windowLogIn.setScene(new Scene(root,400,400));
        windowLogIn.setResizable(false);

    }



    @FXML
    void initialize() {
        close.setOnAction(event -> {
            close.getScene().getWindow().hide();
        });

        refreshButton.setOnAction(event -> {
            password.setText(getAlphaNumericString());
        });

    }

    @FXML
    void networkButton(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("network.fxml")));

        Stage windowLogIn = (Stage)  network.getScene().getWindow();
        windowLogIn.setScene(new Scene(root,1000,600));
        windowLogIn.setResizable(false);
    }

    // функция для генерации случайной строки
    public static String getAlphaNumericString()
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();

    }

}
