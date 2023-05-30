package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;
import java.util.Objects;


public class MenuController {

    @FXML
    private Button startButton;

    @FXML
    private Button quitButton;

    @FXML
    private Button scoreBoradButton;

    /**
     * Opens the player name input window
     */
    @FXML
    void goesToPlayersInput(ActionEvent event) throws IOException {
        Logger.info("The player name input window loads from menu.");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/PlayerNames.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Opens the scoreboard
     */
    @FXML
    void goesToScoreBoard(ActionEvent event) throws IOException {
        Logger.info("The score board window loads from menu.");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ScoreBoard.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void quitsGame(ActionEvent event) {
        Logger.info("The game quits from menu.");
        System.exit(0);
    }
}
