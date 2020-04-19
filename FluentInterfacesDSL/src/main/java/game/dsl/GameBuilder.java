package game.dsl;

import game.Game;

public interface GameBuilder {
    PlayerBuilder player(String name);

    static GameBuilder newInstance() {
        return new BasicGameBuilder();
    }

}
