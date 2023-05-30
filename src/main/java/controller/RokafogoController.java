package controller;

import jakarta.xml.bind.JAXBException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import org.tinylog.Logger;
import jaxb.JAXBHelper;
import players.AllPlayers;
import players.Player;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class RokafogoController {
    @FXML
    private GridPane board;
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;
    private String player1Name;
    private String player2Name;
    private final RokafogoModel model = new RokafogoModel();

    /**
     * Creates the whole board, adds the pieces to it's coordinates, and creates the move lists.
     */
    @FXML
    private void initialize() {
        for (int i = 0; i < board.getRowCount(); i++) {
            for (int j = 0; j < board.getColumnCount(); j++) {
                if ((i%2 == 1 && j%2 == 0)||(i%2 == 0 && j%2 == 1)){
                    StackPane square = createSquare();
                    square.getStyleClass().add("blue-square");
                    board.add(square, i,j);
                }
                else board.add(createSquare(), i, j);
            }
        }
        board.add(whitePiece(), model.getWhitePawn().getX(),model.getWhitePawn().getY());
        board.add(blackPiece1(), model.getBlackPawn1().getX(), model.getBlackPawn1().getY());
        board.add(blackPiece2(), model.getBlackPawn2().getX(), model.getBlackPawn2().getY());
        board.add(blackPiece3(), model.getBlackPawn3().getX(), model.getBlackPawn3().getY());
        board.add(blackPiece4(), model.getBlackPawn4().getX(), model.getBlackPawn4().getY());
        model.createLists();
    }

    /**
     * When a white piece has a mouse clicked event, puts down green squares, the next possible steps
     * @return a white piece with its coordinates
     */
    private Text whitePiece(){
        Text whitePiece = new Text("♙");
        whitePiece.setFont(new Font(50));
        whitePiece.setOnMouseClicked(event -> {
            if(event.getTarget() instanceof Text) {
                if (model.getNextPlayer() % 2 == 1){
                    model.removesPiece(model.getWhiteMoveList());
                    for (var next : model.getWhiteMoveList() ){
                        board.add(createGreenSquare(model.getWhiteMoveList(), "white", whitePiece()), next.getX(), next.getY());
                    }
                    Logger.info("Clicked on white pawn.");
                }
                else {
                    Logger.info("Clicked on white pawn, but you can't move.");
                }
            }
        });
        return whitePiece;
    }

    /**
     * When a black piece has a mouse clicked event, puts down green squares, the next possible steps
     * @return a black piece with its coordinates
     */
    private Text blackPiece1(){
        Text blackPiece1 = new Text("♟");
        blackPiece1.setFont(new Font(50));
        blackPiece1.setOnMouseClicked(event -> {
            if(event.getTarget() instanceof Text) {
                if (model.getNextPlayer() % 2 == 0 && model.isClickedOn()){
                    model.removesPiece(model.getBlackMoveList1());
                    for (var next : model.getBlackMoveList1() ){
                        board.add(createGreenSquare(model.getBlackMoveList1(), "black1", blackPiece1()), next.getX(), next.getY());
                        model.setClickedOn(false);
                    }
                    Logger.info("Clicked on black pawn 1.");
                }else {
                    Logger.info("Clicked on black pawn 1, but you can't move.");
                }
            }
        });
        return blackPiece1;
    }

    /**
     * When a black piece has a mouse clicked event, puts down green squares, the next possible steps
     * @return a black piece with its coordinates
     */
    private Text blackPiece2(){
        Text blackPiece2 = new Text("♟");
        blackPiece2.setFont(new Font(50));
        blackPiece2.setOnMouseClicked(event -> {
            if(event.getTarget() instanceof Text) {
                if (model.getNextPlayer() % 2 == 0 && model.isClickedOn()){
                    model.removesPiece(model.getBlackMoveList2());
                    for (var next : model.getBlackMoveList2() ){
                        board.add(createGreenSquare(model.getBlackMoveList2(), "black2", blackPiece2()), next.getX(), next.getY());
                        model.setClickedOn(false);
                    }
                    Logger.info("Clicked on black pawn 2.");
                }else {
                    Logger.info("Clicked on black pawn 2, but you can't move.");
                }
            }
        });
        return blackPiece2;
    }

    /**
     * When a black piece has a mouse clicked event, puts down green squares, the next possible steps
     * @return a black piece with its coordinates
     */
    private Text blackPiece3(){
        Text blackPiece3 = new Text("♟");
        blackPiece3.setFont(new Font(50));
        blackPiece3.setOnMouseClicked(event -> {
            if(event.getTarget() instanceof Text) {
                if (model.getNextPlayer() % 2 == 0 && model.isClickedOn()){
                    model.removesPiece(model.getBlackMoveList3());
                    for (var next : model.getBlackMoveList3() ){
                        board.add(createGreenSquare(model.getBlackMoveList3(), "black3", blackPiece3()), next.getX(), next.getY());
                        model.setClickedOn(false);
                    }
                    Logger.info("Clicked on black pawn 3.");
                }else {
                    Logger.info("Clicked on black pawn 3, but you can't move.");
                }
            }
        });
        return blackPiece3;
    }

    /**
     * When a black piece has a mouse clicked event, puts down green squares, the next possible steps
     * @return a black piece with its coordinates
     */
    private Text blackPiece4(){
        Text blackPiece4 = new Text("♟");
        blackPiece4.setFont(new Font(50));
        blackPiece4.setOnMouseClicked(event -> {
            if(event.getTarget() instanceof Text) {
                if (model.getNextPlayer() % 2 == 0 && model.isClickedOn()){
                    model.removesPiece(model.getBlackMoveList4());
                    for (var next : model.getBlackMoveList4() ){
                        board.add(createGreenSquare(model.getBlackMoveList4(), "black4", blackPiece4()), next.getX(), next.getY());
                        model.setClickedOn(false);
                    }
                    Logger.info("Clicked on black pawn 4.");
                }else {
                    Logger.info("Clicked on black pawn 4, but you can't move.");
                }
            }
        });
        return blackPiece4;
    }

    /**
     * If we click on a given green square after we clicked on a piece, the piece will be set on this green square,
     * and it will have new move list, and coordinate
     * @param moveList a list with coordinates
     * @param pieceType type of piece in String
     * @param piece the piece from the board
     * @return a green square
     */
    private StackPane createGreenSquare(final List<Point> moveList, String pieceType, Text piece) {
        StackPane greenSquare = new StackPane();
        greenSquare.getStyleClass().add("green-square");
        greenSquare.setOnMouseClicked(event -> {
            if(event.getTarget() instanceof StackPane) {
                int x = (int) Math.floor(greenSquare.getLayoutX() / 50);
                int y = (int) Math.floor(greenSquare.getLayoutY() / 50);
                board.add(createSquare(),x,y);
                for (var next : moveList ){
                    board.add(createSquare(), next.getX(), next.getY());
                }
                board.add(piece,x,y);
                switch (pieceType) {
                    case "white" -> {
                        board.add(createSquare(), model.getWhitePawn().getX(), model.getWhitePawn().getY());
                        model.setWhitePawn(new WhitePawn(x, y));
                        model.createLists();
                        setToDefault();
                        model.setNextPlayer(model.getNextPlayer() + 1);
                        winnerPlayer();
                        Logger.info("New position for white pawn {" + (model.getWhitePawn().getX() + 1) + ", " + (model.getWhitePawn().getY() + 1) + "}");
                    }
                    case "black1" -> {
                        board.add(createSquare(), model.getBlackPawn1().getX(), model.getBlackPawn1().getY());
                        model.setBlackPawn1(new BlackPawn(x, y));
                        model.createLists();
                        setToDefault();
                        model.setNextPlayer(model.getNextPlayer() + 1);
                        model.setClickedOn(true);
                        winnerPlayer();
                        Logger.info("New position for black pawn 1 {" + (model.getBlackPawn1().getX() + 1) + ", " + (model.getBlackPawn1().getY() + 1) + "}");
                    }
                    case "black2" -> {
                        board.add(createSquare(), model.getBlackPawn2().getX(), model.getBlackPawn2().getY());
                        model.setBlackPawn2(new BlackPawn(x, y));
                        model.createLists();
                        setToDefault();
                        model.setNextPlayer(model.getNextPlayer() + 1);
                        model.setClickedOn(true);
                        winnerPlayer();
                        Logger.info("New position for black pawn 2 {" + (model.getBlackPawn2().getX() + 1) + ", " + (model.getBlackPawn2().getY() + 1) + "}");
                    }
                    case "black3" -> {
                        board.add(createSquare(), model.getBlackPawn3().getX(), model.getBlackPawn3().getY());
                        model.setBlackPawn3(new BlackPawn(x, y));
                        model.createLists();
                        setToDefault();
                        model.setNextPlayer(model.getNextPlayer() + 1);
                        model.setClickedOn(true);
                        winnerPlayer();
                        Logger.info("New position for black pawn 3 {" + (model.getBlackPawn3().getX() + 1) + ", " + (model.getBlackPawn3().getY() + 1) + "}");
                    }
                    case "black4" -> {
                        board.add(createSquare(), model.getBlackPawn4().getX(), model.getBlackPawn4().getY());
                        model.setBlackPawn4(new BlackPawn(x, y));
                        model.createLists();
                        setToDefault();
                        model.setNextPlayer(model.getNextPlayer() + 1);
                        model.setClickedOn(true);
                        winnerPlayer();
                        Logger.info("New position for black pawn 4 {" + (model.getBlackPawn4().getX() + 1) + ", " + (model.getBlackPawn4().getY() + 1) + "}");
                    }
                }
            }
        });
        return greenSquare;
    }

    /**
     * If we click on an empty square, the green square will be removed from the board
     * @return an empty square
     */
    private StackPane createSquare() {
        StackPane square = new StackPane();
        square.getStyleClass().add("square");
        square.setOnMouseClicked(event -> {
            if(event.getTarget() instanceof StackPane) {
                List<Point> allMoves = Stream.of(model.getWhiteMoveList(), model.getBlackMoveList1(), model.getBlackMoveList2(),
                                model.getBlackMoveList3(), model.getBlackMoveList4())
                        .flatMap(List::stream)
                        .toList();
                for (var coordinate : allMoves){
                    board.add(createSquare(), coordinate.getX(), coordinate.getY());
                    setToDefault();
                }
                model.setClickedOn(true);
                Logger.info("Clicled on an empty square.");
            }
        });

        return square;
    }

    /**
     * Sets to default the pieces on the board, reason: without this the pieces will be stacked on each other
     */
    private void setToDefault(){
        board.add(createSquare(), model.getWhitePawn().getX(), model.getWhitePawn().getY());
        board.add(createSquare(), model.getBlackPawn1().getX(), model.getBlackPawn1().getY());
        board.add(createSquare(), model.getBlackPawn2().getX(), model.getBlackPawn2().getY());
        board.add(createSquare(), model.getBlackPawn3().getX(), model.getBlackPawn3().getY());
        board.add(createSquare(), model.getBlackPawn4().getX(), model.getBlackPawn4().getY());
        board.add(whitePiece(), model.getWhitePawn().getX(), model.getWhitePawn().getY());
        board.add(blackPiece1(), model.getBlackPawn1().getX(), model.getBlackPawn1().getY());
        board.add(blackPiece2(), model.getBlackPawn2().getX(), model.getBlackPawn2().getY());
        board.add(blackPiece3(), model.getBlackPawn3().getX(), model.getBlackPawn3().getY());
        board.add(blackPiece4(), model.getBlackPawn4().getX(), model.getBlackPawn4().getY());
    }

    /**
     * Checks if any player has a winning situation, and if there is one, the board will be disabled and
     * a popup window will inform us wo won
     */
    public void winnerPlayer(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText(null);
        if(model.whiteWins()){
            Logger.info(player1Name + " won.");
            ImageView imageView = new ImageView(new Image("/whitePawn.png"));
            xmlWrite(player1Name,"Fox",1);
            xmlWrite(player2Name,"Dogs",0);
            imageView.setFitWidth(100);
            imageView.setFitHeight(75);
            alert.setGraphic(imageView);
            alert.setContentText(player1Name + " won!");
            alert.showAndWait();
            board.setDisable(true);
        } else if (model.blackWins()) {
            Logger.info(player2Name + " won.");
            ImageView imageView = new ImageView(new Image("/blackPawn.png"));
            xmlWrite(player1Name,"Fox",0);
            xmlWrite(player2Name,"Dogs",1);
            imageView.setFitWidth(100);
            imageView.setFitHeight(75);
            alert.setGraphic(imageView);
            alert.setContentText(player2Name + " won!");
            alert.showAndWait();
            board.setDisable(true);
        }
    }

    /**
     * If there is a winning situation the xml writer will write the players information
     * @param player player name
     * @param type Fox or Dogs
     * @param win if he won its 1, if he lost its 0
     */
    public void xmlWrite(String player, String type, int win){
        try{
            AllPlayers players;
            File file = new File("player.xml");
            if (file.exists() && file.length() > 0) {
                players = JAXBHelper.fromXML(AllPlayers.class, new FileInputStream(file));
            } else {
                players = new AllPlayers();
            }
            List<Player> playersList = players.getPlayerList();
            boolean exists = false;
            Player p = new Player();
            for(var aPlayer: playersList){
                if(aPlayer.getPlayerName().equals(player) && aPlayer.getPlayerType().equals(type)) {
                    exists = true;
                    p = aPlayer;
                }
            }
            if (exists){
                playersList.remove(p);
                p.setPlayerWinCount(p.getPlayerWinCount()+win);
                playersList.add(p);
            }else {
                playersList.add(new Player(type, player, win));
            }
            JAXBHelper.toXML(players, new FileOutputStream(file, false));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the player names from the player name input UI
     * @param p1 player 1 name, the Fox player
     * @param p2 player 2 name, the Dogs player
     */
    public void setTwoPlayerName(String p1, String p2){
        player1Name = p1;
        player2Name = p2;
        player1Label.setText(p1);
        player2Label.setText(p2);
    }

    /**
     * Goes back to main menu
     */
    @FXML
    void goesMainMenu(ActionEvent event) throws IOException {
        Logger.info("Going to main menu from game.");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Menu.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void quitsGame(ActionEvent event) {
        Logger.info("Quit game.");
        System.exit(0);
    }
}
