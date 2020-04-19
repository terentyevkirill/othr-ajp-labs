package game.dsl;

import game.Game;

public interface GameBuilder {
    PlayerBuilder player(PlayerDetail... details);

    static GameBuilder newInstance() {
        return new BasicGameBuilder();
    }

    Game get();
}
