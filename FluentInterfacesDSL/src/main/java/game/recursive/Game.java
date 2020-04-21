package game.recursive;

import game.recursive.dsl.GameBuilder;
import game.recursive.dsl.PlayerDetail;

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
