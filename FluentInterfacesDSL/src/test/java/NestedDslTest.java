import game.nested.Game;

import static game.nested.Game.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NestedDslTest {

    @Test
    public void nestedDslTest() {
        try {
            Game g = Game.create()
                    .player(name("Brent"), age(27), level(3))
                    .player(name("Sue"), level(10))
                    .player(name("Mary")).asMaster()
                    .player()
                    .setUnderwater();

            System.out.println(g);
        } catch (Throwable t) {
            Assertions.fail("DSL Runtime Error");
        }

    }
}
