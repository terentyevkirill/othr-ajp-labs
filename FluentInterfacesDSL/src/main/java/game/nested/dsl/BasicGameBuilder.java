package game.nested.dsl;


import game.nested.Game;

public class BasicGameBuilder implements GameBuilder, PlayerBuilder {
    private final BasicGame game;
    private Player player;

    public BasicGameBuilder() {
        game = new BasicGame();
    }

    @Override
    public PlayerBuilder player(PlayerDetail... details) {
        player = new BasicPlayer();
        for (PlayerDetail<?> detail : details) {
            switch (detail.attributeType) {
                case NAME:
                    player.setName((String) detail.getAttribute());
                    break;
                case LEVEL:
                    player.setLevel((Integer) detail.getAttribute());
                    break;
                case AGE:
                    player.setAge((Integer) detail.getAttribute());
            }
        }
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
