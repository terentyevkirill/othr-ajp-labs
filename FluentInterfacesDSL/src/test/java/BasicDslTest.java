import game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicDslTest {

    @Test
    public void basicGameTest() {
        try {
            Game game1 = Game.create()
                    .player("Kyrylo").asMaster()
                    .player("Alina")
                    .setOnEarth();
            Game game2 = Game.create()
                    .player("Player 1")
                    .player("Player 2").asMaster()
                    .player("Player 3")
                    .setInSpace();
            System.out.println(game1.toString());
            System.out.println(game2.toString());
        } catch (Throwable t) {
            Assertions.fail("DSL Runtime Error");
        }

    }
}
