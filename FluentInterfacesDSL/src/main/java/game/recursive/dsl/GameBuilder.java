package game.recursive.dsl;

import game.recursive.Game;

public interface GameBuilder {
    PlayerBuilder player(PlayerDetail... details);

    static GameBuilder newInstance() {
        return new BasicGameBuilder();
    }

    Game get();
}
