package game.nested;

import game.nested.dsl.GameBuilder;
import game.nested.dsl.PlayerDetail;

public interface Game {
    static GameBuilder create() {
        return GameBuilder.newInstance();
    }

    static PlayerDetail name(String name) {
        return PlayerDetail.newInstance(name, PlayerDetail.PlayerDetailType.NAME);
    }
    static PlayerDetail age(int age) {
        return PlayerDetail.newInstance(age, PlayerDetail.PlayerDetailType.AGE);
    }
    static PlayerDetail level(int level) {
        return PlayerDetail.newInstance(level, PlayerDetail.PlayerDetailType.LEVEL);
    }
}
