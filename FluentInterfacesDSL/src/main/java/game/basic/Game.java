package game.basic;

import game.basic.dsl.GameBuilder;

public interface Game {
    static GameBuilder create() {
        return GameBuilder.newInstance();
    }
}
