package game.dsl;

import game.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicGame implements Game {
    static final String NO_LOCATION = "nowhere";
    private final List<Player> players = new ArrayList<>();
    private String location = NO_LOCATION;
    private final List<Game> adversaryGames = new ArrayList<>();

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

    public void addAdversary(Game adversary) {
        this.adversaryGames.add(adversary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Basic Game { location: ")
                .append(location)
                .append("; player(s): ")
                .append(Arrays.toString(players.toArray()))
                .append(" }");
        if (!adversaryGames.isEmpty()) {
            sb.append(("\n\tAdversary game(s):"));
            for (Game adversaryGame : adversaryGames) {
                sb.append("\n\t- ").append(adversaryGame);
            }
        }
        return sb.toString();
    }
}
