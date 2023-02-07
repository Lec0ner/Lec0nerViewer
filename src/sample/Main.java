package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logIn.fxml")));
        stage.setTitle("MyViewer");
        stage.setResizable(false);
        stage.setScene(new Scene(root,400,400));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}