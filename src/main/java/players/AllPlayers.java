package players;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * A container class for the players
 */
@lombok.Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class AllPlayers {
    @XmlElementWrapper(name = "PlayerStats")
    private List<Player> playerList = new ArrayList<>();
}
