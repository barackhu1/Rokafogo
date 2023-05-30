/**
 * This package contains the model classes for the Rokafogo game.
 * The model represents the game board, pieces, and their movements.
 * It provides classes for both black and white pieces, as well as the main game model.
 *
 * <p>The model package includes the following classes:
 * <ul>
 *     <li>{@link model.BlackPawn} - Represents a black pawn piece in the game.</li>
 *     <li>{@link model.WhitePawn} - Represents a white pawn piece in the game.</li>
 *     <li>{@link model.Piece} - Defines a basic piece object with coordinates.</li>
 *     <li>{@link model.Point} - Represents a point coordinate with x and y values.</li>
 *     <li>{@link model.RokafogoModel} - Defines the game board and core game logic.</li>
 * </ul>
 *
 * <p>Usage examples:
 * <pre>{@code
 *     // Create a new instance of RokafogoModel
 *     RokafogoModel gameModel = new RokafogoModel();
 *
 *     // Set up the initial game board
 *     gameModel.createLists();
 *
 *     // Get the list of valid moves for a white pawn
 *     List<Point> whitePawnMoves = gameModel.getWhitePawn().ableToMove();
 *
 *     // Check if the white player has won
 *     boolean isWhiteWinner = gameModel.whiteWins();
 *
 *     // Check if the black player has won
 *     boolean isBlackWinner = gameModel.blackWins();
 * }</pre>
 *
 * <p>Note: This package-info file provides an overview of the model package and its classes.
 * For detailed information about each class, refer to their respective documentation.
 */
package model;