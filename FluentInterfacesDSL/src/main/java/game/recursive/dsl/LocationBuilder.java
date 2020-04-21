package game.recursive.dsl;


import game.recursive.Game;

public interface LocationBuilder extends GameBuilderTerminator {
    SemiInterface setInSpace();
    SemiInterface setOnEarth();
    SemiInterface setUnderwater();
    GameBuilder adversary(Game adversaryGame);
}

