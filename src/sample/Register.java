package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Register {

    @FXML
    private Button buttonRegistered;

    @FXML
    private TextField emailRegister;

    @FXML
    private TextField loginRegister;

    @FXML
    private Button back;

    @FXML
    private Button close;

    @FXML
    private TextField passwordRegister;

    @FXML
    void initialize() {
        close.setOnAction(event -> {
            close.getScene().getWindow().hide();
        });
    }

    @FXML
    void backButton(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logIn.fxml")));

        Stage windowLogIn = (Stage)  back.getScene().getWindow();
        windowLogIn.setScene(new Scene(root,400,400));
        windowLogIn.setResizable(false);
    }


    @FXML
    void registreid(ActionEvent event) throws Exception {
        signUpNewUser();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logIn.fxml")));
        Stage windowLogIn = (Stage)  buttonRegistered.getScene().getWindow();
        windowLogIn.setScene(new Scene(root,400,400));
        windowLogIn.setResizable(false);

    }

    private void signUpNewUser() {
        String password = passwordRegister.getText();
        String email = emailRegister.getText();
        String login = loginRegister.getText();

        User user = new User(password, email, login);

        DatebaseHandler dbHandler = new DatebaseHandler();
        dbHandler.signUpUser(user);
    }

}
