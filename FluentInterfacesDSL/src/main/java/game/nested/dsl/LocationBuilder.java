package game.nested.dsl;

import game.nested.Game;

public interface LocationBuilder extends GameBuilder {
    Game setInSpace();
    Game setOnEarth();
    Game setUnderwater();
}
