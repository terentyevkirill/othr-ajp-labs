import game.recursive.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static game.recursive.Game.*;

public class RecursiveDslTest {

    @Test
    public void basicGameTest() {
        try {
            Game g = Game.create()
                    .player(name("Brent"), age(27), level(3))
                    .player(name("Sue"), level(10))
                    .setOnEarth()
                    .player(name("Mary")).asMaster()
                    .player()
                    .adversary(Game.create()
                            .player(name("Capt.	Kirk"), age(99))
                            .setInSpace()
                            .player(name("Kahn"))
                            .adversary(Game.create()
                                    .player(level(1000))
                                    .get())
                            .get())
                    .get();
            System.out.println(g);
        } catch (Throwable t) {
            Assertions.fail("DSL Runtime Error", t);
        }

    }
}
