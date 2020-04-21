package game.dsl;


import game.Game;

public interface LocationBuilder extends GameBuilderTerminator {
    SemiInterface setInSpace();
    SemiInterface setOnEarth();
    SemiInterface setUnderwater();
    GameBuilder adversary(Game adversaryGame);
}

