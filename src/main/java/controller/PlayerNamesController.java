package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class PlayerNamesController {

    @FXML
    private Button okButton;

    @FXML
    private TextField player1Text;

    @FXML
    private TextField player2Text;

    public void initialize(){
        okButton.setDisable(true);
    }

    /**
     * Opens the game UI and transfers the player names to the game UI
     */
    @FXML
    void goToGame(ActionEvent event) throws IOException {
        Logger.info("Game starts.");
        String p1 = player1Text.getText();
        String p2 = player2Text.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RokafogoFXML.fxml"));
        Parent root = loader.load();
        RokafogoController rokafogoController = loader.getController();
        rokafogoController.setTwoPlayerName(p1,p2);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Rókafogó");
        stage.getIcons().add(new Image("/icon.png"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Disables the OK button when the 2 player names are the same and none of them are more than 3 characters, and lesser than 10 characters
     */
    public void keyReleasedProperty(){
        boolean isReleased = (player1Text.getText().equals(player2Text.getText()) ||
                player1Text.getText().isEmpty() || player2Text.getText().isEmpty() ||
                player1Text.getText().length() < 3 || player2Text.getText().length() < 3 ||
                player1Text.getText().length() > 10 || player2Text.getText().length() > 10);
        okButton.setDisable(isReleased);
    }
}
