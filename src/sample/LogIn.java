package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LogIn {

    ResultSet resultUser;

    @FXML
    private Button buttonLogIn;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button close;

    @FXML
    private Label errorLogin;

    /**
     * Проверка на наличие данных в полях логин, пароль.
     * Проверка на соответствие данных с данными в базе Х
     **/

    @FXML
    void buttonLoginToMain(ActionEvent event) throws Exception {
        String loginText = login.getText().trim();
        String loginPassword = password.getText().trim();

        if (!loginText.equals("") && !loginPassword.equals(""))
            loginUser(loginText, loginPassword);
        else {
            errorLogin.setText("Введите логин или пароль");
            System.out.println("Login and password is empty");
        }
    }



    /**
     * Переход в основное приложение, при верно введенных данных
     **/

    private void loginUser(String loginText, String loginPassword) throws Exception {
        int counter = 1;

        DatebaseHandler dbHandler = new DatebaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        while (result.next()) {
            counter++;
        }
        if (counter >= 1) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user.fxml")));

            Stage windowLogIn = (Stage) buttonLogIn.getScene().getWindow();
            windowLogIn.setScene(new Scene(root, 1000, 600));
            windowLogIn.setResizable(false);


        } else {
            errorLogin.setText("Неверный логин или пароль");
            System.out.println("User is not");
        }
    }


    /**
     * Переход к регистрации
     **/
    @FXML
    void registerButton(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));

        Stage windowRegister = (Stage) buttonLogIn.getScene().getWindow();
        windowRegister.setScene(new Scene(root, 400, 400));
        windowRegister.setResizable(false);
    }

    /**
     * Кнопка закрытия приложения
     **/
    @FXML
    void initialize() {
        close.setOnAction(event -> {
            close.getScene().getWindow().hide();
        });
    }


}
