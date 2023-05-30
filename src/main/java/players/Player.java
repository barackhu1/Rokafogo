package players;

import jakarta.xml.bind.annotation.*;

/**
 * A class that contains a player's stats
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"playerType", "playerName", "playerWinCount"})
@lombok.Data
public class Player {
    private String playerType;
    private String playerName;
    private int playerWinCount;
    public Player(){}
    public Player(String playerType, String playerName, int playerWinCount) {
        this.playerType = playerType;
        this.playerName = playerName;
        this.playerWinCount = playerWinCount;
    }
}
