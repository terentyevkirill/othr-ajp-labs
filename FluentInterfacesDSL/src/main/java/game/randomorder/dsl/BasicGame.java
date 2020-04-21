package game.randomorder.dsl;

import game.randomorder.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicGame implements Game {
    static final String NO_LOCATION = "nowhere";
    private final List<Player> players = new ArrayList<>();
    private String location = NO_LOCATION;

    BasicGame() {
    }

    void addPlayer(Player player) {
        players.add(player);
    }

    void setPlayerAsMaster(Player player) {
        player.setMaster(true);
    }

    public void setLocation(String location) {
        if (NO_LOCATION.equals(this.location))
            this.location = location;
        else
            throw new IllegalArgumentException("Location has already been set to " + this.location);
    }

    @Override
    public String toString() {
        return "Basic Game { location: " + location + "; players: " + Arrays.toString(players.toArray()) + " }";
    }
}
