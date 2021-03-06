import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import game.randomorder.Game;

import static game.randomorder.Game.*;


public class RandomOrderDslTest {

    @Test
    public void randomOrderDslTest() {
        try {
            Game g = Game.create()
                    .player(name("Brent"), age(27), level(3))
                    .player(name("Sue"), level(10))
                    .setOnEarth()
                    .player(name("Mary")).asMaster()
                    .player()
                    .get();
            System.out.println(g);
        } catch (Throwable t) {
            Assertions.fail("DSL Runtime Error", t);
        }

    }
}
