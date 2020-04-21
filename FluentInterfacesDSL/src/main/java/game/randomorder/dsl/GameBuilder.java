package game.randomorder.dsl;
import game.randomorder.Game;

public interface GameBuilder {
    PlayerBuilder player(PlayerDetail... details);

    static GameBuilder newInstance() {
        return new BasicGameBuilder();
    }

    Game get();
}
