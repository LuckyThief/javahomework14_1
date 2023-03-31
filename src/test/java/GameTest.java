import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player kolya = new Player(1, "Коля", 25);
        Player polya = new Player(2, "Поля", 20);

        game.register(kolya);
        game.register(polya);

        int expected = 1;
        int actual = game.round("Коля", "Поля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player kolya = new Player(1, "Коля", 25);
        Player polya = new Player(2, "Поля", 30);

        game.register(kolya);
        game.register(polya);

        int expected = 2;
        int actual = game.round("Коля", "Поля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDrawGame() {
        Game game = new Game();
        Player kolya = new Player(1, "Коля", 25);
        Player polya = new Player(2, "Поля", 25);

        game.register(kolya);
        game.register(polya);

        int expected = 0;
        int actual = game.round("Коля", "Поля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotRegistered() {
        Game game = new Game();
        Player kolya = new Player(1, "Коля", 25);
        Player polya = new Player(2, "Поля", 20);

        game.register(kolya);
        game.register(polya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Толя", "Поля")
        );
    }

    @Test
    public void testWhenSecondPlayerNotRegistered() {
        Game game = new Game();
        Player kolya = new Player(1, "Коля", 25);
        Player polya = new Player(2, "Поля", 20);

        game.register(kolya);
        game.register(polya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Толя")
        );
    }

    @Test
    public void testWhenTwoPlayersNotRegistered() {
        Game game = new Game();
        Player kolya = new Player(1, "Коля", 25);
        Player polya = new Player(2, "Поля", 20);

        game.register(kolya);
        game.register(polya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Толя", "Компот")
        );
    }
}
