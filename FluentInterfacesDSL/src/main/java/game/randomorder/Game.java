package game.randomorder;

import game.randomorder.dsl.GameBuilder;
import game.randomorder.dsl.PlayerDetail;

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
