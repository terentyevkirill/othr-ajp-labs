package game.dsl;

public interface PlayerBuilder extends GameBuilder, LocationBuilder, GameBuilderTerminator{
    GameLocationBuilder asMaster();
}
