package game.dsl;

import game.Game;

public class BasicGameBuilder implements GameBuilder, PlayerBuilder, LocationBuilder, SemiInterface, GameLocationBuilder, GameBuilderTerminator {
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
    public GameLocationBuilder asMaster() {
        game.setPlayerAsMaster(player);
        return this;
    }

    @Override
    public SemiInterface setInSpace() {
        game.setLocation("Space");
        return this;
    }

    @Override
    public SemiInterface setOnEarth() {
        game.setLocation("Earth");
        return this;
    }

    @Override
    public SemiInterface setUnderwater() {
        game.setLocation("Underwater");
        return this;
    }

    @Override
    public Game get() {
        return game;
    }

    @Override
    public SemiInterface adversary(Game adversaryGame) {
        this.game.addAdversary(adversaryGame);
        return this;
    }
}
