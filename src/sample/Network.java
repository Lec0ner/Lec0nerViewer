package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.util.Objects;

public class Network {

    @FXML
    private Button buttonLogOut;

    @FXML
    private Button close;

    @FXML
    private ToggleGroup group;

    @FXML
    private TextField idUser;

    @FXML
    private Button network;

    @FXML
    private Button profile;

    @FXML
    private MenuItem saveId1;

    @FXML
    private MenuItem saveId2;

    @FXML
    private Button settings;

    @FXML
    private Button user;

    @FXML
    void LogOut(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logIn.fxml")));

        Stage windowLogIn = (Stage)  buttonLogOut.getScene().getWindow();
        windowLogIn.setScene(new Scene(root,400,400));
        windowLogIn.setResizable(false);
    }

    @FXML
    void networkButton(ActionEvent event) {

    }

    @FXML
    void profileButton(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user.fxml")));

        Stage windowLogIn = (Stage)  profile.getScene().getWindow();
        windowLogIn.setScene(new Scene(root,1000,600));
        windowLogIn.setResizable(false);
    }

    @FXML
    void settingsButton(ActionEvent event) {

    }

    @FXML
    void userButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        close.setOnAction(event -> {
            close.getScene().getWindow().hide();
        });

        saveId1.setOnAction(event -> {
            idUser.setText(saveId1.getText());
        });

        saveId2.setOnAction(event -> {
            idUser.setText(saveId2.getText());
        });
    }

}