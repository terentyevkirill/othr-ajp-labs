package game.dsl;

import game.Game;

public interface LocationBuilder extends GameBuilder {
    Game setInSpace();
    Game setOnEarth();
    Game setUnderwater();
}

