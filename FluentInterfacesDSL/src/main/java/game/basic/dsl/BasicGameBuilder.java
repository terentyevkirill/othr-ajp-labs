package game.basic.dsl;


import game.basic.Game;

public class BasicGameBuilder implements GameBuilder, PlayerBuilder {
    private final BasicGame game;
    private Player player;

    public BasicGameBuilder() {
        game = new BasicGame();
    }

    @Override
    public PlayerBuilder player(String name) {
        player = new BasicPlayer(name);
        game.addPlayer(player);
        return this;
    }

    @Override
    public LocationBuilder asMaster() {
        game.setPlayerAsMaster(player);
        return this;
    }

    @Override
    public Game setInSpace() {
        game.setLocation("Space");
        return game;
    }

    @Override
    public Game setOnEarth() {
        game.setLocation("Earth");
        return game;
    }

    @Override
    public Game setUnderwater() {
        game.setLocation("Underwater");
        return game;
    }
}
