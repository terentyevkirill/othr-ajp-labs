package game;

import game.dsl.GameBuilder;

public interface Game {
    static GameBuilder create() {
        return GameBuilder.newInstance();

    }
}
