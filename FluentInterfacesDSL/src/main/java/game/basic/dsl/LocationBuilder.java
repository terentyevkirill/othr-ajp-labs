package game.basic.dsl;

import game.basic.Game;

public interface LocationBuilder extends GameBuilder {
    Game setInSpace();
    Game setOnEarth();
    Game setUnderwater();
}
