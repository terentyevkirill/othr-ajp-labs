package game.nested.dsl;

import game.nested.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicGame implements Game {
    private final List<Player> players = new ArrayList<>();
    private String location = "";

    BasicGame() {
    }

    void addPlayer(Player player) {
        players.add(player);
    }

    void setPlayerAsMaster(Player player) {
        player.setMaster(true);
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Basic Game { location: " + location + "; players: " + Arrays.toString(players.toArray()) + " }";
    }
}
