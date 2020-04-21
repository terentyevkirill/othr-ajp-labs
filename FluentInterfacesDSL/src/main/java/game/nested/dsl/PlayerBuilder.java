package game.nested.dsl;

public interface PlayerBuilder extends LocationBuilder {
    LocationBuilder asMaster();
}
