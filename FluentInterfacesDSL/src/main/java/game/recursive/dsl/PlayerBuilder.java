package game.recursive.dsl;

public interface PlayerBuilder extends GameBuilder, LocationBuilder, GameBuilderTerminator{
    GameLocationBuilder asMaster();
}
