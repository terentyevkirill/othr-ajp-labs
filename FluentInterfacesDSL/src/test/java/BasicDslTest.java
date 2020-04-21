import game.basic.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicDslTest {

    @Test
    public void basicDslTest() {
        try {
            Game g = Game.create()
                    .player("Kyrylo").asMaster()
                    .player("Alina")
                    .setOnEarth();
            System.out.println(g.toString());
        } catch (Throwable t) {
            Assertions.fail("DSL Runtime Error");
        }

    }
}
