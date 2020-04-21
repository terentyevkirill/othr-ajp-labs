package game.basic.dsl;

public interface GameBuilder {
    PlayerBuilder player(String name);

    static GameBuilder newInstance() {
        return new BasicGameBuilder();
    }

}
