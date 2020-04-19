import game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static game.Game.*;

public class RandomOrderDslTest {

    @Test
    public void basicGameTest() {
        try {
            Game game1 = Game.create()
                    .player(name("Kyrylo"), age(20), level(5)).asMaster()
                    .player(name("Alya"), age(18), level(4))
                    .setOnEarth()
                    .get();
            Game game2 = Game.create()
                    .player(name("Brent"), age(27), level(3))
                    .player(name("Sue"), level(10))
                    .player(name("Mary")).asMaster()
                    .player()
                    .setUnderwater()
                    .get();
            Game game3 = Game.create()
                    .player(name("Brent"), age(27), level(3))
                    .player(name("Sue"), level(10))
                    .setOnEarth()
                    .player(name("Mary")).asMaster()
                    .player()
                    .get();
            System.out.println(game1);
            System.out.println(game2);
            System.out.println(game3);
        } catch (Throwable t) {
            Assertions.fail("DSL Runtime Error", t);
        }

    }
}
