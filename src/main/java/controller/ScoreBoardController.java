package controller;

import jakarta.xml.bind.JAXBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jaxb.JAXBHelper;
import org.tinylog.Logger;
import players.AllPlayers;
import players.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class ScoreBoardController {

    @FXML
    private Button backButton;

    @FXML
    private TableView<Player> table;

    @FXML
    private TableColumn<Player, String> playerName;

    @FXML
    private TableColumn<Player, String> playerType;

    @FXML
    private TableColumn<Player, Integer> playerWinCount;

    /**
     * From player.xml transfers the data's to the scoreboard
     */
    public void initialize(){
        try{
            AllPlayers players;
            File file = new File("player.xml");
            if (file.exists() && file.length() > 0) {
                players = JAXBHelper.fromXML(AllPlayers.class, new FileInputStream(file));
            } else {
                players = new AllPlayers();
            }
            ObservableList<Player> playerObservableList = FXCollections.observableArrayList(players.getPlayerList());
            playerType.setCellValueFactory(new PropertyValueFactory<>("playerType"));
            playerName.setCellValueFactory(new PropertyValueFactory<>("playerName"));
            playerWinCount.setCellValueFactory(new PropertyValueFactory<>("playerWinCount"));
            table.setItems(playerObservableList);
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Takes back to the menu UI
     */
    @FXML
    void backToMenu(ActionEvent event) throws IOException {
        Logger.info("Goes back to menu from score board.");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Menu.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
