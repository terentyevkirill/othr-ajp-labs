package game.dsl;

public interface GameBuilder {
    PlayerBuilder player(PlayerDetail... details);

    static GameBuilder newInstance() {
        return new BasicGameBuilder();
    }

}
