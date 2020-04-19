import game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static game.Game.*;

public class NestedDslTest {

    @Test
    public void basicGameTest() {
        try {
            Game game1 = Game.create()
                    .player( name("Kyrylo"), age(20), level(5)).asMaster()
                    .player(name("Alya"), age(18), level(4))
                    .setOnEarth();
            Game game2 = Game.create()
                    .player( name("Brent"), age(27), level(3) )
                    .player( name("Sue"), level(10) )
                    .player( name("Mary") ).asMaster()
                    .player()
                    .setUnderwater();

            System.out.println(game1);
            System.out.println(game2);
        } catch (Throwable t) {
            Assertions.fail("DSL Runtime Error");
        }

    }
}
