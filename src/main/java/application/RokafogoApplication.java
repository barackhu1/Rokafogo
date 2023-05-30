package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.Objects;

public class RokafogoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Logger.info("Starting program.");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Menu.fxml")));
        stage.setTitle("Rókafogó");
        stage.getIcons().add(new Image("/icon.png"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
