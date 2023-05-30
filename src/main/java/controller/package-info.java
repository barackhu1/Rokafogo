/**
 * This package contains the main classes of the controllers.
 * The controller represents all the methods which connects the UI with the model.
 *
 * <p>The controller package includes the following classes:
 * <ul>
 *     <li>{@link controller.MenuController} - Represents the main menu of the software.
 *     It has a very simple use, a start quit and scoreboard button.</li>
 *     <li>{@link controller.PlayerNamesController} - Represents the player name input UI. There are constrains of 2 valid player names,
 *     it has to be between 4 and 10 characters, and the first player name cant be the same as the second player name.</li>
 *     <li>{@link controller.ScoreBoardController} - Represents a scoreboard of the previous played games. Using JAXB xml writer and
 *     reader, I paste the previously played games result, Player Name, Players Type, and Players Win Count</li>
 *     <li>{@link controller.RokafogoController} - Represents the UI of the game, here's used the model of the board and
 *     the pieces.</li>
 * </ul>
 *
 */
package controller;